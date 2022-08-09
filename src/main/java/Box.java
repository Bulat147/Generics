import java.util.List;

/** Generics - ����������������� ����� - ���������� ����
 * ��� ��� �� ����� � ��� �� - ����� � ������ �������� ������� ���������� ����,
 *  � ����� ���������� ���� ��� ���������*/

public class Box<T extends Number> implements Comparable< Box<? extends Number> >{
    // ���� ? - ����� �������� �� T � �� ������ ���� T
    private final T[] array;

    public Box(T... array){ // ����� ��� ����� ���������� ������, ������ � �������������� �������
        this.array = array;
    }

    public T[] getArray() {
        return array;
    }

    public double avg(){
        double result = 0;
        for(T element: array){
            // ����� ������ ������� ������ downCast �� double �� � ��������� �� �������� �� int, � Integer
            // � Integer �� ������ ������������� � Double, �� � ��� ����� �������� - Number
            // ������� ������ UpCasting �� Number � �������� � ���� ����� ������������� � ������ ���
            Number num = (Number) element;
            result += num.doubleValue();
        }
        return result / array.length;
    }

    @Override
    public int compareTo(Box o) {
        if (avg() > o.avg()){
            return 9;
        } else if (avg() == o.avg()) {
            return 0;
        }else{
            return -9;
        }
    }

    public static double listAvg(List<? extends Number> array){
        if (array.size() == 0){
            return 0;
        }
        double result = 0;
        for(Number element: array){
            result += element.doubleValue();
        }
        return result / array.size();
    }

    /** ������������������� ������!
     *      <U> - ��� �� ������ ����������, ��� ����� ����� �������������������; ����� ���������� � <U> ��� �
     *      ��������� ����� ������� � static public � ��
     *      U - � ����� �� ������ ��������� ��� ������������� �������� </>*/
    public static <U> U getFirstElement(List<U> array){
        return array.get(0);
    }

    public static <J> void transfer(List<? extends J> src, List<? super J> dst){
        // extends - ����� J � �������
        // super - ����� j � ������
        dst.addAll(src); // ������ ����� ��� ���������� ���� ��-�� ��������� ���� ����� ������
        src.clear();
    }
}
