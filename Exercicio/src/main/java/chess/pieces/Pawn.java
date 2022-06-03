package chess.pieces;

public class Pawn {

    String color;
    public static final String WHITE = "white";
    public static final String BLACK = "black";
    public static final String INCOLOR = "incolor";
    private char representation;
    public Pawn(String color, char representation) {
        this.color = color;
        this.representation = representation;
    }


    public char getRepresentation(){
        return representation;
    }

    String getColor() {
        return color;
    }



}
