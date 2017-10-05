import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class View extends JFrame {
  private JMenuBar menuBar;
  private JMenu mnMenu;
  private JMenuItem mntmScanIn;
  private JMenuItem mntmCashier;
  

  private JPanel contentPane;
  private JMenuItem mntmOrder;
  private JMenuItem mntmFinance;
  private JMenuItem mntmQuery;
  private JMenuItem mntmSearch;
  
  
  
  private ScanInPanel scanIn;
  private VerifyLocationPanel verifyLocation;
  private CashierPanel cashier;
  private ProductPanel product;
  private FinancePanel finance;
  private QueryPanel query;
  private OrderPanel orders;
  private NewQueryPanel newQuery;
  private SearchPanel search;
  private NewOrderPanel newOrder;
  

  /**
   * Create the frame.
   */
  public View() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 450, 300);
    
    setUpMenu();
    setUpPanel();
    setUpListeners();
   

  }
  
  private void setUpMenu() {
    menuBar = new JMenuBar();
    setJMenuBar(menuBar);
    
    mnMenu = new JMenu("Menu");
    menuBar.add(mnMenu);
    
    mntmScanIn = new JMenuItem("Scan In");
    mnMenu.add(mntmScanIn);
    
    mntmCashier = new JMenuItem("Cashier");
    mnMenu.add(mntmCashier);
    
    mntmSearch = new JMenuItem("Search");
    mnMenu.add(mntmSearch);
    
    mntmQuery = new JMenuItem("Query");
    mnMenu.add(mntmQuery);
    
    mntmOrder = new JMenuItem("Order");
    mnMenu.add(mntmOrder);
    
    mntmFinance = new JMenuItem("Finance");
    mnMenu.add(mntmFinance);
  }
  
  private void setUpPanel(){
    
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(new CardLayout(0, 0));
    
    
    scanIn = new ScanInPanel(contentPane);
    verifyLocation = new VerifyLocationPanel(contentPane);
    cashier = new CashierPanel(contentPane);
    product = new ProductPanel(contentPane);
    query = new QueryPanel(contentPane);
    finance = new FinancePanel(contentPane);
    orders = new OrderPanel(contentPane);
    search = new SearchPanel(contentPane);
    newQuery = new NewQueryPanel(contentPane);
    newOrder = new NewOrderPanel(contentPane);
    
  }
  
  public ScanInPanel getScanInPanel() {
    return scanIn;
  }
  
  public VerifyLocationPanel getVerifyLocation() {
    return verifyLocation;
  }
  
  public CashierPanel getCashierPanel() {
    return cashier;
  }
  
  public ProductPanel getProductPanel() {
    return product;
  }
  
  public QueryPanel getQueryPanel() {
    return query;
  }
  
  public FinancePanel getFinancePanel() {
    return finance;
  }
  
  public OrderPanel getOrderPanel() {
    return orders;
  }
  
  public SearchPanel getSearchPanel() {
    return search;
  }
  
  public NewQueryPanel getNewQueryPanel() {
    return newQuery;
  }
  
  public NewOrderPanel getNewOrderPanel()
  {
	  return newOrder;
  }
  
  public JPanel getContentPane()
  {
	  return contentPane;
  }
  
  private void setUpListeners() {
    
    
    mntmCashier.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        CardLayout c = (CardLayout) (contentPane.getLayout());
        c.show(contentPane, "Cashier");
      }
    });
    
    mntmScanIn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        CardLayout c = (CardLayout) (contentPane.getLayout());
        c.show(contentPane, "Scan In");
      }
    });
    
    mntmSearch.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        CardLayout c = (CardLayout) (contentPane.getLayout());
        c.show(contentPane, "Search");
      }
    });
    
    mntmOrder.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        CardLayout c = (CardLayout) (contentPane.getLayout());
        c.show(contentPane, "Orders");
      }
    });
    
    mntmQuery.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        CardLayout c = (CardLayout) (contentPane.getLayout());
        c.show(contentPane, "Query");
      }
    });
    
    mntmFinance.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        CardLayout c = (CardLayout) (contentPane.getLayout());
        c.show(contentPane, "Finance");
      }
    });
  }
}
