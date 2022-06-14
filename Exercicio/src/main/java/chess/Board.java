package chess;

import chess.pieces.Piece;
import util.StringUtil;
import java.util.ArrayList;
import java.util.Objects;

public class Board {

    private final ArrayList<Piece> arrayPawn;
    private ArrayList<Piece> firstRank;
    private ArrayList<Piece> secondRank;
    private ArrayList<Piece> seventhRank;
    private ArrayList<Piece> eighthRank;

    private final String dot = "........";

    Board() {

        arrayPawn = new ArrayList<>();
        this.firstRank = new ArrayList<>();
        this.secondRank = new ArrayList<>();
        this.seventhRank = new ArrayList<>();
        this.eighthRank = new ArrayList<>();


    }

    public void initialize() {

        Piece.resetCount();
        firstRank.add(Piece.createWhiteRook());
        firstRank.add(Piece.createWhiteKnight());
        firstRank.add(Piece.createWhiteBishop());
        firstRank.add(Piece.createWhiteQueen());
        firstRank.add(Piece.createWhiteKing());
        firstRank.add(Piece.createWhiteBishop());
        firstRank.add(Piece.createWhiteKnight());
        firstRank.add(Piece.createWhiteRook());

        secondRank.add(Piece.createWhitePawn());
        secondRank.add(Piece.createWhitePawn());
        secondRank.add(Piece.createWhitePawn());
        secondRank.add(Piece.createWhitePawn());
        secondRank.add(Piece.createWhitePawn());
        secondRank.add(Piece.createWhitePawn());
        secondRank.add(Piece.createWhitePawn());
        secondRank.add(Piece.createWhitePawn());

        seventhRank.add(Piece.createBlackPawn());
        seventhRank.add(Piece.createBlackPawn());
        seventhRank.add(Piece.createBlackPawn());
        seventhRank.add(Piece.createBlackPawn());
        seventhRank.add(Piece.createBlackPawn());
        seventhRank.add(Piece.createBlackPawn());
        seventhRank.add(Piece.createBlackPawn());
        seventhRank.add(Piece.createBlackPawn());

        eighthRank.add(Piece.createBlackRook());
        eighthRank.add(Piece.createBlackKnight());
        eighthRank.add(Piece.createBlackBishop());
        eighthRank.add(Piece.createBlackQueen());
        eighthRank.add(Piece.createBlackKing());
        eighthRank.add(Piece.createBlackBishop());
        eighthRank.add(Piece.createBlackKnight());
        eighthRank.add(Piece.createBlackRook());

    }

    public int getNumbOfPiecesWhite(){
        return firstRank.size();
    }
    public int getNumbOfPieces() {
        return firstRank.size() + secondRank.size() + seventhRank.size() + eighthRank.size();
    }

    public String firstRankRepresentation() {

        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < firstRank.size(); i++) {
            buffer.append(firstRank.get(i).getRepresentation());
        }
        return buffer.toString();
    }

    public String secondRankRepresentation() {

        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < secondRank.size(); i++) {
            buffer.append(secondRank.get(i).getRepresentation());
        }
        return buffer.toString();
    }

    public String seventhRankRepresentation() {
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < seventhRank.size(); i++) {
            buffer.append(seventhRank.get(i).getRepresentation());
        }
        return buffer.toString();
    }

    public String eighthRankRepresentation() {
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < eighthRank.size(); i++) {
            buffer.append(eighthRank.get(i).getRepresentation());
        }
        return buffer.toString();
    }

    public String zeroRepresentation() {
        return dot;
    }


    public String printBoardTwo() {

        StringBuilder buffer = new StringBuilder();

        buffer.append(StringUtil.appendNewLine(eighthRankRepresentation()));
        buffer.append(StringUtil.appendNewLine(seventhRankRepresentation()));
        buffer.append(StringUtil.appendNewLine(zeroRepresentation()));
        buffer.append(StringUtil.appendNewLine(zeroRepresentation()));
        buffer.append(StringUtil.appendNewLine(zeroRepresentation()));
        buffer.append(StringUtil.appendNewLine(zeroRepresentation()));
        buffer.append(StringUtil.appendNewLine(secondRankRepresentation()));
        buffer.append(StringUtil.appendNewLine(firstRankRepresentation()));


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
    public int PiecesCount(char representation) {
        int count = 0;
        for (Piece p : firstRank) {
//                if (firstRank.get(0).getRepresentation() == representation) {
//
//                }
        }

        return representation;
    }
}