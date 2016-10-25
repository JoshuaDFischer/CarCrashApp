
public abstract class Car {

	protected String model,
					 make;
	protected int year,
			      value;
	
	public Car(String inputMake, String inputModel, int inputYear, int inputValue){
		model = inputModel;
		make = inputMake;
		year = inputYear;
		value = inputValue;
	}
	
	public void setModel(String inputModel){
		model = inputModel;
	}
	public void setMake(String inputMake){
		make =inputMake;
	}
	public void setYear(int inputYear){
		year = inputYear;
	}
	public void setValue(int inputValue){
		value = inputValue;
	}
	public String getModel(){
		return model;
	}
	public String getMake(){
		return make;
	}
	public int getyear(){
		return year;
	}
	public int getvalue(){
		return value;
	}
	public String ToString(){
		return make + ", " + model + ", " + year + ", " + value;
	};
	
	public abstract void crash(Car a);

	
	
	public Car(){
		
	}
	
	public abstract void Honk();
}
