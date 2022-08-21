package players;
/**
 *  Adventure Game -player tester
 * @author Kyeongtak Han
 */
public class PlayerTester {

	public static void main(String[] args) {
		Player kni = new Knight("Tak");
		System.out.println("This is a maxFatigue " + kni.getMaxFatigue() +" This is a max Step " + kni.getSteps());
		kni.stepsInMud();
		if(kni.equals("Knight")) {
			System.out.println("Yes!");
		}
	}

}
