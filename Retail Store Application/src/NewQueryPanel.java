import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NewQueryPanel {

private JButton btnSaveQuestion;
private JLabel lblNewQuestion;

public NewQueryPanel(JPanel contentPane) {
    JPanel newQuery = new JPanel();
    contentPane.add(newQuery, "New Query");
    newQuery.setLayout(null);

    JEditorPane editorPane = new JEditorPane();
    editorPane.setBounds(44, 56, 348, 114);
    newQuery.add(editorPane);

    btnSaveQuestion = new JButton("Save Question");
    btnSaveQuestion.setBounds(258, 204, 170, 25);
    newQuery.add(btnSaveQuestion);

    lblNewQuestion = new JLabel("New Question");
    lblNewQuestion.setBounds(184, 29, 170, 15);
    newQuery.add(lblNewQuestion);
  }
}
