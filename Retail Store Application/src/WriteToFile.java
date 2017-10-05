import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class WriteToFile {

  static void location(ArrayList<Section> sections, ArrayList<Aisle> aisles,
      ArrayList<Category> categories, ArrayList<Product> products) throws IOException {
    section(sections);
    aisle(aisles);
    category(categories);
    product(products);
  }

  private static void product(ArrayList<Product> products) throws IOException {
    File f = new File("src/Files/Product.txt");
    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
    oos.writeObject(products);
    oos.flush();
    oos.close();
  }

  private static void category(ArrayList<Category> categories) throws IOException {
    File f = new File("src/Files/Category.txt");
    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
    oos.writeObject(categories);
    oos.flush();
    oos.close();
  }

  private static void aisle(ArrayList<Aisle> aisles) throws IOException {
    File f = new File("src/Files/Aisle.txt");
    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
    oos.writeObject(aisles);
    oos.flush();
    oos.close();
  }

  private static void section(ArrayList<Section> sections) throws IOException {
    File f = new File("src/Files/Section.txt");
    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
    oos.writeObject(sections);
    oos.flush();
    oos.close();
  }

  public static ArrayList<Product> setProducts() throws ClassNotFoundException, IOException {
    ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/Files/Product.txt"));
    ArrayList<Product> products = (ArrayList<Product>) in.readObject();

    in.close();
    
    return products;
  }
  
  public static ArrayList<Category> setCategories() throws ClassNotFoundException, IOException {
    ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/Files/Category.txt"));
    ArrayList<Category> categories = (ArrayList<Category>) in.readObject();

    in.close();
    
    return categories;
  }
  
  public static ArrayList<Aisle> setAisles() throws ClassNotFoundException, IOException {
    ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/Files/Aisle.txt"));
    ArrayList<Aisle> aisles = (ArrayList<Aisle>) in.readObject();

    in.close();
    
    return aisles;
  }
  
  public static ArrayList<Section> setSection() throws ClassNotFoundException, IOException {
    ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/Files/Section.txt"));
    ArrayList<Section> section = (ArrayList<Section>) in.readObject();

    in.close();
    
    return section;
  }
  
  public static void saveOrders(ArrayList<Order> pendingOrders, ArrayList<Order> orderHistory) throws IOException {
    pendingOrders(pendingOrders);
    orderHistory(orderHistory);
  }
  private static void pendingOrders(ArrayList<Order> pendingOrders) throws IOException {
    File f = new File("src/Files/PendingOrder.txt");
    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
    oos.writeObject(pendingOrders);
    oos.flush();
    oos.close();
  }
  
  private static void orderHistory(ArrayList<Order> orderHistory) throws IOException {
    File f = new File("src/Files/OrderHistory.txt");
    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
    oos.writeObject(orderHistory);
    oos.flush();
    oos.close();
  }
  
  
  public static ArrayList<Order> setPending() throws ClassNotFoundException, IOException {
    ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/Files/PendingOrder.txt"));
    ArrayList<Order> pending = (ArrayList<Order>) in.readObject();

    in.close();
    
    return pending;
  }
  
  public static ArrayList<Order> setHistory() throws ClassNotFoundException, IOException {
    ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/Files/OrderHistory.txt"));
    ArrayList<Order> history = (ArrayList<Order>) in.readObject();

    in.close();
    
    return history;
  }

  public static void main(String[] args) throws IOException, ClassNotFoundException {
//    Section toGo;
//    Section frozen;
//    Category pizza;
//    Category pasta;
//    Category chicken;
//    Category iceCream;
//    Category frozenPizza;
//
//    InventoryManager inventory = new InventoryManager();
//
//    inventory.addSection("To go", "Order food to go");
//    inventory.addSection("Frozen", "Put in your freezer");
//
//    inventory.addAisle("To go");
//    inventory.addAisle("To go");
//    inventory.addAisle("To go");
//
//    inventory.addAisle("Frozen");
//    inventory.addAisle("Frozen");
//
//    inventory.addCategory("Pizza", 1);
//    inventory.addCategory("Pasta", 2);
//    inventory.addCategory("Chicken", 2);
//
//    inventory.addCategory("Ice Cream", 4);
//    inventory.addCategory("Frozen Pizza", 5);
//
//    pizza = inventory.getCategory("Pizza");
//    pasta = inventory.getCategory("Pasta");
//    chicken = inventory.getCategory("Chicken");
//    iceCream = inventory.getCategory("Ice Cream");
//    frozenPizza = inventory.getCategory("Frozen Pizza");
//
//    inventory.addProduct("Pizza Pocket", frozenPizza);
//    inventory.addProduct("Tom and Jerrys", iceCream);
//    inventory.addProduct("Cheese Pizza", pizza);
//
//    inventory.store();
//    inventory.load();
//    
//    
//    
//    Category fp = inventory.getCategory("Frozen Pizza");
//    
//    System.out.println(fp.getName());
    
    OrderManager om = new OrderManager();
    
    om.createOrder("Patrick Bagel", 123, 10);
    
    om.saveOrder();
    
    
    
    
  }
}
