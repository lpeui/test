package invaders.entities;

import invaders.factory.PlayerProjectile;
import invaders.factory.PlayerProjectileFactory;
import invaders.factory.Projectile;
import invaders.factory.ProjectileFactory;
import invaders.physics.Collider;
import invaders.physics.Moveable;
import invaders.physics.Vector2D;
import invaders.rendering.Animator;
import invaders.rendering.Renderable;

import invaders.strategy.NormalProjectileStrategy;
import javafx.scene.image.Image;
import org.json.simple.JSONObject;

import java.io.File;

public class Player implements Moveable, Renderable {

    private final Vector2D position;
    private double health;
    private double velocity;

    private final double width = 20;
    private final double height = 20;
    private final Image image;
    private String imageName;
    private ProjectileFactory playerProjectileFactory = new PlayerProjectileFactory();


    public Player(JSONObject playerInfo){
        double x = ((Number)((JSONObject)(playerInfo.get("position"))).get("x")).doubleValue();
        double y = ((Number)((JSONObject)(playerInfo.get("position"))).get("y")).doubleValue();


        this.image = new Image(new File("src/main/resources/player.png").toURI().toString(), width, height, true, true);
        this.position = new Vector2D(x,y);
        this.health = ((Number) playerInfo.get("lives")).intValue();
        this.velocity = ((Number) playerInfo.get("speed")).intValue();

    }

    @Override
    public void takeDamage(double amount) {
        this.health -= amount;
    }

    @Override
    public double getHealth() {
        return this.health;
    }

    @Override
    public boolean isAlive() {
        return this.health > 0;
    }

    @Override
    public void up() {
        return;
    }

    @Override
    public void down() {
        return;
    }

    @Override
    public void left() {
        this.position.setX(this.position.getX() - this.velocity);
    }

    @Override
    public void right() {
        this.position.setX(this.position.getX() + this.velocity);
    }

    public Projectile shoot(){
        return playerProjectileFactory.createProjectile(new Vector2D(this.position.getX() + 5 ,this.position.getY() - 10),new NormalProjectileStrategy(),null);
    }

    @Override
    public Image getImage() {
        return this.image;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public Vector2D getPosition() {
        return position;
    }

    @Override
    public Layer getLayer() {
        return Layer.FOREGROUND;
    }

    @Override
    public String getRenderableObjectName() {
        return "Player";
    }

    @Override
    public String getImageName(){
        return "Player";
    }
    @Override
    public Player deepCopy() {
        // Constructing a mock JSONObject for the sake of copying
        JSONObject mockPlayerInfo = new JSONObject();
        JSONObject positionInfo = new JSONObject();
        positionInfo.put("x", this.position.getX());
        positionInfo.put("y", this.position.getY());
        mockPlayerInfo.put("position", positionInfo);
        mockPlayerInfo.put("lives", this.health);
        mockPlayerInfo.put("speed", this.velocity);

        Player copiedPlayer = new Player(mockPlayerInfo);

        return copiedPlayer;
    }

}
