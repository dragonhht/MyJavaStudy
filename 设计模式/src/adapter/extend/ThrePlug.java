package adapter.extend;

/**
 * 3项插头
 * 适配对象
 * <p>
 * User : Dragon_hht
 * Date : 17-3-31
 * Time : 下午7:06
 */
public class ThrePlug {
    private String specification;

    public String getInput() {
        return specification;
    }

    public ThrePlug() {
        specification = "3-Pin";
    }
}
