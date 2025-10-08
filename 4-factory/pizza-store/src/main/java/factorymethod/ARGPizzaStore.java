package factorymethod;

public class ARGPizzaStore extends PizzaStore {
    
    Pizza createPizza(String item){
        if(item.equals("fugazzeta")){
            return new ARGStyleFugazzetaPizza();  
        }else if(item.equals("rucula")){
            return new ARGStyleRuculaPizza();
        }else if(item.equals("comun")){
            return new ARGStyleComunPizza();
        }else {
            return null;
        }
    }
}
