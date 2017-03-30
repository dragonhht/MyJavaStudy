package generator;

/**
 * 生成器模式测试类
 * <p>
 * User : Dragon_hht
 * Date : 17-3-30
 * Time : 下午10:27
 */
public class Test {
    public static void main(String[] arg) {
        CarBuilder height = new HightEndCarBuilder();
        MechaincalEngineer engineer = new MechaincalEngineer(height);
        engineer.buildCar();
        Car car = engineer.getCar();
        System.out.println("Builder Constructed Car:"+car);
    }
}
