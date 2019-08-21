import java.util.Random;
import java.util.LinkedList;
import java.util.Scanner;

public class Util{
    Random random = new Random();
    Scanner scan = new Scanner(System.in);

    public int[] getInput(){
        System.out.println("\nSort Types:\n" + "1) Bubble Sort\n" + "2) QuickSort\n" + "3) Insertion Sort");
        System.out.println("[Sort Type #], [array length], [left bound], [right bound]");
        String[] input = scan.nextLine().split(", ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);
        int d = Integer.parseInt(input[3]);
        int[] returnArray = {a, b, c, d};
        return returnArray;
    }

    public int[] getRandomArray(int length, int leftBound, int rightBound){
        return random.ints(length, leftBound, rightBound).toArray();
    }

    public int getRandomNumber(int bound){
        return random.nextInt(bound);
    }

    public void printArray(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println("\n");
    }

    public int[] linkedListToIntArray(LinkedList E){
        int[] returnArray = new int[E.size()];
        for(int i = 0; i < E.size(); i++){
            returnArray[i] = (int)E.get(i);
        }
        return returnArray;
    }

    public LinkedList intArrayToLinkedList(int[] array){
        LinkedList list = new LinkedList();
        for(int number : array){
            list.add(number);
        }
        return list;
    }

    public boolean isSorted(int[] array){
        for(int i = 0; i < array.length - 1; i++){
            if(array[i] > array[i + 1]){
                return false;
            }
        }
        return true;
    }
}