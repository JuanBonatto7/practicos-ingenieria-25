package factorymethod;

public class ARGStyleRuculaPizza extends Pizza {
    public ARGStyleRuculaPizza(){
        name = "rucula";
        dough = "wasd";
		sauce = "wasd";
 
		toppings.add("aceituna");
    }

    void cut() {
		System.out.println("Cutting the pizza into square slices");
	}
}
