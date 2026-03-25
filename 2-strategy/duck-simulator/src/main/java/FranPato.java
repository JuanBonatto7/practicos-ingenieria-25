public class FranPato extends Duck {
    
    public FranPato(){
        quackBehavior = new Pity();
        flyBehavior = new tienesUnaVideollamada();

    }

    public void display()
    {
        System.out.println("Te elceocutaste Pity, te electovutaste");
    }
}
