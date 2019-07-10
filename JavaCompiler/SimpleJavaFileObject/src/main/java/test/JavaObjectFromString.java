package test;

import javax.tools.SimpleJavaFileObject;
import java.io.IOException;
import java.net.URI;

class JavaObjectFromString extends SimpleJavaFileObject {
    private String contents = null;

    public JavaObjectFromString(String className, String contents) throws Exception {
        super(new URI(className), Kind.SOURCE);
        this.contents = contents;
    }

    public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
        return contents;
    }
}
