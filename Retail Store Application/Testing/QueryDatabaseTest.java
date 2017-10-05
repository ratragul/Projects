import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class QueryDatabaseTest {

  QueryDatabase queryDatabase;


  @Before
  public void setUp() {
    queryDatabase = new QueryDatabase();
    queryDatabase.addQuery("Is mayonaise an instrument");
    queryDatabase.addQuery("is it?");
    
  }

  @Test
  public void testAddQuery() {
    Query question = queryDatabase.getQuery("Is mayonaise an instrument");
    Query question2 = queryDatabase.getQuery("is it?");
    assertEquals(question.getQuestion(), "Is mayonaise an instrument");
    assertEquals(question.getAnswer(), null);
    

    assertEquals(question2.getQuestion(), "is it?");
    assertEquals(question2.getAnswer(), null);
  }

  @Test
  public void testRemoveQuery() {
    assertEquals(true, queryDatabase.removeQuery("is it?"));
    assertEquals(null, queryDatabase.getQuery("is it?"));
    
  }

  @Test
  public void testSetAnswer() {
    String yes = "yes";
    String no = "no";
    

    Query question = queryDatabase.getQuery("Is mayonaise an instrument");
    Query question2 = queryDatabase.getQuery("is it?");
    
    assertEquals(true, queryDatabase.setAnswer(question.getQuestion(), no));
    assertEquals(true, queryDatabase.setAnswer(question2.getQuestion(), yes));
    
    assertEquals("no", question.getAnswer());
    assertEquals("yes", question2.getAnswer());
    
    BigDecimal b = new BigDecimal("1.999");
    BigDecimal b2 = new BigDecimal("2.0");
    System.out.print(b.add(b2));
  }

}
