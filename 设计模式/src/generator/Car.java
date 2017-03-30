package generator;

/**
 * 接口的具体类（具体产品类）
 * <p>
 * User : Dragon_hht
 * Date : 17-3-30
 * Time : 下午10:05
 */
public class Car implements CarPlan{
    private String base;
    private String wheels;
    private String engine;
    private String roof;
    private String mirrors;
    private String lights;
    private String interior;

    @Override
    public void setBase(String base) {
        this.base = base;
    }

    @Override
    public void setWheels(String wheels) {
        this.wheels = wheels;
    }

    @Override
    public void setEngine(String engine) {
        this.engine = engine;
    }

    @Override
    public void setRoof(String roof) {
        this.roof = roof;
    }

    @Override
    public void setMirrors(String mirrors) {
        this.mirrors = mirrors;
    }

    @Override
    public void setLights(String lights) {
        this.lights = lights;
    }

    @Override
    public void setInterior(String interior) {
        this.interior = interior;
    }
}
