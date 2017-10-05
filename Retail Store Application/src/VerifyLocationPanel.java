

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

// TODO: Auto-generated Javadoc
/**
 * The Class VerifyLocation.
 */
public class VerifyLocationPanel {
  
  private JButton btnVerifyLocation;
  private JComboBox aisleBox;
  private JComboBox categoryBox;
  private JComboBox sectionBox;
  private JLabel lblAisle;
  private JLabel lblCategory;
  private JLabel lblSection;
  private JLabel lblVerifyLocation;
  private JPanel verifyLocation;

  /**
   * Instantiates a new verify location.
   *
   * @param contentPane the content pane
   */
  public VerifyLocationPanel(JPanel contentPane) {
    verifyLocation = new JPanel();
    contentPane.add(verifyLocation, "location");
    verifyLocation.setLayout(null);
    
    //TODO: read up on comboBox Model
    setUpBox();
    setUpLabels();
    setUpButtons();
  }
  
  /**
   * Gets the aisle box.
   *
   * @return the aisle box
   */
  public JComboBox getAisleBox() {
    return aisleBox;
  }
  
  /**
   * Gets the JButton verify location.
   *
   * @return the JButton verify location
   */
  public JButton getBtnVerifyLocation() {
    return btnVerifyLocation;
  }
  
  /**
   * Gets the category box.
   *
   * @return the category box
   */
  public JComboBox getCategoryBox() {
    return categoryBox;
  }

  /**
   * Gets the section box.
   *
   * @return the section box
   */
  public JComboBox getSectionBox() {
    return sectionBox;
  }

  /**
   * Gets the aisle selection.
   *
   * @return the aisle selection
   */
  public String getAisleSelection() {
    return String.valueOf(aisleBox.getSelectedItem());
  }
  
  /**
   * Gets the category selection.
   *
   * @return the category selection
   */
  public String getCategorySelection() {
    return String.valueOf(categoryBox.getSelectedItem());
  }
  
  /**
   * Gets the section selection.
   *
   * @return the section selection
   */
  public String getSectionSelection() {
    return String.valueOf(sectionBox.getSelectedItem());
  }

  /**
   * Sets up the box.
   */
  private void setUpBox() {
    sectionBox = new JComboBox();
    sectionBox.setEditable(true);
    sectionBox.setBounds(150, 68, 234, 24);
    verifyLocation.add(sectionBox);
    
    aisleBox = new JComboBox();
    aisleBox.setEditable(true);
    aisleBox.setBounds(150, 104, 234, 24);
    verifyLocation.add(aisleBox);
    
    categoryBox = new JComboBox();
    categoryBox.setEditable(true);
    categoryBox.setBounds(150, 140, 234, 24);
    verifyLocation.add(categoryBox);
  }

  /**
   * Sets up the buttons.
   */
  private void setUpButtons() {
    btnVerifyLocation = new JButton("Verify");
    btnVerifyLocation.setBounds(311, 204, 117, 25);
    verifyLocation.add(btnVerifyLocation);
  }

  /**
   * Sets up the labels.
   */
  private void setUpLabels() {
    
    lblSection = new JLabel("Section");
    lblSection.setBounds(80, 72, 70, 15);
    verifyLocation.add(lblSection);
    
    lblAisle = new JLabel("Aisle");
    lblAisle.setBounds(97, 108, 70, 15);
    verifyLocation.add(lblAisle);
    
    lblCategory = new JLabel("Category");
    lblCategory.setBounds(66, 144, 70, 15);
    verifyLocation.add(lblCategory);
    
    lblVerifyLocation = new JLabel("Verify Location");
    lblVerifyLocation.setBounds(182, 32, 128, 15);
    verifyLocation.add(lblVerifyLocation); 
  }
  
  //TODO: should we pass it a combo box instance from controller or change its contents from 
  // controller?

}
