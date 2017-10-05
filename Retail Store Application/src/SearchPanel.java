import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SearchPanel {
	
private JPanel search;
private JTextField textField_1;
private JComboBox comboBox_4;
private JLabel serachLabel;
private JButton btnSearch;

public SearchPanel(JPanel contentPane) {
    search = new JPanel();
    contentPane.add(search, "Search");
    search.setLayout(null);
    
    textField_1 = new JTextField();
    textField_1.setBounds(222, 38, 183, 19);
    textField_1.setColumns(10);
    search.add(textField_1);
    
    comboBox_4 = new JComboBox(new Object[]{});
    comboBox_4.setBounds(113, 36, 93, 22);
    search.add(comboBox_4);
    
    serachLabel = new JLabel("Search by");
    serachLabel.setBounds(32, 40, 70, 15);
    search.add(serachLabel);
    
    btnSearch = new JButton("Search");
    btnSearch.setBounds(288, 69, 117, 25);
    search.add(btnSearch);
  }
}
