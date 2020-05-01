package edu.bu.met.cs665.visitable;

import java.util.HashMap;
import java.util.Map;
import visitors.MatchVisitor;

public class Set extends NonRootMatchComponent implements Visitable {

  /**+.
   * @param: Visitor visitor
   * @return: Visits object and all fo its aggregates
   */
  public void accept(MatchVisitor visitor) {
    visitor.visit(this);

    for (MatchComponents g : this.components) {
      Game gae = (Game) g;
      gae.accept(visitor);
    }

  }

  /**+.
   * @param: none
   * @return: returns winner
   */
  public String getWinner() {
    return this.winner;
  }

  /**+.
   * @param: none
   * @return: Iterates over Games and determines which player won more
   */
  @Override
  public void setWinner() {
    Map<String, Integer> nameToGamesWon = new HashMap<String,Integer>();
    for (MatchComponents c : this.components) {
      Game g = (Game) c;
      if (!nameToGamesWon.containsKey(g.getWinner())) {
        nameToGamesWon.put(g.getWinner(), 1);
      } else {
        nameToGamesWon.put(g.getWinner(), nameToGamesWon.get(g.getWinner()) + 1);
      }
    }
    String setWinner = "";
    for (String player : nameToGamesWon.keySet()) {
      if (setWinner.isBlank() || nameToGamesWon.get(setWinner) <= nameToGamesWon.get(player)) {
        setWinner = player;
      }
    }
    this.winner = setWinner;
  }

  /**+.
   * @param: Game g
   * @return: Aggregates games in ArrayList instance variable
   */
  public void addGame(Game g) {
    this.addComponent(g);
    this.setWinner();
  }

}