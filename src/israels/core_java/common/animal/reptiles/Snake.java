package israels.core_java.common.animal.reptiles;

public class Snake extends Reptile {

	public Snake() {
		setType("snake");
		MAX_AGE= 100;
		MATURITY = 4;
		prey.add("swans");
		prey.add("snakes");
		prey.add("rat");
		prey.add("squirels");
	}
	
//	@Override
//	public void eat() {
//		System.out.println(" is found eating a mouse");
//	}
//	@Override
//	public void move() {
//		System.out.println(" can move at 22mph");
//	}

}
