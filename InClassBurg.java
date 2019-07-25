public class InClassBurg {
    public static void main(String[] args) {
        Burger order = new Avocado(new FriedEgg(new GrilledOnions(new BasicBurger())));
        double cost = order.makeBurger();
        System.out.println("Total: $" + cost);

        // Debug
        System.out.println("with everything on the Menu: ");
        Burger order1 = new RoastedPeppers(new Bacon(new Avocado(new FriedEgg(new GrilledOnions(new BasicBurger())))));
        double cost1 = order1.makeBurger();
        System.out.println("Total: $" + cost1);
    }

}
interface Burger{
    public double makeBurger();
}
class BasicBurger implements Burger{
    private double cost = 6.50;
    @Override
    public double makeBurger() {
        System.out.println("Basic CheeseBurger: $6.50");
        return cost;
    }

}
abstract class BurgerDecorator implements Burger{
    protected Burger specialBurger;
    public BurgerDecorator(Burger specialBurger){
        this.specialBurger = specialBurger;
    }
    public double makeCoffee(){
        return specialBurger.makeBurger();
    }
}


class GrilledOnions extends BurgerDecorator{
    private double cost = 1.00;

    public GrilledOnions(Burger specialBurger){
        super(specialBurger);

    }

    public double makeBurger(){
        return specialBurger.makeBurger() + addGrilledOnions();
    }

    private double addGrilledOnions(){
        System.out.println(" + Grilled Onions: $1.00");
        return cost;
    }
}
class FriedEgg extends BurgerDecorator{
    private double cost = 1.50;

    public FriedEgg(Burger specialBurger){
        super(specialBurger);

    }

    public double makeBurger(){
        return specialBurger.makeBurger() + addFriedEgg();
    }

    private double addFriedEgg(){
        System.out.println(" + Fried Egg: $1.50");
        return cost;
    }
}

class Bacon extends BurgerDecorator{
    private double cost = 1.50;

    public Bacon(Burger specialBurger){
        super(specialBurger);

    }

    public double makeBurger(){
        return specialBurger.makeBurger() + addBacon();
    }

    private double addBacon(){
        System.out.println(" + Bacon: $1.50");
        return cost;
    }
}

class Avocado extends BurgerDecorator{
    private double cost = .75;

    public Avocado(Burger specialBurger){
        super(specialBurger);

    }

    public double makeBurger(){
        return specialBurger.makeBurger() + addAvocado();
    }

    private double addAvocado(){
        System.out.println(" + Avocado: $.75");
        return cost;
    }
}

class  RoastedPeppers extends BurgerDecorator{
    private double cost = 1.50;

    public  RoastedPeppers(Burger specialBurger){
        super(specialBurger);

    }

    public double makeBurger(){
        return specialBurger.makeBurger() + addRoastedPeppers();
    }

    private double addRoastedPeppers(){
        System.out.println(" + Roasted Peppers: $1.50");
        return cost;
    }
}


