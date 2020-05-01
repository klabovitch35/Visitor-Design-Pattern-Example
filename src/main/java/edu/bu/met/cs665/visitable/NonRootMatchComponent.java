package edu.bu.met.cs665.visitable;

import java.util.ArrayList;

public abstract class NonRootMatchComponent extends MatchComponents {

  ArrayList<MatchComponents> components = new ArrayList<MatchComponents>();

  /**+.
   * @param: void
   * @return: Parses through aggregated match components and sets winner based of that calculation
   */
  public abstract void setWinner();

  /**+.
   * @param: MatchComponent c
   * @return: Aggregates component with other similar types.
   */
  public void addComponent(MatchComponents c) {
    this.components.add(c);
  }

}
