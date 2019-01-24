import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

enum Condition {
    PRESSED, NOT_PRESSED
}


public class Tile extends StackPane {
    private static int TILE_SIZE = 50;
    private int _x;
    private int _y;
    private Condition _condition;

    public int get_x() {
        return _x;
    }

    public int get_y() {
        return _y;
    }

    public Condition get_condition() {
        return _condition;
    }

    public void set_condition(Condition _condition) {
        this._condition = _condition;
    }

    private Rectangle _border = new Rectangle(TILE_SIZE - 2, TILE_SIZE - 2);
    private TileHandler _handler;

    public Tile(int x, int y) {
        this._x = x;
        this._y = y;

        this._handler = new TileHandler(this);
        this._condition = Condition.NOT_PRESSED;

        this.setOnMouseClicked(_handler);

        _border.setStroke(Color.LIGHTGRAY);
        _border.setFill(Color.GRAY);

        getChildren().addAll(_border);

        setTranslateX(x * TILE_SIZE);
        setTranslateY(y * TILE_SIZE);

    }

    public static int getTileSize() {
        return TILE_SIZE;
    }

    public boolean hasBomb() {
        // seek if it has Bomb;

        return true;
    }

    public int getNeighbors() {
        // return count of Bomb neighbors;
        return 1;
    }
}
