package chess;

import chess.pieces.Pawn;

import java.util.ArrayList;

public class Board {

    private final ArrayList<Pawn> arrayPawn;
    private ArrayList<Pawn> secondRank;
    private ArrayList<Pawn> seventhRank;
    public static String NEWLINE = System.getProperty("line.separator");

    private final String dot = "........";

    Board (){

        arrayPawn = new ArrayList<>();
        this.secondRank = new ArrayList<>();
        this.seventhRank = new ArrayList<>();

    }

    public void initialize(){

        secondRank.add(new Pawn(Pawn.WHITE, 'p'));
        secondRank.add(new Pawn(Pawn.WHITE, 'p'));
        secondRank.add(new Pawn(Pawn.WHITE, 'p'));
        secondRank.add(new Pawn(Pawn.WHITE, 'p'));
        secondRank.add(new Pawn(Pawn.WHITE, 'p'));
        secondRank.add(new Pawn(Pawn.WHITE, 'p'));
        secondRank.add(new Pawn(Pawn.WHITE, 'p'));
        secondRank.add(new Pawn(Pawn.WHITE, 'p'));

        seventhRank.add(new Pawn(Pawn.BLACK,'P'));
        seventhRank.add(new Pawn(Pawn.BLACK,'P'));
        seventhRank.add(new Pawn(Pawn.BLACK,'P'));
        seventhRank.add(new Pawn(Pawn.BLACK,'P'));
        seventhRank.add(new Pawn(Pawn.BLACK,'P'));
        seventhRank.add(new Pawn(Pawn.BLACK,'P'));
        seventhRank.add(new Pawn(Pawn.BLACK,'P'));
        seventhRank.add(new Pawn(Pawn.BLACK,'P'));

    }

    public int getNumOfPieces() {
        return secondRank.size() + seventhRank.size();
    }
    public String secondRankRepresentation(){

        StringBuilder buffer  = new StringBuilder();
        for (int i = 0; i < secondRank.size(); i++) {
            buffer.append(secondRank.get(i).getRepresentation());
        }
        return buffer.toString();
    }

    public String seventhRankRepresentation(){
        StringBuilder buffer  = new StringBuilder();
        for (int i = 0; i < seventhRank.size(); i++) {
            buffer.append(seventhRank.get(i).getRepresentation());
        }
        return buffer.toString();
    }
    public String zeroRepresentation(){
        return dot;
    }



    public String printBoardTwo(){

        StringBuilder buffer = new StringBuilder();
        buffer.append(zeroRepresentation()).append(NEWLINE);
        buffer.append(seventhRankRepresentation()).append(NEWLINE);
        buffer.append(zeroRepresentation()).append(NEWLINE);
        buffer.append(zeroRepresentation()).append(NEWLINE);
        buffer.append(zeroRepresentation()).append(NEWLINE);
        buffer.append(zeroRepresentation()).append(NEWLINE);
        buffer.append(secondRankRepresentation()).append(NEWLINE);
        buffer.append(zeroRepresentation());

        return buffer.toString();
    }
///    public String printBoard(){
//        return
//                zeroRepresentation()+ Board.NEWLINE +
//                seventhRankRepresentation() + Board.NEWLINE +
//                zeroRepresentation()+ Board.NEWLINE +
//                zeroRepresentation()+ Board.NEWLINE +
//                zeroRepresentation()+ Board.NEWLINE +
//                zeroRepresentation()+ Board.NEWLINE +
//                secondRankRepresentation() + Board.NEWLINE +
//                zeroRepresentation()+ Board.NEWLINE;
//    }

}
