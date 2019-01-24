import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;


public class Board extends GridPane {

    private int _length;
    private int _width;
    private int _mines;

    private Tile[][] _board;

    public Board(int length, int width, int mines) {

        this._length = length;
        this._width = width;
        this._mines = mines;

        setAlignment(Pos.CENTER);

        _board = new Tile[_length][_width];

        for (int y = 0; y < width; y++) {

            for (int x = 0; x < length; x++) {

                Tile tile = new Tile(x, y);

                _board[x][y] = tile;

                getChildren().add(tile);

            }
        }

    }


}
