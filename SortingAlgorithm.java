import java.util.Random;

public class SortingAlgorithm {
    Visual vis;
    Random rand = new Random();
    Util util = new Util();
    int[] theArray;
    //The goal here is to use arrays for all of them
    //Ideally I never have to venture into Set hell

    public SortingAlgorithm(int size, int lBound, int rBound, Visual vis) {
        this.vis = vis;
        theArray = new int[size];
        for (int i = 0; i < theArray.length; i++)
            theArray[i] = lBound + rand.nextInt(rBound - lBound);
    }

    public void run() {}

    public int[] getArray() { //Temporary
        return theArray;
    }
}

class BubbleSort extends SortingAlgorithm {
    int holder, limit;

    public BubbleSort(int size, int lBound, int rBound, Visual vis) {
        super(size, lBound, rBound, vis);
        limit = theArray.length;
    }

    @Override
    public void run() {
        for (int i = 0; i < theArray.length; i++) {
            for (int j = 0; j < limit-1; j++) {
                //Compares two neighboring numbers
                //Switches if the first one is smaller
                if (theArray[j] > theArray[j+1]) {
                    holder = theArray[j];
                    theArray[j] = theArray[j+1];
                    theArray[j+1] = holder;
                }
                //vis.updateVisual();
            }
            limit--;
        }
    }
}

class QuickSort extends SortingAlgorithm {
    int[] copy;
    int pivot, pivIndex, topIndex, leftBound, rightBound; //Sorry for repeating variables
    //pivIndex starts from the bottom. topIndex from the top

    public QuickSort(int size, int lBound, int rBound, Visual vis) {
        super(size, lBound, rBound, vis);
        leftBound = 0;
        rightBound = theArray.length;
    }

    //Works on a system of changing the area of operation in theArray
    @Override
    public void run() {
        int leftHold;
        int pivHold;
        int rightHold;
        //rightBound is the only variable that holds the right bound for the
        //highArray, and it gets set to the right bound for the lowArray, 
        //so I hold its original value in rightHold
        //The same applies with leftHold since pivIndex is changed during
        //The running of the lowArray

        //Reset variables
        copy = new int[rightBound - leftBound];
        pivIndex = leftBound;
        topIndex = rightBound;

        //Split into 2 parts
        pivot = getPivot();
        for (int i = leftBound; i < rightBound; i++) {
            //Splits array into 2 parts, greater or less than the pivot
            if (theArray[i] <= pivot) {
                copy[pivIndex - leftBound] = theArray[i];
                pivIndex++;
            }
            else
                copy[--topIndex - leftBound] = theArray[i];
            //vis.updateVisual();
        }
        updateTheArray();

        //Setting hold values
        rightHold = rightBound;
        pivHold = pivIndex;
        leftHold = leftBound;

        //At length = 2, it's (probably) guaranteed to be sorted
        if ((rightBound - leftBound) <= 2)
            return;

        //Repeat on the two new parts
        //Figuring out this part is a nightmare
        //Lower half
        leftBound = leftHold;
        rightBound = pivHold;
        run();
        //Upper half
        leftBound = pivHold;
        rightBound = rightHold;
        run();

        //End
    }

    private int getPivot() {
        //The pivot is just inbetween min and max
        int min, max;
        min = theArray[leftBound];
        max = theArray[leftBound];

        for (int i = leftBound; i < rightBound; i++) {
            if (theArray[i] < min)
                min = theArray[i];
            if (theArray[i] > max)
                max = theArray[i];
        }
        //If the array size is 2, and say the two numbers are 1 and 2
        //the pivot will be 1 so above when I split the array,
        //I needed to have the operator be <=
        return (min + max) / 2;
    }

    private void updateTheArray() {
        for (int i = 0; i < copy.length; i++)
            theArray[leftBound + i] = copy[i];
    }
}