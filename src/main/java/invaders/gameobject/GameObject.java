package invaders.gameobject;

import invaders.engine.GameEngine;
import invaders.rendering.Renderable;

// contains basic methods that all GameObjects must implement
public interface GameObject {

    public void start();
    public void update(GameEngine model);

    public GameObject deepCopy();
}
