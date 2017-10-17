package com.annawyrwal.paintersbrowser.View;

import com.annawyrwal.paintersbrowser.Models.Author;
import com.annawyrwal.paintersbrowser.Models.AuthorsLibrary;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainWindow {
    @FXML
    private ChoiceBox choiceBox;


    private AuthorsLibrary authorsLibrary;


    @FXML
    private void initialize() {
        initAuthorLibrary();
        choiceBox.setItems(FXCollections.observableArrayList(getAuthors()));
    }



    private void initAuthorLibrary() {
        authorsLibrary = new AuthorsLibrary();
    }

    public List<Author> getAuthors () {
        Map<String, Author> map = authorsLibrary.getAuthorsMap();
        List<Author> authors = new ArrayList<>();
        authors.addAll(map.values());
        return authors;
    }
}
