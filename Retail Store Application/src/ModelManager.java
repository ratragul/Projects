/**
 * ModelManager class is responsible for implementing Singleton pattern.
 * 
 */
public class ModelManager {

	private InventoryManager inventoryManager;
	private Finance finance;
	private QueryDatabase queriesDatabase;
	private OrderManager orderManager;

	/**
	 * Method to return instance of InventoryManager class.
	 * 
	 * @return: InventoryManager instance
	 */
	public InventoryManager getInventoryManager() {
		if (inventoryManager == null)
			inventoryManager = new InventoryManager();

		return inventoryManager;
	}

	/**
	 * Method to return instance of Finance class.
	 * 
	 * @return: Finance instance
	 */
	public Finance getFinance() {
		if (finance == null)
			finance = new Finance();

		return finance;
	}

	/**
	 * Method to return instance of QueryDatabase class.
	 * 
	 * @return: QueryDatabase instance
	 */
	public QueryDatabase getQueryDatabase() {
		if (queriesDatabase == null)
			queriesDatabase = new QueryDatabase();

		return queriesDatabase;
	}

	/**
	 * Gets the OrderManager instance.
	 *
	 * @return the order manager
	 */
	public OrderManager getOrderManager() {
		if (orderManager == null)
			orderManager = new OrderManager();

		return orderManager;
	}
}