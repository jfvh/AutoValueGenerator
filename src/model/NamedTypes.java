package model;

/**
 * Created by jvanheijst on 12/6/16.
 */
public class NamedTypes {

    String name;
    String type;

    public NamedTypes(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return type +" "+name;
    }
}
