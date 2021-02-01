package israels.core_java.common.animal.birds;

public class Duck extends Bird {

	public Duck() {
		setType("Duck");
		MAX_AGE= 15;
		MATURITY = 1;
		
	}

	@Override
	public boolean canRun() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canSwim() {
		// TODO Auto-generated method stub
		return true;
	}

}
