package templateMethod;

/**
 * 抽象类
 * <p>
 * User : Dragon_hht
 * Date : 17-4-8
 * Time : 上午11:21
 */
public abstract class Lunch {
    //模板方法
    public final void prepareLunch() {
        cooking();
        eating();
        cleaning();
    }

    public abstract void prepareIngredients();

    public abstract void cooking();

    public void eating() {
        System.out.println("正在吃....");
    }

    public abstract void cleaning();
}
