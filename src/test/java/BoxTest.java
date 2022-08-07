import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoxTest {
    Box<String, Integer, Double> box;

    @BeforeEach
    void setUp() {
        box = new Box<>("Ключ1", 15, 45.5d);
    }

    @Test
    void getValue() {
        assertEquals(15, box.getValue());
    }

    @Test
    void setValue() {
        box.setValue(455);
        assertEquals(455, box.getValue());
    }

    @Test
    void testTwoValuesSum(){
        Box<String, Integer, Double> box2 = new Box<>("Key2", 30, 0.5d);
        double result = box.twoValuesSum() + box2.twoValuesSum();
        assertEquals(91, result);
    }
}