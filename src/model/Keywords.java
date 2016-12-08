package model;

/**
 *has all java keywords.
 * Some are commented, as those keywords cannot be removed
 */
public class Keywords {
    
    public static String[] allKeywords = {
            "abstract",
            "assert",
//            "boolean",
            "break",
//            "byte",
            "case",
            "catch",
//            "char",
//            "class",
            "const",
            "continue",
            "default",
            "do",
//            "double",
            "else",
//            "enum",
            "extends",
            "final",
            "finally",
//            "float",
            "for",
            "goto",
            "if",
            "implements",
//            "import",
            "instanceof",
//            "int",
            "interface",
//            "long",
            "native",
            "new",
            "package",
            "private",
            "protected",
            "public",
            "return",
            "short",
            "static",
            "strictfp",
            "super",
            "switch",
            "synchronized",
            "this",
            "throw",
            "throws",
            "transient",
            "try",
            "void",
            "volatile",
            "while"
    };

    public static String removeKeywords(String input){
        for (String keyword : allKeywords) {
            input = input.replace(keyword,"");
        }
        return input;
    }
}
