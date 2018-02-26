package util;

public class Position {
  int row;
  int colom;

  public void setRow(int row) {
    this.row = row;
  }

  public void setColom(int colom) {
    this.colom = colom;
  }

  public Position(int row, int colom) {
    this.row = row;
    this.colom = colom;
  }

  public int getRow() {
    return row;
  }

  public int getColom() {
    return colom;
  }

  @Override
  public String toString() {
    return "util.Position{" + "row=" + row + ", colom=" + colom + '}';
  }
}
