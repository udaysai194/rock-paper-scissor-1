import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;

public class Score extends Main{

    static boolean answer;
public static boolean scoreDisplay(){
    Stage window = new Stage();
    window.setTitle("SCORECARD");
    //window.initModality(Modality.APPLICATION_MODAL);

    //setting layouts and components
    VBox score_Layout1 = new VBox(20);
    HBox score_Layout2 = new HBox(20);

    Label score_text = new Label("SCORE");
    Label score_score = new Label(""+userScore);
    Label score_alert = new Label("Do you really want to exit ?");
    Button button_yes = new Button("YES");
    Button button_no = new Button("NO");

    //setting IDs
    score_text.setId("score_text");
    score_score.setId("score_score");
    score_alert.setId("Score_alert");
    button_yes.setId("button_yes");
    button_no.setId("button_no");

    //implementing functions of components
    button_yes.setOnAction(event -> {
        answer = true;
        window.close();
    });
    button_no.setOnAction(event -> {
        answer = false;
        window.close();
    });

    //setting up and adding components
    score_Layout2.getChildren().addAll(button_yes,button_no);
    score_Layout2.setAlignment(Pos.CENTER);
    score_Layout1.getChildren().addAll(score_text,score_score,score_alert,score_Layout2);
    score_Layout1.setAlignment(Pos.CENTER);;
    Scene scene = new Scene(score_Layout1,600,400);

    //designing window
    scene.getStylesheets().add("scoreBoard_Stylesheet.css");

    window.setScene(scene);
    window.showAndWait();



    return answer;
    }
}
