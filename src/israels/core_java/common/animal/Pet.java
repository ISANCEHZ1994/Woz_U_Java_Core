package israels.core_java.common.animal;
import israels.core_java.common.Nameable;

public interface Pet extends Nameable,Domesticatable { // <= extends to both
	
	public abstract boolean hasLicense();
	public abstract void beFriendly();
	
	
	
}
