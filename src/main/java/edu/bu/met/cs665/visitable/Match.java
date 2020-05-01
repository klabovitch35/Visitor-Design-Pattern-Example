package edu.bu.met.cs665.visitable;

import java.util.ArrayList;
import visitors.MatchVisitor;


public class Match implements Visitable {
  ArrayList<Set> sets = new ArrayList<Set>();
  private static String player1;
  private static String player2;

  public Match(String p1, String p2) {
    this.player1 = p1;
    this.player2 = p2;
  }

  /**+.
   * @param: Visitor visitor
   * @return: Visits object and all of its aggregates
   */
  public void accept(MatchVisitor visitor) {
    visitor.visit(this);

    for (Set s : sets) {
      s.accept(visitor);
    }

  }

  /**+.
   * @param: Set s visitor
   * @return: Aggregates Set in ArrayList instance variable
   */
  public void addSet(Set s) {
    this.sets.add(s);
  }

  /**+.
   * @param: none
   * @return: returns player1
   */
  public String getPlayer1() {
    return this.player1;
  }

  /**+.
   * @param: none
   * @return: returns player2
   */
  public String getPlayer2() {
    return this.player2;
  }
}
