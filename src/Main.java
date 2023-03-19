import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super  T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
        return x ->condition.test(x) ? ifTrue.apply(x) : ifFalse.apply(x);
    }

    public static void main(String[] args){
        //Задание 1: Напишите реализации функционального интерфейса Predicate,
        // которые проверяют, является ли число положительным. Если число положительное, то предикат должен возвращать
        // true, в противном случае — false. Реализуйте Predicate в двух вариантах: через анонимный класс, через лямбду.*/
        Predicate<Integer>predicate1 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                if (integer < 0) {
                    return false;
                }
                return true;
            }
        };

        Predicate<Integer>predicate2= x ->x > 9;

        System.out.println(predicate1.test(350));
        System.out.println(predicate2.test(-180));

        //Задание 2
        //Создайте функциональный интерфейс Consumer, который принимает на вход имя человека и выводит в консоль
        // приветствие в его адрес.
        //Реализуйте его в двух вариантах: через анонимный класс и через лямбду.*/

        Consumer<String> consumer1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("Hello " + s + "!");}
        };
        Consumer<String> consumer2 = s -> System.out.println("Hello " + s + "!");

        consumer2.accept("Anna");
        consumer1.accept("Tomara");

        //Задание 3
        //Реализуйте функциональный интерфейс Function, который принимает на вход вещественное число типа Double,
        // а возвращает его округленный вариант типа Long.
        //Реализуйте его в двух вариантах: через анонимный класс и через лямбду.*/

        Function<Double, Long> function1 = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) { return Math.round(aDouble);}
        };
        Function<Double, Long> function2 = Math::round;

        //Задание 4
        //Напишите Supplier, который возвращает случайное число из диапазона от 0 до 100.
        //Реализуйте его в двух вариантах: через анонимный класс и через лямбду.*/

        Supplier<Integer> supplier1 = new Supplier<Integer>() {
            @Override
            public Integer get() {return (int) (Math.random() *  100);
            }
        };
        Supplier<Integer> supplier2 = () -> (int) (Math.random() * 100);

        //Задание 5 (опциональное)
        //Теперь попрактикуемся в комбинировании нескольких функций в одну сложную конструкцию. Для примера построим
        // следующую комбинацию. Дан предикат condition и две функции: ifTrue и ifFalse.
        //Напишите метод ternaryOperator, который из предиката и двух функций построит новую функцию, возвращающую
        // значение функции ifTrue, если предикат выполнен, а в остальных случаях — ifFalse.*/

        Function<Integer, Integer> function3 = x -> Math.round(x);
        Function<Integer, Double> function4 = x -> Math.pow(x, 3);

        System.out.println(ternaryOperator(predicate1, function3, function4).apply(6));



    }

}