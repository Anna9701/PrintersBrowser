package com.annawyrwal.paintersbrowser.View;

import com.annawyrwal.paintersbrowser.Models.Author;
import com.annawyrwal.paintersbrowser.Models.AuthorsLibrary;
import com.annawyrwal.paintersbrowser.Models.Image;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainWindow {
    @FXML
    private ChoiceBox choiceBox;

    @FXML
    private Label titleLabel;

    @FXML
    private Label descriptionLabel;

    @FXML
    private Label placeLabel;


    private AuthorsLibrary authorsLibrary;
    private Map<String, Image> imageMap;
    private int imageIndex = 0;


    @FXML
    private void initialize() {
        choiceBox.setItems(FXCollections.observableArrayList(getAuthors()));

        choiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
                Author author = (Author) choiceBox.getItems().get((Integer) number2);
                loadImages(author);
                imageIndex = 0;
            }
        });
    }

    private void loadImages(Author author) {
        imageMap = author.getImages();
        Image[] s = (Image[]) author.getImages().values().toArray();
        //titleLabel = s.g
    }

    private List<Author> getAuthors () {
        authorsLibrary = new AuthorsLibrary();
        Map<String, Author> map = authorsLibrary.getAuthorsMap();
        List<Author> authors = new ArrayList<>();
        authors.addAll(map.values());
        return authors;
    }
}
