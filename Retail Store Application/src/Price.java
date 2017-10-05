import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.logging.Level;


/**
 * The Class Price. A Price is associated with a product. A product has a list price, sale price and
 * retail price.
 */
public class Price {

  private BigDecimal listPrice;
  private BigDecimal salePrice;
  private BigDecimal retailPrice;
  private LinkedHashMap<String, String> priceHistory;

  /**
   * Instantiates a new price.
   */
  public Price() {
    this.priceHistory = new LinkedHashMap<>();
  }

  /**
   * Instantiates a new price.
   *
   * @param listPrice the list price
   * @param salePrice the sale price
   */
  public Price(String listPrice, String salePrice) {
    correctFormat(listPrice);
    correctFormat(salePrice);
    this.listPrice = new BigDecimal(listPrice);
    this.salePrice = new BigDecimal(salePrice);
    this.retailPrice = this.salePrice;

    this.priceHistory = new LinkedHashMap<>();
    String date = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
    this.priceHistory.put(date, currencyFormat(this.salePrice));
  }

  /**
   * Sets the list price.
   *
   * @param listPrice the new list price
   */
  public void setListPrice(String listPrice) {
    correctFormat(listPrice);
    this.listPrice = new BigDecimal(listPrice);
  }

  /**
   * Sets the sale price.
   *
   * @param salePrice the new sale price
   */
  public void setSalePrice(String salePrice) {
    correctFormat(salePrice);
    this.salePrice = new BigDecimal(salePrice);
    addHistory(salePrice);
  }

  /**
   * Adds the history.
   *
   * @param price the price
   */
  public void addHistory(String price) {
    correctFormat(price);
    String date = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
    this.priceHistory.put(date, currencyFormat(new BigDecimal(price)));
  }

  /**
   * Gets the list price.
   *
   * @return the list price
   */
  public String getListPrice() {
    return currencyFormat(this.listPrice);
  }

  /**
   * Gets the price.
   *
   * @return the price
   */
  public String getPrice() {
    return currencyFormat(this.salePrice);
  }

  /**
   * Reset the price to the retail price.
   */
  public void reset() {
    salePrice = retailPrice;
  }

  /**
   * Gets the price history.
   *
   * @return the price history
   */
  public LinkedHashMap<String, String> getPriceHistory() {
    return priceHistory;
  }


  /**
   * Sets the price history.
   *
   * @param input the input
   */
  public void setPriceHistory(LinkedHashMap<String, String> input) {
    this.priceHistory = input;
  }

  /**
   * Gets the retail price.
   *
   * @return the original
   */
  public String getRetial() {
    return currencyFormat(retailPrice);
  }

  /**
   * Checks if the String is in correct money format.
   *
   * @param str the str
   */
  public static void correctFormat(String str) {
    String[] parts = str.split("\\.");

    if ((parts.length > 2) || (parts[0].length() > 2)) {
      throw new IllegalArgumentException("connection is not established");
    }
  }

  public static String currencyFormat(BigDecimal num) {
    return NumberFormat.getCurrencyInstance().format(num);
  }
}
