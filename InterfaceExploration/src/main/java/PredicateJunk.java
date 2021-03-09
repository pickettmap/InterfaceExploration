import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateJunk{
    public void example(){
        Predicate<Integer> numbersGreaterThan5 = x -> x > 5; //Return true if x > 5
        Predicate<Integer> lessThan8 = x -> x < 8;

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);



        //Testing Predicate
        List<Integer> collect2 = list.stream()
                .filter(lessThan8)
                .collect(Collectors.toList());

        //Testing Predicate negate
        List<Integer> collect = list.stream()
                .filter(numbersGreaterThan5.negate()) // Converts to <=
                .collect(Collectors.toList());

        //Testing Predicate test
        Boolean a = numbersGreaterThan5.test(6);
        String b = "Here";
//
//        System.out.println(a);


        Predicate <String> i = Predicate.isEqual("notEqual");
//        System.out.println(i.test("notEqual"));

        List<Integer> collect3 = list.stream()
                .filter(numbersGreaterThan5.or(lessThan8)) // Converts to <=
                .collect(Collectors.toList());

//        System.out.println(collect3);
//
//        System.out.println(collect); // [6, 7, 8, 9, 10]
//        System.out.println(collect2);

        System.out.println(numbersGreaterThan5.negate().and(lessThan8).test(5)); //!x > 5 && x<8
        System.out.println(numbersGreaterThan5.and(lessThan8).negate().test(6)); //x > 5 && !x<8
        System.out.println(numbersGreaterThan5.and(lessThan8).negate().test(4)); //!(x > 5 && x < 8)
        System.out.println(numbersGreaterThan5.and(lessThan8.negate()).negate().test(4)); //  !(x > 5 && !x < 8)

        //All match, Any match, None Match
        Boolean allMatch = list.stream().allMatch(numbersGreaterThan5);
        System.out.println("Allmatch: " + allMatch);

        Boolean anyMatch = list.stream().anyMatch(numbersGreaterThan5);
        System.out.println("Anymatch: " + anyMatch);

        Boolean noneMatch = list.stream().noneMatch(numbersGreaterThan5);
        System.out.println("Nonematch: " + noneMatch);
    }
}