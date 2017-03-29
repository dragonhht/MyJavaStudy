package abstractFactory;

/**
 * 汽车个零部件
 * <p>
 * User : Dragon_hht
 * Date : 17-3-29
 * Time : 下午8:18
 */
public class Parts {

    public String specification;

    public Parts(String specification) {
        this.specification = specification;
    }

    public String getSpecification() {
        return specification;
    }
}
