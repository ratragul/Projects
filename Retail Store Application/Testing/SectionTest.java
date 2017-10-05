import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SectionTest {
  
  Section section;
  Aisle aisle;
  
  @Before
  public void setUp() {
    section = new Section("To go", "Ready made meals");
    aisle = new Aisle(section);
    
  }
  
  @Test
  public void testName() {
    assertEquals("To go", section.getName());
  }
  
  @Test
  public void testDescription() {
    assertEquals("Ready made meals", section.getDescription());
  }
  
  @Test
  public void testChange() {
    section.changeName("Convience");
    section.changeDescription("Convience for lottery");
    
    assertEquals("Convience", section.getName());
    assertEquals("Convience for lottery", section.getDescription());
  }

}
