package linefeed2;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class all2 
{
  protected static String nl;
  public static synchronized all2 create(String lineSeparator)
  {
    nl = lineSeparator;
    all2 result = new all2();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "c";
  protected final String TEXT_2 = "d";
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = NL;

	public all2()
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

    orchestration(ctx);
    if (ctx.useReporter()){
    ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);
    ctx.clearBuffer();}
    
    stringBuffer.append(TEXT_3);
    stringBuffer.append(TEXT_4);
    return stringBuffer.toString();
  }
public String orchestration(PatternContext ctx) throws Exception  {
InternalPatternContext ictx = (InternalPatternContext)ctx;
int executionIndex = ictx.getExecutionBuffer().length();

    
    {
final Map<String, Object> parameters = new HashMap<String, Object>();
ExecutionContext ctx__XVD1kGJlEd_VJO7D32Myg = new ExecutionContext(ictx);
CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.core.test.pattern/fc/linefeed.fcore#_id8LsF3JEd-mZb1ihLU3ug", ctx__XVD1kGJlEd_VJO7D32Myg, parameters);
}

    {
final Map<String, Object> parameters = new HashMap<String, Object>();
ExecutionContext ctx__XVD1kWJlEd_VJO7D32Myg = new ExecutionContext(ictx);
CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.core.test.pattern/fc/linefeed.fcore#_sv0rMF3JEd-mZb1ihLU3ug", ctx__XVD1kWJlEd_VJO7D32Myg, parameters);
}

    
method_d(ictx.getBuffer(), ictx);
    
method_c(ictx.getBuffer(), ictx);
    
String loop = ictx.getBuffer().toString();
if (ictx.useReporter()){
    ictx.getExecutionBuffer().append(ictx.getBuffer().substring(ictx.getExecutionCurrentIndex()));
    ictx.setExecutionCurrentIndex(0);
    ictx.clearBuffer();}
return loop;
} 

public Map<String, Object> getParameters() {
final Map<String, Object> parameters = new HashMap<String, Object>();
return parameters; }

    protected void method_c(final StringBuffer stringBuffer, final PatternContext ctx)throws Exception {

    stringBuffer.append(TEXT_1);
    }
    protected void method_d(final StringBuffer stringBuffer, final PatternContext ctx)throws Exception {

    stringBuffer.append(TEXT_2);
    }
    }