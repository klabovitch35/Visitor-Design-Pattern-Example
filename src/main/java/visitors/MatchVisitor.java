package visitors;

import edu.bu.met.cs665.visitable.Game;
import edu.bu.met.cs665.visitable.Match;
import edu.bu.met.cs665.visitable.Point;
import edu.bu.met.cs665.visitable.Set;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public abstract class MatchVisitor {

  public abstract void visit(Match m);

  public abstract void visit(Game g);

  public abstract void visit(Set s);

  public abstract void visit(Point p);

  /**+.
   * @param: Object object
   * @return: Logic for visiting object not yet implemented
   */
  public void visit(Object object) {
    try {
      Method downPolymorphic = object.getClass().getMethod("visit",
          new Class[] { object.getClass() });

      if (downPolymorphic == null) {
        defaultVisit(object);
      } else {
        downPolymorphic.invoke(this, new Object[] {object});
      }
    } catch (NoSuchMethodException e) {
      this.defaultVisit(object);
    } catch (InvocationTargetException e) {
      this.defaultVisit(object);
    } catch (IllegalAccessException e) {
      this.defaultVisit(object);
    }
  }

  public abstract void defaultVisit(Object object);
}