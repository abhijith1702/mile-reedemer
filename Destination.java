

public class Destination {

	private String nameOfTheDestinationCity;						//Variable for reading destination city from file
	private int normalMilesRequired;								//Variable for reading normal miles from file
	private int flyCheapMiles;										//Variable for reading fly cheap miles from file
	private int additionalMilesForUpgrading;						//Variable for reading additional miles required for upgrading from file
	private int startMonthOfProgram;								//Variable for reading start month of fly cheap miles program from file
	private int endMonthOfProgram;									//Variable for reading end month of fly cheap miles program from file

	
	//Getters and setters for the above private variables
	public String getNameOfTheDestinationCity() {
		return nameOfTheDestinationCity;
	}

	public void setNameOfTheDestinationCity(String nameOfTheDestinationCity) {
		this.nameOfTheDestinationCity = nameOfTheDestinationCity;
	}

	public int getNormalMilesRequired() {
		return normalMilesRequired;
	}

	public void setNormalMilesRequired(int normalMilesRequired) {
		this.normalMilesRequired = normalMilesRequired;
	}

	public int getFlyCheapMiles() {
		return flyCheapMiles;
	}

	public void setFlyCheapMiles(int flyCheapMiles) {
		this.flyCheapMiles = flyCheapMiles;
	}

	public int getAdditionalMilesForUpgrading() {
		return additionalMilesForUpgrading;
	}

	public void setAdditionalMilesForUpgrading(int additionalMilesForUpgrading) {
		this.additionalMilesForUpgrading = additionalMilesForUpgrading;
	}

	public int getStartMonthOfProgram() {
		return startMonthOfProgram;
	}

	public void setStartMonthOfProgram(int startMonthOfProgram) {
		this.startMonthOfProgram = startMonthOfProgram;
	}

	public int getEndMonthOfProgram() {
		return endMonthOfProgram;
	}

	public void setEndMonthOfProgram(int endMonthOfProgram) {
		this.endMonthOfProgram = endMonthOfProgram;
	}

	//Parameterized constructor
	public Destination(String nameOfTheDestinationCity, int normalMilesRequired, int flyCheapMiles,
			int additionalMilesForUpgrading, int startMonthOfProgram, int endMonthOfProgram) {

		this.nameOfTheDestinationCity = nameOfTheDestinationCity;
		this.normalMilesRequired = normalMilesRequired;
		this.flyCheapMiles = flyCheapMiles;
		this.additionalMilesForUpgrading = additionalMilesForUpgrading;
		this.startMonthOfProgram = startMonthOfProgram;
		this.endMonthOfProgram = endMonthOfProgram;
	}

}
