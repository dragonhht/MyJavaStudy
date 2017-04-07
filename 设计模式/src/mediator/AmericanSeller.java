package mediator;

/**
 * 美国卖家类
 * <p>
 * User : Dragon_hht
 * Date : 17-4-7
 * Time : 下午1:18
 */
public class AmericanSeller {
    Mediator mediator;
    float priceInDollars;

    public AmericanSeller(Mediator mediator, float priceInDollars) {
        this.mediator = mediator;
        this.priceInDollars = priceInDollars;
        this.mediator.registerAmericanSeller(this);
    }

    public boolean isBidAccepted(float bidInDollars) {
        if (bidInDollars >= priceInDollars) {
            System.out.println("Seller accept bid of "+bidInDollars + " dollars\n");
            return true;
        } else {
            System.out.println("Seller rejects bid of "+ bidInDollars + " dollars\n");
            return false;
        }
    }
}
