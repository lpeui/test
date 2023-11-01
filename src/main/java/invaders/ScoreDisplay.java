package invaders;

import javafx.scene.control.Label;

public class ScoreDisplay implements Observer {
    private GameState gameState;
    private Label scoreLabel;

    public ScoreDisplay(GameState gameState, Label scoreLabel) {
        this.gameState = gameState;
        this.scoreLabel = scoreLabel;
        gameState.registerObserver(this);
    }

    @Override
    public void update() {
        displayScore();
    }

    public void displayScore() {
        scoreLabel.setText("Score: " + gameState.getScore());
    }
}

