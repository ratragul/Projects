import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.logging.Level;

/**
 * The Class Stock keeps track of the amount of a product in 
 * the store. Products are either on a shelf or in the stock 
 * room. 
 */
public class Stock {
  
  private int onShelf;
  private int stockRoom;
  private int total;
  private LinkedHashMap<String, Integer> quantityHistory;
  private int threshold;

  /**
   * Instantiates a new stock.
   *
   * @param onShelf the on shelf
   * @param stockRoom the stock room
   * @param threshold the threshold
   */
  public Stock(int onShelf, int stockRoom, int threshold) {
    this.onShelf = onShelf;
    this.stockRoom = stockRoom;
    updateTotal();
    this.threshold = threshold;
    quantityHistory = new LinkedHashMap<>();
    String date = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
    quantityHistory.put(date, total);
  }

  /**
   * Gets the quantity on shelf.
   *
   * @return the quantity on shelf
   */
  public int getQuantityOnShelf() {
    return onShelf;
  }

  /**
   * Gets the quantity stock room.
   *
   * @return the quantity stock room
   */
  public int getQuantityStockRoom() {
    return stockRoom;
  }

  /**
   * Gets the total.
   *
   * @return the total
   */
  public int getTotal() {
    return total;
  }

  /**
   * Gets the quantity history.
   *
   * @return the quantity history
   */
  public LinkedHashMap<String, Integer> getQuantityHistory() {
    return quantityHistory;
  }

  /**
   * Sets the quantity history.
   *
   * @param newQuantites the new quantites
   */
  public void setQuantityHistory(LinkedHashMap<String, Integer> newQuantites) {
    quantityHistory = newQuantites;
  }

  /**
   * Removes an amount of product on shelf.
   *
   * @param amount the amount
   */
  public void removeOnShelf(int amount) {
    if ((onShelf - amount) >= 0) {
      onShelf -= amount;
      updateTotal();
      String date = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
      this.quantityHistory.put(date, total);
      MyLogging.log(Level.INFO, MyLogging.class.getName() + 
          ": removed " + amount + " from the shelf");
    }
  }
  
  /**
   * Allocate an amount from the stock room to shelf.
   *
   * @param amount the amount
   */
  public void stockToShelf(int amount) {
    if (stockRoom >= amount) {
      stockRoom -= amount;
      onShelf += amount;
      MyLogging.log(Level.INFO, MyLogging.class.getName() + 
          ": removed " + amount + " from the stock to Shelf");
    }
  }

  /**
   * Adds the to stock room.
   *
   * @param amount the amount
   */
  public void addToStockRoom(int amount) {
    MyLogging.log(Level.INFO, MyLogging.class.getName() + 
        ": added " + amount + " to the Stock Room");
    stockRoom += amount;
    updateTotal();
  }

  /**
   * Gets the threshold.
   *
   * @return the threshold
   */
  public int getThreshold() {
    return threshold;
  }
  
  /**
   * Sets the threshold.
   *
   * @param amount the new threshold
   */
  public void setThreshold(int amount) {
    threshold = amount;
  }
  
  /**
   * Update total on the store from amount on the shelf
   * and in the stock room.
   */
  private void updateTotal() {
    this.total = this.stockRoom + this.onShelf;
  }
}

