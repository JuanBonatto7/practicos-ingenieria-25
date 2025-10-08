package factorymethod;

public class ARGStyleComunPizza extends Pizza {
    public ARGStyleComunPizza(){
        name = "comun";
        dough = "wasd";
		sauce = "wasd";
 
		toppings.add("aceituna");
    }

    void cut() {
		System.out.println("Cutting the pizza into square slices");
	}
}
