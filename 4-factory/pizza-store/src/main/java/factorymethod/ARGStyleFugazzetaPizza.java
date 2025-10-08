package factorymethod;

public class ARGStyleFugazzetaPizza extends Pizza {
    
    public ARGStyleFugazzetaPizza(){
        name = "fugazeta";
        dough = "wasd";
		sauce = "wasd";
 
		toppings.add("aceituna");
    }

    void cut() {
		System.out.println("Cutting the pizza into square slices");
	}
}
