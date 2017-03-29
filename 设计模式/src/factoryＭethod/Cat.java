package factoryＭethod;

/**
 * 用于实例化工厂方法模式的派生类 2
 * 具体产品类
 * <p>
 * User : Dragon_hht
 * Date : 17-3-29
 * Time : 下午6:49
 */
public class Cat implements Pet{
    @Override
    public String petSound() {
        return "Meaw Meaw...";
    }
}
