package org.hnefatafl.hnefatafl.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

public class GamePaneController implements Initializable {

    @FXML
    private Pane gamepane;
    private GridPane board(int boardSize){
        // Create a GridPane
        GridPane pane = new GridPane();

        int numCols = boardSize;
        int numRows = boardSize;
        pane.setGridLinesVisible(false);
        Double height = (double) Math.round(gamepane.getPrefHeight() / numRows) -1;
        Double width = (double) Math.round(gamepane.getPrefWidth() / numCols) -1;
        System.out.println("Height: " + height + " Width: " + width);
        for (int i = 0; i < numCols; i++) {
            for (int j = 0; j < numRows; j++){
                String text = "[" +i + "," + j + "]";
                Label label = new Label(text);
                label.setStyle("-fx-text-fill: #bababa;");
                Pane labelPane = new Pane();
                labelPane.setPrefSize(width, height);
                labelPane.getChildren().add(label);

                labelPane.setStyle("-fx-border-color: #bababa;-fx-border-width: 1px;");

                if ((i == 0 || i == numCols-1) && (j == 0 || j == numRows-1)) {
                    labelPane.setStyle("-fx-background-color: #ffffff;");
                }

                if (i == (int) Math.floor(numCols/2) && j == (int) Math.floor(numRows/2)) {
                    labelPane.setStyle("-fx-background-color: #ffffff;");
                }
                pane.add(labelPane, i, j);
            }
        }

        return pane;
    }

    public void updateGamePane() {
        GridPane gp = board(11);
        gamepane.getChildren().add(gp);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateGamePane();
    }
}
