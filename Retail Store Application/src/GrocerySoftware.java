import java.awt.EventQueue;
import java.io.IOException;

public class GrocerySoftware {

  public static void main(String[] args) throws ClassNotFoundException, IOException  {
    ModelManager model = new ModelManager();
    
    model.getInventoryManager().load();
    model.getOrderManager().setOrder();
    View view = new View();
    
    Controller controller = new Controller(model, view);
    
    EventQueue.invokeLater(new Runnable() {
        public void run() {
          try {
            View frame = new View();
            frame.setVisible(true);
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
      });
  }
}
