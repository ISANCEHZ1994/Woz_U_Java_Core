package israels.core_java.common.animal.birds;

public class Parrot extends Bird {

	{
		MAX_AGE = 12;
		MATURITY = 2;
	}
	
	public Parrot() {
		setType("parrot");
		food = BirdFood.MEAT;
	}

	@Override
	public boolean canRun() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canSwim() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
