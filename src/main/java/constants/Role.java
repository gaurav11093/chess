package constants;

public enum Role {
  KING("K"),
  QUEEN("Q"),
  ROOK("R"),
  BISHOP("B"),
  KNIGHT("H"),
  PAWN("P");

  private String name;

  @Override
  public String toString() {
    return getName();
  }

  private Role(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

}
