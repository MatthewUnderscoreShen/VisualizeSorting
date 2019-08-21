public class RunSort{
    static SortingAlgorithm sort = new SortingAlgorithm();
    static Util util = new Util();
    public static void main(String[] args){
        int[] IA = util.getInput();
        int[] array = util.getRandomArray(IA[1], IA[2], IA[3]);
        util.printArray(array);

        int[] sortedArray = null;
        switch(IA[0]){
            case 1:
                sortedArray = sort.runBubble(array, 0, false);
            case 2:
                sortedArray = util.linkedListToIntArray(sort.runQuick(util.intArrayToLinkedList(array)));
        }
        util.printArray(sortedArray);
    }
}