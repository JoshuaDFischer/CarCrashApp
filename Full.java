

public class Full extends Car{

	public Full(String make, String model, int year, int value) {
		super(make, model, year, value);
	}
	
	public Full(){
		
	}
	public void crash(Car a) {
		if(a instanceof Full){	
			this.Honk();
			a.Honk();
			if(this.value < a.value){
				if(1500 >= (this.value * .07)){
					this.value = this.value -1500;
				}
				else{
					this.value = (int) ((double)this.value * .93);
				}
				if(2000 >= ((double)a.value * .09)){
					a.value = a.value -2000;
				}
				else {
					a.value = (int) ((double)a.value * .91);
				}
			}
			else{
				if(1500 >= (a.value * .07)){
					a.value = a.value -1500;
				}
				else{
					a.value = (int) ((double)a.value * .93);
					
				}
				if(2000 >= ((double)this.value * .09)){
					this.value = this.value -2000;
				}
				else {
					this.value = (int) ((double)this.value * .91);
				}
			}
			
		}
		else if (a instanceof Suv){
			if(800 >= (a.value * .05))
				a.value = a.value - 800;
			else
				a.value = (int) (a.value * .95);
			if(1000 >= (this.value * .10))
				this.value = this.value - 1000;
			else
				this.value = (int) (this.value * .90);
				a.Honk();
				this.Honk();
			}
		else if(a instanceof Economy){
			if(2500 >= (a.value * .20))
				a.value = a.value -2500;
			else
				a.value =  (int) (a.value * .80);
			if (1400 >= (this.value * .09))
				this.value = this.value - 1400;
			else
				this.value = (int) (this.value * .91);
			this.Honk();
			a.Honk();
			
		}		
	}
	public void Honk(){
		System.out.println("Beep!");
	}
}


