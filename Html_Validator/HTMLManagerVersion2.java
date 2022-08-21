
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
/**
 * HTMLValidator
 * @author Kyeongtak Han
 * This class is called HTMLManager. This class will perform operations which are add, removeAll,
 * getTags and fixHTML. This class uses the HTMLTag type that classified in HTMLTag class.
 *
 */


public class HTMLManagerVersion2 {
	// instance fields
	private Queue<HTMLTag> tags;

	// Constructor that takes the Queue as a parameter. Also, check out the IllegalArgument.
	// if not, store the tags into field.
	public HTMLManagerVersion2(Queue<HTMLTag> page) {
		// I add this checkNull. This checkNull is my private own method to check out the valid parameter
		//and to avoid the redundancy.
		if(page == null) {
			throw new IllegalArgumentException();
		}
		tags = new LinkedList<HTMLTag>();
		// the reason why I use the for each loop is that I didn't change the page Queue.
		for (HTMLTag content : page) {
			tags.add(content);
		}
	}
    // Add method that takes a tag then add the value into tags Queue.
	public void add(HTMLTag tag) {
		// I specified this method to avoid the redundancy. If tag is null, then throw IllegalArgument
		if(tag == null) {
			throw new IllegalArgumentException();
		}
		tags.add(tag);
	}


	// removeAll method that takes a HTMLTag parameter then removes the correspond value in the Queue.
	public void removeAll(HTMLTag tag) {
		if(tag == null) {
			throw new IllegalArgumentException();
		}
		// Local variable to keep the original size of Queue. Because if I use the queue.size directly, it doesn't work well.
		int size = tags.size();
		for (int i = 0; i < size; i++) {
			HTMLTag t = tags.remove();
			if (!t.equals(tag)) {
				tags.add(t);
			}
		}
	}

	// This is a getter to access our field value.
	public Queue<HTMLTag> getTags() {
		return tags;
	}

	public void fixHTML() {
		// This is to store the opening symbol. Then, it starts with the empty.
		Stack<HTMLTag> storage = new Stack<HTMLTag>();
		// This Queue is to store the total symbol.
		Queue<HTMLTag> output = new LinkedList<HTMLTag>();

		// This oldSize is to keep the size. In this case, I'm not going to remove and add. Because I'll copy the
		// my output queue to my original.
		int oldSize = tags.size();
	    for (int i = 0; i < oldSize; i++) {
	    	HTMLTag t = tags.remove();
		   	if (t.isOpening()) {
	    		// stores the value in my storage stack.
		   		storage.push(t);
		   		// stores the value in output queue.
	    		output.add(t);
	    	} else if (t.isSelfClosing()) {
		   		output.add(t);
		   	}
		   	// This is the key point in this method.
		   	// pre - value is the closing value and storage stack is not empty
	 		else if (t.isClosing() && !storage.isEmpty()) {
				// pop off the latest the opening value from stack.
	 			HTMLTag openingValue = storage.pop();

	 			// current closing symbol and
				if (!t.matches(openingValue)) {
	   		    	HTMLTag correctValue = openingValue.getMatching();
	   		    	output.add(correctValue);
	   		    }
				else if (t.matches(openingValue)){
					output.add(t);
			    }
	        }
	    }
        // This is for the rest stack. If there is value in stack, to make a matching value.
		while(!storage.isEmpty()) {
			for(int i = 0; i < storage.size(); i++) {
				HTMLTag last = storage.pop();
				HTMLTag lastValue = last.getMatching();
				output.add(lastValue);
			}
		}

		// Copy the output Queue and paste it to original Queue.
		for(int i=0; i< output.size();i++) {
			HTMLTag tag = output.remove();
			tags.add(tag);
			output.add(tag);
		}
	}
}
