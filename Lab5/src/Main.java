import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("---median---");
        System.out.println(StreamMethods.median(List.of(5, 8)));

        System.out.println("---parseStrings---");
        System.out.println(StreamMethods.parseStrings(List.of("check", "megaCheck")));

        System.out.println("---squares---");
        System.out.println(StreamMethods.squares(List.of(4, 5, 5, 1, 2, 2)));

        System.out.println("---sortWithCondition---");
        System.out.println(StreamMethods.sortWithCondition(List.of("ab", "ba", "aa"), 'a'));

        System.out.println("---lastOrException---");
        try {
            System.out.println(StreamMethods.lastOrException(List.of(4, 6, 2, 1)));
            System.out.println((char[]) StreamMethods.lastOrException(List.of()));
        } catch (IllegalArgumentException ex) {
            System.out.println("An exception was caught!");
        }

        System.out.println("---sumEven---");
        System.out.println(StreamMethods.sumEven(new int[]{2, 4, 5}));
        System.out.println(StreamMethods.sumEven(new int[]{5, 7, 9}));

        System.out.println("---stringMap---");
        System.out.println(StreamMethods.stringMap(List.of("let's", "try", "it")));
    }

}
