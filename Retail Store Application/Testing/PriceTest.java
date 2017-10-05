import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PriceTest {
  Price price;
  
  @Before 
  public void setUp() {
    price = new Price("10.00", "50.00");
  }

  @Test
  public void testPrice() {
    assertEquals(price.getListPrice(), "$10.00");
    assertEquals(price.getPrice(), "$50.00");
  }

  @Test
  public void testSetListPrice() {
    price.setListPrice("12.00");
    assertEquals(price.getListPrice(),"$12.00");
  }

  @Test
  public void testSetSalePrice() {
    price.setSalePrice("40.00");
    assertEquals(price.getPrice(),"$40.00");
  }

  @Test
  public void testReset() {
    price.setSalePrice("40.00");
    price.reset();
    assertEquals(price.getPrice(), "$50.00");
  }

}
