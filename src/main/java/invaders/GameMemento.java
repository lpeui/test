package invaders;

import invaders.gameobject.GameObject;
import invaders.rendering.Renderable;

import java.util.ArrayList;
import java.util.List;

public class GameMemento {
    private final List<Renderable> renderablesState;
    private final GameState gameStateState;
    private final List<GameObject> gameObjectsState;
    private final List<GameObject> pendingToAddGameObjectState;
    private final List<GameObject> pendingToRemoveGameObjectState;
    private final List<Renderable> pendingToAddRenderableState;
    private final List<Renderable> pendingToRemoveRenderableState;


    public GameMemento(
            List<Renderable> renderables,
            GameState gameState,
            List<GameObject> gameObjects,
            List<GameObject> pendingToAddGameObject,
            List<GameObject> pendingToRemoveGameObject,
            List<Renderable> pendingToAddRenderable,
            List<Renderable> pendingToRemoveRenderable) {

        this.renderablesState = deepCopyRenderables(renderables);
        this.gameStateState = gameState.clone();
        this.gameObjectsState = deepCopyGameObjects(gameObjects);
        this.pendingToAddGameObjectState = deepCopyGameObjects(pendingToAddGameObject);
        this.pendingToRemoveGameObjectState = deepCopyGameObjects(pendingToRemoveGameObject);
        this.pendingToAddRenderableState = deepCopyRenderables(pendingToAddRenderable);
        this.pendingToRemoveRenderableState = deepCopyRenderables(pendingToRemoveRenderable);
    }



    private List<Renderable> deepCopyRenderables(List<Renderable> renderables) {
        List<Renderable> copiedRenderables = new ArrayList<>();
        for (Renderable r : renderables) {
            copiedRenderables.add(r.deepCopy());
        }
        return copiedRenderables;
    }

    private List<GameObject> deepCopyGameObjects(List<GameObject> gameObjects) {
        List<GameObject> copiedGameObjects = new ArrayList<>();
        for (GameObject go : gameObjects) {
            copiedGameObjects.add(go.deepCopy());
        }
        return copiedGameObjects;
    }



    public List<Renderable> getRenderablesState() {
        return this.renderablesState;
    }

    public GameState getGameStateState() {
        return this.gameStateState;
    }

    public List<GameObject> getGameObjectsState() {
        return this.gameObjectsState;
    }

    public List<GameObject> getPendingToAddGameObjectState() {
        return this.pendingToAddGameObjectState;
    }

    public List<GameObject> getPendingToRemoveGameObjectState() {
        return this.pendingToRemoveGameObjectState;
    }

    public List<Renderable> getPendingToAddRenderableState() {
        return this.pendingToAddRenderableState;
    }

    public List<Renderable> getPendingToRemoveRenderableState() {
        return this.pendingToRemoveRenderableState;
    }
}


