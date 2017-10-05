import java.io.Serializable;

/**
 * A Product in a store. It belongs in a category, has a UPC, price, name and quantity in store.
 */
public class Product implements Serializable {
  private Category category;
  private Order order;
  private Stock stock;
  private String name;
  private Price price;
  private String upc;

  /**
   * Instantiates a new product.
   *
   * @param name the name
   */
  public Product(String name) {
    this.name = name;
  }

  /**
   * Sets the category.
   *
   * @param category the new category
   */
  public void setCategory(Category category) {
    this.category = category;
  }

  /**
   * Sets the order.
   *
   * @param order the new order
   */
  public void setOrder(Order order) {
    this.order = order;
  }

  /**
   * Gets the category.
   *
   * @return the category
   */
  public Category getCategory() {
    return category;
  }

  /**
   * Gets the order.
   *
   * @return the order
   */
  public Order getOrder() {
    return order;
  }

  /**
   * Gets the stock.
   *
   * @return the stock
   */
  public Stock getStock() {
    return stock;
  }

  /**
   * Gets the name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the price.
   *
   * @return the price
   */
  public Price getPrice() {
    return price;
  }

  /**
   * Returns the UPC.
   *
   * @return the UPC
   */
  public String getUpc() {
    return upc;
  }

  /**
   * Sets the price f the product.
   *
   * @param price the new price
   */
  public void setPrice(Price price) {
    this.price = price;
  }
}
