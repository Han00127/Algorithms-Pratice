
/**
 * 20 Questions 
 * @author Kyeongtak Han
 * The QuestionNode represents a node in a binary tree. This QuestionNode class is almost same with IntTreeNode class
 * The difference is that The node stores String data representing an answer or a question. An ANSWER node has a null left and right node. A QUESTION node has a
 * left node which points to a "Yes" branch and a right node which points to a "No" branch.
 */

public class QuestionNode {

    public String data;
    public QuestionNode left;
    public QuestionNode right;

    /**
     * One parameter constructor
     * @param data - string which represents a question or answer
     */
    public QuestionNode(String data) {
        this.data = data;
        this.left=null;
        this.right=null;
    }

   /**
    * This method indicates if the QuestionNode is an ANSWER or a QUESTION
    * @return true if the QuestionNode represents a Question and false if the QuestionNode represents an Answer
    */
    public boolean isQuestion() {
        return right != null && left != null;
    }
}
