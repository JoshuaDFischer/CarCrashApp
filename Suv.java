
public class Suv extends Car{

	public Suv(String make, String model, int year, int value) {
		super(make, model, year, value);
	}
	
	public Suv(){
		
	}

	public void crash(Car a) {
		if(a instanceof Full){			
			if(1000 >= (a.value * .1))
				a.value = a.value -1000;
			else
				a.value =  (int) (a.value * .9);
			if (800 >= (this.value * .05))
				this.value = this.value - 800;
			else
				this.value = (int) (this.value * .95);
			this.Honk();
			a.Honk();
			
		}
		else if (a instanceof Suv){
			if(1500 >= (this.value * .1))
				this.value = this.value - 1500;
			else
				this.value = (int) (this.value * .9);
			if(1500 >= (a.value * .1))
				a.value = a.value - 1500;
			else
				a.value = (int) (a.value * .9);
				a.Honk();
				this.Honk();
			}
		else if(a instanceof Economy){
			if(3000 >= (a.value * .25))
				a.value = a.value -3000;
			else
				a.value =  (int) (a.value * .75);
			if (600 >= (this.value * .04))
				this.value = this.value - 600;
			else
				this.value = (int) (this.value * .96);
			this.Honk();
			a.Honk();
			
		}
				
		
	}
	public void Honk(){
		System.out.println("Wavv!");
	}
}
