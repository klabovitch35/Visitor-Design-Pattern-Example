package edu.bu.met.cs665;

import visitors.MatchReport;
import edu.bu.met.cs665.visitable.Game;
import edu.bu.met.cs665.visitable.Match;
import edu.bu.met.cs665.visitable.Point;
import edu.bu.met.cs665.visitable.Set;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestMatchReport {

  public Match setUpMatch() {
    Point p1 = new Point("Joe");
    Point p2 = new Point("Jane");
    Point p3 = new Point("Joe");
    Point p4 = new Point("Jane");
    Point p5 = new Point("Joe");
    Point p6 = new Point("Jane");
    Point p7 = new Point("Joe");
    Point p8 = new Point("Jane");
    Point p9 = new Point("Joe");
    Point p10 = new Point("Jane");
    Point p11 = new Point("Joe");
    Point p12 = new Point("Jane");
    Point p13 = new Point("Joe");
    Point p14 = new Point("Jane");
    Point p15 = new Point("Joe");
    Point p16 = new Point("Jane");

    Game g1 = new Game();
    g1.addPoint(p1);
    System.out.println("g1 winner " + g1.getWinner());
    g1.addPoint(p2);
    g1.addPoint(p3);
    Game g2 = new Game();
    g2.addPoint(p4);
    Game g3 = new Game();
    g3.addPoint(p5);

    Set s1 = new Set();

    s1.addGame(g1);
    s1.addGame(g2);
    s1.addGame(g3);
    Game g4 = new Game();
    g4.addPoint(p6);
    g4.addPoint(p7);
    g4.addPoint(p8);
    Game g5 = new Game();
    g5.addPoint(p9);
    Game g6 = new Game();
    g6.addPoint(p10);
    Set s2 = new Set();
    s2.addGame(g4);
    s2.addGame(g5);
    s2.addGame(g6);

    Game g7 = new Game();
    g7.addPoint(p10);
    g7.addPoint(p11);
    g7.addPoint(p12);
    Game g8 = new Game();
    g8.addPoint(p13);
    Game g9 = new Game();
    g9.addPoint(p14);
    Set s3 = new Set();
    s3.addGame(g4);
    s3.addGame(g5);
    s3.addGame(g6);
    Match m = new Match("Joe", "Jane");
    m.addSet(s1);
    m.addSet(s2);
    m.addSet(s3);

    return m;
  }

  @Test
  public void testIt () {
    Match m = this.setUpMatch();
    MatchReport mr = new MatchReport();
    m.accept(mr);
    assertEquals("Joe", mr.getPlayer1());
    assertEquals("Jane", mr.getPlayer2());
    assertEquals(mr.getPlayer1Results()[0], 1);
    assertEquals(mr.getPlayer2Results()[0], 2);
    assertEquals(mr.getPlayer1Results()[1], 4);
    assertEquals(mr.getPlayer2Results()[1], 5);
    assertEquals(mr.getPlayer1Results()[2], 8);
    assertEquals(mr.getPlayer2Results()[2], 7);
  }

  @Test
  public void testGameWinner () {
    Game g = new Game();
    Point p1 = new Point("Jake");
    Point p2 = new Point ("Jane");
    Point p3 = new Point("Jake");
    g.addPoint(p1);
    g.addPoint(p2);
    g.addPoint(p3);
    assertEquals(g.getWinner(), "Jake");
  }

  @Test
  public void testSetWinner () {
    Game g1 = new Game();
    Point p1 = new Point("Jake");
    g1.addPoint(p1);
    Game g2 = new Game();
    Point p2 = new Point ("Jane");
    g2.addPoint(p2);
    Game g3 = new Game();
    Point p3 = new Point("Jake");
    g3.addPoint(p3);
    Set s = new Set();
    s.addGame(g1);
    s.addGame(g2);
    s.addGame(g3);
    assertEquals(s.getWinner(), "Jake");
  }

}
