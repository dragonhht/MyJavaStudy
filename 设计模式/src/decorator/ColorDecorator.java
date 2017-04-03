package decorator;

/**
 * 具体的装饰器类
 * <p>
 * User : Dragon_hht
 * Date : 17-4-3
 * Time : 下午2:13
 */
public class ColorDecorator extends HouseDecorator{

    //实现功能扩展
    public String addColors() {
        return "+ Color";
    }

    public ColorDecorator(House house) {
        super(house);
    }

    public String makeHouse() {
        return house.makeHouse() + addColors();
    }
}
