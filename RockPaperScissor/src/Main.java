import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.lang.reflect.Array;
import java.util.Random;

public class Main extends Application {
    Stage window;
    String random_choice[] = {"ROCK", "PAPER", "SCISSOR"};
    static int userScore = 0, computerScore = 0;
    int computerChoice = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        //on closing game
        window.setOnCloseRequest(event -> {
            event.consume();
            closeGame();
        });

        //creating components
        Button rock_button = new Button("ROCK");
        Button paper_button = new Button("PAPER");
        Button scissor_button = new Button("SCISSOR");
        Label user_label = new Label("user");
        Label comp_label = new Label("computer");
        Label user_choice = new Label();
        Label comp_choice = new Label();
        Label vs = new Label("vs");
        Label user_score = new Label("0");
        Label comp_score = new Label("0");



        //creating ids
        rock_button.setId("rockButton");


        //setting functionalities
        rock_button.setOnAction(event -> {
            user_choice.setText("ROCK");
            computer_choice();
            comp_choice.setText(random_choice[computerChoice]);
            rockButtonAction();
            user_score.setText(""+userScore);
            comp_score.setText(""+computerScore);
        });
        paper_button.setOnAction(event -> {
            user_choice.setText("PAPER");
            computer_choice();
            comp_choice.setText(random_choice[computerChoice]);
            paperButtonAction();
            user_score.setText(""+userScore);
            comp_score.setText(""+computerScore);
        });
        scissor_button.setOnAction(event -> {
            user_choice.setText("SCISSOR");
            computer_choice();
            comp_choice.setText(random_choice[computerChoice]);
            scissorButtonAction();
            user_score.setText(""+userScore);
            comp_score.setText(""+computerScore);
        });

        //setting layouts
        VBox layout = new VBox(8);
        HBox layout_scores = new HBox(30);
        HBox layout_label = new HBox(25);
        HBox layout_choosen = new HBox(40);
        HBox layout_choices = new HBox(100);

        //set ids of layouts

        layout_scores.getChildren().addAll(user_score, comp_score);
        layout_label.getChildren().addAll(user_label, vs, comp_label);
        layout_choosen.getChildren().addAll(user_choice, comp_choice);
        layout_choices.getChildren().addAll(rock_button, paper_button, scissor_button);
        layout.getChildren().addAll(layout_scores, layout_label, layout_choosen, layout_choices);
        Scene scene = new Scene(layout, 683, 360);

        layout_choices.setAlignment(Pos.CENTER);
        layout_scores.setAlignment(Pos.CENTER);
        layout_label.setAlignment(Pos.CENTER);
        layout_choosen.setAlignment(Pos.CENTER);

        scene.getStylesheets().add("Mainscene_Stylesheet.css");

        window.setScene(scene);
        window.show();
    }


    private void closeGame() {
        boolean result = Score.scoreDisplay();
        if (result) {
            window.close();
        }
    }

    private void computer_choice() {
        int choice;
        Random ran = new Random();
        choice = ran.nextInt(3);
        computerChoice = choice;
    }

    private void rockButtonAction(){
        if(computerChoice == 0){
            userScore += 0;
            computerScore += 0;
        }
        if(computerChoice == 1){
            userScore += 0;
            computerScore += 1;
        }
        if(computerChoice == 2){
            userScore += 1;
            computerScore += 0;
        }
    }
    private void paperButtonAction(){
        if(computerChoice == 0){
            userScore += 1;
            computerScore += 0;
        }
        if(computerChoice == 1){
            userScore += 0;
            computerScore += 0;
        }

        if(computerChoice == 2){
            userScore += 0;
            computerScore += 1;
        }
    }
    private void scissorButtonAction() {
        if (computerChoice == 0) {
            userScore += 0;
            computerScore += 1;
        }
        if (computerChoice == 1) {
            userScore += 1;
            computerScore += 0;
        }
        if(computerChoice == 2){
            userScore += 0;
            computerScore += 0;
        }
    }

    public int getUserScore() {
        return userScore;
    }

    public void setUserScore(int userScore) {
        this.userScore = userScore;
    }
}