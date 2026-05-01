package com.notes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {

    // =========================
    // GET ABSOLUTE PATH TO NOTES HOME
    // =========================
    public static String getAbsolutePathToNotesHome() {

        String notesHome = Config.getNotesHomeDirectory();

        Path path = Paths.get(notesHome).toAbsolutePath();

        return path.toString();
    }

    // =========================
    // BUILD NOTE FILE PATH
    // =========================
    public static String buildNoteFilePath(String noteFilename) {

        String notesHome = getAbsolutePathToNotesHome();

        Path fullPath = Paths.get(notesHome, noteFilename);

        return fullPath.toString();
    }

    public static void writeFile(String filePath, String content) {

        Config.ensureNotesDirectoryExists();

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(content);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    public static String readFile(String filePath) {
        StringBuilder content = new StringBuilder();
    
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;

            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return content.toString();
    }
}