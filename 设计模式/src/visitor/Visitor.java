package visitor;

import java.util.Collection;

/**
 * 访问者接口
 * 为被访问的结构对象创建访问者接口
 * <p>
 * User : Dragon_hht
 * Date : 17-4-8
 * Time : 上午11:39
 */
public interface Visitor {
    public void visitCollection(Collection collection);
    public void visitString(Visitable visitable);
    public void visitInteger(Integer integer);
}
