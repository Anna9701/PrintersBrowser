package com.annawyrwal.paintersbrowser.Models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Author {
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty dates;
    private final String[] textInFile;
    private Map<String, Image> images;


    public Author (String path) {
        textInFile  = textFromFile(path).split("\n");
        String[] names = textInFile[0].split(" ");
        firstName = new SimpleStringProperty(names[0]);
        lastName = new SimpleStringProperty(names[1].substring(0, names[1].length()-1));
        dates = new SimpleStringProperty(textInFile[1].substring(0, textInFile[1].length()-1));
    }

    @Override
    public String toString() {
        return firstName.getValue() + " " + lastName.getValue() + " " + dates.getValue();
    }

    private void loadAuthorsImages () {
        if (images == null)
            images = loadImages(textInFile);
    }

    public Map<String, Image> getImages() {
        loadAuthorsImages();

        return images;
    }

    private Map<String, Image> loadImages(String[] text) {
        Map<String, Image> imageMap = new HashMap<>();
        int startIndex = 2;
        for (int i = startIndex; i < text.length; i++) {
            String[] line = text[i].split("\t");
            String path = line[0].substring(1, line[0].length()-1);
            int substringIndex = line[2].indexOf("cm.") + "cm.".length();
            String desc = line[2].substring(0, substringIndex);
            String title = line[1];
            String place = line[2].substring(substringIndex + 1, line[2].length());
            imageMap.put(title, new Image(title, desc, place, path));
        }
        return imageMap;
    }

    private String textFromFile (String path) {
        String everything = "";

        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }

            everything = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return everything;
    }
}
