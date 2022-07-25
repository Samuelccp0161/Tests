package chess.pieces;

import java.util.ArrayList;

public class Piece implements Comparable<Piece>{
    private double power;
    private final char representation;

    @Override
    public int compareTo(Piece piece){
        return Double.compare(piece.getPower(),getPower());
    }

    protected enum Colors {WHITE, BLACK, NO_COLOR}

    public double getPower(){
        return power;
    }

    private final Colors color;
    protected Piece(Colors color, char representation, double power) {
        this.color = color;
        this.power = power;
        this.representation = representation;
    }
    public static final char PAWN_REPRESENTATION = 'p';
    public static final char ROOK_REPRESENTATION = 'r';
    public static final char KNIGHT_REPRESENTATION = 'n';
    public static final char BISHOP_REPRESENTATION = 'b';
    public static final char QUEEN_REPRESENTATION = 'q';
    public static final char KING_REPRESENTATION = 'k';
    public static final char NO_PIECE_REPRESENTATION = '.';
    public static NoPiece noColor() {
        return new NoPiece(Colors.NO_COLOR);
    }

    public static Pawn createWhitePawn(){
        return new Pawn(Colors.WHITE);
    }
    public static Pawn createBlackPawn() {
        return new Pawn(Colors.BLACK);
    }
    public static Knight createWhiteKnight() {
        return new Knight(Colors.WHITE);
    }
    public static Knight createBlackKnight() {
        return new Knight(Colors.BLACK);
    }
    public static Rook createWhiteRook() {
        return new Rook(Colors.WHITE);
    }
    public static Rook createBlackRook() {
        return new Rook(Colors.BLACK);
    }
    public static Bishop createWhiteBishop() {
        return new Bishop(Colors.WHITE);
    }
    public static Bishop createBlackBishop() {
        return new Bishop(Colors.BLACK);
    }
    public static Queen createWhiteQueen(){
        return new Queen(Colors.WHITE);
    }
    public static Queen createBlackQueen(){
        return new Queen(Colors.BLACK);
    }
    public static King createWhiteKing() {
        return new King(Colors.WHITE);
    }
    public static King createBlackKing() {
        return new King(Colors.BLACK);
    }

    public char getRepresentation(){
        if (color == Colors.BLACK) {
            return Character.toUpperCase(representation);
        }
        return representation;
    }

    public boolean isWhite(){
        return color == Colors.WHITE;
    }
    public boolean isBlack(){
        return color == Colors.BLACK;
    }

    public ArrayList<String> possibleMoves(String position){
        ArrayList<String> moves = new ArrayList<>();
            return moves;
    }
}