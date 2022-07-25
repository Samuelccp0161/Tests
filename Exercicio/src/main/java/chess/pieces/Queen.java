package chess.pieces;

import chess.Board;

import java.util.ArrayList;

public class Queen extends Piece{

    public Queen(Colors color) {
        super(color,Name.QUEEN, QUEEN_REPRESENTATION);
    }
    public static ArrayList<String> queenMoves(String position){
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
    @Override
    public ArrayList<String> possibleMoves(String position){
        ArrayList<String> moves = new ArrayList<>();
        moves = queenMoves(position);
        return moves;
    }

}

