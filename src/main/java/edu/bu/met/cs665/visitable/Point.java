package edu.bu.met.cs665.visitable;

import visitors.MatchVisitor;

public class Point extends MatchComponents implements Visitable {

  public Point(String winner) {
    this.winner = winner;
  }

  /**+.
   * @param: Visitor (Expected MatchReport)
   * @return: void, goes to visit method on Visitor for this object
   */
  public void accept(MatchVisitor visitor) {
    visitor.visit(this);

  }

}
