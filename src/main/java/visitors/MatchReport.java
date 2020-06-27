package visitors;

import edu.bu.met.cs665.visitable.Game;
import edu.bu.met.cs665.visitable.Match;
import edu.bu.met.cs665.visitable.Point;
import edu.bu.met.cs665.visitable.Set;

public class MatchReport extends MatchVisitor {
  int[] player1Results = new int[3];
  int[] player2Results = new int[3];
  String player1;
  String player2;

  /**+.
   * @param: Match m
   * @return: implements logic for visting objects that haven't been implemented yet
   */
  public void defaultVisit(Object object) {
    System.out.println("the functionality for visiting this object hasn't been implemented yet");
  }


  /**+.
   * @param: Match m
   * @return: logic template for visiting match
   */
  public void visit(Match m) {
    this.player1 = m.getPlayer1();
    this.player2 = m.getPlayer2();
    this.player1Results[0] = 0;
    this.player1Results[1] = 0;
    this.player1Results[2] = 0;
    this.player2Results[0] = 0;
    this.player2Results[1] = 0;
    this.player2Results[2] = 0;
  }

  /**+.
   * @param: Game g
   * @return: logic template for visiting game
   */
  public void visit(Game g) {
    if (g.getWinner().equals(player1)) {
      this.player1Results[1] = this.player1Results[1] + 1;
    } else if (g.getWinner().equals(player2)) {
      this.player2Results[1] = this.player2Results[1] + 1;
    }
  }

  /**+.
   * @param: Set s
   * @return: logic template for visiting set
   */
  public void visit(Set s) {
    if (s.getWinner().equals(player1)) {
      this.player1Results[0] = this.player1Results[0] + 1;
    } else if (s.getWinner().equals(player2)) {
      this.player2Results[0] = this.player2Results[0] + 1;
    }
  }

  /**+.
   * @param: Point p
   * @return: logic template for visiting point
   */
  @Override
  public void visit(Point p) {
    if (p.getWinner().equals(player1)) {
      this.player1Results[2] = this.player1Results[2]++;
    } else if (p.getWinner().equals(player2)) {
      this.player2Results[2] = this.player1Results[2]++;
    }
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

  /**+.
   * @param: none
   * @return: returns player 1's match results
   */
  public int[] getPlayer1Results() {
    return this.player1Results;
  }

  /**+.
   * @param: none
   * @return: returns player 2's match results
   */
  public int[] getPlayer2Results() {
    return this.player2Results;
  }
}
