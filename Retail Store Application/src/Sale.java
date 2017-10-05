import java.text.ParseException;
//TODO: redo javaDoc for subclasses
/**
 * Sale interface to apply and get the type of sale on each product.
 *
 */
public interface Sale
{
	/**
	 * Apply Sale on a particular product.
	 * @param product : Product to which sale is applied
	 */
	public void applySale(Product product);
	/**
	 * Returns the Sale percentage or dollar value
	 * @return double
	 */
	public String getSale();

	/**
	 * Getter method for start date.
	 * @return Start date
	 */
	public String getStartDate();

	/**
	 * Getter method for end date.
	 * @return End date
	 */
	public String getDateEnd();

	
	/**
	 * Getter method to get the amount.
	 * @return The dollar value.
	 */
	public String getAmount();
}
