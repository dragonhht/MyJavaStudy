package strategy;

/**
 * 具体策略类
 * 冒泡排序
 * <p>
 * User : Dragon_hht
 * Date : 17-4-8
 * Time : 上午10:50
 */
public class BubbleSort implements SortInterface{
    @Override
    public void sort(int[] array) {
        System.out.println("冒泡排序逻辑");
    }
}
