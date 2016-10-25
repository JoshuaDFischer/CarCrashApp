
public class Street<Type extends Car> {

	private int capacity;
	private int count = 0;
	//private Type[] arrayOfCars=(Type[]) new Car[capacity];
	
	private Type[] arrayOfCars;

	
	public Street(int inputCapacity) throws StreetException{
		if(inputCapacity < 1)
			throw new StreetException("Capacity of Street below 1");
		capacity = inputCapacity;		
		
		arrayOfCars = (Type[]) new Car[capacity];
		//fill every cell with null
		for(int i = 0; i < arrayOfCars.length; i++){
			arrayOfCars[i] = null;
		}
	}
	public Car[] getOccupants(){
		return arrayOfCars;
	}
	public int getCapacity(){
		return capacity;
	}
	public void add(Type car) throws StreetException{		
		
		//Checks for duplicate cars in the array
		for(int i = 0; i< arrayOfCars.length; i++){	
			if(arrayOfCars[i] != null){
				if (arrayOfCars[i].make.equals(car.make)){
					if(arrayOfCars[i].model.equals(car.model)){
						if(arrayOfCars[i].year == car.year){
							throw new StreetException("Make, Model or Year can not match existing");
						}
					}
				}	
			}
		}
		//Checks to make sure array will not go over capacity
		if(count +1 > capacity){
			throw new StreetException("Can not add  more cars, Over Capacity");
		}		
		
		arrayOfCars[count] = car;
		count++;
	}
	
	public void remove(Type car) throws StreetException{
		
		boolean removed = false;
		for(int i = 0; i < arrayOfCars.length; i++){
			if(arrayOfCars[i] != null && arrayOfCars[i].make == car.make){
				if(arrayOfCars[i].model == car.model){
					if(arrayOfCars[i].year == car.year){
						arrayOfCars[i] = null;/*
						//loop to shift everything left 
						if((i + 1) < arrayOfCars.length){
							//shift every cell left starting from the value to be removed
							/*int j = i;
							while(j + 1<arrayOfCars.length){
								arrayOfCars[j] = arrayOfCars[j+1]; 
								j++;
							}
							arrayOfCars[arrayOfCars.length - 1] = null;
						}*/
						count--;
						removed = true;
					}
				}
			}
		}
		
		if(removed == false){
			throw new StreetException("Car to be removed not Found");
		}
	}
	
	public void simulate(int i){	
		//used input i of starting position in arrayofcars so I could call recusion with the rest of the
		// of the method after a car has been removed.
		for(;i < arrayOfCars.length; i++){
			if(arrayOfCars[i] != null){
				for(int j = i+1; j< arrayOfCars.length; j++){
					if(arrayOfCars[j] != null){
						if(i != j){							
								System.out.println(arrayOfCars[i].model + " will crash into " + arrayOfCars[j].model);
								arrayOfCars[i].crash(arrayOfCars[j]);									
								if(arrayOfCars[i].value < 2000){
									try {
										System.out.println("Car will be removed: " + arrayOfCars[i].ToString());
										remove(arrayOfCars[i]);
										simulate(i +1);
									} catch (StreetException e) {
										System.out.println(e.getMessage());
									}
								}
								if(arrayOfCars[j].value < 2000){
									try {
										System.out.println("Car will be removed: " + arrayOfCars[j].ToString());
										remove(arrayOfCars[j]);
										simulate(i +1);
									} catch (StreetException e) {
										System.out.println(e.getMessage());
									}	
								}
										
						}
					}
				}
			}
		}
	}
	
	
	void printCar(int cnt){
		System.out.println(arrayOfCars[cnt].ToString());
	}
	void printAllCars(){
		for(int i = 0; i < arrayOfCars.length; i++){
			if(arrayOfCars[i] != null)
			System.out.println(arrayOfCars[i].ToString());
		}
	}
	public String returnCar(int cnt){
		return arrayOfCars[cnt].make + ", " + arrayOfCars[cnt].model + ", " + arrayOfCars[cnt].year + ", " + arrayOfCars[cnt].value;
	}
}
