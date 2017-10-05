import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

public class NumericSaleTest {
  Product wine;
  Price price;
  Sale sale;
  
  @Before
  public void setUp() {
    wine = new Product("Patricks Red Wine");
    price = new Price("2.00", "20.00");
    sale = new NumericSale("2.00", "08-05-17", "09-05-17");
    
    wine.setPrice(price);
    
    sale.applySale(wine);
  }

  @Test
  public void testApplySale() {
    assertEquals(wine.getPrice().getPrice(), "$18.00");
    }

  @Test
  public void testGetSale() {
  }

  @Test
  public void testGetDateEnd() {
    fail("Not yet implemented");
  }

  @Test
  public void testGetStartDate() {
    fail("Not yet implemented");
  }

  @Test
  public void testGetAmount() {
    fail("Not yet implemented");
  }

}
