package chess;

import chess.pieces.Piece;
import util.StringUtil;

import java.util.ArrayList;

public class Board {

    private final ArrayList<ArrayList<Piece>> allRanks;

    Board() {

        this.allRanks = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            allRanks.add(new ArrayList<>());
        }

        for (int i = 0; i < 8; i++) {
            allRanks.get(0).add(Piece.noColor());
            allRanks.get(1).add(Piece.noColor());
            allRanks.get(2).add(Piece.noColor());
            allRanks.get(3).add(Piece.noColor());
            allRanks.get(4).add(Piece.noColor());
            allRanks.get(5).add(Piece.noColor());
            allRanks.get(6).add(Piece.noColor());
            allRanks.get(7).add(Piece.noColor());
        }

    }

    public void initialize() {

        Piece.resetCount();
        allRanks.get(0).set(0, Piece.createWhiteRook());
        allRanks.get(0).set(1, Piece.createWhiteKnight());
        allRanks.get(0).set(2, Piece.createWhiteBishop());
        allRanks.get(0).set(3, Piece.createWhiteQueen());
        allRanks.get(0).set(4, Piece.createWhiteKing());
        allRanks.get(0).set(5, Piece.createWhiteBishop());
        allRanks.get(0).set(6, Piece.createWhiteKnight());
        allRanks.get(0).set(7, Piece.createWhiteRook());

        allRanks.get(1).set(0, Piece.createWhitePawn());
        allRanks.get(1).set(1, Piece.createWhitePawn());
        allRanks.get(1).set(2, Piece.createWhitePawn());
        allRanks.get(1).set(3, Piece.createWhitePawn());
        allRanks.get(1).set(4, Piece.createWhitePawn());
        allRanks.get(1).set(5, Piece.createWhitePawn());
        allRanks.get(1).set(6, Piece.createWhitePawn());
        allRanks.get(1).set(7, Piece.createWhitePawn());

        allRanks.get(6).set(0, Piece.createBlackPawn());
        allRanks.get(6).set(1, Piece.createBlackPawn());
        allRanks.get(6).set(2, Piece.createBlackPawn());
        allRanks.get(6).set(3, Piece.createBlackPawn());
        allRanks.get(6).set(4, Piece.createBlackPawn());
        allRanks.get(6).set(5, Piece.createBlackPawn());
        allRanks.get(6).set(6, Piece.createBlackPawn());
        allRanks.get(6).set(7, Piece.createBlackPawn());

        allRanks.get(7).set(0, Piece.createBlackRook());
        allRanks.get(7).set(1, Piece.createBlackKnight());
        allRanks.get(7).set(2, Piece.createBlackBishop());
        allRanks.get(7).set(3, Piece.createBlackQueen());
        allRanks.get(7).set(4, Piece.createBlackKing());
        allRanks.get(7).set(5, Piece.createBlackBishop());
        allRanks.get(7).set(6, Piece.createBlackKnight());
        allRanks.get(7).set(7, Piece.createBlackRook());
    }

    public int getNumbOfPieces() {
        return Piece.getCountBlack() + Piece.getCountWhite();
    }


    public String printBoard() {

        StringBuilder buffer = new StringBuilder();

        for (int i = 7; i >= 0; i--) {
            printRank(buffer, i);
            buffer.append(StringUtil.appendNewLine(""));
        }
        return buffer.toString();
    }

    public void printRank(StringBuilder buffer, int index) {
        for (int i = 0; i < allRanks.get(index).size(); i++) {
            buffer.append(allRanks.get(index).get(i).getRepresentation());

        }
    }

    public int piecesCount(char representation) {
        int count = 0;
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j < allRanks.size(); j++) {
                if (allRanks.get(i).get(j).getRepresentation() == representation) {
                    count++;
                }
            }
        }
        return count;
    }

    public Piece getPiece(String position) {
        char file = position.charAt(0);
        char rank = position.charAt(1);

        file -= 'a';
        rank -= '1';

        return allRanks.get(rank).get(file);
    }

    public void push(String position, Piece piece) {
        char file = position.charAt(0);
        char rank = position.charAt(1);

        file -= 'a';
        rank -= '1';

        allRanks.get(rank).set(file, piece);

    }

    public double powerBlack() {
        double powerd;

        powerd = piecesCount('Q') * 9;
        powerd += piecesCount('R') * 5;
        powerd += piecesCount('B') * 3;
        powerd += piecesCount('N') * 2.5;
        powerd += powerPawn('P');
        return powerd;
    }

    public double powerWhite() {
        double powers;

        powers = piecesCount('q') * 9;
        powers += piecesCount('r') * 5;
        powers += piecesCount('b') * 3;
        powers += piecesCount('n') * 2.5;
        powers += powerPawn('p');
        return powers;
    }

    public double powerPawn(char pawns) {
        int count = 0;
        double power = 0;

        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j < 8; j++) {
                if (allRanks.get(j).get(i).getRepresentation() == pawns)
                    count += 1;
            }

            if (count > 1)
                power += count * 0.5;
            else power += count;

            count = 0;
        }
        return power;
    }
}