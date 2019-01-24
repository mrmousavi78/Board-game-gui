import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Scanner;


public class MineSweeper extends Application {
    private static String _player1;
    private static String _player2;
    private static Turn _turn = new Turn("Player1's Turn");

    private static int _length;
    private static int _width;
    private static int _mines;


    public void set_length(int length) {
        this._length = length;
    }

    public void set_width(int width) {
        this._width = width;
    }

    public void set_mines(int mines) {
        this._mines = mines;
    }

    public static Turn get_turn() {
        return _turn;
    }

    public static void set_turn(String turn) {
        MineSweeper._turn.set_turn(turn);
    }

    private Parent createContent() {
        Pane root = new Pane();

        root.setPrefSize(600, 800);

        Board board = new Board(_length, _width, _mines);

//        Turn.set_turn("Player1");

        Text player1 = new Text("Player1: " + _player1);

        player1.setTranslateX((_length + 1) * Tile.getTileSize());
        player1.setTranslateY(Tile.getTileSize());

        Text player2 = new Text("Player2: " + _player2);

        player2.setTranslateX((_length + 1) * Tile.getTileSize());
        player2.setTranslateY(Tile.getTileSize() * 2);


        _turn.setTranslateX((_length + 1) * Tile.getTileSize());
        _turn.setTranslateY(Tile.getTileSize() * 3);


        root.getChildren().addAll(board, player1, player2, _turn);
        return root;
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("MineSweeper");
        Parent root= createContent();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the Player1 name: ");
        _player1 = sc.nextLine();
        System.out.print("Please enter the Player2 name: ");
        _player2 = sc.nextLine();
        System.out.print("Please enter the Board length: ");
        _length = sc.nextInt();
        System.out.print("Please enter the Board width: ");
        _width = sc.nextInt();
        System.out.print("Please enter the number of mines: ");
        int temp = sc.nextInt();
        while (!validate(temp)) {
            System.out.println("Invalid number of mines ");
            System.out.print("Please enter the number of mines: ");
            temp = sc.nextInt();
        }
        _mines = temp;
        launch(args);
    }

    private static boolean validate(int temp) {
        // mines validated here;

        return true;
    }
}
