public class RunSort{
    static SortingAlgorithm sort;
    static Visual vis;
    static Util util = new Util();

    public static void main(String[] args) throws Exception {
        vis = new Visual();

        vis.prepare();
        //Check settings, wait for button press

        int size = vis.getArraySize();
        int lBound = vis.getLBound();
        int rBound = vis.getRBound();
        boolean isRandom = vis.getRandom();
        String sortType = vis.getSort();
        
        switch(sortType) {
            case "Bubble Sort":
                sort = new BubbleSort(size, lBound, rBound, isRandom, vis);
                break;
            case "Quicksort":
                sort = new QuickSort(size, lBound, rBound, isRandom, vis);
                break;
            case "Merge Sort":
                sort = new MergeSort(size, lBound, rBound, isRandom, vis);
                break;
            default:
                System.out.println("How????");
        }
    }
}