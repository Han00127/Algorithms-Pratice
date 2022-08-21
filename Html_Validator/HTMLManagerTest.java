
// This testing program stub creates a queue of HTML tags
// in a valid sequence.
// You may use this as a starting point for testing
// your removeAll method.
import java.util.*;

public class HTMLManagerTest {
	public static void main(String[] args) {
		// <b>Hi</b><br/>
		Queue<HTMLTag> tags = new LinkedList<HTMLTag>();
		tags.add(new HTMLTag("br", HTMLTagType.SELF_CLOSING));      // <b>
		tags.add(new HTMLTag("P", HTMLTagType.CLOSING));     // </b>
		tags.add(new HTMLTag("i", HTMLTagType.CLOSING));     // </b>
		tags.add(new HTMLTag("br", HTMLTagType.SELF_CLOSING));           // <br/>
		tags.add(new HTMLTag("b", HTMLTagType.CLOSING));
		tags.add(new HTMLTag("i", HTMLTagType.CLOSING));
		tags.add(new HTMLTag("b", HTMLTagType.CLOSING));

		HTMLManager manager = new HTMLManager(tags);
		manager.removeAll(new HTMLTag("b", HTMLTagType.OPENING));
		System.out.println("Here is previous one " + manager);

		manager.add(new HTMLTag("b", HTMLTagType.OPENING));
		manager.removeAll(new HTMLTag("b", HTMLTagType.CLOSING));
		manager.fixHTML();
		System.out.println("This is fixed one " + manager.toString());
		Queue<HTMLTag> tags2 = new LinkedList<HTMLTag>();
		tags2.add(new HTMLTag("abc",HTMLTagType.SELF_CLOSING));
		tags2.add(new HTMLTag("",HTMLTagType.CLOSING));

		HTMLManager manager2 = new HTMLManager(tags2);

		System.out.println(manager2.toString());
	}
}
