package moves;

import chess.ChessPerson;
import util.Position;

public interface Move {

  public int handleMove(ChessPerson[][] chessBoard, ChessPerson chessPerson, Position start, Position end);

}
