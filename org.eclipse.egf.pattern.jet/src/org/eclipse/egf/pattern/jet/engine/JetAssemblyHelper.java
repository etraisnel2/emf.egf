/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.jet.engine;

import java.util.Map.Entry;

import org.eclipse.egf.common.constant.EGFCommonConstants;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternCall;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.model.pattern.PatternInjectedCall;
import org.eclipse.egf.model.pattern.PatternParameter;
import org.eclipse.egf.model.pattern.Query;
import org.eclipse.egf.model.pattern.SuperCall;
import org.eclipse.egf.pattern.engine.AssemblyHelper;
import org.eclipse.egf.pattern.engine.ParameterMatcher;
import org.eclipse.egf.pattern.engine.PatternHelper;
import org.eclipse.egf.pattern.jet.Messages;
import org.eclipse.egf.pattern.utils.ParameterTypeHelper;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * @author Thomas Guiu
 * 
 */
public class JetAssemblyHelper extends AssemblyHelper {

    public static final String GENERATE_METHOD = "generate";
    public static final String START_METHOD_MARKER = "//Start of work";
    public static final String END_METHOD_MARKER = "//End of work";

    public static final String START_INIT_VARIABLE_MARKER = "//Start of init";
    public static final String END_INIT_VARIABLE_MARKER = "//End of init";

    public static final String CONSTRUCTOR_MARKER = "//Here is the constructor";

    public JetAssemblyHelper(Pattern pattern) {
        super(pattern);
    }

    @Override
    protected void call(PatternInjectedCall call) throws PatternException {
        Pattern pattern = call.getCalled();
        String templateClassName = JetNatureHelper.getTemplateClassName(pattern);
        if (templateClassName == null)
            throw new PatternException(Messages.assembly_error1);

        content.append("<%");
        String ctxName = "ctx_" + EcoreUtil.generateUUID();
        content.append("PatternContext ").append(ctxName).append(" = new PatternContext(ctx);").append(EGFCommonConstants.LINE_SEPARATOR);
        content.append(ctxName).append(".setReporter(callReporter);").append(EGFCommonConstants.LINE_SEPARATOR);
        content.append(ctxName).append(".setValue(").append("PatternContext.INJECTED_CONTEXT, ").append(call.getContext().getName()).append(");").append(EGFCommonConstants.LINE_SEPARATOR);
        content.append("EngineHelper.execute(\"").append(pattern.getID()).append("\", ").append(ctxName).append(");").append(EGFCommonConstants.LINE_SEPARATOR).append(EGFCommonConstants.LINE_SEPARATOR);
        content.append("%>");

    }

    @Override
    protected void call(PatternCall call) throws PatternException {
        Pattern pattern = call.getCalled();

        content.append("<%");
        if (call.getParameterMatching().isEmpty()) {
            // TODO add support for inherited parameters
            // try to match parameters
            ParameterMatcher matcher = ParameterMatcher.create(call.getPattern(), pattern);
            if (!matcher.matches())
                throw new PatternException(Messages.bind(Messages.assembly_error7, call.getPattern().getName()));
            for (PatternParameter key : matcher.getMatching().keySet()) {
                String called = PatternHelper.uniqueName(key);
                content.append(ParameterTypeHelper.INSTANCE.getTypeLiteral(key.getType())).append(" ").append(called).append(" = ").append(matcher.getMatching().get(key).getName()).append(";").append(EGFCommonConstants.LINE_SEPARATOR);
            }
        } else {
            // TODO add support for inherited parameters
            for (Entry<PatternParameter, PatternParameter> binding : call.getParameterMatching()) {
                String called = PatternHelper.uniqueName(binding.getKey());
                content.append(ParameterTypeHelper.INSTANCE.getTypeLiteral(binding.getKey().getType())).append(" ").append(called).append(" = ").append(binding.getValue().getName()).append(";").append(EGFCommonConstants.LINE_SEPARATOR);
            }
        }
        String ctxName = "ctx_" + EcoreUtil.generateUUID();
        content.append("PatternContext ").append(ctxName).append(" = new PatternContext(ctx);").append(EGFCommonConstants.LINE_SEPARATOR);
        content.append(ctxName).append(".setReporter(callReporter);").append(EGFCommonConstants.LINE_SEPARATOR);

        content.append(ctxName).append(".setValue(\"key\", \"value\");").append(EGFCommonConstants.LINE_SEPARATOR);

        content.append("EngineHelper.executeWithInjection(\"").append(pattern.getID()).append("\", ").append(ctxName);
        // content.append(" new ").append(templateClassName).append("().").append(GENERATE_METHOD).append("(stringBuffer, ").append(ctxName);
        for (PatternParameter parameter : pattern.getAllParameters())
            content.append(", ").append(PatternHelper.uniqueName(parameter));

        content.append(");");
        content.append("%>");
    }

    @Override
    protected void beginOrchestration() throws PatternException {
        content.append("<%");
        content.append("InternalPatternContext ctx = (InternalPatternContext)argument;").append(EGFCommonConstants.LINE_SEPARATOR);
        content.append("Map<String, String> queryCtx = null;").append(EGFCommonConstants.LINE_SEPARATOR);
        content.append("IQuery.ParameterDescription paramDesc = null;").append(EGFCommonConstants.LINE_SEPARATOR);
        content.append("%>");
        super.beginOrchestration();
        content.append("<%").append(START_METHOD_MARKER).append("%>");
    }

    /**
     * TODO quick work to validate the whole process, needs a plugable way to
     * add this stuff.
     */
    @Override
    protected void endOrchestration() throws PatternException {
        content.append("<%").append(END_METHOD_MARKER).append("%>");
        if (pattern.getAllParameters().isEmpty()) {
            content.append("<%if (ctx.useReporter()){").append(EGFCommonConstants.LINE_SEPARATOR);
            content.append("    ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);").append(EGFCommonConstants.LINE_SEPARATOR);
            content.append("    ctx.clearBuffer();}%>").append(EGFCommonConstants.LINE_SEPARATOR);
            return;
        }
        // 1 - Add pre block at insertionIndex
        StringBuilder localContent = new StringBuilder(300);
        localContent.append("<%").append(EGFCommonConstants.LINE_SEPARATOR);
        localContent.append("").append(EGFCommonConstants.LINE_SEPARATOR).append(EGFCommonConstants.LINE_SEPARATOR);

        for (PatternParameter parameter : pattern.getAllParameters()) {
            appendQueryCode(localContent, parameter);
        }

        localContent.append(EGFCommonConstants.LINE_SEPARATOR).append(EGFCommonConstants.LINE_SEPARATOR);

        // create a loop per parameter
        for (PatternParameter parameter : pattern.getAllParameters()) {
            String local = PatternHelper.localizeName(parameter);
            localContent.append("for (Object ").append(local).append(" : ").append(getParameterListName(parameter)).append(" ) {").append(EGFCommonConstants.LINE_SEPARATOR);
            // localContent.append("parameterValues.put(\"").append(parameter.getName()).append("\", ").append(local).append(");").append(EGFCommonConstants.LINE_SEPARATOR);

        }

        localContent.append(EGFCommonConstants.LINE_SEPARATOR).append("%>");

        content.insert(orchestrationIndex, localContent);

        // 2 - Add post block at current index
        content.append("<%").append(EGFCommonConstants.LINE_SEPARATOR);

        for (int i = 0; i < pattern.getAllParameters().size(); i++)
            content.append("}").append(EGFCommonConstants.LINE_SEPARATOR);
        content.append("if (ctx.useReporter()){").append(EGFCommonConstants.LINE_SEPARATOR);
        content.append("    ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);").append(EGFCommonConstants.LINE_SEPARATOR);
        content.append("    ctx.clearBuffer();").append(EGFCommonConstants.LINE_SEPARATOR);
        content.append("}%>");

        // 3- Add additional code for parameter names handling
        int startIndex = content.indexOf(START_METHOD_MARKER);
        if (startIndex == -1)
            throw new PatternException(Messages.assembly_error2);

        localContent.setLength(0);
        localContent.append(EGFCommonConstants.LINE_SEPARATOR);
        localContent.append("Map<String, Object> parameterValues = new HashMap<String, Object>();").append(EGFCommonConstants.LINE_SEPARATOR);
        for (org.eclipse.egf.model.pattern.PatternParameter parameter : pattern.getAllParameters()) {
            String local = PatternHelper.localizeName(parameter);
            String type = ParameterTypeHelper.INSTANCE.getTypeLiteral(parameter.getType());
            localContent.append(type).append(" ").append(parameter.getName()).append(" = (").append(type).append(")").append(local).append(";").append(EGFCommonConstants.LINE_SEPARATOR);
            localContent.append("parameterValues.put(\"").append(parameter.getName()).append("\", ").append(local).append(");").append(EGFCommonConstants.LINE_SEPARATOR);
        }
        content.insert(startIndex + START_METHOD_MARKER.length(), localContent);
    }

    private String getParameterListName(PatternParameter parameter) {
        return parameter.getName() + "List";
    }

    private void appendQueryCode(StringBuilder localContent, PatternParameter parameter) throws PatternException {
        Query query = parameter.getQuery();
        if (query == null) {
            // there is no query, so this pattern can only be called by another
            // (i.e. it's an entry point in execution)
            localContent.append("List<Object> ").append(getParameterListName(parameter)).append(" = null;").append(EGFCommonConstants.LINE_SEPARATOR);
            localContent.append("//this pattern can only be called by another (i.e. it's not an entry point in execution)").append(EGFCommonConstants.LINE_SEPARATOR);
            return;
        }
        localContent.append("paramDesc = new IQuery.ParameterDescription(\"").append(parameter.getName()).append("\", \"").append(parameter.getType()).append("\");").append(EGFCommonConstants.LINE_SEPARATOR);
        localContent.append("queryCtx = new HashMap<String, String>();").append(EGFCommonConstants.LINE_SEPARATOR);
        if (query.getQueryContext() != null) {
            for (String key : query.getQueryContext().keySet()) {
                localContent.append("queryCtx.put(\"").append(key).append("\", \"").append(query.getQueryContext().get(key)).append("\");").append(EGFCommonConstants.LINE_SEPARATOR);
            }
        }

        localContent.append("List<Object> ").append(getParameterListName(parameter)).append(" = ");
        localContent.append("QueryHelper.load(ctx, \"").append(query.getExtensionId()).append("\").execute(paramDesc, queryCtx, ctx);").append(EGFCommonConstants.LINE_SEPARATOR);
    }

    @Override
    protected void addVariableInitialization() throws PatternException {
        content.append("<%").append(START_INIT_VARIABLE_MARKER).append("%>");
        content.append(getMethodContent(pattern.getInitMethod()));
        content.append("<%").append(END_INIT_VARIABLE_MARKER).append("%>");
    }

}
