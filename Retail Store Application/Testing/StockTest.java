import static org.junit.Assert.*;

import java.util.LinkedHashMap;

import org.junit.Before;
import org.junit.Test;

public class StockTest {
  Stock stock;
  LinkedHashMap<String, Integer> quantityHistory;
  String date1;
  String date2;
  String date3;

  @Before
  public void setUp() {
    stock = new Stock(10, 20, 5);

    // Create a quantity history
    quantityHistory = new LinkedHashMap<>();
    date1 = "05-01-2017 9:00:00";
    date1 = "06-01-2017 9:00:00";
    date1 = "07-01-2017 9:00:00";
    quantityHistory.put(date1, 10);
    quantityHistory.put(date1, 15);
    quantityHistory.put(date1, 20);

    stock.setQuantityHistory(quantityHistory);


  }

  @Test
  public void testOnShelf() {
    assertEquals(stock.getQuantityOnShelf(), 10);
    stock.stockToShelf(20);
    assertEquals(stock.getQuantityOnShelf(), 30);
    stock.removeOnShelf(30);
    assertEquals(stock.getQuantityOnShelf(), 0);
  }

  @Test
  public void testOnStock() {
    assertEquals(stock.getQuantityStockRoom(), 20);
    stock.addToStockRoom(10);
    assertEquals(stock.getQuantityStockRoom(), 30);
  }

  @Test
  public void testTotalStock() {
    assertEquals(stock.getTotal(), 30);
    stock.stockToShelf(20);
    stock.addToStockRoom(10);
    assertEquals(stock.getTotal(), 40);
    stock.removeOnShelf(30);
    assertEquals(stock.getTotal(), 10);
  }
  
  @Test
  public void testThreshold() {
    assertEquals(stock.getThreshold(), 5);
    stock.setThreshold(10);
    assertEquals(stock.getThreshold(), 10);
  }
}
