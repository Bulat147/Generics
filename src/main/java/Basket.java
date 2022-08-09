import java.util.ArrayList;
import java.util.List;

public class Basket<T extends Fruit> {
    public final List<T> fruits = new ArrayList<>();
    private double weight = 0;

    public <U extends T> void add(U fruit){
        fruits.add(fruit);
        weight += fruit.getWeight();
    }


    public double getWeight(){
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int compare(Basket<? extends Fruit> other){
        if(getWeight() < other.getWeight()){
            return -1;
        } else if (getWeight() == other.getWeight()) {
            return 0;
        }else{
            return 1;
        }
    }

    public static <U extends Fruit> void transfer(Basket<U> src, Basket<? super U> dsr){ // €блоки - фрукты, но не €блоки - апельсины
        for (U fruit : src.fruits){
            dsr.add(fruit);
        }
        src.fruits.clear();
        src.setWeight(0);
    }
}

abstract class Fruit { // ≈сли есть конкретика - €блоко, то фрукт - это уже абстракци€
    public abstract double getWeight();
}

class Apple extends Fruit{

    @Override
    public double getWeight() {
        return 1;
    }
}

class Orange extends Fruit{

    @Override
    public double getWeight() {
        return 1.5;
    }
}