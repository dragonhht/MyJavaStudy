package mediator;

/**
 * 法国买家
 * <p>
 * User : Dragon_hht
 * Date : 17-4-7
 * Time : 下午1:15
 */
public class FrenchBuyer extends Buyer{

    public FrenchBuyer(Mediator mediator) {
        super(mediator, "EURO");
        this.mediator.registerFrenchBuyer(this);
    }
}
