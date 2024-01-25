package org.hnefatafl.hnefatafl.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

public class GamePaneController implements Initializable {

    @FXML
    private GridPane gamepane;
    private void board(int boardSize){
        // Create a GridPane

        int numCols = boardSize;
        int numRows = boardSize;
        gamepane.setGridLinesVisible(false);
        Double height = (double) Math.round(gamepane.getPrefHeight() / numRows) -1;
        Double width = (double) Math.round(gamepane.getPrefWidth() / numCols) -1;
        System.out.println("Height: " + height + " Width: " + width);
        for (int i = 0; i < numCols; i++) {
            for (int j = 0; j < numRows; j++){
                String text = "[" +i + "," + j + "]";
                Label label = new Label(text);
                label.setStyle("-fx-text-fill: #bababa;");
                label.setAlignment(Pos.CENTER);
                HBox labelPane = new HBox();
                labelPane.setPrefSize(width, height);
                labelPane.setAlignment(Pos.CENTER);
                labelPane.getChildren().add(label);

                labelPane.setStyle("-fx-border-color: #bababa;-fx-border-width: 1px;");

                if ((i == 0 || i == numCols-1) && (j == 0 || j == numRows-1)) {
                    labelPane.setStyle("-fx-background-color: #ffffff;");
                }

                if (i == (int) Math.floor(numCols/2) && j == (int) Math.floor(numRows/2)) {
                    labelPane.setStyle("-fx-background-color: #ffffff;");
                }
                gamepane.add(labelPane, i, j);
            }
        }
    }

    public void updateGamePane() {
        board(11);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateGamePane();
    }
}
