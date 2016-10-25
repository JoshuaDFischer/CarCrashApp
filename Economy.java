
public class Economy extends Car{

	public Economy(String make, String model, int year, int value) {
		super(make, model, year, value);
	}
	public Economy(){
		
	}
	public void crash(Car a) {
		if(a instanceof Full){	
				if(2500 >= (this.value * .20)){
					this.value = this.value -2500;
				}
				else{
					this.value = (int) (this.value * .8);
				}
				
				if(1400 >= (a.value * .09)){
					a.value = a.value -1400;
				}
				else {
					a.value = (int) (a.value * .91);
				}		
			
			this.Honk();
			a.Honk();
		}
		
		else if (a instanceof Suv){
			if(3000 >= (this.value * .25))
				this.value = this.value - 3000;
			else
				this.value = (int) (this.value * .75);
			if(600 >= (a.value * .04))
				a.value = a.value - 600;
			else
				a.value = (int) (a.value * .96);
				a.Honk();
				this.Honk();
			}
		else if(a instanceof Economy){
			if(this.value < a.value){
				if(1000 >= (this.value * .06))
					this.value = this.value -1000;
				else
					this.value = (int) (this.value * .94);
				
				if(1200 > (a.value * .09)){
					a.value = a.value -1200;
				}
				else 
					a.value = (int) (a.value * .91);
			}
			else{
				if(1000 >= (a.value * .06))
					a.value = a.value -1000;
				else
					a.value = (int) (a.value * .94);
				if(1200 >= (this.value * .09)){
					this.value = this.value -1200;
				}
				else 
					this.value = (int) (this.value * .91);
			}
			this.Honk();
			a.Honk();
			
			
		}		
	}
	public void Honk(){
		System.out.println("beep!");
	}
}


