import java.util.ArrayList;
import java.util.logging.Level;

/**
 * The Class QueryDatabase. Stores all Queries.
 */


public class QueryDatabase {

  private ArrayList<Query> queries;

  /**
   * Instantiates a new query database.
   */
  public QueryDatabase() {
    queries = new ArrayList<>();
  }

  /**
   * Add query into the database. Returns true if successful.
   *
   * @param question the query
   */
  public boolean addQuery(String question) {
    // Check if this question exists as a Query object
    for (Query query: queries) {
      if (query.getQuestion().equals(question)) {
        MyLogging.log(Level.INFO, this.getClass().getName() + 
            ": this question exists already in the Query Database.");
        return false;
      }
    }
    
    // Create a query
    Query query = new Query(question);
    MyLogging.log(Level.INFO, this.getClass().getName() + 
        ": added to Query Database.");
    queries.add(query);
    return true;
  }

  /**
   * It removes query from the QueryDatabase. Returns True if successful.
   *
   * @param query the query to be removed from the database
   */
  public boolean removeQuery(String question) {
    Query query = getQuery(question);
    
    if (query != null) {

      MyLogging.log(Level.INFO, this.getClass().getName() + 
          ": Query[" + query.getQuestion() + "] has been removed");
      queries.remove(query);
      return true;
    } else {
      MyLogging.log(Level.INFO, this.getClass().getName() + 
          "the question [" + question + "] does not exist in the" +
          " QueryDatabase");
      return false;
    }
  }
  
  /**
   * Gets the query specified by the String question.
   *
   * @param query the query
   * @return the query
   */
  public Query getQuery(String question) {
    Query foundQuery = null;
    for (Query query : queries) {
      if (question.equals(query.getQuestion())) {
        foundQuery = query;
      }
    }
    return foundQuery;
  }
  
  /**
   * Sets the answer given by the String question.
   *
   * @param question the question
   * @param answer the answer
   * @return true, if successful
   */
  public boolean setAnswer(String question, String answer) {
    Query query = getQuery(question);
    
    if (query != null) {
      query.answer(answer);
      return true;
    } else {
      return false;
    }
  }
}
