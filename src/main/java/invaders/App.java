package invaders;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import invaders.engine.GameEngine;
import invaders.engine.GameWindow;

import java.util.Map;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("Select Difficulty Level");
        for (DifficultyLevel.Level level : DifficultyLevel.Level.values()) {
            MenuItem item = new MenuItem(level.name());
            item.setOnAction(e -> {
                DifficultyLevel.getInstance(level);
                startGame(primaryStage);  // This method will contain the previous logic in start
            });
            menu.getItems().add(item);
        }
        menuBar.getMenus().add(menu);
        VBox vBox = new VBox(menuBar);
        Scene scene = new Scene(vBox, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void startGame(Stage primaryStage) {
        DifficultyLevel level = DifficultyLevel.getInstance(DifficultyLevel.Level.EASY); // default level
        GameEngine model = new GameEngine("src/main/resources/" + level.getCurrentLevel().getConfigFile());
        GameWindow window = new GameWindow(model);

        TimerDisplay timerDisplay = new TimerDisplay(model.getGameState(), window.getTimerLabel());  // Connect TimerDisplay with the label
        model.getGameState().registerObserver(timerDisplay);
        ScoreDisplay scoreDisplay = new ScoreDisplay(model.getGameState(), window.getScoreLabel());
        model.getGameState().registerObserver(scoreDisplay);

        primaryStage.setTitle("Space Invaders");
        primaryStage.setScene(window.getScene());
        primaryStage.show();

        window.run();
    }
}
