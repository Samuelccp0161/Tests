package chess;

import chess.pieces.NoPiece;
import chess.pieces.Piece;
import util.StringUtil;
import java.util.*;

public class Board implements Iterable<Piece> {
    private final Piece [][] allRanks;
    private final ArrayList<Piece> pieceWhite = new ArrayList<>();
    private final ArrayList<Piece> pieceBlack = new ArrayList<>();
    public ArrayList<Piece> getPieceWhiteList(){
        return pieceWhite;
    }
    public ArrayList<Piece> getPieceBlackList(){
        return pieceBlack;
    }
    public int getNumbOfPiecesWhite(){
        return pieceWhite.size();
    }
    public int getNumbOfPiecesBlack(){
        return pieceBlack.size();
    }
    public void setOrdWhite(){
        Collections.sort(pieceWhite);
    }
    public void setOrdBlack(){
        Collections.sort(pieceBlack);
    }
    public int getNumbOfPieces() {
        return pieceWhite.size() + pieceBlack.size();
    }
    public Board() {
        this.allRanks = new Piece[8][8];

        for (int i = 0; i < 8; i++) {
            allRanks[i][0] = Piece.noColor();
            allRanks[i][1] = Piece.noColor();
            allRanks[i][2] = Piece.noColor();
            allRanks[i][3] = Piece.noColor();
            allRanks[i][4] = Piece.noColor();
            allRanks[i][5] = Piece.noColor();
            allRanks[i][6] = Piece.noColor();
            allRanks[i][7] = Piece.noColor();
        }
    }
    public void initialize() {

        allRanks[0][0] =  Piece.createWhiteRook();
        allRanks[0][1] =  Piece.createWhiteKnight();
        allRanks[0][2] = Piece.createWhiteBishop();
        allRanks[0][3] = Piece.createWhiteQueen();
        allRanks[0][4] = Piece.createWhiteKing();
        allRanks[0][5] = Piece.createWhiteBishop();
        allRanks[0][6] = Piece.createWhiteKnight();
        allRanks[0][7] = Piece.createWhiteRook();

        allRanks[1][0] = Piece.createWhitePawn();
        allRanks[1][1] = Piece.createWhitePawn();
        allRanks[1][2] = Piece.createWhitePawn();
        allRanks[1][3] = Piece.createWhitePawn();
        allRanks[1][4] = Piece.createWhitePawn();
        allRanks[1][5] = Piece.createWhitePawn();
        allRanks[1][6] = Piece.createWhitePawn();
        allRanks[1][7] = Piece.createWhitePawn();

        allRanks[6][0] = Piece.createBlackPawn();
        allRanks[6][1] = Piece.createBlackPawn();
        allRanks[6][2] = Piece.createBlackPawn();
        allRanks[6][3] = Piece.createBlackPawn();
        allRanks[6][4] = Piece.createBlackPawn();
        allRanks[6][5] = Piece.createBlackPawn();
        allRanks[6][6] = Piece.createBlackPawn();
        allRanks[6][7] = Piece.createBlackPawn();


        allRanks[7][0] = Piece.createBlackRook();
        allRanks[7][1] = Piece.createBlackKnight();
        allRanks[7][2] = Piece.createBlackBishop();
        allRanks[7][3] = Piece.createBlackQueen();
        allRanks[7][4] = Piece.createBlackKing();
        allRanks[7][5] = Piece.createBlackBishop();
        allRanks[7][6] = Piece.createBlackKnight();
        allRanks[7][7] = Piece.createBlackRook();
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
        for (int i = 0; i < allRanks[index].length; i++) {
            buffer.append(allRanks[index][i].getRepresentation());

        }
    }
    public int piecesCount(char representation) {
        int count = 0;
        for (Piece p : this) {
                if (p.getRepresentation() == representation) {
                    count++;
                }
            }
        return count;
    }
    public Piece getPiece(String position) {
        char file = position.charAt(0);
        char rank = position.charAt(1);

        file -= 'a';
         rank -= '1';

        return allRanks[rank][file];
    }
    public void push(String position, Piece piece) {
        char file = position.charAt(0);
        char rank = position.charAt(1);

        file -= 'a';
        rank -= '1';

        allRanks[rank][file] = piece;
        if (piece.isWhite()){
            pieceWhite.add(piece);
            setOrdWhite();
        } else if (piece.isBlack()) {
            pieceBlack.add(piece);
            setOrdBlack();
        }
    }
    private void pieceLists() {
        for (Piece p : this) {
                if(p.isWhite()){
                    pieceWhite.add(p);
                }
                else if (p.isBlack()) {
                    pieceBlack.add(p);
                }
            }
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
            if (allRanks[j][column].getRepresentation() == representation)
                count++;
        } return count;
    }
    @Override
    public Iterator<Piece> iterator() {
        return gg().iterator();
    }
    public List<Piece> gg(){
        List<Piece> pieceInBoard = new ArrayList<Piece>();
        for (Piece[] rank : allRanks)
            for (int i = 0; i < allRanks.length; i++) {
                if (rank[i].getRepresentation() != NoPiece.NO_PIECE_REPRESENTATION){
                    pieceInBoard.add(rank[i]);

                }
            }

        return pieceInBoard;
    }
}
