



import java.io.FileNotFoundException;
import java.util.Scanner;

public class MileRedemptionApp {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner userInput = new Scanner(System.in);
		String yesOrNo = "";

		MileRedeemer redeem = new MileRedeemer();

		System.out.println("Please enter the name of the file: ");

		redeem.readDestinations(userInput);								//Passing the file name to read destinations method

		System.out.println("-------------------------------------------------");
		System.out.println("WELCOME TO THE JAVA AIRLINES MILES REDEMPTION APP");
		System.out.println("-------------------------------------------------");

		System.out.println("List of destination cities your client can travel to:");
		String[] cities = redeem.getCityNames();						//Retrieving the city names 

		for (int i = 0; i < cities.length; i++) {
			System.out.println(cities[i]);
		}

		System.out.println("----------------------------------------------------------------");

		do {

			System.out.println("Please enter your client's accumulated Frequent Flyer Miles:");
			int miles = userInput.nextInt();

			System.out.println("Please enter your client's month of departure (1-12):");
			int month = userInput.nextInt();

			String[] redeemMilesResultMsg = redeem.redeemMiles(miles, month);

			if (!isEmptyStringArray(redeemMilesResultMsg)) {						//Checking if the response string array is empty or null
				System.out.println("Your client's Frequent Flyer Miles can be used to redeem the following tickets:");
				for (int i = 0; i < redeemMilesResultMsg.length; i++) {

					if (redeemMilesResultMsg[i] != null)
						System.out.println(redeemMilesResultMsg[i]);
				}
			} else {
				System.out.println("*** Your client has not accumulated enough Frequent Flyer Miles ***");
			}
			System.out.println("Your client's remaining Frequent Flyer Miles:" + redeem.getRemainingMiles());

			System.out.println("----------------------------------------------------------------");
			System.out.println("Do you want to continue (y/n)? ");					//Taking the usr input whether to continue or terminate the app
			yesOrNo = userInput.next();		

		} while (yesOrNo.equalsIgnoreCase("yes") || yesOrNo.equalsIgnoreCase("y"));

		System.out.println("-------------------------------------------------------------------------");
		System.out.println("THANK YOU FOR USING THE JAVA AIRLINES FREQUENT FLYER MILES REDEMPTION APP");
		System.out.println("-------------------------------------------------------------------------");
		
		userInput.close();                 											//Closing the scanner
	}

	public static boolean isEmptyStringArray(String[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] != null) {
				return false;
			}
		}
		return true;
	}

}
