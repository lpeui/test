package invaders;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class GameState implements Subject {
    // List of observers to be notified on state change
    private List<Observer> observers;
    private int score;
    private Duration gameTime = Duration.ZERO;

    public GameState() {
        observers = new ArrayList<>();
        score = 0;
        gameTime = Duration.ofMinutes(0);
    }
    // Register an observer to be notified
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    //notify observers of the change
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public int getScore() {
        return score;
    }

    public void increaseScore(int points) {
        this.score += points;
        notifyObservers();
    }

    public Duration getGameTime() {
        return gameTime;
    }

    public void setGameTime(Duration gameTime) {
        this.gameTime = gameTime;
        notifyObservers();
    }

    public void incrementGameTime(Duration delta) {
        this.gameTime = this.gameTime.plus(delta);
        notifyObservers();
    }

    @Override
    public GameState clone() {
        GameState clonedState = new GameState();

        clonedState.observers.addAll(this.observers);

        clonedState.score = this.score;
        clonedState.gameTime = Duration.ofMillis(this.gameTime.toMillis()); // Cloning Duration

        return clonedState;
    }
}

