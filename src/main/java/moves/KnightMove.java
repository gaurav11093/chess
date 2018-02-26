package moves;

import chess.ChessPerson;
import util.Position;

public class KnightMove implements Move {

  public int handleMove(ChessPerson[][] chessBoard, ChessPerson chessPerson, Position start, Position end) {
    boolean isValid = false;
    if (((end.getColom() - start.getColom()) == 1) || ((end.getColom() - start.getColom() == -1))) {
      if (((end.getRow() - start.getRow()) == 2) || ((end.getRow() - start.getRow() == -2)))
        isValid = true;
    }
    if (((end.getRow() - start.getRow()) == 1) || ((end.getRow() - start.getRow() == -1))) {
      if (((end.getColom() - start.getColom()) == 2) || ((end.getColom() - start.getColom() == -2)))
        isValid = true;
    }
    if (isValid) {
      Position position = chessPerson.getPosition();
      position.setRow(end.getRow());
      position.setColom(end.getColom());
      chessBoard[end.getRow()][end.getColom()] = chessPerson;
      chessBoard[start.getRow()][start.getColom()] = null;
      return 0;
    }
    return -1;

  }
}
