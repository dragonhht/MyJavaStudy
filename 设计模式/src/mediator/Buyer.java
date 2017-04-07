package mediator;

/**
 * 买家类
 * <p>
 * User : Dragon_hht
 * Date : 17-4-7
 * Time : 下午1:13
 */
public class Buyer {
    Mediator mediator;
    String unitOfCurrency;

    public Buyer(Mediator mediator, String unitOfCurrency) {
        this.mediator = mediator;
        this.unitOfCurrency = unitOfCurrency;
    }

    public boolean attemptToPurchase(float bid) {
        System.out.println("Buyer attempting a bid of "+ bid + " " + unitOfCurrency);
        return mediator.placeBid(bid,unitOfCurrency);
    }

}
