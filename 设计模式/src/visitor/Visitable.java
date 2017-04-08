package visitor;

/**
 * 元素类接口
 * 为被访问的结构对象创建元素类接口
 * <p>
 * User : Dragon_hht
 * Date : 17-4-8
 * Time : 上午11:41
 */
public interface Visitable {
    public void accept(Visitor visitor);
}
