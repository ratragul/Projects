import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * The Class Controller.
 */
public class Controller {

  ModelManager modelManager;
  View view;
  ScanInPanel scan;
  OrderPanel orderScan;
  FinancePanel financeScan;
  VerifyLocationPanel verifyLocationPanel;
  SearchPanel search;
  QueryPanel query;
  NewQueryPanel newQuery;
  CashierPanel cashier;
  NewOrderPanel newOrder;
  JButton createNewOrder;
  OrderManager orderManager;
  JPanel contentPane;
  JButton buttonNewOrder;

  public Controller(ModelManager model, View view) {
    this.modelManager = model;
    this.view = view;
    
    orderManager = modelManager.getOrderManager();
    contentPane = view.getContentPane();
    		
    scan = view.getScanInPanel();
    orderScan = view.getOrderPanel();
    financeScan = view.getFinancePanel();
    verifyLocationPanel = view.getVerifyLocation();
    search = view.getSearchPanel();
    query = view.getQueryPanel();
    newQuery = view.getNewQueryPanel();
    cashier = view.getCashierPanel();
    newOrder = view.getNewOrderPanel();
    
    createNewOrder = newOrder.getBtnNewOrder(); 
    buttonNewOrder = orderScan.buttonNewOrder();

    initializeButtons();

    addListeners();
    load();
  }

  private void initializeButtons() {

  }
  
  private void load()
  {
	  OrderManager order = modelManager.getOrderManager();
	  ArrayList<Order> orderList = order.getPendingOrder();
	  
	  
	  for(Order o : orderList)
	  {
		  orderScan.getList().addElement(o.toString());
	  }
	  
  }

  private void addListeners() {
	
	
	JButton btnScan = scan.getScanBtn();
	
	
    btnScan.addActionListener(new ActionListener() {
    	
      public void actionPerformed(ActionEvent ev) {
    	 System.out.println("in here");
    	  String txt = scan.getSearchField().getText();
    	    
    	  String productName = scan.getProductName().getText();
    	  OrderManager order = modelManager.getOrderManager();
    	  Order getOrder = order.getPendingOrder(Integer.parseInt(txt));
    	  
    	  scan.getProductName().setText(getOrder.getProductOrdered());
    	  scan.getAmountField().setText(String.valueOf(getOrder.getAmountOrdered()));
    	 
    	  
      }
    });
    
    createNewOrder.addActionListener(new ActionListener() {
    	
        public void actionPerformed(ActionEvent ev) {
      	 
      	  String productName = newOrder.getProductField().getText();
      	  String amount = newOrder.getAmountField().getText();
      	  String upc = newOrder.getUpcField().getText();
      	  
      	  orderManager.createOrder(productName, Integer.parseInt(upc), Integer.parseInt(amount));
      	  
      	  
      	  CardLayout c = (CardLayout) (contentPane.getLayout());
      	  c.show(contentPane, "Orders");
        }
      });
    
    buttonNewOrder.addActionListener(new ActionListener() {
    	
        public void actionPerformed(ActionEvent ev) {
      	  CardLayout c = (CardLayout) (contentPane.getLayout());
      	  c.show(contentPane, "New Order");
        }
      });
    
  }
}
