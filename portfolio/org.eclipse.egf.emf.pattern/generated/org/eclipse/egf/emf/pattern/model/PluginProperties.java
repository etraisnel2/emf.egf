package org.eclipse.egf.emf.pattern.model;

import org.eclipse.egf.emf.pattern.base.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.emf.codegen.ecore.genmodel.impl.*;
import org.eclipse.emf.codegen.ecore.genmodel.generator.*;
import org.eclipse.emf.codegen.util.*;
import org.eclipse.emf.ecore.util.*;
import org.eclipse.emf.common.util.*;
import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class PluginProperties extends org.eclipse.egf.emf.pattern.base.GenModelProperties {
	protected static String nl;

	public static synchronized PluginProperties create(String lineSeparator) {
		nl = lineSeparator;
		PluginProperties result = new PluginProperties();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "";
	protected final String TEXT_2 = NL + NL + "pluginName = ";
	protected final String TEXT_3 = " Model" + NL + "providerName = www.example.org";
	protected final String TEXT_4 = NL;
	protected final String TEXT_5 = NL + "_UI_";
	protected final String TEXT_6 = "_content_type = ";
	protected final String TEXT_7 = " File";
	protected final String TEXT_8 = NL;
	protected final String TEXT_9 = NL;
	protected final String TEXT_10 = NL;

	public PluginProperties() {
		//Here is the constructor
		StringBuffer stringBuffer = new StringBuffer();

		// add initialisation of the pattern variables (declaration has been already done).

	}

	public String generate(Object argument) throws Exception {
		final StringBuffer stringBuffer = new StringBuffer();

		InternalPatternContext ctx = (InternalPatternContext) argument;
		Map<String, String> queryCtx = null;
		IQuery.ParameterDescription paramDesc = null;

		List<Object> parameterList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object parameterParameter : parameterList) {

			this.parameter = (org.eclipse.emf.codegen.ecore.genmodel.GenModel) parameterParameter;

			if (preCondition())
				orchestration(ctx);

		}
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);
			ctx.clearBuffer();
		}

		stringBuffer.append(TEXT_9);
		stringBuffer.append(TEXT_10);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		int executionIndex = ictx.getExecutionBuffer().length();

		super.orchestration(new SuperOrchestrationContext(ictx));

		method_preGenerate(ictx.getBuffer(), ictx);

		method_doGenerate(ictx.getBuffer(), ictx);
		{
			ictx.setExecutionCurrentIndex(ictx.getBuffer().length());
			ictx.getExecutionBuffer().append(ictx.getBuffer());
			final Map<String, Object> parameters = getParameters();
			CallbackContext ctx_callback = new CallbackContext(ictx);
			CallHelper.callBack(ctx_callback, parameters);
		}

		method_postGenerate(ictx.getBuffer(), ictx);

		String loop = ictx.getBuffer().toString();
		if (ictx.useReporter()) {
			ictx.getExecutionBuffer().append(ictx.getBuffer().substring(ictx.getExecutionCurrentIndex()));
			ictx.setExecutionCurrentIndex(0);
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("parameter", this.parameter);
			String outputWithCallBack = ictx.getExecutionBuffer().substring(executionIndex);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
			ictx.clearBuffer();
		}
		return loop;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

	protected void method_setReporterVariables(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		GenModel genModel = parameter;
		targetPathName = genModel.getModelProjectDirectory() + "/plugin.properties";

	}

	protected void method_setArgument(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		GenModel genModel = parameter;
		argument = parameter;

	}

	protected void method_ensureProjectExists(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		new CodegenGeneratorAdapter(parameter).ensureProjectExists(genModel.getModelDirectory(), genModel,
				GenBaseGeneratorAdapter.MODEL_PROJECT_TYPE, genModel.isUpdateClasspath(), new BasicMonitor());

	}

	protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		/**
		 * <copyright>
		 *
		 * Copyright (c) 2002-2004 IBM Corporation and others.
		 * All rights reserved.   This program and the accompanying materials
		 * are made available under the terms of the Eclipse Public License v1.0
		 * which accompanies this distribution, and is available at
		 * http://www.eclipse.org/legal/epl-v10.html
		 * 
		 * Contributors: 
		 *   IBM - Initial API and implementation
		 *
		 * </copyright>
		 */

		GenModel genModel = (GenModel) argument;
		stringBuffer.append(TEXT_1);
		{
			final Map<String, Object> callParameters = new HashMap<String, Object>();
			callParameters.put("argument", parameter);
			CallHelper.executeWithParameterInjection(
					"platform:/plugin/org.eclipse.egf.emf.pattern.base/egf/EMF_Pattern_Base.fcore#_FEoPwCwuEd-jc5T-XaRJlg",
					new ExecutionContext((InternalPatternContext) ctx), callParameters);
		}

		stringBuffer.append(TEXT_2);
		stringBuffer.append(genModel.getModelName());
		stringBuffer.append(TEXT_3);
		boolean first = true;
		for (GenPackage genPackage : genModel.getAllGenPackagesWithClassifiers()) {
			if (genPackage.isContentType()) {
				if (first) {
					first = false;
					stringBuffer.append(TEXT_4);
				}
				stringBuffer.append(TEXT_5);
				stringBuffer.append(genPackage.getPrefix());
				stringBuffer.append(TEXT_6);
				stringBuffer.append(genPackage.getPrefix());
				stringBuffer.append(TEXT_7);
			}
		}
		stringBuffer.append(TEXT_8);
	}

	public boolean preCondition() throws Exception {
		GenModel genModel = parameter;
		genModel = parameter.getGenModel();
		boolean canGenerate = new CodegenGeneratorAdapter(parameter)
				.canGenerate("org.eclipse.emf.codegen.ecore.genmodel.generator.ModelProject");
		canGenerate = canGenerate && (genModel.hasPluginSupport());
		return canGenerate;
	}
}