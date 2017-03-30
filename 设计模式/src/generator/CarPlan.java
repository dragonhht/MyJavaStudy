package generator;

/**
 * 用于从生成器返回作为汽车（具体产品类）的接口
 * <p>
 * User : Dragon_hht
 * Date : 17-3-30
 * Time : 下午10:00
 */
public interface CarPlan {
    public void setBase(String basement);
    public void setWheels(String structure);
    public void setEngine(String structure);
    public void setRoof(String structure);
    public void setMirrors(String roof);
    public void setLights(String roof);
    public void setInterior(String interior);
}
