import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Task2 {


    private static void presentPairedIntegers() {
        int counter = 0;
        List<Integer> integers = handleInput();
        ArrayList<Integer> pairableIntegers = extractPairableIntegers(integers);
        pairableIntegers.sort(Comparator.comparing(Integer::intValue));
        while (pairableIntegers.get(counter) < 13 - pairableIntegers.get(counter)) {
            System.out.println(pairableIntegers.get(counter) + " " + (13 - pairableIntegers.get(counter)));
            counter++;
        }
    }

    private static ArrayList<Integer> extractPairableIntegers(List<Integer> integers) {
        ArrayList<Integer> pairableIntegers = new ArrayList<>();

        for (Integer integer : integers) {
            if (integers.contains(13 - integer))
                pairableIntegers.add(integer);
        }
        return pairableIntegers;
    }

    private static ArrayList<Integer> handleInput() {
        ArrayList<Integer> inputList = new ArrayList<>();
        System.out.println("Please enter integers according to the pattern (1 2 10 7 5 3 6 6 13 0)");
        Scanner scanner = new Scanner(System.in);
        String[] str = scanner.nextLine().trim().split(" ");
        for (String s : str) {
            int num = Integer.parseInt(s);
            inputList.add(num);
        }
        return inputList;
    }

    public static void main(String[] args) {
        presentPairedIntegers();
    }


}
