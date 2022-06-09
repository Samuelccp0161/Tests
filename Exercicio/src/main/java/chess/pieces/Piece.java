package chess.pieces;

import chess.Board;

public class Piece {


    private final String name;
    String color;
    public static final String WHITE = "white";
    public static final String BLACK = "black";

    public static String PIECE_PAWN = "Pawn";
    public static String PIECE_KNIGHT = "Knight";
    public static String PIECE_ROOK = "Rook";
    public static String PIECE_BISHOP = "Bishop";
    public static String PIECE_QUEEN = "Queen";
    public static String PIECE_KING = "King";

    public static final String INCOLOR = "incolor";
    private char representation;
    private static int countWhite;
    private static int countBlack;
    private Piece(String color, String name, char representation) {
        this.color = color;
        this.name = name;
        this.representation = representation;
    }

    private static Piece createWhite(String name, char representation){
        incrementCountWhite();
        return new Piece(WHITE,name, representation);
    }
    private static Piece createBlack(String name, char representation){
        incrementCountBlack();
        return new Piece(BLACK,name, representation);

    }
    public static Piece createWhitePawn(){
        return createWhite(PIECE_PAWN, 'p');
    }
    public static Piece createBlackPawn() {
        return createBlack(PIECE_PAWN, 'p');
    }
    public static Piece createWhiteKnight() {
        return createWhite(PIECE_KNIGHT, 'n');
    }
    public static Piece createBlackKnight() {
        return createBlack(PIECE_KNIGHT, 'n');
    }
    public static Piece createWhiteRook() {
        return createWhite(PIECE_ROOK, 'r');
    }
    public static Piece createBlackRook() {
        return createBlack(PIECE_ROOK, 'r');
    }
    public static Piece createWhiteBishop() {
        return createWhite(PIECE_BISHOP, 'b');
    }
    public static Piece createBlackBishop() {
        return createBlack(PIECE_BISHOP, 'b');
    }
    public static Piece createWhiteQueen() {
        return createWhite(PIECE_QUEEN, 'q');
    }
    public static Piece createBlackQueen() {
        return createBlack(PIECE_QUEEN, 'q');
    }
    public static Piece createWhiteKing() {
        return createWhite(PIECE_KING, 'k');
    }
    public static Piece createBlackKing() {
        return createBlack(PIECE_KING, 'k');
    }
    public char getRepresentation(){
        if (color.equals(BLACK)){
            return Character.toUpperCase(representation);
        }
        return representation;
    }
    private static void incrementCountWhite(){
        ++countWhite;
    }
    private static void incrementCountBlack(){
        ++countBlack;
    }


    String getColor() {
        return color;
    }
    public static int getCountWhite(){
        return countWhite;
    }

    public static int getCountBlack(){
        return countBlack;
    }

    public static void resetCount(){
        countWhite = 0;
    }

}
