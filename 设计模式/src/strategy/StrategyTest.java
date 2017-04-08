package strategy;

/**
 * 测试类
 * <p>
 * User : Dragon_hht
 * Date : 17-4-8
 * Time : 上午10:56
 */
public class StrategyTest {
    public static void main(String[] args) {
        int[] list = {13,13,15,13};

        MySorter mySorter = new MySorter();
        mySorter.setSorter(new BubbleSort());
        mySorter.doSort(list);
        mySorter.setSorter(new QuickSort());
        mySorter.doSort(list);
    }
}
