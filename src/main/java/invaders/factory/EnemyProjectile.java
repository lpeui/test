package invaders.factory;

import invaders.engine.GameEngine;
import invaders.physics.Collider;
import invaders.physics.Vector2D;
import invaders.strategy.ProjectileStrategy;
import javafx.scene.image.Image;

public class EnemyProjectile extends Projectile{
    private ProjectileStrategy strategy;
    private String imageName;

    public EnemyProjectile(Vector2D position, ProjectileStrategy strategy, Image image) {
        super(position,image);
        this.strategy = strategy;
    }

    @Override
    public void update(GameEngine model) {
        //System.out.println(this.getRenderableObjectName());
        strategy.update(this);

        if(this.getPosition().getY()>= model.getGameHeight() - this.getImage().getHeight()){
            this.takeDamage(1);
        }

    }

    @Override
    public String getImageName(){
        return this.imageName;
    }

    public void setImageName(String imageName){
        this.imageName= imageName;
    }

    @Override
    public String getRenderableObjectName() {
        return "EnemyProjectile";
    }

    @Override
    public EnemyProjectile deepCopy() {
        ProjectileStrategy copiedStrategy = this.strategy.deepCopy();

        EnemyProjectile copiedProjectile = new EnemyProjectile(new Vector2D(this.getPosition().getX(), this.getPosition().getY()), copiedStrategy, new Image(this.getImage().getUrl())); // Assuming Image copy by URL is sufficient
        copiedProjectile.setImageName(this.imageName);
        copiedProjectile.setLives((int) this.getHealth());

        return copiedProjectile;
    }
}
