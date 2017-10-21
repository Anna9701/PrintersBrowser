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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

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

    @FXML
    private ImageView imageView;

    private AuthorsLibrary authorsLibrary;
    private int imageIndex;
    private ArrayList<Image> images;

    @FXML
    private void initialize() {
        imageIndex = -1;
        choiceBox.setItems(FXCollections.observableArrayList(getAuthors()));

        choiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
                imageIndex = 0;
                Author author = (Author) choiceBox.getItems().get((Integer) number2);
                loadImages(author);
            }
        });
    }

    public void init(Stage stage) {
        imageView.fitWidthProperty().bind(stage.widthProperty());
        imageView.setPreserveRatio(true);
    }

    @FXML
    private void handleNextImage() {
        if (imageIndex == -1)
            return;
        if (++imageIndex == images.size())
            imageIndex = 0;
        loadImage();
    }


    @FXML
    private void handlePrevImage() {
        if (imageIndex == -1)
            return;
        if (--imageIndex < 0)
            imageIndex = images.size() - 1;
        loadImage();
    }

    private void loadImages(Author author) {
        images = author.getImageArrayList();
        loadImage();
    }

    private void loadImage() {
        titleLabel.setText(images.get(imageIndex).getName());
        descriptionLabel.setText(images.get(imageIndex).getDescription());
        placeLabel.setText(images.get(imageIndex).getLocalization());
        imageView.setImage(images.get(imageIndex).getImage());
    }

    private List<Author> getAuthors() {
        authorsLibrary = new AuthorsLibrary();
        Map<String, Author> map = authorsLibrary.getAuthorsMap();
        List<Author> authors = new ArrayList<>();
        authors.addAll(map.values());
        return authors;
    }
}

