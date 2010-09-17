/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.java.engine;

import org.eclipse.egf.common.constant.EGFCommonConstants;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.model.pattern.PatternParameter;
import org.eclipse.egf.model.pattern.Query;
import org.eclipse.egf.pattern.common.java.BaseJavaAssemblyHelper;
import org.eclipse.egf.pattern.engine.AssemblyHelper;
import org.eclipse.egf.pattern.engine.PatternHelper;
import org.eclipse.egf.pattern.utils.ParameterTypeHelper;

/**
 * @author Thomas Guiu
 */
public class JavaAssemblyHelper extends BaseJavaAssemblyHelper {

    public static final String CONSTRUCTOR_MARKER = "//Here is the constructor"; //$NON-NLS-1$

    public JavaAssemblyHelper(Pattern pattern, JavaAssemblyContentProvider contentProvider) {
        super(pattern, contentProvider);
    }

    @Override
    protected void addVariableInitialization() throws PatternException {
        int indexOf = content.indexOf(CONSTRUCTOR_MARKER);
        if (indexOf == -1)
            throw new IllegalStateException();
        content.insert(indexOf + CONSTRUCTOR_MARKER.length() + 1, contentHelper.getMethodContent(pattern.getInitMethod()));
    }

    @Override
    protected void beginOrchestration() throws PatternException {
        content.append("public void generate (Object argument) throws Exception {").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
        content.append("InternalPatternContext ctx = (InternalPatternContext)argument;").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
        content.append("IQuery.ParameterDescription paramDesc = null;").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
        content.append("Map<String, String> queryCtx = null;").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
        super.beginOrchestration();

        if (!pattern.getAllParameters().isEmpty()) {

            for (PatternParameter parameter : pattern.getAllParameters()) {
                appendQueryCode(content, parameter);
            }

            content.append(EGFCommonConstants.LINE_SEPARATOR).append(EGFCommonConstants.LINE_SEPARATOR);

            // create a loop per parameter
            for (PatternParameter parameter : pattern.getAllParameters()) {
                String local = PatternHelper.localizeName(parameter);
                content.append("for (Object ").append(local).append(" : ").append(getParameterListName(parameter)).append(" ) {").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            }
            content.append(EGFCommonConstants.LINE_SEPARATOR);
            for (org.eclipse.egf.model.pattern.PatternParameter parameter : pattern.getAllParameters()) {
                String local = PatternHelper.localizeName(parameter);
                String type = ParameterTypeHelper.INSTANCE.getSourceTypeLiteral(parameter.getType());
                content.append("this.").append(parameter.getName()).append(" = (").append(type).append(")").append(local).append(";").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
            }
            if (pattern.getConditionMethod() != null) {
                content.append(EGFCommonConstants.LINE_SEPARATOR);
                content.append("if (preCondition())"); //$NON-NLS-1$
            }
            content.append(EGFCommonConstants.LINE_SEPARATOR);

            content.append(AssemblyHelper.ORCHESTRATION_METHOD).append("((PatternContext)argument);").append(EGFCommonConstants.LINE_SEPARATOR).append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$

            // 2 - Add post block at current index
            for (int i = 0; i < pattern.getAllParameters().size(); i++)
                content.append("}").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
        } else {
            if (pattern.getConditionMethod() != null) {
                content.append(EGFCommonConstants.LINE_SEPARATOR);
                content.append("if (preCondition())"); //$NON-NLS-1$
            }
            content.append(EGFCommonConstants.LINE_SEPARATOR).append(AssemblyHelper.ORCHESTRATION_METHOD).append("((PatternContext)argument);").append(EGFCommonConstants.LINE_SEPARATOR).append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
        }
        content.append("if (ctx.useReporter()){").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
        content.append("    ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
        content.append("    ctx.clearBuffer();}").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
        // end of method generate (Object argument)
        content.append("}").append(EGFCommonConstants.LINE_SEPARATOR).append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$

        // add new method body
        content.append("public String ").append(AssemblyHelper.ORCHESTRATION_METHOD).append("(PatternContext ctx) throws Exception {").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$ //$NON-NLS-2$
        content.append("InternalPatternContext ictx = (InternalPatternContext)ctx;").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
        content.append("int executionIndex = ictx.getExecutionBuffer().length();").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
    }

    /**
     * TODO quick work to validate the whole process, needs a plugable way to
     * add this stuff.
     */
    @Override
    protected void endOrchestration() throws PatternException {

        content.append(EGFCommonConstants.LINE_SEPARATOR).append("String loop = ictx.getBuffer().toString();").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
        boolean hasParameter = !pattern.getAllParameters().isEmpty();
        content.append("if (ictx.useReporter()){").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
        content.append("    ictx.getExecutionBuffer().append(ictx.getBuffer().substring(ictx.getExecutionCurrentIndex()));").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
        content.append("    ictx.setExecutionCurrentIndex(0);").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
        if (hasParameter) {
            content.append("Map<String, Object> parameterValues = new HashMap<String, Object>();").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
            for (org.eclipse.egf.model.pattern.PatternParameter parameter : pattern.getAllParameters()) {
                content.append("parameterValues.put(\"").append(parameter.getName()).append("\", this.").append(parameter.getName()).append(");").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            }
            content.append("    String outputWithCallBack = ictx.getExecutionBuffer().substring(executionIndex);").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
            content.append("    ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
        }

        content.append("    ictx.clearBuffer();}").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
        content.append("return loop;").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
        // end of method generate(PatternContext ctx, ...)
        content.append("}").append(EGFCommonConstants.LINE_SEPARATOR).append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$

    }

    private String getParameterListName(PatternParameter parameter) {
        return parameter.getName() + "List"; //$NON-NLS-1$
    }

    @SuppressWarnings("unused")
    private void appendQueryCode(StringBuilder localContent, PatternParameter parameter) throws PatternException {
        Query query = parameter.getQuery();
        if (query == null) {
            // there is no query, so this pattern can only be called by another
            // (i.e. it's an entry point in execution)
            localContent.append("List<Object> ").append(getParameterListName(parameter)).append(" = null;").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$ //$NON-NLS-2$
            localContent.append("//this pattern can only be called by another (i.e. it's not an entry point in execution)").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
            return;
        }
        localContent.append("paramDesc = new IQuery.ParameterDescription(\"").append(parameter.getName()).append("\", \"").append(parameter.getType()).append("\");").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        localContent.append("queryCtx = new HashMap<String, String>();").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
        if (query.getQueryContext() != null) {
            for (String key : query.getQueryContext().keySet()) {
                localContent.append("queryCtx.put(\"").append(key).append("\", \"").append(query.getQueryContext().get(key)).append("\");").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            }
        }

        localContent.append("List<Object> ").append(getParameterListName(parameter)).append(" = "); //$NON-NLS-1$ //$NON-NLS-2$
        localContent.append("QueryHelper.load(ctx, \"").append(query.getExtensionId()).append("\").execute(paramDesc, queryCtx, ctx);").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$ //$NON-NLS-2$
    }

}
