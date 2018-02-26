package constants;

public enum Color {
  BLACK("B"),
  WHITE("W");

  private String color;

  @Override
  public String toString() {
    return getColor();
  }

  private Color(String color) {
    this.color = color;
  }

  public String getColor() {
    return color;
  }
}
