import java.util.List;

/** Generics - параметризованный класс - обобщенные типы
 * Все это об одном и том же - можно в классе большими буквами обозначать типы,
 *  и потом ПЕРЕДАВАТЬ ТИПЫ КАК АРГУМЕНТЫ*/

public class Box<T extends Number> implements Comparable< Box<? extends Number> >{
    // Выше ? - чтобы отличить от T и не совать туда T
    private final T[] array;

    public Box(T... array){ // Здесь все равно передается массив, просто с синтаксическим сахаром
        this.array = array;
    }

    public T[] getArray() {
        return array;
    }

    public double avg(){
        double result = 0;
        for(T element: array){
            // Здесь нельзя сделать просто downCast до double тк в аргументы мы передаем не int, а Integer
            // а Integer не связан наследованием с Double, но у них общий родитель - Number
            // Поэтому делаем UpCasting до Number и вызываем у него метод преобразующий в нужный тип
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

    /** Параметризированные методы!
     *      <U> - так мы просто показываем, что метод будет параметризированным; Можно относиться к <U> как к
     *      ключевому слову наравне с static public и тд
     *      U - а здесь мы просто указываем тип возвращаемого значения </>*/
    public static <U> U getFirstElement(List<U> array){
        return array.get(0);
    }

    public static <J> void transfer(List<? extends J> src, List<? super J> dst){
        // extends - класс J и потомки
        // super - класс j и предки
        dst.addAll(src); // Вместо цикла для добавления всех эл-ов используй этот метод всегда
        src.clear();
    }
}
