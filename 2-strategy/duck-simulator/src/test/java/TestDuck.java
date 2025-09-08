import org.junit.jupiter.api.Test;

public class TestDuck {

    @Test
    public void testMallardDuck() {
        Duck mallard = new MallardDuck();
        mallard.performQuack();
        mallard.performFly();
    }

    @Test
    public void testModelDuck() {
        Duck model = new ModelDuck();
        model.performQuack();
        model.performFly();
    }

    @Test
    public void testModelDuckChangeFlyBehavior() {
        Duck model = new ModelDuck();
        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();
    }
    
    @Test
    public void testPatoCriollo() {
        Duck criollo = new PatoCriollo();
        criollo.performQuack();
        criollo.performFly();
    }

    @Test
    public void testPatoCriolloChangeFlyBehavior() {
        Duck criollo = new PatoCriollo();
        criollo.performFly();
        criollo.setFlyBehavior(new FlyRocketPowered());
        criollo.performFly();
    }

    @Test 
    public void testPaty()
    {
        Duck paty = new FranPato();
        paty.performFly();
        paty.performQuack();
    }

}
