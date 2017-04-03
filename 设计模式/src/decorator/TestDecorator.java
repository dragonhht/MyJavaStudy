package decorator;

/**
 * 装饰器模式测试类
 * <p>
 * User : Dragon_hht
 * Date : 17-4-3
 * Time : 下午2:17
 */
public class TestDecorator {
    public static void main(String[] arg) {
        House house = new ColorDecorator(new SimpleHouse());
        System.out.println(house.makeHouse());
    }
}

