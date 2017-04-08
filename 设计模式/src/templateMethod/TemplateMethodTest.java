package templateMethod;

/**
 * 测试类
 * <p>
 * User : Dragon_hht
 * Date : 17-4-8
 * Time : 上午11:28
 */
public class TemplateMethodTest {
    public static void main(String[] args) {
        Lunch meal1 = new McDonaldMeal();
        meal1.prepareLunch();

        Lunch meal2 = new KFCMeal();
        meal2.prepareLunch();
    }
}
