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
//    public ArrayList<ArrayList<Piece>> setPut(){
//        return board.put();
//    }
    public double powerPawn(char representation) {
        int count = 0;
        double power = 0;
        for (int i = 0; i <= 7; i++) { // Para cada coluna i
                count = board.countPiecesInColumn(i, representation);
            if (count > 1)
                power += count * Piece.Name.PAWN.getPower() / 2;
            else power += count * Piece.Name.PAWN.getPower();

            count = 0;
        }
        return power;
    }

    private ArrayList<String> kingMoves(String position, Piece piece) {
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
            if (board.isValidPosition(pos))
                newList.add(pos);

        return newList;
    }

    private ArrayList<String> queenMoves(String position, Piece piece){
        ArrayList<String> listQueen = new ArrayList<>();
        ArrayList<String> newListQueen = new ArrayList<>();
        char column = position.charAt(0);
        char line = position.charAt(1);
        char up = (char) (line +1 ); // tenho que fazer as possiveis movimentação da rainha, questao 8.
//        char right = (char) (column+1);
//        char down = (char)(line -1);
//        char left = (char)(column -1);
//        listQueen.add("" + column + down);
//        listQueen.add("" + right + line);
//        listQueen.add("" + left + line);

        for (String positionQueen : listQueen) // para cada String "positionQueen" dentro de list, executar:
            if (board.isValidPosition(positionQueen))
                newListQueen.add(positionQueen);

        return newListQueen;
    }

    public ArrayList<String> possibleMoves(String position, Piece piece){
        if(piece.getType() == Piece.Name.KING){
            return kingMoves(position, piece);
        } else if (piece.getType() == Piece.Name.QUEEN){
            return queenMoves(position, piece);
        } return null;
    }

}
