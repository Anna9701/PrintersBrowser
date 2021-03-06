package com.annawyrwal.paintersbrowser.Models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Author {
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty dates;
    private final String[] textInFile;
    private Map<String, Image> images;
    private ArrayList<Image> imageLinkedList;

    public Author(String path) {
        imageLinkedList = new ArrayList<>();
        textInFile = textFromFile(path).split("\n");
        String[] names = textInFile[0].split(" ");
        firstName = new SimpleStringProperty(names[0]);
        lastName = new SimpleStringProperty(names[1].substring(0, names[1].length() - 1));
        dates = new SimpleStringProperty(textInFile[1].substring(0, textInFile[1].length() - 1));
    }

    @Override
    public String toString() {
        return firstName.getValue() + " " + lastName.getValue() + " " + dates.getValue();
    }


    private void loadAuthorsImages() {
        if (images == null) {
            images = loadImages(textInFile);
            loadImages();
        }
    }

    public ArrayList<Image> getImageArrayList() {
        loadAuthorsImages();

        return imageLinkedList;

    }

    public Map<String, Image> getImages() {
        loadAuthorsImages();

        return images;
    }

    private void loadImages() {
        for (Image img : images.values())
            imageLinkedList.add(img);
    }

    private Map<String, Image> loadImages(String[] text) {
        Map<String, Image> imageMap = new HashMap<>();
        int startIndex = 2;
        for (int i = startIndex; i < text.length; i++) {
            String[] line = text[i].split("\t");
            String path = line[0].substring(1, line[0].length() - 1);
            int substringIndex = line[2].indexOf("cm.") + "cm.".length();
            String desc = line[2].substring(0, substringIndex);
            String title = line[1];
            String place = line[2].substring(substringIndex + 1, line[2].length());
            imageMap.put(title, new Image(title, desc, place, path));
        }
        return imageMap;
    }

    private String textFromFile(String path) {
        String everything = "";


        try (Reader br = new InputStreamReader(new FileInputStream(path), "ISO8859-2")) {
            StringBuilder sb = new StringBuilder();
            Scanner sc = new Scanner(br);
            String line = sc.nextLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                if (sc.hasNext())
                    line = sc.nextLine();
                else
                    line = null;
            }

            everything = sb.toString();
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return everything;
    }
}
