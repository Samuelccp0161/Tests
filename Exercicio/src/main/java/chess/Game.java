package chess;

import chess.pieces.Piece;

import java.io.*;

public class Game {
    private Board board;
    public Game(){
        this.board = new Board();
    }
    public void initialize(){
        board.initialize();
    }
    public String printBoard(){
        return board.printBoard();
    }
    public int getNumbOfPieces(){
        return board.getNumbOfPieces();
    }
    public int getNumbOfPiecesBlack(){
        return board.getNumbOfPiecesBlack();
    }
    public int getNumbOfPiecesWhite(){
        return board.getNumbOfPiecesWhite();
    }
    public Piece getPieces(String position){
        return board.getPiece(position);
    }
    public void push(String position, Piece piece){
        board.push(position, piece);
    }
    public int piecesCount(char representation) {
        return board.piecesCount(representation);
    }
    public double powerBlack() {
        double powerd;

        powerd = piecesCount('Q') *  Piece.createBlackQueen().getPower();
        powerd += piecesCount('R') * Piece.createBlackRook().getPower();
        powerd += piecesCount('B') * Piece.createBlackBishop().getPower();
        powerd += piecesCount('N') * Piece.createBlackKnight().getPower();
        powerd += powerPawn('P');
        return powerd;
    }
    public double powerWhite() {
        double powers;

        powers = piecesCount('q') * Piece.createWhiteQueen().getPower();
        powers += piecesCount('r') * Piece.createWhiteRook().getPower();
        powers += piecesCount('b') * Piece.createWhiteBishop().getPower();
        powers += piecesCount('n') * Piece.createWhiteKnight().getPower();
        powers += powerPawn('p');
        return powers;
    }
    public double powerPawn(char representation) {
        int count;
        double power = 0;
        for (int i = 0; i <= 7; i++) { // Para cada coluna i
                count = board.countPiecesInColumn(i, representation);
            if (count > 1)
                power += count * Piece.createBlackPawn().getPower()/ 2;
            else power += count * Piece.createBlackPawn().getPower();
        }
        return power;
    }
    public void saveSerialized(String filename) throws IOException{
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(filename));
            outputStream.writeObject(board);
        } finally {
            outputStream.close();
        }
    }
    public void loadSerialized(String filename) throws IOException, ClassNotFoundException{
        ObjectInputStream inputStream = null;
        try {
            inputStream = new ObjectInputStream(new FileInputStream(filename));
            board = (Board) inputStream.readObject();

        }finally {
            inputStream.close();
        }
    }
//    File file = new File("filename");
    public void saveTextual(String filename) throws IOException {
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(filename));
        writer.write(board.printBoard());
        writer.flush();
    }
    public void loadTextual(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
//        for(int i = 0; i < ; i++){}
        board.push("a1", Piece.createBlackPawn());
        for (int i = 0; i < 8; i++) {
            System.out.printf(reader.readLine() + "\n");
        }

    }
    public Piece stringToPiece(String i){
        return switch (i){
            case "P" -> Piece.createBlackPawn();
            case "R" -> Piece.createBlackRook();
            case "K" -> Piece.createBlackKing();
            case "Q" -> Piece.createBlackQueen();
            case "N" -> Piece.createBlackKnight();
            case "B" -> Piece.createBlackBishop();

            case "p" -> Piece.createWhitePawn();
            case "r" -> Piece.createWhiteRook();
            case "k" -> Piece.createWhiteKing();
            case "q" -> Piece.createWhiteQueen();
            case "n" -> Piece.createWhiteKnight();
            case "b" -> Piece.createWhiteBishop();

            default -> Piece.noPiece();
        };
    }
}