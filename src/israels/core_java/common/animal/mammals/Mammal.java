package israels.core_java.common.animal.mammals;

import israels.core_java.common.animal.Animal;

public abstract class Mammal extends Animal {
	
	protected int maxRunningSpeed = 1;
	
	public void setMaxRunningSpeed(int speed) {
		if(speed > 1) {
			maxRunningSpeed = speed;
		}
	
	};
	
	public Mammal() {
		setType("uknown mammal");
	};
	
// --------------------------> METHOD SECTION <----------------------------------------------------------	
	
	@Override
	public boolean equals(Object other) {
		if(this == other) { return true;}
		boolean result = false;
		if(other instanceof Mammal) {
			result = super.equals(other)
					&& maxRunningSpeed == ((Mammal)other).maxRunningSpeed;
		}
		return result;
	}
	
	@Override
	public int hashCode() {
		int code = super.hashCode();
		code ^= maxRunningSpeed * 37;
		
		return code;
	}
	
	
	public int getRunningSpeed() {
		int speed;
		if(getHealth() > 4) {
			speed = maxRunningSpeed;
		}else if (getHealth() > 3){
			speed = (int) (maxRunningSpeed * 0.9);
		}else if (getHealth() > 1){
			speed = (int) (maxRunningSpeed * 0.8);
		}else if (getHealth() > -1){
			speed = (int) (maxRunningSpeed * 0.7);
		}else if (getHealth() > -2){
			speed = (int) (maxRunningSpeed * 0.6);
		}else if (getHealth() > -4){
			speed = (int) (maxRunningSpeed * 0.5);
		}else if (getHealth() > -6){
			speed = (int) (maxRunningSpeed * 0.3);
		}else if (getHealth() > -8){
			speed = (int) (maxRunningSpeed * 0.1);
		}else {
			speed = 1;
		}
			
		return speed;
	};
	

	
};


