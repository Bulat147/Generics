/** Generics - параметризованный класс - обобщенные типы
 * Все это об одном и том же - можно в классе большими буквами обозначать типы,
 *  и потом ПЕРЕДАВАТЬ ТИПЫ КАК АРГУМЕНТЫ*/

public class Box<K, V, D> {
    public K key;
    private V value;
    private D secondValue;

    public Box(K key, V value, D secondValue){
        this.key = key;
        this.value = value;
        this.secondValue = secondValue;
    }


    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public double twoValuesSum(){
        if (value instanceof Integer && secondValue instanceof Double){
            return (int) value + (double) secondValue;
        }
        throw new RuntimeException();
    }
}
