package chess.pieces;

public class Piece {

//    String color
//    private final String name;
//    public static final String WHITE = "white";
//    public static final String BLACK = "black";

    private char representation;
    private static int countWhite;
    private static int countBlack;
    //    private static int countWhitePawn;
    private static int column;

    public static Piece noColor() {
        return new Piece(Colors.NO_COLOR, Name.NO_POINTS, '.');
    }

    public Name getType() {
        return name;
    }


    private enum Colors {WHITE, BLACK, NO_COLOR}
    public enum Name{PAWN, KNIGHT, ROOK, BISHOP, QUEEN, KING, NO_POINTS}

    private Name name;
    private Colors color;

    private Piece(Colors color, Name name, char representation) {
        this.color = color;
        this.name = name;
        this.representation = representation;
    }

    private static Piece createWhite(Name name, char representation){
        incrementCountWhite();
        return new Piece(Colors.WHITE,name, representation);
    }
    private static Piece createBlack(Name name, char representation){
        incrementCountBlack();
        return new Piece(Colors.BLACK,name, representation);
    }
    private static  Piece createScore(Name name, char representation){
        return new Piece(Colors.NO_COLOR, name, '.');
    }

    public static final char PAWN_REPRESENTATION = 'p';
    public static final char ROOK_REPRESENTATION = 'r';
    public static final char KNIGHT_REPRESENTATION = 'n';
    public static final char BISHOP_REPRESENTATION = 'b';
    public static final char QUEEN_REPRESENTATION = 'q';
    public static final char KING_REPRESENTATION = 'k';
    public static final char NO_REPRESENTATION = '.';

    public static Piece createWhitePawn(){
//        incrementCountWhitePawn();
        return createWhite(Name.PAWN, 'p');
    }
    public static Piece createBlackPawn() {
        return createBlack(Name.PAWN, 'P');
    }
    public static Piece createWhiteKnight() {
        return createWhite(Name.KNIGHT, 'n');
    }
    public static Piece createBlackKnight() {
        return createBlack(Name.KNIGHT, 'N');
    }
    public static Piece createWhiteRook() {
        return createWhite(Name.ROOK, 'r');
    }
    public static Piece createBlackRook() {
        return createBlack(Name.ROOK, 'R');
    }
    public static Piece createWhiteBishop() {
        return createWhite(Name.BISHOP, 'b');
    }
    public static Piece createBlackBishop() {
        return createBlack(Name.BISHOP, 'B');
    }
    public static Piece createWhiteQueen() {
        return createWhite(Name.QUEEN, 'q');
    }
    public static Piece createBlackQueen() {
        return createBlack(Name.QUEEN, 'Q');
    }
    public static Piece createWhiteKing() {
        return createWhite(Name.KING, 'k');
    }
    public static Piece createBlackKing() {
        return createBlack(Name.KING, 'K');
    }

    public static Piece createNoPoints(){
        return createScore(Name.NO_POINTS,'.');
    }
//    public static Piece createSpotss() { return createScore(Name.NO_COLOR, '.');}
    public char getRepresentation(){
        if (color == Colors.BLACK) {
            return Character.toUpperCase(representation);
        }
        return representation;
    }
    private static void incrementCountWhite(){
        ++countWhite;
    }
//    private static void incrementCountWhitePawn(){
//        ++countWhitePawn;
//    }
    private static void incrementCountBlack(){
        ++countBlack;
    }
//    String getCOLORS() {
//        return color;
//    }
    public static int getCountWhite(){
        return countWhite;
    }

    public static int getCountBlack(){
        return countBlack;
    }
//    public static int getCoun tWhitePawn(){return countWhitePawn;}

    public static void resetCount(){
        countWhite = 0;
    }
    public static void resetCountBlack(){
        countBlack = 0;
    }

    public boolean isWhite(){
        if (color == Colors.WHITE ){return true;}
        else return false;
    }
    public boolean isBlack(){
        if (color == Colors.BLACK){return true;}
        else return false;
    }
    public static int getColumn() {
        return column;
    }
}

