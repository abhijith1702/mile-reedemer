

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Collections;

public class MileRedeemer {

	private ArrayList<Destination> destinationList;									//Global variable for storing the data read from file
	private int remainingMiles = 0;													//Global variable for storing the remaining miles consequently

	public void readDestinations(Scanner fileScanner) throws FileNotFoundException {

		destinationList = new ArrayList<Destination>();								//Initialising the arraylist

		Scanner scanner = new Scanner(new File(fileScanner.next()));				//Reading the data from file into scanner

		while (scanner.hasNextLine()) {												//Reading line by line until there is no data in file

			String line = scanner.nextLine();										//Storing the data of one line into string

			String[] split = line.split(";");										//Setting the delimiter to set variables of the destination class

			String[] monthsSplit = split[4].split("-");								//Setting the delimiter to set start month and end month

			Destination dest = new Destination(split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2]),		//Setting values using parameterized constructor
					Integer.parseInt(split[3]), Integer.parseInt(monthsSplit[0]), Integer.parseInt(monthsSplit[1]));

			destinationList.add(dest);												//Adding each class to the list of destination classes
		}
		scanner.close();															//Closing the scanner close for security purpose
		Destination[] destinationArray = (Destination[]) destinationList			//Converting arraylist to destination array
				.toArray(new Destination[destinationList.size()]);
		Arrays.sort(destinationArray, new MileageComparator());						//Sorting the destination objects based on the normalMilesRequired for redeeming

		destinationList.removeAll(destinationList);									//Removing the elements from arraylist and adding the sorted list into arraylist
		Collections.addAll(destinationList, destinationArray);		

	}

	
	//Comparator for arranging objects based on the normalMilesRequired for redeeming
	public class MileageComparator implements Comparator<Destination> {
		public int compare(Destination d1, Destination d2) {
			return (d2.getNormalMilesRequired() - d1.getNormalMilesRequired());
		}
	}

	//Extracting city names to display them to user
	public String[] getCityNames() {

		String[] cities = new String[destinationList.size()];						//Initializing a string array  for storing the city details

		int counterIndex = 0;														

		for (Destination dest : destinationList) {

			cities[counterIndex] = dest.getNameOfTheDestinationCity();				//Setting each city into a indexed array of strings 
			counterIndex++;

		}
		Arrays.sort(cities);														//Sorting the array in alphabetical order
		return cities;

	}

	public String[] redeemMiles(int miles, int month) {
		String resultMessage = "";
		String[] resultMessageForCustomer = new String[destinationList.size()];		//Initializing a string array for storing the data that needs to be displayed to customer
		Destination[] destinationArray = new Destination[destinationList.size()];	
		int index = 0;

		// Check whether to use normal miles or fly cheap miles
		for (Destination dest : destinationList) {
			if (dest.getStartMonthOfProgram() <= month && month <= dest.getEndMonthOfProgram()) {		//Check for fly cheap

				if (miles - dest.getFlyCheapMiles() > 0) {
					remainingMiles = miles - dest.getFlyCheapMiles();									//Reducing the remaining miles after redemption calculation
					resultMessage = "A trip to " + dest.getNameOfTheDestinationCity() + " in "			//Setting the response output string
							+ "Economy" + " Class ";
					resultMessageForCustomer[index] = resultMessage;
					destinationArray[index] = dest;
					index++;
					miles = remainingMiles;
				} else {
					remainingMiles = miles;
				}

			} else {
				if (miles - dest.getNormalMilesRequired() > 0) {
					remainingMiles = miles - dest.getNormalMilesRequired();
					resultMessage = "A trip to " + dest.getNameOfTheDestinationCity() + " in "
							+ "Economy" + " Class ";
					resultMessageForCustomer[index] = resultMessage;
					destinationArray[index] = dest;

					index++;
					miles = remainingMiles;

				} else {
					remainingMiles = miles;
				}
			}
		}

		for (int i = 0; i < index; i++) {
			if (destinationArray[i].getAdditionalMilesForUpgrading() <= miles) {					//Checking for any possible upgrades
				resultMessageForCustomer[i] = "A trip to " + destinationArray[i].getNameOfTheDestinationCity()
						+ " in First Class";
				remainingMiles = miles - destinationArray[i].getAdditionalMilesForUpgrading();
				miles = remainingMiles;
			}
		}

		return resultMessageForCustomer;

	}

	public int getRemainingMiles() {
		return remainingMiles;
	}

}
