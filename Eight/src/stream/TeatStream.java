package stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * 流.
 * User: huang
 * Date: 17-6-10
 */
public class TeatStream {
    private List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH)
    );

    /**
     * stream的使用示例.
     */
    @Test
    public void streamFirstTest() {
        // 接收结果的集合
        List<String> resule =
                menu.stream()                           // 从menu中获取流, 把stream换成parallelStream就可利用多线程
                    .filter(d -> d.getCalories() > 300)  // 建立操作流,首先选出高热量的菜肴
                    .map(Dish::getName)                  // 获取菜名
                    .limit(3)                            // 只选前三个
                    .collect(toList());                  // 将结果存入另一个List中
        System.out.println(resule);

        menu.parallelStream()
                .forEach(System.out::println);
    }


}
