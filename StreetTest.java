import static org.junit.Assert.assertEquals;

import org.junit.*;

public class StreetTest {

	public StreetTest() {
			
	}
	

	@Test (expected = StreetException.class)
	public void StreetInputZero() throws StreetException {
		Street<Car> mainStreet = new Street<Car>(0);
	}
	
	@Test
	public void GetCapacity() throws StreetException {
		Street<Car> mainStreet = new Street<Car>(5);
		assertEquals(5, mainStreet.getCapacity());
	}
	
	@Test
	public void AddSuv() throws StreetException {
		Street<Car> mainStreet = new Street<Car>(1);
		Suv suv1 = new Suv("Ford", "Bronco", 2012, 23000);
		mainStreet.add(suv1);
		assertEquals(mainStreet.returnCar(0), suv1.ToString());
	}
	
	@Test
	public void AddSuvAndEcon() throws StreetException {
		Street<Car> mainStreet = new Street<Car>(2);
		Suv suv1 = new Suv("Ford", "Bronco", 2012, 23000);
		Economy econ1 = new Economy("Chevy", "Sonic", 2014, 16000);
		mainStreet.add(suv1);
		mainStreet.add(econ1);
		assertEquals(mainStreet.returnCar(0), suv1.ToString());
		assertEquals(mainStreet.returnCar(0), suv1.ToString());
	}
	
	@Test (expected = StreetException.class)
	public void RemoveNonExistCar() throws StreetException {
		Street<Car> mainStreet = new Street<Car>(1);
		Suv suv1 = new Suv("Ford", "Bronco", 2012, 23000);
		mainStreet.remove(suv1);
	}
	
	@Test (expected = StreetException.class)
	public void AddDuplicateCar() throws StreetException {
		Street<Car> mainStreet = new Street<Car>(1);
		Suv suv1 = new Suv("Ford", "Bronco", 2012, 23000);
		mainStreet.add(suv1);
		mainStreet.add(suv1);
	}
	
	
	@Test 
	public void SimulationValues() throws StreetException {
		Street<Car> mainStreet = new Street<Car>(3);
		Suv suv1 = new Suv("Ford", "Bronco", 2012, 2000);
		mainStreet.add(suv1);
		Economy econ1 = new Economy("Chevy", "Spark", 2012, 15000);
		mainStreet.add(econ1);
		Full full1 = new Full("Kia", "Optima", 2012, 18000);
		mainStreet.add(full1);
		mainStreet.printAllCars();
		mainStreet.simulate(0);
		mainStreet.printAllCars();

	}
	
	
	/*•	If the car that a Full is crashing with is an Economy
		- The value of the Economy drops by 20% or $2500 whichever is greater
		- The value of the Full drops by 9% or $1400 whichever is greater
		*/
	@Test 
	public void CrashFullEcon() throws StreetException {
		Full fullLow = new Full("Ford", "Firbird", 2012, 15000);
		Full fullHigh = new Full("Ford", "crownVic", 2012, 23000);
		Economy econLow = new Economy("Electric", "Elo", 2012, 11000);
		Economy econHigh = new Economy("Electric", "Elo", 2012, 23000);
		fullLow.crash(econLow);
		fullHigh.crash(econHigh);
		//fulllow.value -= 1400
		assertEquals(13600, fullLow.value);
		//econlow.value -= 2500
		assertEquals(8500, econLow.value);
		//fullHigh.value -= 9%
		assertEquals(20930, fullHigh.value);
		//econHigh.value -= 20%
		assertEquals(18400, econHigh.value);
	}
	@Test 
	public void CrashEconFull() throws StreetException {
		Full fullLow = new Full("Ford", "Firbird", 2012, 15000);
		Full fullHigh = new Full("Ford", "crownVic", 2012, 23000);
		Economy econLow = new Economy("Electric", "Elo", 2012, 11000);
		Economy econHigh = new Economy("Electric", "Elo", 2012, 23000);
		econLow.crash(fullLow);
		econHigh.crash(fullHigh);
		//fulllow.value -= 1400
		assertEquals(13600, fullLow.value);
		//econlow.value -= 2500
		assertEquals(8500, econLow.value);
		//fullHigh.value -= 9%
		assertEquals(20930, fullHigh.value);
		//econHigh.value -= 20%
		assertEquals(18400, econHigh.value);
	}
	
	/*•	If the car that a Full size is crashing at is a SUV
		- The value of the SUV drops by %5 or $800 whichever is greater
		- The value of the Full size drops by 10% or $1000 whichever is greater
	 */
	@Test 
	public void CrashFullSuv() throws StreetException {
		Full fullLow = new Full("Ford", "Firbird", 2012, 9000);
		Full fullHigh = new Full("Ford", "crownVic", 2012, 20000);
		Suv suvHigh = new Suv("Sharpie", "Spen", 2012, 17000);
		Suv suvLow = new Suv("Sharpie", "Spen", 2012, 11000);
		fullLow.crash(suvLow);
		fullHigh.crash(suvHigh);
		//fulllow.value -= 1000
		assertEquals(8000, fullLow.value);
		//suvlow.value -= 800
		assertEquals(10200, suvLow.value);
		//fullHigh.value -= 10%
		assertEquals(18000, fullHigh.value);
		//suvHigh.value -= 5%
		assertEquals(16150, suvHigh.value);
	}
	@Test 
	public void CrashSuvFull() throws StreetException {
		Full fullLow = new Full("Ford", "Firbird", 2012, 9000);
		Full fullHigh = new Full("Ford", "crownVic", 2012, 20000);
		Suv suvHigh = new Suv("Sharpie", "Spen", 2012, 17000);
		Suv suvLow = new Suv("Sharpie", "Spen", 2012, 11000);
		suvLow.crash(fullLow);
		suvHigh.crash(fullHigh);
		//fulllow.value -= 1000
		assertEquals(8000, fullLow.value);
		//suvlow.value -= 800
		assertEquals(10200, suvLow.value);
		//fullHigh.value -= 10%
		assertEquals(18000, fullHigh.value);
		//suvHigh.value -= 5%
		assertEquals(16150, suvHigh.value);
	}
	
	/*•	If the Car that a SUV is crashing with is an Economy
		- The value of the Economy drops by 25% or $3000 whichever is greater
		- The value of the SUV drops by 4% or $600 whichever is greater
	 */
	@Test 
	public void CrashSuvEcon() throws StreetException {
		Economy econLow = new Economy("Electric", "Elo", 2012, 11000);
		Economy econHigh = new Economy("Electric", "Elo", 2012, 23000);
		Suv suvHigh = new Suv("Sharpie", "Spen", 2012, 27000);
		Suv suvLow = new Suv("Sharpie", "Spen", 2012, 7000);
		suvLow.crash(econLow);
		suvHigh.crash(econHigh);
		//econlow.value = 11000 - 3000
		assertEquals(8000, econLow.value);
		//suvlow.value = 7000 - 600
		assertEquals(6400, suvLow.value);
		//econHigh.value = 23000 - (23000 * 25%)
		assertEquals(17250, econHigh.value);
		//suvHigh.value -= 27000 - (27000 * 4%)
		assertEquals(25920, suvHigh.value);
	}
	@Test 
	public void CrashEconSuv() throws StreetException {
		Economy econLow = new Economy("Electric", "Elo", 2012, 11000);
		Economy econHigh = new Economy("Electric", "Elo", 2012, 23000);
		Suv suvHigh = new Suv("Sharpie", "Spen", 2012, 27000);
		Suv suvLow = new Suv("Sharpie", "Spen", 2012, 7000);
		econLow.crash(suvLow);
		econHigh.crash(suvHigh);
		//econlow.value = 11000 - 3000
		assertEquals(8000, econLow.value);
		//suvlow.value = 7000 - 600
		assertEquals(6400, suvLow.value);
		//econHigh.value = 23000 - (23000 * 25%)
		assertEquals(17250, econHigh.value);
		//suvHigh.value -= 27000 - (27000 * 4%)
		assertEquals(25920, suvHigh.value);
	}
	
	/*•	If the vehicle that SUV car is crashing with is another SUV 
		-The value of the both SUV drop by 10% or $1500 whichever is greater
	*/
	@Test 
	public void CrashSuvSuv() throws StreetException {
		Suv suvHigh = new Suv("Sharpie", "Spen", 2012, 27000);
		Suv suvLow = new Suv("Sharpie", "Spen", 2012, 7000);
		suvLow.crash(suvHigh);
		//suvlow.value = 7000 - 1500
		assertEquals(5500, suvLow.value);
		//suvHigh.value = 27000 - (27000 * 10%)
		assertEquals(24300, suvHigh.value);
	}

	/*•	If the vehicle that a car is crashing with is another Full size 
		-The value of the one with lesser value drops by 7% or $1500 whichever is greater
		-The value of the one with greater value drops by 9% or $2000 whichever is greater
	*/
	@Test 
	public void CrashFullFull() throws StreetException {
		Full fullLowest = new Full("Ford", "F", 2012, 9000);
		Full fullLow = new Full("Ford", "Firbird", 2012, 22000);
		Full fullHigh = new Full("Ford", "crownVic", 2012, 20000);
		Full fullHighest = new Full("Ford", "crownVic", 2012, 28000);
		fullLowest.crash(fullHigh);
		fullLow.crash(fullHighest);		
		//fulllowest.value = 9000 - 1500
		assertEquals(7500, fullLowest.value);
		//fulllow.value = 22000 - (22000 * 7%)
		assertEquals(20460, fullLow.value);
		//fullHigh.value = 20000 - 2000
		assertEquals(18000, fullHigh.value);
		//fullHighest.value = 28000 - (28000 * 9%)
		assertEquals(25480, fullHighest.value);
	}
	
	/*•	If the vehicle that a car is crashing with is another Economy 
		-The value of the one with lesser value drops by 6% or $1000 whichever is greater
		-The value of the one with greater value drops by 9% or $1200 whichever is greater
	 */
	@Test 
	public void CrashEconEcon() throws StreetException {
		Economy econLowest = new Economy("Electric", "Elo1", 2012, 5000);
		Economy econLow = new Economy("Electric", "Elo2", 2012, 18000);
		Economy econHigh = new Economy("Electric", "Elo3", 2012, 13000);
		Economy econHighest = new Economy("Electric", "Elo4", 2012, 23000);
		econLowest.crash(econHigh);
		econLow.crash(econHighest);
		//lowest.value = 5000 - 1000
		assertEquals(4000, econLowest.value);
		//low.value = 18000 - (18000 * 6%)
		assertEquals(16920, econLow.value);
		//High.value = 13000 - 1200
		assertEquals(11800, econHigh.value);
		//Highest.value =(23000 * 81%)
		assertEquals(20930, econHighest.value);
	}
	
}
