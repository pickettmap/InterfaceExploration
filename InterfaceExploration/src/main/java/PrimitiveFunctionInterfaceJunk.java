import java.util.function.IntFunction;
import java.util.function.IntToLongFunction;
import java.util.function.LongFunction;

public class PrimitiveFunctionInterfaceJunk {
    public void example(){
        //Specialized primitive function interfaces for only: double, int, long

        IntFunction<Integer> intFunction = (x -> x + 100);
        System.out.println(intFunction.apply(100));

        LongFunction<Long> longFunction = (x -> x*4);
        System.out.println(longFunction.apply(6));

        IntToLongFunction intToLong = new IntToLongFunction() {
            @Override
            public long applyAsLong(int value) {
                return (long) value;
            }
        };
        System.out.println(longFunction.apply(intToLong.applyAsLong(5)).getClass());
    }
}
