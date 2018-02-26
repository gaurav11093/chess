package chess;

import static constants.Role.QUEEN;

import constants.Color;
import constants.Role;
import util.MoveUtil;
import util.Position;

public class ChessBoard {
  private ChessPerson[][] chessBoard = new ChessPerson[8][8];

  public static void main(String[] args) {
    ChessBoard chessBoard = new ChessBoard();
    int moveStatus;
    chessBoard.printChessBoard();

    moveStatus = chessBoard.handleMove("WP", "10", "20");
    if (moveStatus != -1) {
      chessBoard.printChessBoard();
    } else {
      System.out.println();
      System.out.println("Invalid move");
      System.out.println();
    }

  }

  public ChessBoard() {
    init();
  }

  private void init() {
    for (int i = 2; i < 6; i++) {
      for (int j = 0; j < 8; j++) {
        chessBoard[i][j] = null;
      }
    }
    chessBoard[0][0] = new ChessPerson(Color.WHITE, new Position(0, 0), Role.ROOK);
    chessBoard[0][1] = new ChessPerson(Color.WHITE, new Position(0, 1), Role.KNIGHT);
    chessBoard[0][2] = new ChessPerson(Color.WHITE, new Position(0, 2), Role.BISHOP);
    chessBoard[0][3] = new ChessPerson(Color.WHITE, new Position(0, 3), QUEEN);
    chessBoard[0][4] = new ChessPerson(Color.WHITE, new Position(0, 4), Role.KING);
    chessBoard[0][5] = new ChessPerson(Color.WHITE, new Position(0, 5), Role.BISHOP);
    chessBoard[0][6] = new ChessPerson(Color.WHITE, new Position(0, 6), Role.KNIGHT);
    chessBoard[0][7] = new ChessPerson(Color.WHITE, new Position(0, 7), Role.ROOK);
    chessBoard[1][0] = new ChessPerson(Color.WHITE, new Position(1, 0), Role.PAWN);
    chessBoard[1][1] = new ChessPerson(Color.WHITE, new Position(1, 1), Role.PAWN);
    chessBoard[1][2] = new ChessPerson(Color.WHITE, new Position(1, 2), Role.PAWN);
    chessBoard[1][3] = new ChessPerson(Color.WHITE, new Position(1, 3), Role.PAWN);
    chessBoard[1][4] = new ChessPerson(Color.WHITE, new Position(1, 4), Role.PAWN);
    chessBoard[1][5] = new ChessPerson(Color.WHITE, new Position(1, 5), Role.PAWN);
    chessBoard[1][6] = new ChessPerson(Color.WHITE, new Position(1, 6), Role.PAWN);
    chessBoard[1][7] = new ChessPerson(Color.WHITE, new Position(1, 7), Role.PAWN);

    chessBoard[7][0] = new ChessPerson(Color.BLACK, new Position(7, 0), Role.ROOK);
    chessBoard[7][1] = new ChessPerson(Color.BLACK, new Position(7, 1), Role.KNIGHT);
    chessBoard[7][2] = new ChessPerson(Color.BLACK, new Position(7, 2), Role.BISHOP);
    chessBoard[7][3] = new ChessPerson(Color.BLACK, new Position(7, 3), QUEEN);
    chessBoard[7][4] = new ChessPerson(Color.BLACK, new Position(7, 4), Role.KING);
    chessBoard[7][5] = new ChessPerson(Color.BLACK, new Position(7, 5), Role.BISHOP);
    chessBoard[7][6] = new ChessPerson(Color.BLACK, new Position(7, 6), Role.KNIGHT);
    chessBoard[7][7] = new ChessPerson(Color.BLACK, new Position(7, 7), Role.ROOK);
    chessBoard[6][0] = new ChessPerson(Color.BLACK, new Position(6, 0), Role.PAWN);
    chessBoard[6][1] = new ChessPerson(Color.BLACK, new Position(6, 1), Role.PAWN);
    chessBoard[6][2] = new ChessPerson(Color.BLACK, new Position(6, 2), Role.PAWN);
    chessBoard[6][3] = new ChessPerson(Color.BLACK, new Position(6, 3), Role.PAWN);
    chessBoard[6][4] = new ChessPerson(Color.BLACK, new Position(6, 4), Role.PAWN);
    chessBoard[6][5] = new ChessPerson(Color.BLACK, new Position(6, 5), Role.PAWN);
    chessBoard[6][6] = new ChessPerson(Color.BLACK, new Position(6, 6), Role.PAWN);
    chessBoard[6][7] = new ChessPerson(Color.BLACK, new Position(6, 7), Role.PAWN);
  }

  public void printChessBoard() {
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        if (chessBoard[i][j] != null) {
          System.out.print(chessBoard[i][j].toString() + " ");
        } else {
          System.out.print("-- ");
        }
      }
      System.out.println();
    }
    System.out.println();
  }

  /**
   * Will return -1 in case of invalid move
   *
   *
   * @param person
   * @param start
   * @param end
   * @return
   */
  public int handleMove(String person, String start, String end) {
    String c = person.substring(0, 1);
    String r = person.substring(1, 2);
    Color color = null;
    if (c.equals(Color.BLACK.getColor())) {
      color = Color.BLACK;
    } else if (c.equals(Color.WHITE.getColor())) {
      color = Color.WHITE;
    }

    // TODO Check for valid color

    Role role = null;
    if (r.equals(Role.QUEEN.getName())) {
      role = Role.QUEEN;
    } else if (r.equals(Role.PAWN.getName())) {
      role = Role.PAWN;
    } else if (r.equals(Role.KNIGHT.getName())) {
      role = Role.KNIGHT;
    }

    // TODO Check for valid role

    Position startPosition = new Position(Integer.parseInt(start.substring(0, 1)), Integer.parseInt(start.substring(1, 2)));
    Position endPosition = new Position(Integer.parseInt(end.substring(0, 1)), Integer.parseInt(end.substring(1, 2)));

    if (!validPositions(startPosition, endPosition)) {
      return -1;
    }

    ChessPerson startPerson = chessBoard[startPosition.getRow()][startPosition.getColom()];
    ChessPerson endPerson = chessBoard[endPosition.getRow()][endPosition.getColom()];
    if (startPerson == null) {
      return -1;
    }
    if (startPerson.getPosition().getColom() != startPosition.getColom()
        || startPerson.getPosition().getRow() != startPosition.getRow()) {
      return -1;
    }

    // check for same color start
    if (!startPerson.getColor().getColor().equals(color.getColor())) {
      return -1;
    }

    // check for different color end
    if (endPerson != null && endPerson.getColor().getColor().equals(color.getColor())) {
      return -1;
    }

    return MoveUtil.move(chessBoard, startPerson, startPosition, endPosition, role);
  }

  public ChessPerson getPerson(Position position) {
    return chessBoard[position.getRow()][position.getColom()];
  }

  private boolean validPositions(Position startPosition, Position endPosition) {
    // TODO check for boundry
    return true;
  }
}
