package factoryＭethod;

/**
 * 使用工厂方法模式
 * <p>
 * User : Dragon_hht
 * Date : 17-3-29
 * Time : 下午6:55
 */
public class SampleFactoryMethod {
    public static void main(String[] arg) {
        //创建工厂
        PetFactory petFactory = new PetFactory();
        //工厂实例化一个对象
        Pet pet = petFactory.getPet("Meaw");

        System.out.println(pet.petSound());
    }
}
