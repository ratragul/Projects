import java.io.Serializable;
import java.util.ArrayList;

/**
 * Aisle have an aisle number and belongs in a Section. Aisle have multiple
 * categories.
 */
public class Aisle implements Serializable{
  
	private ArrayList<Category> categories;
	private Section section;

	/**
	 * Instantiates a new aisle.
	 *
	 * @param aisleNum
	 *            the aisle number
	 * @param section
	 *            the section
	 */
	public Aisle(Section section) {
		this.section = section;
		categories = new ArrayList<>();
	}

	/**
	 * Sets the section.
	 *
	 * @param section
	 *            the new section
	 */
	public void setSection(Section section) {
		this.section = section;
	}

	/**
	 * Gets the categories.
	 *
	 * @return the categories
	 */
	public ArrayList<Category> getCategories() {
		return this.categories;
	}

	/**
	 * Gets the section that Aisle belongs to.
	 *
	 * @return the section
	 */
	public Section getSection() {
		return section;
	}
}