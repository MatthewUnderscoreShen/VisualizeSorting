import java.util.LinkedList;

public class SortingAlgorithm{
    Util util = new Util();

    public int[] runBubble(int[] array, int counter, boolean hasSwitched){
        if(util.isSorted(array)){
            return array;
        }
        if(counter == array.length - 1){
            if(hasSwitched){
                return runBubble(array, 0, false);
            } else{
                return array;
            }
        }
        
        int a = array[counter];
        int b = array[counter + 1];

        if(a > b){
            array[counter] = b;
            array[counter + 1] = a;
            counter++;
            return runBubble(array, counter, true);
        } else{
            counter++;
            return runBubble(array, counter, hasSwitched);
        }
    }

    public LinkedList runQuick(LinkedList<Integer> array){
        LinkedList<Integer> lowArray = new LinkedList();
        LinkedList<Integer> highArray = new LinkedList();
        LinkedList<Integer> finalArray = new LinkedList();
        int pivotIndex = util.random.nextInt(array.size());

        for(int number : array){
            if((int)number < (int)array.get(pivotIndex)){
                lowArray.add(number);
            } else{
                highArray.add(number);
            }
        }

        if(!util.isSorted(util.linkedListToIntArray(lowArray))){
            lowArray = runQuick(lowArray);
        } if(!util.isSorted(util.linkedListToIntArray(highArray))){
            highArray = runQuick(highArray);
        }

        int a = lowArray.size();
        int b = highArray.size();

        for(int i = 0; i < a; i++){
            finalArray.add(lowArray.pop());
        } for(int j = 0; j < b; j++){
            finalArray.add(highArray.pop());
        }

        return finalArray;
    }

    public void runMerge(int[] array){
        
    }
}