package com.annawyrwal.paintersbrowser.Models;

import com.annawyrwal.paintersbrowser.Global;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class AuthorsLibrary {
    private File directory;
    private Map<String, Author> authorsMap;
    //private String textDirPath = "images/";
    private String textDirPath = Global.getPath();

    public AuthorsLibrary() {
        directory = new File(textDirPath);
        if (!directory.isDirectory()) {
            System.err.println("No such directory like + " + textDirPath + "!\n");
            System.exit(-1);
        }
        authorsMap = getAuthorsFromDirectory();
    }

    public Map getAuthorsMap() {
        return authorsMap;
    }

    private Map<String, Author> getAuthorsFromDirectory() {
        File[] files = directory.listFiles();
        Map<String, Author> aMap = new HashMap<>();

        for (File file : files) {
            if (file.isFile()) {
                if (file.getName().endsWith(".txt"))
                    aMap.put(file.getName(), new Author(file.getAbsolutePath()));
            } else {
                System.err.println(file + " is not a file!");
            }
        }

        return aMap;
    }
}
