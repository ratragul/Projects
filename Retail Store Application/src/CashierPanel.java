import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * The Class CashierPanel.
 */
public class CashierPanel {

  private JButton btnApplyDiscount;
  private JButton btnFinalSale;
  private JButton btnPriceInquiry;
  private JButton btnPriceOverride;
  private JButton btnScan;
  private JPanel cashier;
  private JTextField cashierScan;
  private JLabel lblAmount;
  private JLabel lblAmountOff;
  private JLabel lblDiscount;
  private JLabel lblTotal;
  private JList list;

  /**
   * Instantiates a new cashier panel.
   *
   * @param contentPane the content pane
   */
  public CashierPanel(JPanel contentPane) {
    cashier = new JPanel();
    contentPane.add(cashier, "Cashier");
    cashier.setLayout(null);
    
    list = new JList();
    list.setBounds(12, 12, 232, 245);
    cashier.add(list);
    
    cashierScan = new JTextField();
    cashierScan.setBounds(256, 11, 172, 19);
    cashier.add(cashierScan);
    cashierScan.setColumns(10);
    
    lblDiscount = new JLabel("Discount: ");
    lblDiscount.setBounds(256, 222, 100, 15);
    cashier.add(lblDiscount);
    
    lblAmountOff = new JLabel("-##.##");
    lblAmountOff.setForeground(Color.GREEN);
    lblAmountOff.setBounds(363, 222, 70, 15);
    cashier.add(lblAmountOff);
    
    lblTotal = new JLabel("Total: ");
    lblTotal.setBounds(256, 242, 70, 15);
    cashier.add(lblTotal);
    
    lblAmount = new JLabel("$##.##");
    lblAmount.setForeground(Color.RED);
    lblAmount.setBounds(363, 242, 70, 15);
    cashier.add(lblAmount);
    
    setUpButtons();
  }
  
  /**
   * Gets the JButton apply discount.
   *
   * @return the JButton apply discount
   */
  public JButton getBtnApplyDiscount() {
    return btnApplyDiscount;
  }

  /**
   * Gets the JButton final sale.
   *
   * @return the JButton final sale
   */
  public JButton getBtnFinalSale() {
    return btnFinalSale;
  }

  /**
   * Gets the JButton new button.
   *
   * @return the JButton new button
   */
  public JButton getBtnPriceInquiry() {
    return btnPriceInquiry;
  }

  /**
   * Gets the JButton price override.
   *
   * @return the JButton price override
   */
  public JButton getBtnPriceOverride() {
    return btnPriceOverride;
  }

  /**
   * Sets the up buttons.
   */
  private void setUpButtons() {
    btnFinalSale = new JButton("Final Sale");
    btnFinalSale.setBounds(305, 175, 123, 25);
    cashier.add(btnFinalSale);
    
    btnApplyDiscount = new JButton("Discount");
    btnApplyDiscount.setBounds(294, 138, 134, 25);
    cashier.add(btnApplyDiscount);
    
    btnPriceOverride = new JButton("Price Override");
    btnPriceOverride.setBounds(294, 102, 134, 25);
    cashier.add(btnPriceOverride);
    
    btnPriceInquiry = new JButton("Price Inquiry");
    btnPriceInquiry.setBounds(294, 66, 134, 25);
    cashier.add(btnPriceInquiry);
    
    btnScan = new JButton("Scan");
    btnScan.setBounds(311, 30, 117, 25);
    cashier.add(btnScan);
  }
  
  //TODO: read on how to use JList, or any other better
  // alternatives to creating a list.
}
