package org.eclipse.egf.emf.pattern.editor;

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

public class ModelIcon extends org.eclipse.egf.emf.pattern.base.GenPackageGIF {
  protected static String nl;
  public static synchronized ModelIcon create(String lineSeparator)
  {
    nl = lineSeparator;
    ModelIcon result = new ModelIcon();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;

	public ModelIcon()
	{
	//Here is the constructor
StringBuffer stringBuffer = new StringBuffer();

    // add initialisation of the pattern variables (declaration has been already done).
    
	}
  	
  	public String generate(Object argument) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    InternalPatternContext ctx = (InternalPatternContext)argument;
Map<String, String> queryCtx = null;
IQuery.ParameterDescription paramDesc = null;

    
List<Object> parameterList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)


for (Object parameterParameter : parameterList ) {

this.parameter = (org.eclipse.emf.codegen.ecore.genmodel.GenPackage)parameterParameter;


    orchestration(ctx);
    
}
if (ctx.useReporter()){
    ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);
    ctx.clearBuffer();
}
    
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    return stringBuffer.toString();
  }
public String orchestration(PatternContext ctx) throws Exception  {
InternalPatternContext ictx = (InternalPatternContext)ctx;
int index = 0, executionIndex = ictx.getExecutionBuffer().length();

    super.orchestration(new SuperOrchestrationContext(ictx));

    
method_preGenerate(ictx.getBuffer(), ictx);
    
method_doGenerate(ictx.getBuffer(), ictx);
    {
final Map<String, Object> parameters = new HashMap<String, Object>();
index = ictx.getBuffer().length();
ictx.getExecutionBuffer().append(ictx.getBuffer());
parameters.put("parameter", this.parameter);
CallbackContext ctx_callback = new CallbackContext(ictx);
CallHelper.callBack(ctx_callback, parameters);
}

    
method_postGenerate(ictx.getBuffer(), ictx);
    
String loop = ictx.getBuffer().toString();
if (ictx.useReporter()){
    ictx.getExecutionBuffer().append(ictx.getBuffer().substring(index));
    Map<String, Object> parameterValues = new HashMap<String, Object>();
    parameterValues.put("parameter", this.parameter);
    String outputWithCallBack = ictx.getExecutionBuffer().substring(executionIndex);
    ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
    ictx.clearBuffer();}
return loop;
} 


    protected void method_setReporterVariables(final StringBuffer stringBuffer, final PatternContext ctx)throws Exception {

    
canGenerate = new CodegenGeneratorAdapter(genModel).canGenerate(parameter, "org.eclipse.emf.codegen.ecore.genmodel.generator.EditorProject");

    }
    protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx)throws Exception {

    
if (!canGenerate)
    return;
new CodegenGeneratorAdapter(genModel).ensureProjectExists(genModel.getEditorDirectory(), genModel, GenBaseGeneratorAdapter.EDITOR_PROJECT_TYPE, genModel.isUpdateClasspath(), new BasicMonitor());
GenPackage genPackage = parameter;
if (genPackage.hasConcreteClasses()) {
new CodegenGeneratorAdapter(genModel).generateGIF(parameter, "editor/ModelFile.gif", genPackage.getModelIconFileName(), genPackage.getPrefix(), null, false);
}
 else {
}

    }
    }