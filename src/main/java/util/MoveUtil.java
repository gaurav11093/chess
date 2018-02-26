package util;

import chess.ChessPerson;
import constants.Role;
import moves.KnightMove;
import moves.PawnMove;
import moves.QueenMove;

public class MoveUtil {

  public static int move(ChessPerson[][] chessBoard, ChessPerson chessPerson, Position start, Position end, Role role) {
    switch (role) {
      case QUEEN:
        return new QueenMove().handleMove(chessBoard, chessPerson, start, end);
      case KNIGHT:
        return new KnightMove().handleMove(chessBoard, chessPerson, start, end);
      case PAWN:
        return new PawnMove().handleMove(chessBoard, chessPerson, start, end);
      default:
        break;
    }
    return -1;
  }

}
