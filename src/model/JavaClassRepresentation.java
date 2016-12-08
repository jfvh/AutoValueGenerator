package model;

import com.thoughtworks.qdox.model.JavaClass;

import java.util.List;

/**
 * Created by jvanheijst on 12/6/16.
 */
public class JavaClassRepresentation {

    private String className;
    private List<NamedTypes> parameterList;
    private JavaClass qdoxJavaObject; //the dqox class object

    public JavaClassRepresentation(String className, List<NamedTypes> parameterList, JavaClass qdoxJavaObject) {
        this.className = className;
        this.parameterList = parameterList;
        this.qdoxJavaObject = qdoxJavaObject;
    }

    public String getClassName() {
        return className;
    }

    public List<NamedTypes> getParameterList() {
        return parameterList;
    }

    public JavaClass getQdoxJavaObject() {
        return qdoxJavaObject;
    }
}
