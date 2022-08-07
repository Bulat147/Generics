/** Generics - ����������������� ����� - ���������� ����
 * ��� ��� �� ����� � ��� �� - ����� � ������ �������� ������� ���������� ����,
 *  � ����� ���������� ���� ��� ���������*/

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

    public void setSecondValue(D secondValue){
        this.secondValue = secondValue;
    }

    public D getSecondValue(){
        return secondValue;
    }
}
