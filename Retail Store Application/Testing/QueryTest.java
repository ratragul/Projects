import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class QueryTest {
  Query query;
  
  @Before 
  public void setUP() {
    query = new Query("Is mayonaise an instrument");
  }

  @Test
  public void testGetQuestion() {
    assertEquals(query.getQuestion(), "Is mayonaise an instrument");
  }

  @Test
  public void testGetAnswer() {
    query.answer("No, patrick. Mayonaise is not an instrument");
    assertEquals(query.getAnswer(), "No, patrick. Mayonaise is not an instrument");
  }

}
