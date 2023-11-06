package invaders;

import invaders.engine.GameEngine;
import invaders.rendering.Renderable;

import java.util.Iterator;

public class CheatFacade {
    private GameEngine engine;
    private GameState gameState;

    public CheatFacade(GameEngine engine) {
        this.engine = engine;
        this.gameState = engine.getGameState();
    }

    // Method to activate a cheat based on a cheat code string
    public void activateCheat(String cheatCode) {
        switch (cheatCode) {
            case "slowProjectiles":
                cheatRemoveSlowProjectiles();
                break;
            case "fastProjectiles":
                cheatRemoveFastProjectiles();
                break;
            case "slowAliens":
                cheatRemoveSlowAlien();
                break;
            case "fastAliens":
                cheatRemoveFastAlien();
                break;
            default:
                System.out.println("Cheat code not recognized");
                break;
        }
    }

    public void cheatRemoveSlowProjectiles() {
        int slowProjectilesCount = 0;

        Iterator<Renderable> renderIt = engine.getRenderables().iterator();
        while (renderIt.hasNext()) {
            Renderable renderable = renderIt.next();
            if (renderable.getImageName().equals("slow_bullet")) {
                slowProjectilesCount++;
                renderable.takeDamage(1);
            }
        }

        // Update score
        gameState.increaseScore(slowProjectilesCount);
    }

    public void cheatRemoveFastProjectiles() {
        int fastProjectilesCount = 0;

        Iterator<Renderable> renderIt = engine.getRenderables().iterator();
        while (renderIt.hasNext()) {
            Renderable renderable = renderIt.next();
            if (renderable.getImageName().equals("fast_bullet")) {
                fastProjectilesCount++;
                renderable.takeDamage(1);
            }
        }

        // Update score
        gameState.increaseScore(fastProjectilesCount*2);
    }

    public void cheatRemoveSlowAlien() {
        int slowAlienCount = 0;

        Iterator<Renderable> renderIt = engine.getRenderables().iterator();
        while (renderIt.hasNext()) {
            Renderable renderable = renderIt.next();
            if (renderable.getImageName().equals("slow_alien")) {
                slowAlienCount++;
                renderable.takeDamage(1);
            }
        }

        // Update score
        gameState.increaseScore(slowAlienCount*3);
    }

    public void cheatRemoveFastAlien() {
        int fastAlienCount = 0;

        Iterator<Renderable> renderIt = engine.getRenderables().iterator();
        while (renderIt.hasNext()) {
            Renderable renderable = renderIt.next();
            if (renderable.getImageName().equals("fast_alien")) {
                fastAlienCount++;
                renderable.takeDamage(1);
            }
        }

        // Update score
        gameState.increaseScore(fastAlienCount*4);
    }
}

