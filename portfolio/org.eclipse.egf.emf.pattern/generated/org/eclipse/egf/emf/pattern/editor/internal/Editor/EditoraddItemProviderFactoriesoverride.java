package org.eclipse.egf.emf.pattern.editor.internal.Editor;

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

public class EditoraddItemProviderFactoriesoverride 
{
  protected static String nl;
  public static synchronized EditoraddItemProviderFactoriesoverride create(String lineSeparator)
  {
    nl = lineSeparator;
    EditoraddItemProviderFactoriesoverride result = new EditoraddItemProviderFactoriesoverride();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\tadapterFactory.addAdapterFactory(new ";
  protected final String TEXT_2 = "());";
  protected final String TEXT_3 = NL + "\t\tadapterFactory.addAdapterFactory(new ";
  protected final String TEXT_4 = "());";
  protected final String TEXT_5 = NL;
  protected final String TEXT_6 = NL;
  protected final String TEXT_7 = NL;
  protected final String TEXT_8 = NL;

	public EditoraddItemProviderFactoriesoverride()
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

    
List<Object> genPackageList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)
List<Object> genModelList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)
List<Object> importedOperationClassNameList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)
List<Object> operationMethodNameList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)
List<Object> _ArrayListOfObjectList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)
List<Object> _ArrayListOfSelectionChangedListenerList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)
List<Object> _CollectionOfSelectionChangedListenerList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)
List<Object> _ArrayListOfResourceList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)
List<Object> _CollectionOfResourceList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)
List<Object> _MapOfResourceToDiagnosticList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)
List<Object> _HashMapOfResourceToBooleanList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)
List<Object> _MapOfObjectToObjectList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)
List<Object> _HashMapOfObjectToObjectList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)
List<Object> _LinkedHashMapOfResourceToDiagnosticList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)
List<Object> _CollectionOfAnythingList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)
List<Object> _ListOfAnythingList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)
List<Object> useExtendedLabelProviderList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)
List<Object> _AdapterFactoryLabelProviderList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)
List<Object> _ArrayListOfStringList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)
List<Object> _ListOfStringList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)


for (Object genPackageParameter : genPackageList ) {
for (Object genModelParameter : genModelList ) {
for (Object importedOperationClassNameParameter : importedOperationClassNameList ) {
for (Object operationMethodNameParameter : operationMethodNameList ) {
for (Object _ArrayListOfObjectParameter : _ArrayListOfObjectList ) {
for (Object _ArrayListOfSelectionChangedListenerParameter : _ArrayListOfSelectionChangedListenerList ) {
for (Object _CollectionOfSelectionChangedListenerParameter : _CollectionOfSelectionChangedListenerList ) {
for (Object _ArrayListOfResourceParameter : _ArrayListOfResourceList ) {
for (Object _CollectionOfResourceParameter : _CollectionOfResourceList ) {
for (Object _MapOfResourceToDiagnosticParameter : _MapOfResourceToDiagnosticList ) {
for (Object _HashMapOfResourceToBooleanParameter : _HashMapOfResourceToBooleanList ) {
for (Object _MapOfObjectToObjectParameter : _MapOfObjectToObjectList ) {
for (Object _HashMapOfObjectToObjectParameter : _HashMapOfObjectToObjectList ) {
for (Object _LinkedHashMapOfResourceToDiagnosticParameter : _LinkedHashMapOfResourceToDiagnosticList ) {
for (Object _CollectionOfAnythingParameter : _CollectionOfAnythingList ) {
for (Object _ListOfAnythingParameter : _ListOfAnythingList ) {
for (Object useExtendedLabelProviderParameter : useExtendedLabelProviderList ) {
for (Object _AdapterFactoryLabelProviderParameter : _AdapterFactoryLabelProviderList ) {
for (Object _ArrayListOfStringParameter : _ArrayListOfStringList ) {
for (Object _ListOfStringParameter : _ListOfStringList ) {

this.genPackage = (org.eclipse.emf.codegen.ecore.genmodel.GenPackage)genPackageParameter;
this.genModel = (org.eclipse.emf.codegen.ecore.genmodel.GenModel)genModelParameter;
this.importedOperationClassName = (java.lang.String)importedOperationClassNameParameter;
this.operationMethodName = (java.lang.String)operationMethodNameParameter;
this._ArrayListOfObject = (java.lang.String)_ArrayListOfObjectParameter;
this._ArrayListOfSelectionChangedListener = (java.lang.String)_ArrayListOfSelectionChangedListenerParameter;
this._CollectionOfSelectionChangedListener = (java.lang.String)_CollectionOfSelectionChangedListenerParameter;
this._ArrayListOfResource = (java.lang.String)_ArrayListOfResourceParameter;
this._CollectionOfResource = (java.lang.String)_CollectionOfResourceParameter;
this._MapOfResourceToDiagnostic = (java.lang.String)_MapOfResourceToDiagnosticParameter;
this._HashMapOfResourceToBoolean = (java.lang.String)_HashMapOfResourceToBooleanParameter;
this._MapOfObjectToObject = (java.lang.String)_MapOfObjectToObjectParameter;
this._HashMapOfObjectToObject = (java.lang.String)_HashMapOfObjectToObjectParameter;
this._LinkedHashMapOfResourceToDiagnostic = (java.lang.String)_LinkedHashMapOfResourceToDiagnosticParameter;
this._CollectionOfAnything = (java.lang.String)_CollectionOfAnythingParameter;
this._ListOfAnything = (java.lang.String)_ListOfAnythingParameter;
this.useExtendedLabelProvider = (java.lang.Boolean)useExtendedLabelProviderParameter;
this._AdapterFactoryLabelProvider = (java.lang.String)_AdapterFactoryLabelProviderParameter;
this._ArrayListOfString = (java.lang.String)_ArrayListOfStringParameter;
this._ListOfString = (java.lang.String)_ListOfStringParameter;


    orchestration(ctx);
    
}
}
}
}
}
}
}
}
}
}
}
}
}
}
}
}
}
}
}
}
if (ctx.useReporter()){
    ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);
    ctx.clearBuffer();
}
    
    stringBuffer.append(TEXT_7);
    stringBuffer.append(TEXT_8);
    return stringBuffer.toString();
  }
public String orchestration(PatternContext ctx) throws Exception  {
InternalPatternContext ictx = (InternalPatternContext)ctx;
int executionIndex = ictx.getExecutionBuffer().length();

    
    
method_doGenerate(ictx.getBuffer(), ictx);
    
String loop = ictx.getBuffer().toString();
if (ictx.useReporter()){
    ictx.getExecutionBuffer().append(ictx.getBuffer().substring(ictx.getExecutionCurrentIndex()));
    ictx.setExecutionCurrentIndex(0);
    Map<String, Object> parameterValues = new HashMap<String, Object>();
    parameterValues.put("genPackage", this.genPackage);
    parameterValues.put("genModel", this.genModel);
    parameterValues.put("importedOperationClassName", this.importedOperationClassName);
    parameterValues.put("operationMethodName", this.operationMethodName);
    parameterValues.put("_ArrayListOfObject", this._ArrayListOfObject);
    parameterValues.put("_ArrayListOfSelectionChangedListener", this._ArrayListOfSelectionChangedListener);
    parameterValues.put("_CollectionOfSelectionChangedListener", this._CollectionOfSelectionChangedListener);
    parameterValues.put("_ArrayListOfResource", this._ArrayListOfResource);
    parameterValues.put("_CollectionOfResource", this._CollectionOfResource);
    parameterValues.put("_MapOfResourceToDiagnostic", this._MapOfResourceToDiagnostic);
    parameterValues.put("_HashMapOfResourceToBoolean", this._HashMapOfResourceToBoolean);
    parameterValues.put("_MapOfObjectToObject", this._MapOfObjectToObject);
    parameterValues.put("_HashMapOfObjectToObject", this._HashMapOfObjectToObject);
    parameterValues.put("_LinkedHashMapOfResourceToDiagnostic", this._LinkedHashMapOfResourceToDiagnostic);
    parameterValues.put("_CollectionOfAnything", this._CollectionOfAnything);
    parameterValues.put("_ListOfAnything", this._ListOfAnything);
    parameterValues.put("useExtendedLabelProvider", this.useExtendedLabelProvider);
    parameterValues.put("_AdapterFactoryLabelProvider", this._AdapterFactoryLabelProvider);
    parameterValues.put("_ArrayListOfString", this._ArrayListOfString);
    parameterValues.put("_ListOfString", this._ListOfString);
    String outputWithCallBack = ictx.getExecutionBuffer().substring(executionIndex);
    ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
    ictx.clearBuffer();}
return loop;
} 

protected org.eclipse.emf.codegen.ecore.genmodel.GenPackage genPackage = null;
public void set_genPackage(org.eclipse.emf.codegen.ecore.genmodel.GenPackage object) {
this.genPackage = object;
}
protected org.eclipse.emf.codegen.ecore.genmodel.GenModel genModel = null;
public void set_genModel(org.eclipse.emf.codegen.ecore.genmodel.GenModel object) {
this.genModel = object;
}
protected java.lang.String importedOperationClassName = null;
public void set_importedOperationClassName(java.lang.String object) {
this.importedOperationClassName = object;
}
protected java.lang.String operationMethodName = null;
public void set_operationMethodName(java.lang.String object) {
this.operationMethodName = object;
}
protected java.lang.String _ArrayListOfObject = null;
public void set__ArrayListOfObject(java.lang.String object) {
this._ArrayListOfObject = object;
}
protected java.lang.String _ArrayListOfSelectionChangedListener = null;
public void set__ArrayListOfSelectionChangedListener(java.lang.String object) {
this._ArrayListOfSelectionChangedListener = object;
}
protected java.lang.String _CollectionOfSelectionChangedListener = null;
public void set__CollectionOfSelectionChangedListener(java.lang.String object) {
this._CollectionOfSelectionChangedListener = object;
}
protected java.lang.String _ArrayListOfResource = null;
public void set__ArrayListOfResource(java.lang.String object) {
this._ArrayListOfResource = object;
}
protected java.lang.String _CollectionOfResource = null;
public void set__CollectionOfResource(java.lang.String object) {
this._CollectionOfResource = object;
}
protected java.lang.String _MapOfResourceToDiagnostic = null;
public void set__MapOfResourceToDiagnostic(java.lang.String object) {
this._MapOfResourceToDiagnostic = object;
}
protected java.lang.String _HashMapOfResourceToBoolean = null;
public void set__HashMapOfResourceToBoolean(java.lang.String object) {
this._HashMapOfResourceToBoolean = object;
}
protected java.lang.String _MapOfObjectToObject = null;
public void set__MapOfObjectToObject(java.lang.String object) {
this._MapOfObjectToObject = object;
}
protected java.lang.String _HashMapOfObjectToObject = null;
public void set__HashMapOfObjectToObject(java.lang.String object) {
this._HashMapOfObjectToObject = object;
}
protected java.lang.String _LinkedHashMapOfResourceToDiagnostic = null;
public void set__LinkedHashMapOfResourceToDiagnostic(java.lang.String object) {
this._LinkedHashMapOfResourceToDiagnostic = object;
}
protected java.lang.String _CollectionOfAnything = null;
public void set__CollectionOfAnything(java.lang.String object) {
this._CollectionOfAnything = object;
}
protected java.lang.String _ListOfAnything = null;
public void set__ListOfAnything(java.lang.String object) {
this._ListOfAnything = object;
}
protected java.lang.Boolean useExtendedLabelProvider = null;
public void set_useExtendedLabelProvider(java.lang.Boolean object) {
this.useExtendedLabelProvider = object;
}
protected java.lang.String _AdapterFactoryLabelProvider = null;
public void set__AdapterFactoryLabelProvider(java.lang.String object) {
this._AdapterFactoryLabelProvider = object;
}
protected java.lang.String _ArrayListOfString = null;
public void set__ArrayListOfString(java.lang.String object) {
this._ArrayListOfString = object;
}
protected java.lang.String _ListOfString = null;
public void set__ListOfString(java.lang.String object) {
this._ListOfString = object;
}
public Map<String, Object> getParameters() {
final Map<String, Object> parameters = new HashMap<String, Object>();
parameters.put("genPackage", this.genPackage);
parameters.put("genModel", this.genModel);
parameters.put("importedOperationClassName", this.importedOperationClassName);
parameters.put("operationMethodName", this.operationMethodName);
parameters.put("_ArrayListOfObject", this._ArrayListOfObject);
parameters.put("_ArrayListOfSelectionChangedListener", this._ArrayListOfSelectionChangedListener);
parameters.put("_CollectionOfSelectionChangedListener", this._CollectionOfSelectionChangedListener);
parameters.put("_ArrayListOfResource", this._ArrayListOfResource);
parameters.put("_CollectionOfResource", this._CollectionOfResource);
parameters.put("_MapOfResourceToDiagnostic", this._MapOfResourceToDiagnostic);
parameters.put("_HashMapOfResourceToBoolean", this._HashMapOfResourceToBoolean);
parameters.put("_MapOfObjectToObject", this._MapOfObjectToObject);
parameters.put("_HashMapOfObjectToObject", this._HashMapOfObjectToObject);
parameters.put("_LinkedHashMapOfResourceToDiagnostic", this._LinkedHashMapOfResourceToDiagnostic);
parameters.put("_CollectionOfAnything", this._CollectionOfAnything);
parameters.put("_ListOfAnything", this._ListOfAnything);
parameters.put("useExtendedLabelProvider", this.useExtendedLabelProvider);
parameters.put("_AdapterFactoryLabelProvider", this._AdapterFactoryLabelProvider);
parameters.put("_ArrayListOfString", this._ArrayListOfString);
parameters.put("_ListOfString", this._ListOfString);
return parameters; }

    protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx)throws Exception {

    for (GenPackage aGenPackage : genModel.getAllGenPackagesWithClassifiers()) {
    if (!aGenPackage.getGenClasses().isEmpty() && aGenPackage.getGenModel().hasEditSupport()) {
    stringBuffer.append(TEXT_1);
    stringBuffer.append(aGenPackage.getImportedItemProviderAdapterFactoryClassName());
    stringBuffer.append(TEXT_2);
    }
    }
    for (GenPackage aGenPackage : genModel.getAllUsedGenPackagesWithClassifiers()) {
    if (!aGenPackage.getGenClasses().isEmpty() && aGenPackage.getGenModel().hasEditSupport()) {
    stringBuffer.append(TEXT_3);
    stringBuffer.append(aGenPackage.getImportedItemProviderAdapterFactoryClassName());
    stringBuffer.append(TEXT_4);
    }
    }
    stringBuffer.append(TEXT_5);
    final Map<String, Object> parameters__289lsGKMEd_wNQtGaQlw = new HashMap<String, Object>();
parameters__289lsGKMEd_wNQtGaQlw.put("genPackage", genPackage);
parameters__289lsGKMEd_wNQtGaQlw.put("genModel", genModel);
parameters__289lsGKMEd_wNQtGaQlw.put("importedOperationClassName", importedOperationClassName);
parameters__289lsGKMEd_wNQtGaQlw.put("operationMethodName", operationMethodName);
parameters__289lsGKMEd_wNQtGaQlw.put("_ArrayListOfObject", _ArrayListOfObject);
parameters__289lsGKMEd_wNQtGaQlw.put("_ArrayListOfSelectionChangedListener", _ArrayListOfSelectionChangedListener);
parameters__289lsGKMEd_wNQtGaQlw.put("_CollectionOfSelectionChangedListener", _CollectionOfSelectionChangedListener);
parameters__289lsGKMEd_wNQtGaQlw.put("_ArrayListOfResource", _ArrayListOfResource);
parameters__289lsGKMEd_wNQtGaQlw.put("_CollectionOfResource", _CollectionOfResource);
parameters__289lsGKMEd_wNQtGaQlw.put("_MapOfResourceToDiagnostic", _MapOfResourceToDiagnostic);
parameters__289lsGKMEd_wNQtGaQlw.put("_HashMapOfResourceToBoolean", _HashMapOfResourceToBoolean);
parameters__289lsGKMEd_wNQtGaQlw.put("_MapOfObjectToObject", _MapOfObjectToObject);
parameters__289lsGKMEd_wNQtGaQlw.put("_HashMapOfObjectToObject", _HashMapOfObjectToObject);
parameters__289lsGKMEd_wNQtGaQlw.put("_LinkedHashMapOfResourceToDiagnostic", _LinkedHashMapOfResourceToDiagnostic);
parameters__289lsGKMEd_wNQtGaQlw.put("_CollectionOfAnything", _CollectionOfAnything);
parameters__289lsGKMEd_wNQtGaQlw.put("_ListOfAnything", _ListOfAnything);
parameters__289lsGKMEd_wNQtGaQlw.put("useExtendedLabelProvider", useExtendedLabelProvider);
parameters__289lsGKMEd_wNQtGaQlw.put("_AdapterFactoryLabelProvider", _AdapterFactoryLabelProvider);
parameters__289lsGKMEd_wNQtGaQlw.put("_ArrayListOfString", _ArrayListOfString);
parameters__289lsGKMEd_wNQtGaQlw.put("_ListOfString", _ListOfString);
CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_09RHMGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), parameters__289lsGKMEd_wNQtGaQlw);

    stringBuffer.append(TEXT_6);
    }
    }