package test;


import javax.tools.*;
import java.util.Arrays;
import java.util.List;

public class App {

	public static void main(String[] args) throws Exception {
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		DiagnosticCollector diagnosticsCollector = 	new DiagnosticCollector();

		StandardJavaFileManager fileManager  = compiler.getStandardFileManager(diagnosticsCollector, null, null);
		JavaFileObject javaObjectFromString = getJavaFileContentsAsString();

		Iterable fileObjects = Arrays.asList(javaObjectFromString);

		JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, diagnosticsCollector, null, null, fileObjects);

		// после этой строчки будет создан класс TestClass.class
		Boolean result = task.call();
		List<Diagnostic> diagnostics = diagnosticsCollector.getDiagnostics();

		for(Diagnostic d : diagnostics){
			// Print all the information here.
		}
		if(result == true){
			System.out.println("Compilation has succeeded");
		}else{
			System.out.println("Compilation fails.");
		}
	}

	static SimpleJavaFileObject getJavaFileContentsAsString(){
		StringBuilder javaFileContents = new StringBuilder("" +
				"class TestClass{" +
				"	public void testMethod(){" +
				"		System.out.println(" + "\"test\"" +           ");" +
				"}" +
				"}");
		JavaObjectFromString javaFileObject = null;
		try{
			javaFileObject = new JavaObjectFromString("TestClass", javaFileContents.toString());
		}catch(Exception exception){
			exception.printStackTrace();
		}
		return javaFileObject;
	}
}
