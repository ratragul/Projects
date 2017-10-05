import static org.junit.Assert.*;

import java.util.LinkedHashMap;

import org.junit.Before;
import org.junit.Test;

public class FinanceTest {
  Product cocaCola;
  Product noNamePizza;
  Price cocaColaPrice;
  Price noNamePizzaPrice;
  Finance finance;
  
  @Before
  public void setUp() {
    cocaCola = new Product("Coca-Cola");
    noNamePizza = new Product("No Name Pizza");
    
    cocaColaPrice = new Price("0.50", "5.00");
    cocaCola.setPrice(cocaColaPrice);
    
    noNamePizzaPrice = new Price("1.00", "10.00");
    noNamePizza.setPrice(noNamePizzaPrice);
    
    finance = new Finance();
    
    finance.sold(cocaCola, 10);
    finance.sold(noNamePizza, 5);
  }
  
  @Test
  public void testProfit() {
    LinkedHashMap<String, String> profit = finance.getProfit();
    String profitMade = profit.get("Coca-Cola");
    
    assertEquals(profitMade, "$45.00");
    
    profitMade = profit.get("No Name Pizza");
    assertEquals(profitMade, "$45.00");
  }
  
  @Test
  public void testRevenue() {
    LinkedHashMap<String, String> revenue = finance.getRevenue();
    String profitMade = revenue.get("Coca-Cola");
    
    assertEquals(profitMade, "$50.00");
    
    profitMade = revenue.get("No Name Pizza");
    assertEquals(profitMade, "$50.00");
  }

}
