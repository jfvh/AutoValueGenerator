import com.thoughtworks.qdox.JavaProjectBuilder;
import com.thoughtworks.qdox.model.*;
import model.JavaClassRepresentation;
import model.NamedTypes;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jvanheijst on 12/6/16.
 */
public class ClassParser {

    public static JavaClassRepresentation getJavaClassRepresentation(String codeString) throws IOException {

        JavaProjectBuilder builder = new JavaProjectBuilder();
        JavaSource src = builder.addSource(new StringReader(codeString));
        List<JavaClass> classes = src.getClasses();
        if (classes.size() != 1) {
            throw new IOException("Multiple classes present, can't parse");
        }
        JavaClass aClass = classes.get(0);
        List<NamedTypes> parameters = new ArrayList<>();
        for (JavaField field : aClass.getFields()) {
            parameters.add(new NamedTypes(field.getName(),field.getType().getName()));
        }
        List<JavaMethod> methods = aClass.getMethods();
        for (JavaMethod method : methods) {
            System.out.println(method.getCodeBlock());
        }



        return new JavaClassRepresentation(aClass.getName(),parameters,aClass);
    }
}
