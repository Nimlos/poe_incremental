package sample.Entities.NPC;

import javafx.scene.image.Image;
import sample.Controller;
import sample.Entities.Entity;
import sample.Entities.EntityType;

public class OwlMonster implements Entity {
    private String imageName = "Owlet_Monster.png";
    private EntityType type = EntityType.ENEMY;
    private Controller controller;
    private double x, y;
    private Image image;
    private double moveSpeed = 100;

    public OwlMonster(Controller controller, double x, double y) {
        this.controller = controller;
        this.x = x;
        this.y = y;
        this.image = new Image(getClass().getResourceAsStream(imageName));
    }

    @Override
    public void takeTurn() {
        controller.getHero();

        controller.getCanvas().getGraphicsContext2D().drawImage(image, x, y);
    }

    @Override
    public EntityType getType() {
        return type;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
