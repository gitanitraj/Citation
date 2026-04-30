package com.notes.config;

import java.io.File;

public class Config {

    // =========================
    // DEFAULT
    // =========================
    public static final String DEFAULT_NOTES_HOME =
            System.getProperty("user.home") + File.separator + ".notes";

    // =========================
    // GET NOTES HOME DIRECTORY
    // =========================
    public static String getNotesHomeDirectory() {

        String env = System.getenv("NOTES_HOME");

        if (env != null && !env.isEmpty()) {
            return env;
        } else {
            return DEFAULT_NOTES_HOME;
        }
    }

    // =========================
    // ENSURE DIRECTORY EXISTS
    // =========================
    public static String ensureNotesDirectoryExists() {

        String path = getNotesHomeDirectory();
        File dir = new File(path);

        if (!dir.exists()) {
            boolean created = dir.mkdirs();

            if (created) {
                System.out.println("Created notes directory at: " + path);
            } else {
                System.out.println("Failed to create directory: " + path);
            }
        }

        return path;
    }
}