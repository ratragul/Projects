import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ProductPanel {


private JPanel Product;
private JLabel lblProductName_1;
private JLabel lblPo;
private JLabel lblUpc;
private JTextField poField;
private JTextField upcField;
private JTextField productNameField;
private JLabel lblListPrice;
private JLabel lblSalePrice;
private JLabel label;
private JTextField listPriceField;
private JTextField salePriceField;
private JLabel lblOnSale;
private JTextField SaleType;
private JLabel lblOnShelf;
private JLabel lblStockRoom;
private JTextField onShelfField;
private JTextField stockRoomField;
private JButton btnEditPrices;
private JLabel lblSection_1;
private JLabel lblAisle_1;
private JLabel lblCategory_1;
private JTextField sectionField;
private JTextField aisleField;
private JTextField categoryField;
private JButton btnEditLocation;
private JButton editAmountBtn;

public ProductPanel(JPanel contentPane) {
    Product = new JPanel();
    contentPane.add(Product, "Product");
    Product.setLayout(null);
    
    lblProductName_1 = new JLabel("Product Name");
    lblProductName_1.setBounds(12, 12, 115, 15);
    Product.add(lblProductName_1);
    
    lblPo = new JLabel("P.O. #");
    lblPo.setBounds(12, 39, 70, 15);
    Product.add(lblPo);
    
    lblUpc = new JLabel("UPC");
    lblUpc.setBounds(12, 68, 70, 15);
    Product.add(lblUpc);
    
    poField = new JTextField();
    poField.setEditable(false);
    poField.setBounds(76, 37, 185, 19);
    Product.add(poField);
    poField.setColumns(10);
    
    upcField = new JTextField();
    upcField.setEditable(false);
    upcField.setColumns(10);
    upcField.setBounds(76, 66, 185, 19);
    Product.add(upcField);
    
    productNameField = new JTextField();
    productNameField.setEditable(false);
    productNameField.setBounds(125, 10, 132, 19);
    Product.add(productNameField);
    productNameField.setColumns(10);
    
    lblListPrice = new JLabel("List Price");
    lblListPrice.setBounds(279, 12, 70, 15);
    Product.add(lblListPrice);
    
    lblSalePrice = new JLabel("Sale Price");
    lblSalePrice.setBounds(279, 39, 70, 15);
    Product.add(lblSalePrice);
    
    label = new JLabel("----------------------------------------------------------------------------------");
    label.setBounds(12, 120, 416, 15);
    Product.add(label);
    
    listPriceField = new JTextField();
    listPriceField.setEditable(false);
    listPriceField.setBounds(356, 10, 72, 17);
    Product.add(listPriceField);
    listPriceField.setColumns(10);
    
    salePriceField = new JTextField();
    salePriceField.setEditable(false);
    salePriceField.setColumns(10);
    salePriceField.setBounds(356, 38, 72, 17);
    Product.add(salePriceField);
    
    lblOnSale = new JLabel("On Sale");
    lblOnSale.setBounds(289, 68, 70, 15);
    Product.add(lblOnSale);
    
    SaleType = new JTextField();
    SaleType.setEditable(false);
    SaleType.setColumns(10);
    SaleType.setBounds(356, 66, 72, 17);
    Product.add(SaleType);
    
    lblOnShelf = new JLabel("On Shelf");
    lblOnShelf.setBounds(46, 147, 70, 15);
    Product.add(lblOnShelf);
    
    lblStockRoom = new JLabel("Stock Room");
    lblStockRoom.setBounds(24, 174, 94, 15);
    Product.add(lblStockRoom);
    
    onShelfField = new JTextField();
    onShelfField.setEditable(false);
    onShelfField.setBounds(125, 145, 59, 19);
    Product.add(onShelfField);
    onShelfField.setColumns(10);
    
    stockRoomField = new JTextField();
    stockRoomField.setEditable(false);
    stockRoomField.setBounds(125, 172, 59, 19);
    Product.add(stockRoomField);
    stockRoomField.setColumns(10);
    
    btnEditPrices = new JButton("Edit");
    btnEditPrices.setBounds(358, 95, 70, 19);
    Product.add(btnEditPrices);
    
    lblSection_1 = new JLabel("Section");
    lblSection_1.setBounds(236, 149, 70, 15);
    Product.add(lblSection_1);
    
    lblAisle_1 = new JLabel("Aisle");
    lblAisle_1.setBounds(255, 173, 70, 15);
    Product.add(lblAisle_1);
    
    lblCategory_1 = new JLabel("Category");
    lblCategory_1.setBounds(226, 198, 70, 15);
    Product.add(lblCategory_1);
    
    sectionField = new JTextField();
    sectionField.setEditable(false);
    sectionField.setBounds(302, 147, 114, 19);
    Product.add(sectionField);
    sectionField.setColumns(10);
    
    aisleField = new JTextField();
    aisleField.setEditable(false);
    aisleField.setBounds(302, 172, 114, 19);
    Product.add(aisleField);
    aisleField.setColumns(10);
    
    categoryField = new JTextField();
    categoryField.setEditable(false);
    categoryField.setColumns(10);
    categoryField.setBounds(302, 196, 114, 19);
    Product.add(categoryField);
    
    btnEditLocation = new JButton("Edit");
    btnEditLocation.setBounds(358, 222, 70, 19);
    Product.add(btnEditLocation);
    
    editAmountBtn = new JButton("Edit");
    editAmountBtn.setBounds(138, 219, 70, 19);
    Product.add(editAmountBtn);
  }

public JButton getEditAmountBtn()
{
	return editAmountBtn;
}

public JButton getEditPriceBtn()
{
	return btnEditPrices;
}

/**
 * @return
 */
public JButton getEditLocationBtn()
{
	return btnEditLocation;
}

public void setPoField(String poField)
{
	this.poField.setText(poField);
}

public void setUpcField(String upcField)
{
	this.upcField.setText(upcField);
}

public void setProductNameField(String productNameField)
{
	this.productNameField.setText(productNameField);
}

public void setListPriceField(String listPriceField)
{
	this.listPriceField.setText(listPriceField);
}

public void setSalePriceField(String salePriceField)
{
	this.salePriceField.setText(salePriceField);
}

public void setSaleType(String saleType)
{
	SaleType.setText(saleType);
}

public void setOnShelfField(String onShelfField)
{
	this.onShelfField.setText(onShelfField);
}

public void setStockRoomField(String stockRoomField)
{
	this.stockRoomField.setText(stockRoomField);
}

public void setSectionField(String sectionField)
{
	this.sectionField.setText(sectionField);
}

public void setAisleField(String aisleField)
{
	this.aisleField.setText(aisleField);
}

public void setCategoryField(String categoryField)
{
	this.categoryField.setText(categoryField);
}
}
