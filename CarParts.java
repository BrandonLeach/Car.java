package Alpha;

public abstract class CarParts implements Functional, vwInterface {
	
	private static long instanceCount = 0;
	
	protected String partName;
	protected long serialNumber;
	protected float bestCondition;
	protected String conditionMeasure;
	
	protected float condition;
	protected float currentTotalMiles;
	
	//GETTERS//

	public CarParts(String name, String conditionMeasure,float bestCondition) {
		instanceCount += 1;
		this.serialNumber = instanceCount;
		this.partName = name;
		this.bestCondition = bestCondition;
		this.conditionMeasure = conditionMeasure;
		this.condition = this.bestCondition;
		this.currentTotalMiles =0;
	}

public String getPartName( ) {return this.partName;}
public long getSerialNumber() { return this.serialNumber;}
public float getBestondition() { return this.bestCondition;}
public String getConditionMeasure() {return this.conditionMeasure;}

public boolean isBroken() { return this.condition <=0;}
public boolean isNotBroken() {return this.bestCondition >= this.bestCondition;}
public float getCondition() { return this.bestCondition;}
public float getCurrentTotalMiles() { return this.currentTotalMiles;}


//SETTERS//

public void setCondition(float newCondition) {
	this.condition = newCondition;
	if(this.condition < 0) {
		this.condition =0;
		
	}else if (this.condition > this.bestCondition) {
		this.condition = this.bestCondition;
	}
}
public void changeCondition(float delta)) {
	this.condition += delta;
	if (this.condition < 0) {
		this.condition = 0;
	} else if (this.condition > this.bestCondition) {
		this.condition = this.bestCondition;
	}
}

public void makeBroken() {
	this.condition = 0;
}

public void replacePart() {
	this.condition = this.bestCondition;
	this.currentTotalMiles = 0;
}

// The status method can accept an extra message
public void status() {
	System.out.println("Your " + this.partName + " (serial #00" + this.serialNumber + ") is at "
			+ this.condition + this.conditionMeasure + ".");
}
public void status(String extraMessage) {
	System.out.print("Your " + this.partName + " ("
			+ this.condition + this.conditionMeasure + ") says: ");
	System.out.println(extraMessage);
}

public void brokenCar() throws CarBrokenDownException {
	throw new CarBrokenDownException("The " + this.partName + " broken down the car!");
}

public void function(float milesDriven) throws CarBrokenDownException {
	this.currentTotalMiles += milesDriven;
}
}
