import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * The Class ScanInPanel.
 */
public class ScanInPanel {


  private JButton btnScan;
  private JButton btnVerify;
  private JComboBox comboBox;
  private Component divider;
  private JLabel lblProductName;
  private JLabel lblScanBy;
  private JPanel scanIn;
  private JTextField amountField;
  private JTextField ProductName;
  private JTextField scan;


  /**
   * Instantiates a new scan in panel.
   *
   * @param contentPane the content pane
   */
  public ScanInPanel(JPanel contentPane) {
    scanIn = new JPanel();
    contentPane.add(scanIn, "Scan In");
    scanIn.setLayout(null);

    setUpButtons();
    setUpFields();
    setUpLabels();

  }

  /**
   * Gets the combo box.
   *
   * @return the combo box
   */
  public JComboBox getComboBox() {
    return comboBox;
  }

  /**
   * Gets the scan JButton.
   *
   * @return the scan JButton
   */
  public JButton getScanBtn() {
    return btnScan;
  }

  /**
   * Gets the verify JButton.
   *
   * @return the verify JButton
   */
  public JButton getVerifyBtn() {
    return btnVerify;
  }

  /**
   * Sets up the buttons.
   */
  private void setUpButtons() {
    btnVerify = new JButton("Verify");
    btnVerify.setBounds(311, 204, 117, 25);
    scanIn.add(btnVerify);

    btnScan = new JButton("Scan");
    btnScan.setBounds(311, 55, 117, 25);
    scanIn.add(btnScan);

    String[] choices = {"PO#", "UPC"};
    comboBox = new JComboBox(choices);
    comboBox.setBounds(118, 29, 78, 22);
    scanIn.add(comboBox);
  }

  /**
   * Sets up the fields.
   */
  private void setUpFields() {

    amountField = new JTextField();
    amountField.setBounds(188, 160, 38, 19);
    scanIn.add(amountField);
    amountField.setColumns(10);

    scan = new JTextField();
    scan.setBounds(208, 31, 220, 19);
    scanIn.add(scan);
    scan.setColumns(10);

    ProductName = new JTextField();
    ProductName.setBounds(188, 129, 166, 19);
    scanIn.add(ProductName);
    ProductName.setColumns(10);
  }

  /**
   * Sets up the labels.
   */
  private void setUpLabels() {
    lblScanBy = new JLabel("Scan by");
    lblScanBy.setBounds(40, 33, 70, 15);
    scanIn.add(lblScanBy);

    JLabel lblProductInfo = new JLabel("PRODUCT INFO ");
    lblProductInfo.setBounds(148, 104, 132, 15);
    scanIn.add(lblProductInfo);


    lblProductName = new JLabel("Product Name");
    lblProductName.setBounds(72, 131, 124, 15);
    scanIn.add(lblProductName);

    JLabel lblAmount = new JLabel("Amount");
    lblAmount.setBounds(118, 158, 70, 15);
    scanIn.add(lblAmount);

    divider = new JLabel(
        "----------------------------------------------------------------------------------");
    divider.setBounds(24, 85, 416, 15);
    scanIn.add(divider);
  }

  public JTextField getSearchField() {
    return scan;
  }

  public JTextField getAmountField() {
    return amountField;
  }

  public JTextField getProductName() {
    return ProductName;
  }
}
