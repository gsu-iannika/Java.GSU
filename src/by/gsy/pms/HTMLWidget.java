package by.gsy.pms;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HTMLWidget {
    public void saveWidgetHtml(String data) {

        String html = "<html> " + data + "</html>";

        File fileHtml = new File("src/Widget.html");
        try {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileHtml))) {
                bufferedWriter.write(html);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
