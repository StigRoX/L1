package core.directory;

import java.util.Random;

public class Poison extends Cell {
    private Random random;
    private Snake snake;
    //private Poison poison;

    public Poison(Snake snake) { // constructor
        super(-1, -1, GameSnake.CELL_SIZE, GameSnake.POISON_COLOR);
        random = new Random();
        this.snake = snake;
    }

    /*public void setPoison(Poison poison) {
        this.poison = poison;
    }*/

    public boolean isPoison(int x, int y) {   // if food has x, y coordinate
        return (getX() == x) && (getY() == y);
    }

    public boolean isEaten() {              // if food is eaten or not
        return getX() == -1;
    }

    public void eat() {                     // virtual eating
        set(-1, -1);
    }

    public void appear() {                  // show food at new x,y coordinates
        int x, y;
        do {
            x = random.nextInt(GameSnake.CANVAS_WIDTH);
            y = random.nextInt(GameSnake.CANVAS_HEIGHT);
        } while (snake.isInSnake(x, y) /*|| poison.isPoison(x, y)*/);
        set(x, y);
    }
}