package visitors;

import edu.bu.met.cs665.visitable.Game;
import edu.bu.met.cs665.visitable.Match;
import edu.bu.met.cs665.visitable.Point;
import edu.bu.met.cs665.visitable.Set;

public class ComponentFactory {

  public static Match getMatch(String player1, String player2) {
    return new Match(player1, player2);
  }

  public static Set getSet() {
    return new Set();
  }

  public static Game getGame() {
    return new Game();
  }

  public static Point getPoint(String winner) {
    return new Point(winner);
  }
}
