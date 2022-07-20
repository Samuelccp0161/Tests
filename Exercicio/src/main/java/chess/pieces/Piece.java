package chess.pieces;

import chess.Board;

import java.util.ArrayList;

public class Piece implements Comparable<Piece>{

    private final char representation;
    private static int countWhite;
    private static int countBlack;
    public static Piece noColor() {
        return new Piece(Colors.NO_COLOR, Name.NO_POINTS, '.');
    }

    public Name getType() {
        return name;
    }
    @Override
    public int compareTo(Piece piece){
        return Double.compare(piece.getPower(),getPower());
    }

    protected enum Colors {WHITE, BLACK, NO_COLOR}
    public enum Name{
        PAWN(1, 'p'),
        KNIGHT(2.5, 'n'),
        ROOK(5,'r'),
        BISHOP(3, 'b'),
        QUEEN(9,'q' ),
        KING(0,'k'),
        NO_POINTS(0,'.');
        private final double power;
        private final char representation;
        Name(double power, char representation) {
           this.power = power;
           this.representation = representation;
        }
        public double getPower(){
            return power;
        }
    }

    public double getPower(){
        return name.getPower();
    }
    private final Name name;
    private final Colors color;
    protected Piece(Colors color, Name name, char representation) {
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

    public static final char PAWN_REPRESENTATION = 'p';
    public static final char ROOK_REPRESENTATION = 'r';
    public static final char KNIGHT_REPRESENTATION = 'n';
    public static final char BISHOP_REPRESENTATION = 'b';
    public static final char QUEEN_REPRESENTATION = 'q';
    public static final char KING_REPRESENTATION = 'k';

    public static Piece createWhitePawn(){
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
    public static Queen createWhiteQueen() {
        return createWhite(Name.QUEEN, 'q');
    }
    public static Queen createBlackQueen() {
        return createBlack(Name.QUEEN, 'Q');
    }
    public static Piece createWhiteKing() {
        return createWhite(Name.KING, 'k');
    }
    public static King createBlackKing() {
        return createBlack(Name.KING, 'K');
    }

    public char getRepresentation(){
        if (color == Colors.BLACK) {
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
    public static int getCountWhite(){
        return countWhite;
    }
    public static int getCountBlack(){
        return countBlack;
    }
    public static void resetCount(){
        countWhite = countBlack = 0;
    }

    public boolean isWhite(){
        return color == Colors.WHITE;
    }
    public boolean isBlack(){
        return color == Colors.BLACK;
    }
    private static ArrayList<String> kingMoves(String position) {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> newList = new ArrayList<>();

        char column = position.charAt(0);
        char line = position.charAt(1);

        char up = (char) (line+1);
        char right = (char) (column+1);
        char down = (char)(line -1);
        char left = (char)(column -1);

        list.add("" + column + up);
        list.add("" + column + down);
        list.add("" + right + line);
        list.add("" + left + line);
        list.add("" + left + up);
        list.add("" + right + up);
        list.add("" + left + down);
        list.add("" + right + down);

        for (String pos : list) // para cada String "pos"  dentro de list, executar:
            if (Board.isValidPosition(pos))
                newList.add(pos);

        return newList;
    }

    private static ArrayList<String> queenMoves(String position){
        ArrayList<String> listQueen = new ArrayList<>();
        ArrayList<String> newListQueen = new ArrayList<>();
        char column = position.charAt(0);
        char line = position.charAt(1);

        char up = (char) (line + 1);
        char right = (char) (column +1 );
        char down = (char)(line -1);
        char left = (char)(column -1);

        for (int i = 0; i < 8; i++) {
            listQueen.add("" + column + up);
            listQueen.add("" + right + line);
            listQueen.add("" + right + up);
            listQueen.add("" + right + down);
            listQueen.add("" + column + down);
            listQueen.add("" +  left + line);
            listQueen.add("" + left + down);
            listQueen.add("" + left + up);

            right++ ;
            up++;
            left--;
            down--;
        }

        for (String positionQueen : listQueen) // para cada String "positionQueen" dentro de list, executar:
            if (Board.isValidPosition(positionQueen)) //validar posição de queen
                newListQueen.add(positionQueen); // adicionar posição valida dentro da lista.

        return newListQueen;
    }
    public static ArrayList<String> possibleMoves(String position, Piece piece){
        if(piece.getType() == Piece.Name.KING){
            return kingMoves(position);
        } else if (piece.getType() == Piece.Name.QUEEN){
            return queenMoves(position);
        } return null;
    }
}