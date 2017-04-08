package strategy;

/**
 * 内容类
 * <p>
 * User : Dragon_hht
 * Date : 17-4-8
 * Time : 上午10:51
 */
public abstract class Sorter {
    private SortInterface strategy;
    public void setSorter(SortInterface strategy) {
        this.strategy = strategy;
    }

    public SortInterface getSorter() {
        return this.strategy;
    }

    public abstract void doSort(int[] listToSort);


}
