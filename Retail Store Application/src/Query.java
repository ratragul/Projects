import java.util.logging.Level;
/**
 * The Class Query. Query contains a question and may have an answer.
 */
public class Query {

  private String question;
  private String answer;

  /**
   * Instantiates a new query.
   *
   * @param question the question
   */
  public Query(String question) {

    MyLogging.log(Level.INFO, this.getClass().getName() + 
        ": saved [" + question + "] as an unanswered Query.");
    this.question = question;
  }

  /**
   * Creates an answer for a query.
   *
   * @param answer the answer
   */
  public void answer(String answer) {
    MyLogging.log(Level.INFO, this.getClass().getName() + 
        ": answered [" + question + "] with [" + answer + "]");
    this.answer = answer;
  }
  
  /**
   * Gets the question.
   *
   * @return the question
   */
  public String getQuestion() {

    MyLogging.log(Level.INFO, this.getClass().getName() + 
        ": returned the Query[" + question + "]");
    return question;
  }
  
  /**
   * Gets the answer.
   *
   * @return the answer
   */
  public String getAnswer() {
    MyLogging.log(Level.INFO, this.getClass().getName() + 
        ": returned the answer for the Query[" + question + "]");
    return answer;
  }
}
