import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;

/**
 * A type of Sale that discounts by a dollar amount
 */
public class NumericSale implements Sale {

  BigDecimal dollarValue;
  String startDate;
  String dateEnd;
  NumberFormat formatter;


  /**
   * Constructor to set the dollar value amount.
   * 
   * @param dollarValue The amount reduced off the product's price
   */
  public NumericSale(String dollarValue, String startDate, String dateEnd) {
    this.dollarValue = new BigDecimal(dollarValue);
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
    
    BigDecimal newPrice = new BigDecimal(price.getPrice().substring(1));
    newPrice = newPrice.subtract(dollarValue);
    
    price.setSalePrice(formatter.format(newPrice));
  }

  /**
   * Get the Sale amount
   *
   */
  public String getSale() {
    return this.dollarValue.toString();
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
   * Getter method for start date.
   * 
   * @return Start date
   */
  public String getStartDate() {
    return this.startDate;
  }

  /**
   * Getter method to get the amount.
   * 
   * @return The dollar value.
   */
  public String getAmount() {
    return this.dollarValue.toString();
  }

}
