package strategy;

/**
 * 依赖的具体实现
 * <p>
 * User : Dragon_hht
 * Date : 17-4-8
 * Time : 上午10:58
 */
public class MySorter extends Sorter {
    public void doSort(int[] listToSort) {
        getSorter().sort(listToSort);
    }
}
