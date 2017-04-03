package decorator;

/**
 * 装饰器基类
 * <p>
 * User : Dragon_hht
 * Date : 17-4-3
 * Time : 下午2:10
 */
public class HouseDecorator implements House{
    protected House house;

    public HouseDecorator(House house) {
        this.house = house;
    }
    @Override
    public String makeHouse() {
        return house.makeHouse();
    }
}
