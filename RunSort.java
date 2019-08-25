public class RunSort{
    static SortingAlgorithm sort;
    static Visual vis = new Visual();
    static Util util = new Util();

    public static void main(String[] args) throws Exception{
        //Past here needs changes
        System.out.println("Select Sort:");
        //See if you can use a hashmap or something
        System.out.println("\t1) Bubble");
        System.out.println("\t2) Quick");
        System.out.println("\nInput: Sort type, array length, left bound, right bound");

        int[] IA = util.getInput(", "); //"Input Array"

        switch (IA[0]) {
            case 1:
                sort = new BubbleSort(IA[1], IA[2], IA[3], vis);
                break;
            case 2:
                sort = new QuickSort(IA[1], IA[2], IA[3], vis);
                break;
            default:
                System.out.println("???");
        }

        int[] printMe = sort.getArray();
        util.printArray(printMe);

        sort.run();

        printMe = sort.getArray();
        System.out.println();
        util.printArray(printMe);
    }
}