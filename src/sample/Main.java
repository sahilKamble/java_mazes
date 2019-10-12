package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        String s = new MazeGenerator(20, 20).toString();
        int n = s.length();
        System.out.println(s);
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        Rectangle rect[] = new Rectangle[n];
        int k = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            rect[i] = new Rectangle();
            rect[i].setWidth(10);
            rect[i].setHeight(10);
            if (s.charAt(i) == '0') {
                rect[i].setFill(Color.WHITE);
            } else if (s.charAt(i) == '1') {
                rect[i].setFill(Color.BLACK);
            } else if (s.charAt(i) == '\n') {
                GridPane.setConstraints(rect[i], j++, k);
                j = 0;
                k++;
                continue;
            }
            GridPane.setConstraints(rect[i], j++, k);
        }
        grid.getChildren().addAll(rect);
        primaryStage.setTitle("Maze");
        primaryStage.setScene(new Scene(grid, 500, 500));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
