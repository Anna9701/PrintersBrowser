package com.annawyrwal.paintersbrowser.Models;

import com.annawyrwal.paintersbrowser.Global;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Image {
    private final StringProperty name;
    private final StringProperty description;
    private final StringProperty localization;
    private final javafx.scene.image.Image image;
   // private final String imgDirPath = "File:images/";
    private final String imgDirPath = "File:" + Global.getPath();

    public Image(String name, String description, String localization, String path) {
        this.name = new SimpleStringProperty(makeText(name));
        this.description = new SimpleStringProperty(makeText(description));
        this.localization = new SimpleStringProperty(makeLocalization(localization));
        this.image = new javafx.scene.image.Image(imgDirPath + path);
    }

    private String makeText(String text) {


        if (text.startsWith("\"")) {
            text = text.substring(1, text.length());
        }
        if (text.endsWith("\""))
            text = text.substring(0, text.length() - 1);


        return text;

    }

    private String makeLocalization(String text) {
        try {
            if (text.length() > 0)
                text = text.substring(0, text.length() - 3);
        } catch (IndexOutOfBoundsException ex) {
            System.err.println(ex.getCause());
        }

        return text;

    }

    public javafx.scene.image.Image getImage() {
        return image;
    }

    public String getDescription() {
        return description.get();
    }

    public String getName() {
        return name.get();
    }

    public String getLocalization() {
        return localization.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setDescription(String name) {
        this.description.set(name);
    }

    public void setLocalization(String localization) {
        this.localization.set(localization);
    }

}

