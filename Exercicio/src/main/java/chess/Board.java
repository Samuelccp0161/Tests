package chess;

import chess.pieces.Piece;
import util.StringUtil;
import java.util.ArrayList;
import java.util.Collections;


public class Board {

    private final ArrayList<ArrayList<Piece>> allRanks;
    private final ArrayList<Piece> pieceWhite = new ArrayList<>();
    private final ArrayList<Piece> pieceBlack = new ArrayList<>();
    public void setOrdWhite(){
        Collections.sort(pieceWhite);
    }
    public void setOrdBlack(){
        Collections.sort(pieceBlack);
    }
    public int getNumbOfPieces() {
        return pieceWhite.size() + pieceBlack.size();
    }
    public int getNumbOfPiecesWhite(){
        return pieceWhite.size();
    }
    public int getNumbOfPiecesBlack(){
        return pieceBlack.size();
    }

    public Board() {

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
        pieceWhite.clear();
        pieceBlack.clear();
        pieceLists();
        setOrdWhite();
        setOrdBlack();

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
        if (piece.isWhite()){
            pieceWhite.add(piece);
            setOrdWhite();
        } else if (piece.isBlack()) {
            pieceBlack.add(piece);
            setOrdBlack();
        }
    }
    private void pieceLists() {
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
    public static boolean isValidPosition(String position){
        char column = position.charAt(0);
        char line = position.charAt(1);
        if (line < '1' || line > '8'){
            return false;
        }
        return column >= 'a' && column <= 'h';
    }
    public int countPiecesInColumn(int column, char representation) {
        int count = 0;
        for (int j = 0; j < 8; j++) { // Para cada peça na coluna i
            if (allRanks.get(j).get(column).getRepresentation() == representation)
                count++;
        } return count;
    }
}

