package edu.bu.met.cs665.visitable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import visitors.MatchVisitor;


public class Game extends NonRootMatchComponent implements Visitable {

  /**+.
   * @param: Visitor visitor
   * @return: Visits object and all fo its aggregates
   */
  public void accept(MatchVisitor visitor) {
    visitor.visit(this);

    for (MatchComponents c : components) {
      Point p = (Point) c;
      p.accept(visitor);
    }

  }

  /**+.
   * @param: none
   * @return: Iterates over Games and determines which player won more
   */
  @Override
  public void setWinner() {
    HashSet<String> playerNames = new HashSet<String>();
    Map<String, Integer> nameToPointsWon = new HashMap<String,Integer>();
    for (MatchComponents c : this.components) {
      Point p = (Point) c;
      if (!nameToPointsWon.containsKey(p.getWinner())) {
        nameToPointsWon.put(p.getWinner(), 1);
      } else {
        nameToPointsWon.put(p.getWinner(), nameToPointsWon.get(p.getWinner()) + 1);
      }
    }
    String gameWinner = "";
    for (String player : nameToPointsWon.keySet()) {
      if (gameWinner.isBlank() || nameToPointsWon.get(gameWinner) <= nameToPointsWon.get(player)) {
        gameWinner = player;
      }
    }
    this.winner = gameWinner;
  }

  /**+.
   * @param: Point p
   * @return: Aggregates point in ArrayList instance variable
   */

  public void addPoint(Point p) {
    this.addComponent(p);
    this.setWinner();
  }


}
