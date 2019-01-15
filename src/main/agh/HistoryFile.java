package agh;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HistoryFile {
    private Path path;
    private boolean addedFile;

    public HistoryFile(Path path) throws IllegalAccessException {
        if (!Files.exists(path))
            throw new IllegalAccessException(path.toString() + ": The specified file path doesn't exist.");
        this.path = path;
        this.addedFile = true;
    }

    public HistoryFile() {
        this.addedFile = false;
    }

    public void addToFile(String string) throws IOException {
        if(addedFile) {
            FileWriter file = new FileWriter(this.path.toString(), true);
            BufferedWriter out = new BufferedWriter(file);
            String updatedText = string.replaceAll("\n", System.lineSeparator());
            out.write(updatedText);
            out.close();
        }
    }

}
