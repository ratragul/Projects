import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

public class OrderPanel {
  
  private JPanel Orders;
private JList list_1;
private JLabel lblPendingLabel;
private JButton btnNewOrder;
private JButton btnOrderHistory;
private DefaultListModel<String> listModel = new DefaultListModel<>();

public JButton buttonNewOrder()
{
	return btnNewOrder;
}

public OrderPanel(JPanel contentPane) {
    Orders = new JPanel();
    contentPane.add(Orders, "Orders");
    Orders.setLayout(null);
    
    
    list_1 = new JList(listModel);
    list_1.setBounds(12, 35, 259, 194);
    Orders.add(list_1);
    
    lblPendingLabel = new JLabel("Pending Orders");
    lblPendingLabel.setBounds(12, 12, 159, 15);
    Orders.add(lblPendingLabel);
    
    btnNewOrder = new JButton("New Order");
    btnNewOrder.setBounds(283, 204, 145, 25);
    Orders.add(btnNewOrder);
    
    btnOrderHistory = new JButton("Order History");
    btnOrderHistory.setBounds(283, 163, 145, 25);
    Orders.add(btnOrderHistory);
  }

public DefaultListModel<String> getList()
{
	return listModel;
}
}
