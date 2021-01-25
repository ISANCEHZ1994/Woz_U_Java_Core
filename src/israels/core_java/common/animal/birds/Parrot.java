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
	
}
