import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JPanel;

public class QueryPanel {
	
private JPanel Query;
private JComboBox comboBox_5;
private JLabel lblQuestion;
private JButton btnNewQuestion;

public QueryPanel(JPanel contentPane) {
    Query = new JPanel();
    contentPane.add(Query, "Query");
    Query.setLayout(null);
    
    comboBox_5 = new JComboBox();
    comboBox_5.setBounds(90, 12, 338, 24);
    Query.add(comboBox_5);
    
    lblQuestion = new JLabel("Question");
    lblQuestion.setBounds(12, 44, 85, 19);
    Query.add(lblQuestion);
    
    JLabel lblAnswer = new JLabel("Answer");
    lblAnswer.setBounds(12, 113, 70, 15);
    Query.add(lblAnswer);
    
    JButton btnAddeditAnswer = new JButton("Add/Edit Answer");
    btnAddeditAnswer.setBounds(259, 204, 169, 25);
    Query.add(btnAddeditAnswer);
    
    btnNewQuestion = new JButton("New Question");
    
    btnNewQuestion.setBounds(78, 204, 169, 25);
    Query.add(btnNewQuestion);
    
    JTextPane textPane = new JTextPane();
    textPane.setBounds(90, 114, 338, 77);
    Query.add(textPane);
    
    JTextArea textArea = new JTextArea();
    textArea.setBounds(90, 46, 338, 50);
    Query.add(textArea);
  }
}
