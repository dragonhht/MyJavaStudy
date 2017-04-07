package mediator;

/**
 * 印度买家
 * <p>
 * User : Dragon_hht
 * Date : 17-4-7
 * Time : 下午1:14
 */
public class IndianBuyer extends Buyer{

    public IndianBuyer(Mediator mediator) {
        super(mediator, "INR");
        this.mediator.registerIndianBuyer(this);
    }
}
