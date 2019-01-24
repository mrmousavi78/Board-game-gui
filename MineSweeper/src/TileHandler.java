
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class TileHandler implements EventHandler<MouseEvent> {
    private final Tile tile;

    public TileHandler(Tile tile) {
        this.tile = tile;
    }

    @Override
    public void handle(MouseEvent event) {

        if (tile.get_condition() == Condition.NOT_PRESSED) {
            if (tile.hasBomb()) { // check if it has Bomb
                Circle c = new Circle(10);
                switch (MineSweeper.get_turn().get_turn()) {
                    case "Player1's Turn":
                        c.setFill(Color.RED);
                        tile.set_condition(Condition.PRESSED);
//                        MineSweeper.set_turn("Player2's Turn");
                        break;
                    case "Player2's Turn":
                        c.setFill(Color.BLUE);
                        tile.set_condition(Condition.PRESSED);
                        break;
                }
                tile.getChildren().add(c);
            } else {
                tile.set_condition(Condition.PRESSED);
                // do the right action when there isn't Bomb;
                Text text = new Text(""+tile.getNeighbors());
                tile.getChildren().add(text);
                MineSweeper.set_turn(MineSweeper.get_turn().get_turn());
            }
        }


        System.out.println("Tile (" + tile.get_x() + "," + tile.get_y() + ") Pressed");


    }
}
