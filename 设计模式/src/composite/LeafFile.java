package composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 叶子节点
 * <p>
 * User : Dragon_hht
 * Date : 17-4-2
 * Time : 下午3:56
 */
public class LeafFile implements FileComponet{

    //用于存储FileComponet的列表
    private List files = new ArrayList();
    @Override
    public void printName() {

    }
}
