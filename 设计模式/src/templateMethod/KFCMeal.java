package templateMethod;

/**
 * 具体类
 * <p>
 * User : Dragon_hht
 * Date : 17-4-8
 * Time : 上午11:26
 */
public class KFCMeal extends Lunch{
    @Override
    public void prepareIngredients() {
        System.out.println("获取原料");
    }

    @Override
    public void cooking() {
        System.out.println("在KFC制作");
    }

    @Override
    public void cleaning() {
        System.out.println("KFC清理");
    }

    public void eating() {
        System.out.println("在KFC吃");
    }
}
