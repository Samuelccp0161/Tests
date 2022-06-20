package chess;

import chess.pieces.Piece;
import util.StringUtil;
import java.util.ArrayList;

public class Board {

    private final ArrayList<ArrayList<Piece>> allRanks;

    Board() {

        this.allRanks = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            allRanks.add(new ArrayList<Piece>());
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


    public String printBoard(){

        StringBuilder buffer = new StringBuilder();

        for (int i = 7; i >= 0; i--) {
            printRank(buffer, i);
            buffer.append(StringUtil.appendNewLine(""));
        }
        return buffer.toString();
    }
    public void printRank(StringBuilder buffer, int index){
        for (int i = 0; i < allRanks.get(index).size(); i++) {
            buffer.append(allRanks.get(index).get(i).getRepresentation());

        }
    }
    public int piecesCount(char representation) {
        int count = 0;
        for (int i = 0; i <=7 ; i++) {
            for (int j = 0; j < allRanks.size(); j++) {
                if (allRanks.get(i).get(j).getRepresentation() == representation){
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
// parei aqui por conta do horario, vou ter que refatorar sem usar if, else ou for.
        if (rank == '1') {
            return allRanks.get(0).get(file);

        } else if (rank == '2') {
            return allRanks.get(1).get(file);

        } else if (rank == '3') {
            return allRanks.get(2).get(file);

        } else if (rank == '4') {
            return allRanks.get(3).get(file);

        } else if (rank == '5') {
            return allRanks.get(4).get(file);

        } else if (rank == '6') {
            return allRanks.get(5).get(file);

        } else if (rank == '7') {
            return allRanks.get(6).get(file);

        } else {
            return allRanks.get(7).get(file);
        }
    }

    public void push(String position, Piece piece) {
        char file = position.charAt(0);
        char rank = position.charAt(1);

        file -= 'a';

        if (rank == '1') {
             allRanks.get(0).set(file, piece);

        } else if (rank == '2') {
            allRanks.get(1).set(file, piece);

        } else if (rank == '3') {
           allRanks.get(2).set(file, piece);

        } else if (rank == '4') {
            allRanks.get(3).set(file, piece);

        } else if (rank == '5') {
            allRanks.get(4).set(file, piece);

        } else if (rank == '6') {
           allRanks.get(5).set(file, piece);

        } else if (rank == '7') {
            allRanks.get(6).set(file, piece);

        } else {
            allRanks.get(7).set(file,piece);
        }
    }

    public double pawnPower(){
        return 0.5;
    }
    public int rookPower(){
        return 5;
    }
    public double knightPower(){
        return 2.5;
    }
    public int bishopPower(){
        return 3;
    }
    public int queenPower(){
        return 9;
    }

    public double getPawnPower(){
        return pawnPower();
    }
    public int getRookPower(){
        return rookPower();
    }
    public double getKnightPower(){
        return knightPower();
    }
    public int getBishopPower(){
        return bishopPower();
    }
    public int getQueenPower(){
        return queenPower();
    }


}