package chess;

import chess.pieces.Piece;
import util.StringUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;


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

    private Map<Piece.Name, Double> powers = null;
    private void powers(){
        powers = new EnumMap<Piece.Name, Double>(Piece.Name.class);
        powers.put(Piece.Name.KING, 0.0);
        powers.put(Piece.Name.NO_POINTS, 0.0);
        powers.put(Piece.Name.ROOK, 5.0);
        powers.put(Piece.Name.QUEEN, 9.0);
        powers.put(Piece.Name.PAWN, 1.0);
        powers.put(Piece.Name.KNIGHT, 2.5);
        powers.put(Piece.Name.BISHOP, 3.0);
    }
    private Map<Piece.Name, Double> getPowers(){
        if (powers == null)
            powers();
        return powers;
    }
    public Double getMapPower(Piece.Name name){
        return getPowers().get(name);
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

        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j < 8; j++) {
                if (allRanks.get(j).get(i).getRepresentation() == representation)
                    count += 1;
            }

            if (count > 1)
                power += count * Piece.Name.PAWN.getPower() / 2;
            else power += count * Piece.Name.PAWN.getPower();

            count = 0;
        }
        return power;
    }

    private final ArrayList<Piece> pieceWhite = new ArrayList<>();
    private final ArrayList<Piece> pieceBlack = new ArrayList<>();
    public void pieceLists() {
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j < allRanks.size(); j++) {
                if(allRanks.get(i).get(j).isWhite()){
                    pieceWhite.add(allRanks.get(i).get(j));
                }
                else if (allRanks.get(i).get(j).isBlack()) {
                    pieceBlack.add(allRanks.get(i).get(j));
                }
            }
        }
    }
    public ArrayList<Piece> getPieceWhiteList(){
        return pieceWhite;
    }
    public ArrayList<Piece> getPieceBlackList(){
        return pieceBlack;
    }
    public void getOrdWhite(){
        Collections.sort(pieceWhite);
    }
    public void getOrdBlack(){
        Collections.sort(pieceBlack);
    }

    public ArrayList<String> freePositions(String position, Piece piece) {
        ArrayList<String> list = new ArrayList<>();

        char column = position.charAt(0);
        char line = position.charAt(1);

        char app = (char) (line+1);
        char att = (char) (column+1);
        char aqq = (char)(line -1);
        char acc = (char)(column -1);

        String n = ""  +column + app ;
        String nu = ""  +att + app ;
        String num = "" +att +line;
        String numb = ""  +att + aqq;
        String numbe = "" +acc + line;
        String number = "" +acc + aqq;
        String numbere = "" + acc + app;
        String numberer = "" + column + aqq ;

        list.add(n);
        list.add(nu);
        list.add(num);
        list.add(numb);
        list.add(numbe);
        list.add(number);
        list.add(numbere);
        list.add(numberer);

        return list;
    }

}

