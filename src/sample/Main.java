package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        String s = new MazeGenerator(20,20).toString();
        int n = s.length();
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        Rectangle rect[] = new Rectangle[n];
        int k=0;
        int j=0;
        for(int i = 0; i < n; i++) {
            rect[i] = new Rectangle();
            rect[i].setWidth(10);
            rect[i].setHeight(10);
            if(s.charAt(i) == '0') {
                rect[i].setFill(Color.SLATEBLUE);
            } else if (s.charAt(i) == '1'){
                rect[i].setFill(Color.BLACK);
            } else if (s.charAt(i) == '\n') {
                j = 0;
                k++;
            }
            GridPane.setConstraints(rect[i], j++, k);
        }
        grid.getChildren().addAll(rect);
        primaryStage.setTitle("Maze");
        primaryStage.setScene(new Scene(grid, 800, 800));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
