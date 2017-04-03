package decorator;

/**
 * 增加装饰器的基类
 * <p>
 * User : Dragon_hht
 * Date : 17-4-3
 * Time : 下午2:08
 */
public class SimpleHouse implements House{
    @Override
    public String makeHouse() {
        return "Base House";
    }
}
