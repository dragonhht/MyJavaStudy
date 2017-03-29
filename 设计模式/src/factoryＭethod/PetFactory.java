package factoryＭethod;

/**
 * 工厂方法模式实现，并展示对象创建逻辑
 * <p>
 * User : Dragon_hht
 * Date : 17-3-29
 * Time : 下午6:51
 */
public class PetFactory {

    public Pet getPet(String petType) {
        Pet pet = null;
        //工厂实例化对象的基本逻辑
        if ("Bow".equals(petType)) {
            pet = new Dog();
        }else if ("Meaw".equals(petType)) {
            pet = new Cat();
        }
        return pet;
    }
}
