import javafx.scene.text.Text;

public class Turn extends Text {

   private  String _turn;

    public Turn(String text) {
        super(text);
        _turn=text;

    }

    public  void set_turn(String turn) {
        _turn = turn;
        this.setText(turn);
    }

    public  String get_turn() {
        // do the right thing for getting turn;
        return _turn;
    }

}

