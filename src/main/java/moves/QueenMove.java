package moves;

import chess.ChessPerson;
import util.Position;

public class QueenMove implements Move {

  public int handleMove(ChessPerson[][] chessBoard, ChessPerson chessPerson, Position start, Position end) {

    if ((end.getColom() - start.getColom()) != (start.getRow() - end.getRow())) {
      return -1;
    }
    if (end.getRow() != start.getRow() && end.getColom() != start.getColom()) {
      return -1;
    }
    chessBoard[end.getRow()][end.getColom()] = chessPerson;
    chessBoard[start.getRow()][start.getColom()] = null;
    return 0;
  }
}
