import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BoxTest {
    @Test
    public void avg(){
        Box<Integer> box1 = new Box<>(4, 5, 6, 7);
        assertEquals(22, box1.avg());
    }

    @Test
    public void compareTo(){
        Box<Float> box1 = new Box<>(4.5f, 5.5f, 5f);
        Box<Integer> box2 = new Box<>(15, 5);
        int check = box1.compareTo(box2);
        assertEquals(-9, check);
    }

    @Test
    public void listAvg(){
        List<Integer> newList = new ArrayList<>();
        double result = Box.listAvg(newList);
        assertEquals(0, result);
    }

    @Test
    public void transfer(){
        List<Integer> nums = new ArrayList<>();
        for (int i=0; i<10; i++){
            nums.add(i);
        }
        List<Number> nums2 = new ArrayList<>();
        Box.transfer(nums, nums2); // Мы можем добавлять Integer-объекты в Number-коллекцию
    }
}