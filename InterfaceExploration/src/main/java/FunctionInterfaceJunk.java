import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class FunctionInterfaceJunk {
    public void example(){
        // printConsumer is a function that will "consume" the objects in the stream and print them
        Consumer<String> printConsumer = t -> System.out.println(t);
        Stream<String> cities = Stream.of("Sydney", "Dhaka", "New York", "London");
        cities.forEach(printConsumer);


        Function<Double, Double> byQuarter = a -> a /4.0;
        Function<Double, Double> adding100 = a -> a + 100;
        Function<Double, Double> half = a -> a/2.0;
        half = half.andThen(a -> 3 *a);
        System.out.println(half.apply(5.0)); // result = (5/2) * 3
        System.out.println(half.andThen(byQuarter).apply(50.0)); // result = ((50/2)*3) / 4

        System.out.println(half.compose(byQuarter).apply(50.0)); // result = (((50/4)/2)*3)

        System.out.println(half.andThen(adding100).apply(50.0)); // result = ((50/2)*3) + 100

        System.out.println(half.compose(adding100).apply(50.0)); // result = (((50 + 100)/2)*3)
    }
}
