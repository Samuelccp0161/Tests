package chess;

import chess.pieces.Pawn;

import java.util.ArrayList;
/*
Criei uma class board aonde recebe os pawn's.
 */
public class Board {

    private ArrayList<Pawn> arrayPawn;
    Board (){
        arrayPawn = new ArrayList<>();
    }

    /**
     *
     * @param pawn ele instancia pawn para o objeto.
     */
    public void addPawn(Pawn pawn){
        arrayPawn.add(pawn);
    }

    /**
     *
     * @return Retorna o números de peças que tem no tabuleiro.
     */
    public int getNumOfPieces() {
        return arrayPawn.size();
    }



}
