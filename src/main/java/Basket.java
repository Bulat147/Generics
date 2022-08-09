import java.util.ArrayList;
import java.util.List;

public class Basket<T extends Fruit> {
    private final List<T> array = new ArrayList<>();
    private double weight = 0;

    public <U extends T> void add(U fruit){
        array.add(fruit);
        weight += fruit.weight();
    }

    public List<T> getFruits(){
        return array;
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
        for (U fruit : src.getFruits()){
            dsr.add(fruit);
        }
        src.getFruits().clear();
        src.setWeight(0);
    }
}

class Fruit {
    private final double weight;

    public Fruit(double weight){
        this.weight = weight;
    }

    public double weight() {
        return weight;
    }
}

class Apple extends Fruit{

    public Apple() {
        super(1); // ¬ызываем конструктор Fruit
    }
}

class Orange extends Fruit{

    public Orange() {
        super(1.5);
    }
}