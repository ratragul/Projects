import java.io.Serializable;
import java.util.logging.Level;

/**
 * The Class Order. An Order is a shipment from the distributor. It
 * contains a product and an amount of that product.
 */
public class Order implements Serializable {

  /** The product ordered. */
  private String productOrdered;
  
  /** The purchase order. */
  private int purchaseOrder;
  
  /** The amount ordered. */
  private int amountOrdered;

  private int UPC;

  /**
   * Instantiates a new order.
   *
   * @param productOrdered the product ordered
   * @param UPC : UPC of the Product
   * @param distributor: Distributor of the product
   * @param amountOrdered the amount ordered
   * @param purchaseOrder the purchase order
   */
  public Order(String productOrdered, int UPC,
      int amountOrdered, int purchaseOrder) {
    this.productOrdered = productOrdered;
    this.UPC = UPC;
    this.amountOrdered = amountOrdered;
    this.purchaseOrder = purchaseOrder;
    
    MyLogging.log(Level.INFO, this.getClass().getName() + 
        ": created an order for " + productOrdered + " with " + 
        amountOrdered + "units ordered and " + purchaseOrder + " as a P.O.#");
  }

  /**
   * Gets the purchase order.
   *
   * @return the purchase order
   */
  public int getPurchaseOrder() {
    return this.purchaseOrder;
  }

  /**
   * Gets the product ordered.
   *
   * @return the product ordered
   */
  public String getProductOrdered() {
    return productOrdered;
  }

  /**
   * Gets the amount ordered.
   *
   * @return the amount ordered
   */
  public int getAmountOrdered() {
    return amountOrdered;
  }

  public int getUPC(){
    return this.UPC;
  }

  public String toString(){
    return productOrdered + ", " + UPC + ", " + amountOrdered;
  }
  
}
