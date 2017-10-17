package com.annawyrwal.paintersbrowser.Models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.swing.text.html.ImageView;

public class Image {
    private final StringProperty name;
    private final StringProperty description;
    private final StringProperty localization;
    private final javafx.scene.image.Image image;
    private final String imgDirPath = "File:images/";

    public Image(String name, String description, String localization, String path) {
        this.name = new SimpleStringProperty(name);
        this.description = new SimpleStringProperty(description);
        this.localization = new SimpleStringProperty(localization);
        this.image = new javafx.scene.image.Image(imgDirPath + path);
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
