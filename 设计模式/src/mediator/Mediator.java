package mediator;

/**
 * 中介者类（无中介者接口）
 * <p>
 * User : Dragon_hht
 * Date : 17-4-7
 * Time : 下午1:16
 */
public class Mediator {
    Buyer indianBuyer;
    Buyer frenchBuyer;
    AmericanSeller americanSeller;
    DollarConverter dollarConverter;

    public Mediator() {

    }

    public void registerIndianBuyer(IndianBuyer indianBuyer) {
        this.indianBuyer = indianBuyer;
    }

    public void registerFrenchBuyer(FrenchBuyer frenchBuyer) {
        this.frenchBuyer = frenchBuyer;
    }

    public void registerAmericanSeller(AmericanSeller americanSeller) {
        this.americanSeller = americanSeller;
    }

    public void registerDollarConverter(DollarConverter dollarConverter) {
        this.dollarConverter = dollarConverter;
    }

    public boolean placeBid(float bid, String unitOfCurrency) {
        float dollarAmount = dollarConverter.convertCurrencyToDollar(bid, unitOfCurrency);
        return americanSeller.isBidAccepted(dollarAmount);
    }
}
