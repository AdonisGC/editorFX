package sample;

import javafx.scene.Parent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.*;

class openDialog {


    static String showDialogToOpen(Parent root) {

        FileChooser chooser = new FileChooser();
        FileChooser.ExtensionFilter filtro = new FileChooser.ExtensionFilter("Arxiu de text","*.txt");
        chooser.setTitle("Selecciona un fitxer");
        chooser.getExtensionFilters().add(filtro);
        Stage mainStage = (Stage) root.getScene().getWindow();
        File selectedFile = chooser.showOpenDialog(mainStage);

        String content = "";

        if (selectedFile != null) {
            mainStage.setTitle(selectedFile.getName());
            content = openFile(selectedFile);
        }
        return content;
    }


    static void showDialogToSave(String content, Parent root) {

        FileChooser chooser = new FileChooser();
        FileChooser.ExtensionFilter filtro = new FileChooser.ExtensionFilter("Arxiu de text","*.txt");
        chooser.getExtensionFilters().add(filtro);
        Stage mainStage = (Stage) root.getScene().getWindow();
        File f = chooser.showSaveDialog(mainStage);

        if (f != null ) {
            saveFile(f, content);
        }
    }

     private static void saveFile(File f, String content) {
        try {
            FileWriter newFile = new FileWriter(f);
            newFile.write(content);
            newFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static String openFile(File selectedFile) {
        String text = "";
        try {
            BufferedReader f = new BufferedReader(new FileReader(selectedFile));
            while (f.ready()) {
                text += f.readLine()+"\n";
            }
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }
}

