package chess;

import chess.pieces.Piece;
import util.StringUtil;
import java.util.ArrayList;

public class Board {

//    private final ArrayList<Piece> arrayPawn;
    private ArrayList<Piece> firstRank;
    private ArrayList<Piece> secondRank;
    private ArrayList<Piece> thirdRank;
    private ArrayList<Piece> fourthRank;
    private ArrayList<Piece> fifthRank;
    private ArrayList<Piece> sixthRank;
    private ArrayList<Piece> seventhRank;
    private ArrayList<Piece> eighthRank;
    private ArrayList<Piece> column;

    private final String dot = "........";

    Board() {

//        arrayPawn = new ArrayList<>();
        this.firstRank = new ArrayList<>(8);
        firstRank.add(Piece.createWhiteRook());
        firstRank.add(Piece.createWhiteKnight());
        firstRank.add(Piece.createWhiteBishop());
        firstRank.add(Piece.createWhiteQueen());
        firstRank.add(Piece.createWhiteKing());
        firstRank.add(Piece.createWhiteBishop());
        firstRank.add(Piece.createWhiteKnight());
        firstRank.add(Piece.createWhiteRook());

        this.secondRank = new ArrayList<>(8);
        secondRank.add(Piece.createWhitePawn());
        secondRank.add(Piece.createWhitePawn());
        secondRank.add(Piece.createWhitePawn());
        secondRank.add(Piece.createWhitePawn());
        secondRank.add(Piece.createWhitePawn());
        secondRank.add(Piece.createWhitePawn());
        secondRank.add(Piece.createWhitePawn());
        secondRank.add(Piece.createWhitePawn());

        this.thirdRank = new ArrayList<>(8);
        thirdRank.add(Piece.createNoPoints());
        thirdRank.add(Piece.createNoPoints());
        thirdRank.add(Piece.createNoPoints());
        thirdRank.add(Piece.createNoPoints());
        thirdRank.add(Piece.createNoPoints());
        thirdRank.add(Piece.createNoPoints());
        thirdRank.add(Piece.createNoPoints());
        thirdRank.add(Piece.createNoPoints());

        this.fourthRank = new ArrayList<>(8);
        fourthRank.add(Piece.createNoPoints());
        fourthRank.add(Piece.createNoPoints());
        fourthRank.add(Piece.createNoPoints());
        fourthRank.add(Piece.createNoPoints());
        fourthRank.add(Piece.createNoPoints());
        fourthRank.add(Piece.createNoPoints());
        fourthRank.add(Piece.createNoPoints());
        fourthRank.add(Piece.createNoPoints());

        this.fifthRank = new ArrayList<>(8);
        fifthRank.add(Piece.createNoPoints());
        fifthRank.add(Piece.createNoPoints());
        fifthRank.add(Piece.createNoPoints());
        fifthRank.add(Piece.createNoPoints());
        fifthRank.add(Piece.createNoPoints());
        fifthRank.add(Piece.createNoPoints());
        fifthRank.add(Piece.createNoPoints());
        fifthRank.add(Piece.createNoPoints());

        this.sixthRank = new ArrayList<>(8);
        sixthRank.add(Piece.createNoPoints());
        sixthRank.add(Piece.createNoPoints());
        sixthRank.add(Piece.createNoPoints());
        sixthRank.add(Piece.createNoPoints());
        sixthRank.add(Piece.createNoPoints());
        sixthRank.add(Piece.createNoPoints());
        sixthRank.add(Piece.createNoPoints());
        sixthRank.add(Piece.createNoPoints());

        this.seventhRank = new ArrayList<>(8);
        seventhRank.add(Piece.createBlackPawn());
        seventhRank.add(Piece.createBlackPawn());
        seventhRank.add(Piece.createBlackPawn());
        seventhRank.add(Piece.createBlackPawn());
        seventhRank.add(Piece.createBlackPawn());
        seventhRank.add(Piece.createBlackPawn());
        seventhRank.add(Piece.createBlackPawn());
        seventhRank.add(Piece.createBlackPawn());

        this.eighthRank = new ArrayList<>(8);
        eighthRank.add(Piece.createBlackRook());
        eighthRank.add(Piece.createBlackKnight());
        eighthRank.add(Piece.createBlackBishop());
        eighthRank.add(Piece.createBlackQueen());
        eighthRank.add(Piece.createBlackKing());
        eighthRank.add(Piece.createBlackBishop());
        eighthRank.add(Piece.createBlackKnight());
        eighthRank.add(Piece.createBlackRook());
    }

    public void initialize() {

        Piece.resetCount();
        firstRank.set(0, Piece.createWhiteRook());
        firstRank.set(1, Piece.createWhiteKnight());
        firstRank.set(2, Piece.createWhiteBishop());
        firstRank.set(3, Piece.createWhiteQueen());
        firstRank.set(4, Piece.createWhiteKing());
        firstRank.set(5, Piece.createWhiteBishop());
        firstRank.set(6, Piece.createWhiteKnight());
        firstRank.set(7, Piece.createWhiteRook());

        secondRank.set(0, Piece.createWhitePawn());
        secondRank.set(1, Piece.createWhitePawn());
        secondRank.set(2, Piece.createWhitePawn());
        secondRank.set(3, Piece.createWhitePawn());
        secondRank.set(4, Piece.createWhitePawn());
        secondRank.set(5, Piece.createWhitePawn());
        secondRank.set(6, Piece.createWhitePawn());
        secondRank.set(7, Piece.createWhitePawn());

        thirdRank.set(0, Piece.createNoPoints());
        thirdRank.set(1, Piece.createNoPoints());
        thirdRank.set(2, Piece.createNoPoints());
        thirdRank.set(3, Piece.createNoPoints());
        thirdRank.set(4, Piece.createNoPoints());
        thirdRank.set(5, Piece.createNoPoints());
        thirdRank.set(6, Piece.createNoPoints());
        thirdRank.set(7, Piece.createNoPoints());

        fourthRank.set(0, Piece.createNoPoints());
        fourthRank.set(1, Piece.createNoPoints());
        fourthRank.set(2, Piece.createNoPoints());
        fourthRank.set(3, Piece.createNoPoints());
        fourthRank.set(4, Piece.createNoPoints());
        fourthRank.set(5, Piece.createNoPoints());
        fourthRank.set(6, Piece.createNoPoints());
        fourthRank.set(7, Piece.createNoPoints());

        fifthRank.set(0, Piece.createNoPoints());
        fifthRank.set(1, Piece.createNoPoints());
        fifthRank.set(2, Piece.createNoPoints());
        fifthRank.set(3, Piece.createNoPoints());
        fifthRank.set(4, Piece.createNoPoints());
        fifthRank.set(5, Piece.createNoPoints());
        fifthRank.set(6, Piece.createNoPoints());
        fifthRank.set(7, Piece.createNoPoints());

        sixthRank.set(0, Piece.createNoPoints());
        sixthRank.set(1, Piece.createNoPoints());
        sixthRank.set(2, Piece.createNoPoints());
        sixthRank.set(3, Piece.createNoPoints());
        sixthRank.set(4, Piece.createNoPoints());
        sixthRank.set(5, Piece.createNoPoints());
        sixthRank.set(6, Piece.createNoPoints());
        sixthRank.set(7, Piece.createNoPoints());

        seventhRank.set(0, Piece.createBlackPawn());
        seventhRank.set(1, Piece.createBlackPawn());
        seventhRank.set(2, Piece.createBlackPawn());
        seventhRank.set(3, Piece.createBlackPawn());
        seventhRank.set(4, Piece.createBlackPawn());
        seventhRank.set(5, Piece.createBlackPawn());
        seventhRank.set(6, Piece.createBlackPawn());
        seventhRank.set(7, Piece.createBlackPawn());

        eighthRank.set(0, Piece.createBlackRook());
        eighthRank.set(1, Piece.createBlackKnight());
        eighthRank.set(2, Piece.createBlackBishop());
        eighthRank.set(3, Piece.createBlackQueen());
        eighthRank.set(4, Piece.createBlackKing());
        eighthRank.set(5, Piece.createBlackBishop());
        eighthRank.set(6, Piece.createBlackKnight());
        eighthRank.set(7, Piece.createBlackRook());
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

    public int piecesCount(char representation) {
        int count = 0;
        for (Piece piece : firstRank) {
            if (piece.getRepresentation() == representation) {
                count += 1;
            }
        }
        for (Piece piece : secondRank) {
            if (piece.getRepresentation() == representation) {
                count += 1;
            }
        }
        for (Piece piece : thirdRank) {
            if (piece.getRepresentation() == representation) {
                count += 1;
            }
        }
        for (Piece piece : fourthRank) {
            if (piece.getRepresentation() == representation) {
                count += 1;
            }
        }
        for (Piece piece : fifthRank) {
            if (piece.getRepresentation() == representation) {
                count += 1;
            }
        }
        for (Piece piece : sixthRank) {
            if (piece.getRepresentation() == representation) {
                count += 1;
            }
        }
        for (Piece piece : seventhRank) {
            if (piece.getRepresentation() == representation) {
                count += 1;
            }
        }
        for (Piece piece : eighthRank) {
            if (piece.getRepresentation() == representation) {
                count += 1;
            }
        }

        return count;
    }

    public Piece getPiece(String position) {

        char file = position.charAt(0);
        char rank = position.charAt(1);

        file -= 'a';
        if (rank == '1') {
            return firstRank.get(file);

        } else if (rank == '2') {
            return secondRank.get(file);

        } else if (rank == '3') {
            return thirdRank.get(file);

        } else if (rank == '4') {
            return fourthRank.get(file);

        } else if (rank == '5') {
            return fifthRank.get(file);

        } else if (rank == '6') {
            return sixthRank.get(file);

        } else if (rank == '7') {
            return seventhRank.get(file);

        } else {
            return eighthRank.get(file);
        }
    }
}