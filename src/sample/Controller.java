package sample;

import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import sample.Entities.Entity;
import sample.Entities.NPC.OwlMonster;
import sample.Entities.PC.Hero;

import java.util.ArrayList;

public class Controller {

    private Canvas canvas;
    private Entity hero;
    private ArrayList<Entity> entities;


    Controller(Canvas canvas) {
        this.canvas = canvas;
        this.hero = new Hero(this, 300,canvas.getHeight()/2 );
        this.entities = new ArrayList<Entity>();

        entities.add(new OwlMonster(this, 800, 200));
    }

    public void nextTurn() {
        canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        hero.takeTurn();

        for (Entity entity : entities) {
            entity.takeTurn();
        }

    }

    public Canvas getCanvas() {
        return canvas;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public Entity getHero() {
        return hero;
    }
}
