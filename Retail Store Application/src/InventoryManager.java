import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * The Class InventoryManager. It Manages the class of Section, Categories, Aisle, Product.
 */
public class InventoryManager {

  /** The sections. */
  private ArrayList<Section> sections;

  /** The aisles. */
  private ArrayList<Aisle> aisles;

  /** The categories. */
  private ArrayList<Category> categories;

  /** The products. */
  private ArrayList<Product> products;

  /**
   * Instantiates a new inventory manager.
   */
  public InventoryManager() {
    sections = new ArrayList<>();
    aisles = new ArrayList<>();
    categories = new ArrayList<>();
    products = new ArrayList<>();
  }

  /**
   * Adds a Section to the store.
   *
   * @param name the name
   * @param description the description
   * @return true, if successful
   */
  public boolean addSection(String name, String description) {
    Section section = getSection(name);

    // Create a new Section if existingSection is null
    if (section == null) {
      section = new Section(name, description);
      sections.add(section);
      return true;
    }

    return false;
  }

  /**
   * Adds the aisle to the Section determined by sectionName.
   *
   * @param sectionName the section name
   * @return true, if successful
   */
  public boolean addAisle(String sectionName) {
    Section existingSection = getSection(sectionName);

    // If the Section exists add the new Aisle into the list.
    if (existingSection != null) {
      Aisle newAisle = new Aisle(existingSection);
      existingSection.getAisles().add(newAisle);
      aisles.add(newAisle);
      return true;
    }

    return false;
  }

  /**
   * Adds a Category in the Inventory.
   *
   * @param categoryName the category name
   * @param aisleNum the aisle number
   * @return true, if successful
   */
  public boolean addCategory(String categoryName, int aisleNum) {
    Aisle aisle = getAisle(aisleNum);
    Category category;

    // if the aisle exists then we add this category into the aisle
    if (aisle != null) {
      category = new Category(categoryName, aisle);
      aisle.getCategories().add(category);
      categories.add(category);
      return true;
    }
    return false;
  }

  /**
   * Adds the product.
   *
   * @param productName the product name
   * @param category the category
   * @return true, if successful
   */
  public boolean addProduct(String productName, Category category) {
    Product product = getProduct(productName);

    // adds a new Product if it doesn't exist
    if (product == null) {
      product = new Product(productName);
      category.getProducts().add(product);
      product.setCategory(category);
      products.add(product);
      return true;
    }

    return false;
  }

  /**
   * Gets the section.
   *
   * @param sectionName the section name
   * @return the section
   */
  public Section getSection(String sectionName) {

    // iterate sections, and looks for a match with the
    // section's name and sectionName
    for (Section section : sections) {
      if (section.getName().equals(sectionName)) {
        return section;
      }
    }
    return null;
  }

  /**
   * Gets the aisle.
   *
   * @param aisleNum the aisle num
   * @return the aisle
   */
  public Aisle getAisle(int aisleNum) {
    // current range of aisleNum
    if (aisleNum - 1 < aisles.size()) {
      return aisles.get(aisleNum - 1);
    }
    return null;
  }

  /**
   * Gets the category.
   *
   * @param categoryName the category name
   * @return the category
   */
  public Category getCategory(String categoryName) {
    for (Category category : categories) {
      if (category.getName().equals(categoryName)) {
        return category;
      }
    }
    return null;
  }

  /**
   * Gets the product from the Category.
   *
   * @param productName the product name
   * @return the product
   */
  public Product getProduct(String productName) {
    for (Product product : products) {
      if (product.getName().equals(productName)) {
        return product;
      }
    }
    return null;
  }

  /**
   * Removes the section.
   *
   * @param sectionName the section name
   * @return true, if successful
   */
  public boolean removeSection(String sectionName) {

    Section section = getSection(sectionName);

   
    if (section != null) {
      cleanseAisles(section);
      sections.remove(section);
      return true;
    }
    return false;
  }

  /**
   * Removes the aisle.
   *
   * @param aisleNum the aisle number
   * @return true, if successful
   */
  public boolean removeAisle(int aisleNum) {

    if (aisleNum - 1 < aisles.size()) {

      // get the aisle from our list
      Aisle aisle = aisles.get(aisleNum - 1);

      // find the parent
      Section section = aisle.getSection();

      // remove it from the parent and then remove
      // it from our list
      section.getAisles().remove(aisle);
      aisles.remove(aisle);
      getClass().getName();
      cleanseCategory(aisle);
      return true;
    }
    return false;
  }

  /**
   * Removes the category from the Aisle.
   *
   * @param categoryName the category name
   * @return true, if successful
   */
  public boolean removeCategory(String categoryName) {
    Category category = getCategory(categoryName);

    if (category != null) {
      Aisle aisle = category.getAisle();
      cleanseProduct(category);
      aisle.getCategories().remove(category);
      categories.remove(category);
      return true;
    }
    return false;
  }


  /**
   * Removes the product.
   *
   * @param productName the product name
   * @return true, if successful
   */
  public boolean removeProduct(String productName) {
    Product product = getProduct(productName);

    if (product != null) {
      Category category = product.getCategory();
      category.getProducts().remove(product);
      products.remove(product);
      return true;
    }
    return false;
  }


  /**
   * Deletes aisles whose parent is this section.
   *
   * @param section the section
   */
  private void cleanseAisles(Section section) {
    Iterator<Aisle> iter = aisles.iterator();

    while (iter.hasNext()) {
      Aisle aisle = iter.next();
      if (aisle.getSection() == section) {
        cleanseCategory(aisle);
        iter.remove();
      }
    }
  }

  /**
   * Deletes categories whose parent is this aisle.
   *
   * @param aisle the aisle
   */
  private void cleanseCategory(Aisle aisle) {
    Iterator<Category> iter = categories.iterator();

    while (iter.hasNext()) {
      Category category = iter.next();

      if (category.getAisle() == aisle) {
        cleanseProduct(category);
        iter.remove();
      }
    }
  }

  /**
   * Deletes products whose parent is this category.
   * 
   * @param category
   */
  private void cleanseProduct(Category category) {
    Iterator<Product> iter = products.iterator();

    while (iter.hasNext()) {
      Product product = iter.next();

      if (product.getCategory() == category) {
        iter.remove();
      }
    }
  }
  
  public void store() throws IOException{
    WriteToFile.location(sections, aisles, categories, products);
  }
  
  public void load() throws ClassNotFoundException, IOException {
    
    this.sections = WriteToFile.setSection();
    this.aisles = WriteToFile.setAisles();
    this.categories = WriteToFile.setCategories();
    this.products = WriteToFile.setProducts();
  }
}
