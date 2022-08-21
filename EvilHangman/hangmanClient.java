import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Evil Hangman
 * @author Kyeongtak Han
 * This class is called Hangman manager. This class will perform lots operations which are
 * record, making pattern etc. The key point for this class is that this program reproduce the format
 * and generate new set of words.
 */
public class hangmanClient {

	public static void main(String[] args) {
		String [] words = {"ally", "beta", "cool", "deal", "else", "flew", "good", "hope", "ibex"};
		List<String> dic = new ArrayList<String>(Arrays.asList(words));
		HangmanManager game = new HangmanManager(dic,4,7);

	}

}
