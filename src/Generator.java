import model.JavaClassRepresentation;
import model.NamedTypes;

import java.io.IOException;

/**
 * Created by jvanheijst on 12/6/16.
 */
public class Generator {

    public static String generateAutovalueClass(String codeInput) throws IOException {


        JavaClassRepresentation javaClassRepresentation = ClassParser.getJavaClassRepresentation(codeInput);
        //remove last }, so the functions are kept inside the class
        //todo check if necessary
        int indexOfBracket = codeInput.lastIndexOf('}');
        StringBuilder sb = new StringBuilder(codeInput);
        codeInput = sb.deleteCharAt(indexOfBracket).toString();

        String[] lines = codeInput.split(System.getProperty("line.separator"));
        String templine;

        int lastParamLineNumber = -1; //needed for placement of the
        for (int i = 0; i < lines.length; i++) {
            templine = lines[i];
            if (i == 0) {
                if (templine.contains("package")) {
                    templine = templine + "\n\n import com.google.auto.value.AutoValue; \n \n";
                } else {
                    templine = "\n\n import com.google.auto.value.AutoValue; \n \n" + templine;
                }
            }
            if (templine.contains(javaClassRepresentation.getClassName())) {
                templine = Keywords.removeKeywords(templine);
                templine = "@AutoValue \npublic abstract " + templine;
            }
            for (NamedTypes namedTypes : javaClassRepresentation.getParameterList()) {
                if (templine.contains(namedTypes.toString())) { //todo check ignore spaces
                    templine = "public abstract " + namedTypes.toString() + "(); \n";
                    lastParamLineNumber = i;
                }
            }
            lines[i] = templine + "\n ";
        }

        if (lastParamLineNumber == -1) {
            throw new IOException("No parameters found");
        }
        lines[lastParamLineNumber] = lines[lastParamLineNumber] + getBuilderPart(javaClassRepresentation);



        return combineArray(lines) + "\n }";

    }

    private static String combineArray(String[] strings) {
        String output = "";
        for (String string : strings) {
            output += string;
        }
        return output;
    }

    private static String getBuilderPart(JavaClassRepresentation javaClassRepresentation) {
        StringBuilder builder = new StringBuilder();
        builder.append("public static Builder builder(){").append("\n");
        builder.append("    return new AutoValue_").append(javaClassRepresentation.getClassName()).append(".Builder();").append("\n");
        builder.append("}").append("\n");
        builder.append("\n");
        builder.append("@AutoValue.Builder").append("\n");
        builder.append("public abstract static class Builder {").append("\n");
        builder.append("\n");
        for (NamedTypes namedTypes : javaClassRepresentation.getParameterList()) {
            builder.append("public abstract Builder ").append(namedTypes.getName()).append("(").append(namedTypes.getType()).append(" ").append(namedTypes.getName()).append(");").append("\n");
            builder.append("\n");
        }
        builder.append("public abstract ").append(javaClassRepresentation.getClassName()).append(" build();").append("\n");


        builder.append(" \n } \n");

        return builder.toString();
    }

}
