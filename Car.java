package Alpha;

import java.util.ArrayList;
import java.util.Iterator;

public class Car implements vwInterface {
	private ArrayList<CarParts> parts = new ArrayList<>();
	
	/* CONSTRUCTOR */
	
	public Car() {
		this.parts.add(new FuelTank(17.2f, 35));
		this.parts.add(new Engine(0));
		for (int t = 0; t<4; t++) {
			this.parts.add(new Wheels(32));
		}
	}
	
	/* GETTERS */
	
	public String getParts() { return toString(this.parts); }
	
	public String toString(ArrayList<CarParts> partsList) {
		String result = "";
		for (Iterator<CarParts> iter = partsList.iterator(); iter.hasNext();) {
			result += ((CarParts) iter.next()).partName + "\n";
		}
		return result;
	}
	
	public void status() {
		for (Iterator<CarParts> iter = this.parts.iterator(); iter.hasNext();) {
			iter.next().status();
		}
	}
	
	public void run() {
		try {
			do {
				float miles = getFloat("How many miles are you driving?");
				
				Engine engine = null;
				for (int p = 0; p<parts.size(); p++) {
					parts.get(p).function(miles);
					if (parts.get(p).partName == "engine") { engine = (Engine) parts.get(p); }
				}
				// The oil tank's behavior is affected by the engine's age in years,
				// which are actually real-life minutes.
				//oTank.setEngineAgeModifier(1 + (engine.getLifeInMinutes() / engine.getBestCondition()));//
			} while (getBoolean("Keep driving?"));
			this.status();
		} catch (CarBrokenDownException e) {
			System.out.println(e.getMessage());
			System.out.println("Your car crashed! You'll have to buy a new one and start over.");
		} finally {
			System.out.println("Thank you for driving responsibly.");
	
	}
  }

}
