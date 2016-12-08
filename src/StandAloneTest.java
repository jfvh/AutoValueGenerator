import java.io.IOException;


/**
 * Used for fast debugging and testing without having to fire up a sandbox intellij to actually use the plugin
 */
public class StandAloneTest {
    public static void main(String[] args) {

        String someclassString = "/**\n" +
                " * Created by jvanheijst on 12/6/16.\n" +
                " */\n" +
                "public class SomeClass {\n" +
                "\n" +
                "    String someString;\n" +
                "    String anotherString;\n" +
                "    int anInt;\n" +
                "\n" +
                "    public void someClass(){\n" +
                "        //does nothing\n" +
                "    }\n" +
                "\n" +
                "}\n";


        try {
            System.out.println(Generator.generateAutovalueClass(someclassString));

        }catch (IOException ioe){
            ioe.printStackTrace();
        }


    }
}
