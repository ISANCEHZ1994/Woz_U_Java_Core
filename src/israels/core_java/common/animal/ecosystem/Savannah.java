package israels.core_java.common.animal.ecosystem;

import java.util.List;

import israels.core_java.common.animal.*;
import israels.core_java.common.animal.mammals.*;

public class Savannah extends Ecosystem {
// Variables Section
	List<Lion> lionPride = (List<Lion>) new RandomAnimalBuilder(Lion.class).build(6);
	List<Cheetah> cheetah = (List<Cheetah>) new RandomAnimalBuilder(Lion.class).build(6);
	
	
}
