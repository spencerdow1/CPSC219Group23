package sample;


import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    @FXML
    private ChoiceBox mode;
    @FXML
    private ChoiceBox difficulty;
    @FXML
    private Button start;
    @FXML
    public TextField one;
    @FXML
    public TextField two;

    public String playerOneName;
    public String playerTwoName;

    public void initialize() throws IOException {
       start.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
           @Override
           public void handle(javafx.event.ActionEvent event) {
               Stage stage = (Stage) start.getScene().getWindow();
               stage.close();
           }
       });
        mode.setItems(FXCollections.observableArrayList("Single Player","MultiPlayer"));
        difficulty.setItems(FXCollections.observableArrayList("Easy","Medium","Hard"));

        mode.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if ("Single Player".equals(mode.getValue())) {
                    one.setVisible(true);
                    difficulty.setVisible(true);
                }
                else if ("MultiPlayer".equals(mode.getValue())) {
                    two.setVisible(true);
                    one.setVisible(true);


                }
            }
        });
        playerOneName = one.getText();
        playerTwoName = two.getText();

    }



}
