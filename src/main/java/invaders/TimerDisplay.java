package invaders;

import javafx.application.Platform;
import javafx.scene.control.Label;

import java.time.Duration;

public class TimerDisplay implements Observer {
    private GameState gameState;
    private Label timerLabel;  // New addition

    public TimerDisplay(GameState gameState, Label timerLabel) {
        this.gameState = gameState;
        this.timerLabel = timerLabel;
        gameState.registerObserver(this);
    }

    @Override
    public void update() {
        displayTime();
    }

    public void displayTime() {
        Duration gameDuration = gameState.getGameTime();
        long totalSeconds = gameDuration.getSeconds();
        long minutes = totalSeconds / 60;
        long seconds = totalSeconds % 60;
        timerLabel.setText(String.format("Time: %02d:%02d", minutes, seconds));  // Update the label with formatted time
    }
}


