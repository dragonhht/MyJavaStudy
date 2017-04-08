package visitor;

/**
 * 具体元素类
 * <p>
 * User : Dragon_hht
 * Date : 17-4-8
 * Time : 上午11:43
 */
public class VisitableString implements Visitable{
    private String value;

    public VisitableString(String string) {
        value = string;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitString(this);
    }
}
