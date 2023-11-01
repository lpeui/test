package invaders.state;

import invaders.gameobject.Bunker;

public interface BunkerState {
    public void takeDamage();
    BunkerState deepCopy(Bunker bunker);
}
