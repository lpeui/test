package invaders.factory;

import invaders.gameobject.GameObject;
import invaders.physics.Collider;
import invaders.physics.Vector2D;
import invaders.rendering.Renderable;
import javafx.scene.image.Image;

public abstract class Projectile implements Renderable, GameObject {
    private int lives = 1;
    private Vector2D position;
    private final Image image;
    private String imageName;

    public Projectile(Vector2D position, Image image) {
        this.position = position;
        this.image = image;
    }

    @Override
    public Vector2D getPosition() {
        return position;
    }

    @Override
    public Image getImage() {
        return image;
    }

    public void setImageName(String imageName){
        this.imageName = imageName;
    }

    @Override
    public Layer getLayer() {
        return Layer.FOREGROUND;
    }

    @Override
    public void start() {}

    @Override
    public double getWidth() {
        return 10;
    }

    @Override
    public double getHeight() {
        return 10;
    }

    @Override
    public void takeDamage(double amount) {
        this.lives-=1;
    }

    @Override
    public double getHealth() {
        return this.lives;
    }


    @Override
    public boolean isAlive() {
        return this.lives>0;
    }

    @Override
    public String getImageName(){
        return "projectile";
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public abstract Projectile deepCopy();

}
