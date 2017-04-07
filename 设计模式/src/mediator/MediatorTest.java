package mediator;

/**
 * 中介者测试类
 * <p>
 * User : Dragon_hht
 * Date : 17-4-7
 * Time : 下午1:44
 */
public class MediatorTest {
    public static void main(String[] args) {
        Mediator mediator = new Mediator();

        Buyer indianBuyer = new IndianBuyer(mediator);
        Buyer frenceBuyer = new FrenchBuyer(mediator);
        float sellingPriceInDollar = 10.0f;

        AmericanSeller americanSeller = new AmericanSeller(mediator, sellingPriceInDollar);
        DollarConverter dollarConverter = new DollarConverter(mediator);
        float indianBidInInr = 55.0f;

        while (!indianBuyer.attemptToPurchase(indianBidInInr)) {
            indianBidInInr  +=15.0f;
        }

        float frenchBidInEuros = 3.0f;
        while (!frenceBuyer.attemptToPurchase(frenchBidInEuros)) {
            frenchBidInEuros +=1.5f;
        }
    }
}
