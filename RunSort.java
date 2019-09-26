public class RunSort{
    static SortingAlgorithm sort;
    static Visual vis;
    static Util util = new Util();

    public static void main(String[] args) throws Exception {
        vis = new Visual();
        boolean running = true;

        while (running) {
            vis.prepare();
            //Check settings, wait for button press

            running = vis.isRunning();
            if (!running) { continue; }

            int size = vis.getArraySize();
            int lBound = vis.getLBound();
            int rBound = vis.getRBound();
            boolean isRandom = vis.getRandom();
            String sortType = vis.getSort();
            System.out.println("\n--- NOW SORTING --- NOW SORTING --- NOW SORTING ---");
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

            Thread.sleep(1000);
            vis.setWaitTime(1);

            sort.run();

            util.printArray(sort.theArray);

            vis.setListening(true);
            running = vis.isRunning();
        }
    }
}