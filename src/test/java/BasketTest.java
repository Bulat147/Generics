import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasketTest {

    @Test
    public void testBasket() {
        Basket<Orange> oranges = new Basket<>();
        Basket<Apple> apples = new Basket<>();
        Basket<Fruit> fruits = new Basket<>();
        for (int i = 0; i < 10; i++) {
            oranges.add(new Orange());
            apples.add(new Apple());
        }
        assertEquals(15f, oranges.getWeight(), 0.001);
        assertEquals(10f, apples.getWeight(), 0.001);
        assertEquals(1, oranges.compare(apples));
        Basket.transfer(oranges, fruits);
        Basket.transfer(apples, fruits);
        assertEquals(25f, fruits.getWeight(), 0.001);
        assertEquals(0f, apples.getWeight(), 0.001);
        assertEquals(0f, oranges.getWeight(), 0.001);

        Basket<Orange> oranges2 = new Basket<>();
        Basket<Apple> apples2 = new Basket<>();
        for (int i = 0; i < 10; i++) {
            oranges2.add(new Orange());
            apples2.add(new Apple());
        }
        Basket.transfer(oranges2, oranges);
        Basket.transfer(apples2, apples);
        assertEquals(15f, oranges.getWeight(), 0.001);
        assertEquals(10f, apples.getWeight(), 0.001);
    }

    @Test
    void whenGetWeightThenReturnTrueValue() {
        Basket<Fruit> basket = new Basket<>();
        Apple apple = new Apple();
        Orange orange = new Orange();
        basket.add(apple);
        basket.add(orange);
        assertEquals(2.5, basket.getWeight());
    }

    @Test
    void compare(){ // проверить 3 ситуации
        Basket<Apple> basket1 = new Basket<>(); // 10
        Basket<Fruit> basket2 = new Basket<>();
        for (int i=0; i<10; i++){
            basket1.add(new Apple());
        }
        basket2.add(new Orange());
        assertEquals(1, basket1.compare(basket2), 0.0005);
        assertEquals(-1, basket2.compare(basket1), 0.0005);
        class Pineapple extends Fruit{

            @Override
            public double getWeight() {
                return 8.5;
            }
        }
        basket2.add(new Pineapple());
        assertEquals(0, basket1.compare(basket2), 0.0005);
    }

    @Test
    void whenTransferThenWeight0(){
        Basket<Apple> basket1 = new Basket<>(); // 10
        Basket<Fruit> basket2 = new Basket<>();
        for (int i=0; i<10; i++){
            basket1.add(new Apple());
        }
        Basket.transfer(basket1, basket2);
        assertEquals(0, basket1.getWeight());
        assertEquals(0, basket1.fruits.size());
    }
}

class AppleOrangeTest {

    @Test
    void weight(){
        Apple apple = new Apple();
        assertEquals(1, apple.getWeight());
        Orange orange = new Orange();
        assertEquals(1.5, orange.getWeight());
    }
}