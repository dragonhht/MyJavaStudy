package visitor;

import java.util.Collection;
import java.util.Iterator;

/**
 * ClassDescription
 * <p>
 * User : Dragon_hht
 * Date : 17-4-8
 * Time : 上午11:46
 */
public class PrintVisitor implements Visitor{
    Object o;
    @Override
    public void visitCollection(Collection collection) {
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            o =iterator.next();
            if (o instanceof Visitable) {
                ((Visitable)o).accept(this);
            }
        }
    }

    @Override
    public void visitString(Visitable visitable) {
        System.out.println("value: "+ o.toString());
    }

    @Override
    public void visitInteger(Integer integer) {
        System.out.println(integer.toString() + "I");
    }
}
