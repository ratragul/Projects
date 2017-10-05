import java.io.Serializable;
import java.util.*;

/**
 * Section has a name and a description. A Section contains Aisle.
 */
public class Section  implements Serializable {

    /** The description. */
    private String description;

    /** The name. */
    private String name;

    /** The aisle. */
    private ArrayList<Aisle> aisles;

    /**
     * Instantiates a new section.
     *
     * @param name
     *            the name
     * @param description
     *            the description
     */
    public Section(String name, String description) {
        this.name = name;
        this.description = description;
        aisles = new ArrayList<>();
    }

    /**
     * Change description of the Section.
     *
     * @param description
     *            the description
     */
    public void changeDescription(String description) {
        this.description = description;
    }

    /**
     * Change name of the Section.
     *
     * @param name
     *            the name
     */
    public void changeName(String name) {
        this.name = name;
    }

    /**
     * Gets the description of the Section.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * Gets the name of the Section.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the ArrayList of Aisles.
     *
     * @return the aisles
     */
    public ArrayList<Aisle> getAisles() {
        return aisles;
    }
}