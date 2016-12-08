import java.util.regex.Pattern;

/**
 * Created by jvanheijst on 12/6/16.
 */
@Deprecated
public class FileNameParser {

    public static String pathToFilename(String path){
        String pattern = Pattern.quote(System.getProperty("file.separator"));
        String[] splittedFileName = path.split(pattern);
        splittedFileName = splittedFileName[splittedFileName.length-1].split(".");
        return splittedFileName[0];
    }
}
