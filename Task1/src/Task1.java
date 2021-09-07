import java.util.IntSummaryStatistics;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Task1 {


    public static void main(String[] args) {
        System.out.println("Please enter integers according to the pattern (1 10 20 20 2 5)");
        Scanner scanner = new Scanner(System.in);
        String[] str = scanner.nextLine().trim().split(" ");
        int[] ints = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            ints[i] = Integer.parseInt(str[i]);
        }
        showIntListStats(ints);
    }


    public static void showIntListStats(int... ints) {

        IntStream intStream1 = IntStream.of(ints);
        IntStream intStream2 = IntStream.of(ints);

        long countDistinct = intStream1.distinct().sorted().peek(a -> System.out.print(a + " ")).count();
        IntSummaryStatistics intSummaryStatistics = intStream2.summaryStatistics();
        System.out.println("\ncount: " + intSummaryStatistics.getCount()
                + "\ndistinct: " + countDistinct
                + "\nmin: " + intSummaryStatistics.getMin()
                + "\nmax: " + intSummaryStatistics.getMax());

    }
}
