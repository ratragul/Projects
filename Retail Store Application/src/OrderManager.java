import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;

/**
 * The Class OrderManager. Manages and keeps track of all Orders and
 * pending Orders.
 */
public class OrderManager implements Serializable {

  private ArrayList<Order> pendingOrder;
  private ArrayList<Order> orderHistory;

  private int globalPurchaseOrder = 0;
  private Order newOrder;
  private static OrderManager instance;

  /**
   * Instantiates a new order manager.
   */
  public OrderManager() {
    pendingOrder = new ArrayList<>();
    orderHistory = new ArrayList<>();
  }

  /**
   * Creates the order and returns the purchase order
   *
   * @param product the product
   * @param amount the amount
   * @return the purchase order
   */
  public int createOrder(String product, int UPC, int amount) {
    globalPurchaseOrder++;
    newOrder = new Order(product, UPC, amount,
        globalPurchaseOrder);
    pendingOrder.add(newOrder);
    orderHistory.add(newOrder);
    MyLogging.log(Level.INFO, this.getClass().getName() + 
        ": P.O.#" + newOrder.getProductOrdered() + " is pending");
    return globalPurchaseOrder;
  }

  public void addToHistory(String product, int UPC, int amount){
    globalPurchaseOrder++;
    newOrder = new Order(product, UPC, amount,
        globalPurchaseOrder);
    orderHistory.add(newOrder);
  }

  public void addToPending(String product, int UPC, int amount){
    newOrder = new Order(product, UPC, amount,
        globalPurchaseOrder);
    pendingOrder.add(newOrder);
  }

  public static OrderManager getInstance(){
    if (instance == null) {
      instance = new OrderManager();
    }
    return instance;
  }

  /**
   * Gets the pending order determined by purchase order number.
   *
   * @param purchaseOrder the purchase order
   * @return the pending order
   */
  public Order getPendingOrder(int purchaseOrder) {
    Order foundOrder = null;
    
    // iterate through orders to see if there's a matching purchase
    // order
    for (Order order : pendingOrder) {
      if (order.getPurchaseOrder() == purchaseOrder) {
        foundOrder = order;
      }
    }
    return foundOrder;
  }

  /**
   * Gets the order determined by purchase order number.
   *
   * @param purchaseOrder the purchase order
   * @return the order
   */
  public Order getOrder(int purchaseOrder) {
    Order foundOrder = null;
    
    // iterate through orders to see if there's a matching purchase
    // order
    for (Order order : orderHistory) {
      if (order.getPurchaseOrder() == purchaseOrder) {
        foundOrder = order;
        return foundOrder;
      }
    }
    return foundOrder;
  }

  /**
   * remove a pending Order.
   *
   * @param purchaseOrder the purchase order
   * @return true, if successful
   */
  public boolean orderArrived(int purchaseOrder) {
    
    // iterate through orders to see if there's a matching purchase
    // order
    for (Order order : pendingOrder) {
      if (order.getPurchaseOrder() == purchaseOrder) {
        pendingOrder.remove(order);

        MyLogging.log(Level.INFO, this.getClass().getName() + 
            ": P.O.#" + purchaseOrder + " has arrived");
        
        return true;
      }
    }
    return false;
  }

  public ArrayList<Order> getOrderHistory(){
    return this.orderHistory;
  }

  public ArrayList<Order> getPendingOrder(){
    return this.pendingOrder;
  }
  
  public void setOrder() throws ClassNotFoundException, IOException {
    this.orderHistory = WriteToFile.setHistory();
    this.pendingOrder = WriteToFile.setPending();
  }
  
  public void saveOrder() throws IOException {
    WriteToFile.saveOrders(pendingOrder, orderHistory);
  }
}
