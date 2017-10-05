import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * When a sale is applied to a product by a percentage.
 */
public class PercentSale implements Sale {
  /** The percentage by which the product value decreases. */
  double percentage;
  String startDate;
  String dateEnd;
  NumberFormat formatter;


  /**
   * Constructor to set the percentage value amount.
   * 
   * @param percentage The percentage off
   */
  public PercentSale(double percentage, String startDate, String dateEnd) {
    this.percentage = percentage;
    this.startDate = startDate;
    this.dateEnd = dateEnd;
    formatter = new DecimalFormat("#0.00");
  }

  /**
   * Apply sale to the product.
   *
   * @param product: The product whose dollar value is decreasing.
   */
  public void applySale(Product product) {
    Price price = product.getPrice();
    
    // Note: price.getPrice() returns "$###.##". Must remove the dollar sign.
    BigDecimal newPrice = new BigDecimal(price.getPrice().substring(1));
    BigDecimal percent = new BigDecimal(1-percentage);
    
    newPrice = newPrice.multiply(percent);
    
    price.setSalePrice(formatter.format(newPrice));
  }

  /**
   * Get the percentage by which the product value decreased by.
   *
   * @param The percent value.
   */
  public String getSale() {
    return Double.toString(percentage);
  }
    
  /**
   * Getter method for start date.
   * 
   * @return Start date
   */
  public String getStartDate() {
    return startDate;
  }

  /**
   * Getter method for end date.
   * 
   * @return End date
   */
  public String getDateEnd() {
    return dateEnd;
  }

  /**
   * Getter method to get the amount.
   * 
   * @return The percent value.
   */
  public String getAmount() {
    return Double.toString(percentage);
  }
}
