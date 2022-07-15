package chess.pieces;

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

    private enum Colors {WHITE, BLACK, NO_COLOR}
    public enum Name{
        PAWN(1, 'p'),
        KNIGHT(2.5, 'n'),
        ROOK(5,'r'),
        BISHOP(3, 'b'),
        QUEEN(9,'q'),
        KING(0,'k'),
        NO_POINTS(0,'.');
        private final double power;
        private char representation;
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
}