package chess;


import chess.pieces.Piece;

import java.util.ArrayList;

public class Game {
    private Board board;
    public Game(){
        this.board = new Board();
    }
    public void initialize(){
        board.initialize();
    }
    public int piecesCount(char representation) {
        return board.piecesCount(representation);
    }
    public String printBoard(){
        return board.printBoard();
    }
    public int getNumbOfPieces(){
        return board.getNumbOfPieces();
    }
    public Piece getPieces(String position){
        return board.getPiece(position);
    }
    public void push(String position, Piece piece){
        board.push(position, piece);
    }
    public double powerBlack() {
        double powerd;

        powerd = piecesCount('Q') * Piece.Name.QUEEN.getPower();
        powerd += piecesCount('R') * Piece.Name.ROOK.getPower();
        powerd += piecesCount('B') * Piece.Name.BISHOP.getPower();
        powerd += piecesCount('N') * Piece.Name.KNIGHT.getPower();
        powerd += powerPawn('P');
        return powerd;
    }

    public double powerWhite() {
        double powers;

        powers = piecesCount('q') * Piece.Name.QUEEN.getPower();
        powers += piecesCount('r') * Piece.Name.ROOK.getPower();
        powers += piecesCount('b') * Piece.Name.BISHOP.getPower();
        powers += piecesCount('n') * Piece.Name.KNIGHT.getPower();
        powers += powerPawn('p');
        return powers;
    }
    public double powerPawn(char representation) {
        int count = 0;
        double power = 0;
        for (int i = 0; i <= 7; i++) { // Para cada coluna i
                count = board.countPiecesInColumn(i, representation);
            if (count > 1)
                power += count * Piece.Name.PAWN.getPower() / 2;
            else power += count * Piece.Name.PAWN.getPower();
        }
        return power;
    }

}
