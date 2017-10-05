import java.util.Date;
import java.util.LinkedHashMap;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;

/**
 * Finance class handles all revenue and profit made.
 */
public class Finance {

  private LinkedHashMap<String, String> profit;
  private LinkedHashMap<String, String> revenue;
  
  public Finance() {
    profit = new LinkedHashMap<>();
    revenue = new LinkedHashMap<>();
  }

  /**
   * Records the product and amount sold for.
   * 
   * @param product The product which got sold.
   * @param amount The amount of that product.
   */
  public void sold(Product product, int amount) {

    addRevenue(product, amount);
    addProfit(product, amount);
  }

  /**
   * Helper method to add revenue made after a sale of a product.
   * 
   * @param product : The product which got sold.
   * @param amount : The amount of that product.
   */
  private void addRevenue(Product product, int amount) {
//    String date = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
    
    Price price = product.getPrice();
 // Note getPrice and getList price will return '$##.##'. Must remove first character
    BigDecimal currentPrice = new BigDecimal(price.getPrice().substring(1));
    BigDecimal savePrice = currentPrice.multiply(new BigDecimal(amount));
    
    String revenueProduct = Price.currencyFormat(savePrice);
    revenue.put(product.getName(), revenueProduct);
  }

  /**
   * Helper method to add revenue made after a sale of a product.
   * 
   * @param product : The product which got sold.
   * @param amount : The amount of that product.
   */
  private void addProfit(Product product, int amount) {
    //TODO: removed date fro mkey in addRevenue and addProfit. must implement date.
//    String date = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
    Price price = product.getPrice();

    // Note getPrice and getList price will return '$##.##'. Must remove first character
    BigDecimal listPrice = new BigDecimal(price.getListPrice().substring(1));
    BigDecimal currentPrice = new BigDecimal(price.getPrice().substring(1));
    
    // Profit made out of one unit
    BigDecimal oneProfit = currentPrice.subtract(listPrice);
    // Profit made of x amount
    BigDecimal amountProfit = oneProfit.multiply(new BigDecimal(amount));
    
    String profitProduct = Price.currencyFormat(amountProfit);
    profit.put(product.getName(), profitProduct);
  }

  /**
   * Returns the profit of the grocery store.
   * 
   * @return LinkedHashMap<String, Double>: The profit of the store.
   */
  public LinkedHashMap<String, String> getProfit() {
    return profit;
  }

  /**
   * Returns the revenue of the grocery store.
   * 
   * @return LinkedHashMap<String, Double>: The revenue of the store.
   */
  public LinkedHashMap<String, String> getRevenue() {
    return revenue;
  }
}
