import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class InventoryManagerTest {
  InventoryManager inventory;
  Section toGo;
  Section frozen;
  Category pizza;
  Category pasta;
  Category chicken;
  Category iceCream;
  Category frozenPizza;
  Product pizzaPocket;
  Product benAndJerrys;
  Product cheesePizza;
  
  @Before
  public void setUP() {
    inventory = new InventoryManager();  
    
    inventory.addSection("To go", "Order food to go");
    inventory.addSection("Frozen", "Put in your freezer");
    
    toGo = inventory.getSection("To go");
    frozen = inventory.getSection("Frozen");
    
    inventory.addAisle("To go");
    inventory.addAisle("To go");
    inventory.addAisle("To go");
    
    inventory.addAisle("Frozen");
    inventory.addAisle("Frozen");
    
    inventory.addCategory("Pizza", 1);
    inventory.addCategory("Pasta", 2);
    inventory.addCategory("Chicken", 2);
    
    inventory.addCategory("Ice Cream", 4);
    inventory.addCategory("Frozen Pizza", 5);
    
    pizza = inventory.getCategory("Pizza");
    pasta = inventory.getCategory("Pasta");
    chicken = inventory.getCategory("Chicken");
    iceCream = inventory.getCategory("Ice Cream");
    frozenPizza = inventory.getCategory("Frozen Pizza");
    
    System.out.println(frozenPizza);
    inventory.addProduct("Pizza Pocket", frozenPizza);
    inventory.addProduct("Tom and Jerrys", iceCream);
    inventory.addProduct("Cheese Pizza", pizza);
    
  }

  @Test
  public void testAddSection() {
   
   assertEquals(toGo.getName(), "To go");
   assertEquals(frozen.getName(), "Frozen");
   
   assertEquals(toGo.getDescription(), "Order food to go");
   assertEquals(frozen.getDescription(), "Put in your freezer");
  }

  @Test
  public void testAddAisleSizes() {
    assertEquals(3, toGo.getAisles().size());
    assertEquals(2, frozen.getAisles().size());
  }
  
  @Test
  public void testAddCategoryReferences() {
    Aisle aisle = inventory.getAisle(1);
    Category category = aisle.getCategories().get(0);
    assertEquals(category, pizza);
    

    aisle = inventory.getAisle(2);
    category = aisle.getCategories().get(0);
    assertEquals(category, pasta);
    
    aisle = inventory.getAisle(2);
    category = aisle.getCategories().get(1);
    assertEquals(category, chicken);
    
    aisle = inventory.getAisle(4);
    category = aisle.getCategories().get(0);
    assertEquals(category, iceCream);
    
    aisle = inventory.getAisle(5);
    category = aisle.getCategories().get(0);
    assertEquals(category, frozenPizza);
  }

  @Test
  public void testAddProduct() {
    Product product = frozenPizza.getProducts().get(0);
    assertEquals(product.getName(), "Pizza Pocket");
    

    product = iceCream.getProducts().get(0);
    assertEquals(product.getName(), "Tom and Jerrys");
    

    product = pizza.getProducts().get(0);
    assertEquals(product.getName(), "Cheese Pizza");
  }

  @Test
  public void testRemoveSection() {
    assertEquals(true, inventory.removeSection("To go"));
    Section section = inventory.getSection("To go");
    
    assertEquals(null, section);
    
    // All the branch that are connected with deleted section
    // should be removed from the list.
    assertEquals(null, inventory.getCategory("Pizza"));
    assertEquals(null, inventory.getProduct("Cheese Pizza"));
  }

  @Test
  public void testRemoveAisle() {
    inventory.removeAisle(5);
    
    assertEquals(null, inventory.getAisle(5));
    assertEquals(null, inventory.getCategory("Frozen Pizza"));
  }

  @Test
  public void testRemoveCategory() {
    assertEquals(true, inventory.removeCategory("Ice Cream"));
    assertEquals(null, inventory.getCategory("Ice Cream"));
    assertEquals(null, inventory.getProduct("Tom and Jerrys"));
  }

  @Test
  public void testRemoveProduct() {
    assertEquals(true, inventory.removeProduct("Pizza Pocket"));
    assertEquals(null, inventory.getProduct("Pizza Pocket"));
  }

}
