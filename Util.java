import java.util.Scanner;

public class Util {
    Scanner scan;

    public Util() {
        scan = new Scanner(System.in);
    }

    public int[] getInput(String splitter) throws Exception {
        String[] input = scan.nextLine().split(splitter);
        int[] returnArray = new int[input.length];

        for (int i = 0; i < input.length; i++)
            returnArray[i] = Integer.parseInt(input[i]);
        scan.close();
        return returnArray;
    }

    public void printArray(int[] array) {
        System.out.print("\n\t");
        for (int v : array)
            System.out.print(v + " ");
    }
}