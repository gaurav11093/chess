package chess;

import constants.Color;
import constants.Role;
import util.Position;

public class ChessPerson {
  private Color color;
  private Position position;
  private Role role;

  public ChessPerson(Color color, Position position, Role role) {
    this.color = color;
    this.position = position;
    this.role = role;
  }

  public Color getColor() {
    return color;
  }

  public Position getPosition() {
    return position;
  }

  public Role getRole() {
    return role;
  }

  public int move(ChessBoard chessBoard, Position start, Position end) {
    return 0;
  }

  @Override
  public String toString() {
    return color.getColor() + role.getName();
  }
}
