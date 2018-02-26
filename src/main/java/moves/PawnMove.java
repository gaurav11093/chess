package moves;

import chess.ChessPerson;
import util.Position;

public class PawnMove implements Move {
  public int handleMove(ChessPerson[][] chessBoard, ChessPerson chessPerson, Position start, Position end) {
    if (end.getColom() != start.getColom()) {
      return -1;
    }
    if (end.getRow() != start.getRow() + 1) {
      return -1;
    }
    Position position = chessPerson.getPosition();
    position.setRow(end.getRow());
    position.setColom(end.getColom());
    chessBoard[end.getRow()][end.getColom()] = chessPerson;
    chessBoard[start.getRow()][start.getColom()] = null;
    return 0;
  }
}
