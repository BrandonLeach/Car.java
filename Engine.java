package Alpha;


public class Engine extends CarParts{
	private long creationTime;
	private float lifeInMinutes;
	
	/* CONSTRUCTOR */
	

	public Engine(float yearsOld) {
		super("engine", " years left", 10);
		this.creationTime = System.currentTimeMillis();
		this.lifeInMinutes = 0;
	}
	
	/* GETTERS */
	
	

	public float getLifeInMinutes() { return this.lifeInMinutes; }
	
	/* SETTERS */
	
	
	public void replacePart() {
		super.replacePart();
		this.lifeInMinutes = 0;
	}
	
	public void function(float milesDriven) throws CarBrokenDownException {
		super.function(milesDriven);
		this.lifeInMinutes = (System.currentTimeMillis() - this.creationTime) / 60000f;
		this.setCondition(this.bestCondition - lifeInMinutes);
		if (this.condition <= 0) {
			this.brokenCar();
		} else if (this.condition <= 2) {
			this.status("Your engine is getting old!");
			if (getBoolean("Replace?")) {
				this.replacePart();
				this.status("Engine replaced!");
			}
		} else {
			this.status("You'll need a new engine in " + this.condition + " years.");
		}
	}

}
