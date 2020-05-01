package edu.bu.met.cs665.visitable;

import visitors.MatchVisitor;

public interface Visitable {
  public void accept(MatchVisitor visitor);

}
