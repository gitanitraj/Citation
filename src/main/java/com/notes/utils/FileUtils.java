package com.notes.utils;

import com.notes.config.Config;
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
}