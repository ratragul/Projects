import java.io.Serializable;
import java.util.ArrayList;
/**
 * Category has name and belongs in an Aisle. Category has 
 * products. 
 */
public class Category implements Serializable{
    
    private String name;
    private ArrayList<Product> products;
    private Aisle aisle;

    /**
     * Instantiates a new category.
     *
     * @param name the name
     * @param aisle the aisle
     */
    public Category(String name, Aisle aisle) {
        this.name = name;
        this.aisle = aisle;
        products = new ArrayList<>();
    }

    /**
     * Change name of the Category.
     *
     * @param name the name
     */
    public void changeName(String name) {
        this.name = name;
    }

    /**
     * Returns the name of the Category.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the products.
     *
     * @return the products
     */
    public ArrayList<Product> getProducts() {
        return products;
    }

    /**
     * Gets the aisle.
     *
     * @return the aisle
     */
    public Aisle getAisle() {
        return aisle;
    }
}