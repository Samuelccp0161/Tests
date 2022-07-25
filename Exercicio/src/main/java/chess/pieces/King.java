package chess.pieces;

import chess.Board;

import java.util.ArrayList;

public class King extends Piece{
    protected King(Colors color) {
        super(color, Piece.Name.KING, KING_REPRESENTATION);
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
    @Override
    public ArrayList<String> possibleMoves(String position){
        ArrayList<String> moves = new ArrayList<>();
        moves = kingMoves(position);
        return moves;
    }
}
