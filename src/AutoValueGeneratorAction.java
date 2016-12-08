import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.LangDataKeys;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.sun.org.apache.bcel.internal.classfile.ClassParser;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by jvanheijst on 12/2/16.
 */
public class AutoValueGeneratorAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        final Project project = e.getRequiredData(CommonDataKeys.PROJECT);
        Document currentDoc = e.getData(LangDataKeys.EDITOR).getDocument();
        String text = currentDoc.getText() + " ";
        try {
            String autoValueClass = Generator.generateAutovalueClass(text);
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    currentDoc.replaceString(0, currentDoc.getTextLength() - 1, autoValueClass);
                }
            };
            //Making the replacement
            WriteCommandAction.runWriteCommandAction(project, runnable);


        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
}
