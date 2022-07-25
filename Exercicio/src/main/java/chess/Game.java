package chess;


import chess.pieces.Piece;
import chess.pieces.Queen;

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
    public int getNumbOfPiecesWhite(){
        return board.getNumbOfPiecesWhite();
    }
    public int getNumbOfPiecesBlack(){
        return board.getNumbOfPiecesBlack();
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
        int count = 0;
        double power = 0;
        for (int i = 0; i <= 7; i++) { // Para cada coluna i
                count = board.countPiecesInColumn(i, representation);
            if (count > 1)
                power += count * Piece.createBlackPawn().getPower()/ 2;
            else power += count * Piece.createBlackPawn().getPower();
        }
        return power;
    }

}
