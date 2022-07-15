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
            for (int j = 0; j < 8; j++) { // Para cada peça na coluna i
                if (allRanks.get(j).get(i).getRepresentation() == representation)
                    count += 1;
            }
            /* ----> fazer um metodo no board aonde:                 ^
             * vai retornar o numero de peças que tem numa coluna.   |
             */
            if (count > 1)
                power += count * Piece.Name.PAWN.getPower() / 2;
            else power += count * Piece.Name.PAWN.getPower();

            count = 0;
        }
        return power;
    }

    public ArrayList<String> kingMoves(String position, Piece piece) {
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

        for (String pos : list)// para cada string pos dentro de list, executar:
            if (board.isValidPosition(pos))
                newList.add(pos);

        return newList;
    }



}
