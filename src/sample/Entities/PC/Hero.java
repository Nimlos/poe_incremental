package sample.Entities.PC;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import sample.Controller;
import sample.Entities.Entity;
import sample.Entities.EntityType;

public class Hero implements Entity {
    private String imageName = "Pink_Monster.png";
    private EntityType type = EntityType.PLAYER;
    private Controller controller;
    private double x, y;
    private Image image;
    private double moveSpeed = 1;

    public Hero(Controller controller, double x, double y) {
        this.controller = controller;
        this.x = x;
        this.y = y;
        this.image = new Image(getClass().getResourceAsStream(imageName));
    }

    @Override
    public void takeTurn() {
        for (Entity entity : controller.getEntities()) {
            double ab_x = (entity.getX() - x);
            double ab_y = (entity.getY() - y);
            double ab_length = (Math.sqrt(Math.pow(ab_x, 2) + Math.pow(ab_y, 2)));

            if (ab_length > moveSpeed + 100) {
                double ab_e_const = 1/(Math.abs(ab_length));
                double ab_e_x = (ab_e_const*ab_x)*moveSpeed;
                double ab_e_y = (ab_e_const*ab_y)*moveSpeed;
                System.out.println(ab_e_x);
                System.out.println(ab_e_y);
                x = ab_e_x + x;
                y = ab_e_y + y;
                System.out.println("X: " + x);
                System.out.println("Y: " + y);
            }
        }
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
