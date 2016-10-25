
import java.io.IOException;
import java.util.Scanner;

public class StreetClient {

	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		try {
			
			Street<Car> firstStreet = new Street<Car>(getStreetSize());
			boolean more = false;
			do{
				System.out.println("Enter make of car:");
				String make = in.nextLine();
				System.out.println("Enter model of car:");
				String model = in.nextLine();
				
				int year = getYear();
				int value = getValue();
				
				boolean getTypeOfCar = false;
				do{
					System.out.println("Enter type of car(Suv, Full, Economy):");				
					switch(in.nextLine().toLowerCase()){
						case "suv":
							Suv suv1 = new Suv(make, model, year, value);
							firstStreet.add(suv1);
							getTypeOfCar = false;
							break;				
						case "economy":
							Economy Econ1 = new Economy(make, model, year, value);
							firstStreet.add(Econ1);	
							getTypeOfCar = false;
							break;
						case "full":
							Full full1 = new Full(make, model, year, value);
							firstStreet.add(full1);		
							getTypeOfCar = false;
							break;
						default:
							System.out.println("Incorrect answer for type");
							getTypeOfCar = true;
							break;						
						}					
				}
				while(getTypeOfCar);
				more = getAnotherCar();
			}
			while(more);
			//Used to clear the screen
			for (int i = 0; i < 50; ++i) 
				System.out.println();
					
			
			System.out.println("Starting simulation with the below cars:");
			firstStreet.printAllCars();
			firstStreet.simulate(0);
			System.out.println("Simulation is complete:");
			firstStreet.printAllCars();


		} 
		catch (StreetException e) {
			System.out.println(e.getMessage());
		}
		in.close();
		}
	
	private static int getStreetSize(){

		int streetSize = 0;
		Scanner in = new Scanner(System.in);
		do{
			System.out.println("What is street size:");
			try{
		       streetSize = Integer.parseInt(in.nextLine());
		    }
			catch(NumberFormatException e){
				System.out.println("Street Size must be a number greater than 1");
		    }
			
			if(streetSize < 1){
				streetSize = 0;
			}
		}
		while(streetSize == 0);
		
		return streetSize;
	}
	
	private static int getYear(){
		int year = 0;
		Scanner in = new Scanner(System.in);
		do{
			System.out.println("Enter year of car:");
			try{
		       year = Integer.parseInt(in.nextLine());
		       if(year < 1800 || year > 2017)
					System.out.println("Year must be a number from 1800 - 2017");
		    }
			catch(NumberFormatException e){
				System.out.println("Year must be a number from 1800 - 2017");
		    }
		}
		while(year < 1800 || year > 2017);
		return year;
	}

	private static int getValue(){

		int value = 0;
		Scanner in = new Scanner(System.in);
		do{
			System.out.println("What is value:");
			try{
		       value = Integer.parseInt(in.nextLine());
		       if(value < 2000){
					System.out.println("Value must be a number greater than 2000");
					value = 0;
				}
		    }
			catch(NumberFormatException e){
				System.out.println("Value must be a number greater than 2000");
		    }
			
			
		}
		while(value == 0);
		
		return value;
	}

	private static boolean getAnotherCar(){
		Scanner in = new Scanner(System.in);
		boolean rtn = false;
		boolean askAgain = true;
		while(askAgain == true){
			System.out.println("Do you want to add another car? (Y/N) ");	
			String ans = in.nextLine().toLowerCase();
			if(ans.equalsIgnoreCase("y")){
				rtn = true;
				askAgain = false;
			}
			else if(ans.equalsIgnoreCase("n")){
				rtn = false;
				askAgain = false;
			}
			else
				askAgain = true;	
		}
		return rtn;
	}
}



		


