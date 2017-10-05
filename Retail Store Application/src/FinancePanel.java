import java.awt.List;
import javax.swing.JPanel;

public class FinancePanel {

  private JPanel Finance;

public FinancePanel(JPanel contentPane) {
    Finance = new JPanel();
    contentPane.add(Finance, "Finance");
    Finance.setLayout(null);

    List list_2 = new List();
    list_2.setBounds(115, 10, 315, 221);
    Finance.add(list_2);
  }
}
