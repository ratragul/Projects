import java.awt.Component;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewOrderPanel {
  private JPanel newOrder;
  private JLabel lblOrderProduct;
  private JLabel lblAmount_2;
  private JLabel poNumber;
  private JTextField productField;
  private JTextField amountField;
  private JTextField poField;
  private JButton btnNewOrder;
  private JLabel labelUpc;
  private JTextField upcField;

  public NewOrderPanel(JPanel contentPane) {
    
    newOrder = new JPanel();
    contentPane.add(newOrder, "New Order");
    newOrder.setLayout(null);
    
    lblOrderProduct = new JLabel("Product");
    lblOrderProduct.setBounds(52, 24, 70, 15);
    newOrder.add(lblOrderProduct);
    
    lblAmount_2 = new JLabel("Amount");
    lblAmount_2.setBounds(52, 64, 70, 15);
    newOrder.add(lblAmount_2);
    
    poNumber = new JLabel("P.O.#");
    poNumber.setBounds(52, 107, 70, 15);
    newOrder.add(poNumber);
    
    productField = new JTextField();
    productField.setBounds(121, 22, 288, 17);
    newOrder.add(productField);
    productField.setColumns(10);
    
    amountField = new JTextField();
    amountField.setColumns(10);
    amountField.setBounds(121, 63, 288, 17);
    newOrder.add(amountField);
    
    poField = new JTextField();
    poField.setColumns(10);
    poField.setBounds(121, 106, 288, 17);
    newOrder.add(poField);
    
    btnNewOrder = new JButton("New Order");
    btnNewOrder.setBounds(311, 204, 117, 25);
    newOrder.add(btnNewOrder);
    
    labelUpc = new JLabel("UPC");
    labelUpc.setBounds(52, 144, 70, 15);
    newOrder.add(labelUpc);
    
    upcField = new JTextField();
    upcField.setColumns(10);
    upcField.setBounds(121, 142, 288, 17);
    newOrder.add(upcField);
  }
  
  public JTextField getProductField() {
    return productField;
  }

  public JTextField getAmountField() {
    return amountField;
  }

  public JButton getBtnNewOrder() {
    return btnNewOrder;
  }

  public JTextField getUpcField() {
    return upcField;
  }
}
