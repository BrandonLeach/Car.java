package Alpha;

public class FuelTank extends CarParts {
	private float milesPerGallon;
	
	// CONSTRUCTOR //
	
	public FuelTank(float capacityGallons, float milesPerGallon) {
		super("Fuel Tank", " Gallons", capacityGallons);
		this.milesPerGallon = milesPerGallon;
	}
	
	// GETTERS //

	public float getMPG() { return this.milesPerGallon; }
	
	// SETTERS //
	
	public void fillTank(float numOfGallons) {
		float remainder = this.bestCondition - this.condition;
		if (this.condition < 0) {
			this.status("you can not have a negative number! Adding "
					+ remainder + "amount of gallons to reach capacity.");
			this.setCondition(this.bestCondition);
		} else if (numOfGallons > remainder) {
			this.status("over filling! Only adding " + remainder + " Gallons to reach a Full Tank.");
			this.setCondition(this.bestCondition);
		} else {
			this.status("Adding " + numOfGallons + " Gallons. You now have "
					+ this.condition + numOfGallons + " Gallons.");
			this.changeCondition(numOfGallons);
		}
	}
	
	public void function(float milesDriven) throws CarBrokenDownException{
		super.function(milesDriven);
		float gallonsConsumed = milesDriven / this.milesPerGallon;
		this.changeCondition(-1 * gallonsConsumed);
		if (this.condition <= 0) {
			this.brokenCar();
		} else if (this.condition <= (this.bestCondition / 4)) {
			this.status("Low on Fuel!");
			if (getBoolean("Topped Off?")) {
				this.fillTank(getFloat("How much Fuel?"));
			}
		}
		if ((this.condition / this.bestCondition) < 0.5) {
			this.status("You NEED to Stop for FUEL!.");
		} else {
			this.status("You have Fuel.");
		   }
	  }
 }
