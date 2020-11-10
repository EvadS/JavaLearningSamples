package hello;

import org.joda.time.LocalTime;

import javax.tools.*;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.nio.file.Path;
import java.util.*;

public class App {

	public static void main(String[] args) {



	}


    private static class StringJavaFileObject extends SimpleJavaFileObject {
        private final String code;

        public StringJavaFileObject(String name, String code) {
            super(URI.create("string:///" + name.replace('.', '/') + Kind.SOURCE.extension),
                    Kind.SOURCE);
            this.code = code;
        }

        @Override
        public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
            return code;
        }
    }

    private static class ClassJavaFileObject extends SimpleJavaFileObject {
        private final ByteArrayOutputStream outputStream;
        private final String className;

        protected ClassJavaFileObject(String className, Kind kind) {
            super(URI.create("mem:///" + className.replace('.', '/') + kind.extension), kind);
            this.className = className;
            outputStream = new ByteArrayOutputStream();
        }

        @Override
        public OutputStream openOutputStream() throws IOException {
            return outputStream;
        }

        public byte[] getBytes() {
            return outputStream.toByteArray();
        }

        public String getClassName() {
            return className;
        }
    }

    private static class SimpleJavaFileManager extends ForwardingJavaFileManager {
        private final List<ClassJavaFileObject> outputFiles;

        protected SimpleJavaFileManager(JavaFileManager fileManager) {
            super(fileManager);
            outputFiles = new ArrayList<ClassJavaFileObject>();
        }

        @Override
        public JavaFileObject getJavaFileForOutput(Location location, String className, JavaFileObject.Kind kind, FileObject sibling) throws IOException {
            ClassJavaFileObject file = new ClassJavaFileObject(className, kind);
            outputFiles.add(file);
            return file;
        }

        public List<ClassJavaFileObject> getGeneratedOutputFiles() {
            return outputFiles;
        }
    }

    private static class CompiledClassLoader extends ClassLoader {
        private final List<ClassJavaFileObject> files;

        private CompiledClassLoader(List<ClassJavaFileObject> files) {
            this.files = files;
        }

        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            Iterator<ClassJavaFileObject> itr = files.iterator();
            while (itr.hasNext()) {
                ClassJavaFileObject file = itr.next();
                if (file.getClassName().equals(name)) {
                    itr.remove();
                    byte[] bytes = file.getBytes();
                    return super.defineClass(name, bytes, 0, bytes.length);
                }
            }
            return super.findClass(name);
        }
    }


 /*   public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        // create directory
      //  File outputDir = new File("target" + File.separator + "bin");
      ///  outputDir.mkdir();

        String program = "" +
                "public class CodeGenTest2222 {\n" +
                "  public static void main(String[] args) {\n" +
                "    System.out.println(\"Hello World, from a generated program!\");\n" +
                "  }\n" +
                "}\n";

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

        JavaFileObject compilationUnit =
                new StringJavaFileObject("CodeGenTest2222", program);

        SimpleJavaFileManager fileManager =
                new SimpleJavaFileManager(compiler.getStandardFileManager(null, null, null));

        JavaCompiler.CompilationTask compilationTask = compiler.getTask(
                null, fileManager, null, null, null, Arrays.asList(compilationUnit));

        compilationTask.call();

        CompiledClassLoader classLoader =
                new CompiledClassLoader(fileManager.getGeneratedOutputFiles());

        Class<?> codeGenTest = classLoader.loadClass("CodeGenTest2222");
        Method main = codeGenTest.getMethod("main", String[].class);
        main.invoke(null, new Object[]{null});

    }*/

    public static void SampleTest1() throws  FileNotFoundException
    {
        // Берём новый экземпляр Java компилятора
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        // Берём новый экземпляр реализации стандартного файлового менеджера
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
        // Получаем список файловых объектов java, в нашем случае мы имеем только один файл, TestClass.java
        Iterable<? extends JavaFileObject> compilationUnits1 = fileManager.getJavaFileObjectsFromFiles(Arrays.asList(new File("TestClass.java")));

        // Создаём задачу компиляции
        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager,
                null, null, null, compilationUnits1);
        // Выполняем задачу компиляции
        task.call();
    }

}
