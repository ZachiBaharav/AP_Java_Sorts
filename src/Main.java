

public class Main {

    public static void main(String[] args) {
        
        int[] A ;

        
        System.out.println("\n\n*** BubbleSort ***");
        A = new int[]{3,0,40,19,17,86,18,6};
        System.out.println("Array Before:");
        printArray(A);        
        bubbleSort(A);
        System.out.println("Array After:");
        printArray(A);
        

        System.out.println("\n\n*** SelectionSort ***");
        A = new int[]{3,0,40,19,17,86,18,6};
        System.out.println("Array Before:");
        printArray(A);
        selectionSort(A);
        System.out.println("Array After:");
        printArray(A);

        
        System.out.println("\n\n*** InsertionSort ***");
        A = new int[]{3,0,40,19,17,86,18,6};
        System.out.println("Array Before:");
        printArray(A);
        insertionSort(A);
        System.out.println("Array After:");
        printArray(A);
        

        System.out.println("\n\n*** MergeSort ***");
        A = new int[]{3,0,40,19,17,86,18,6};
        System.out.println("Array Before:");
        printArray(A);
        mergeSort(A);
        System.out.println("Array After:");
        printArray(A);

        
    }
    
    
    
    // Merge sort
    public static void mergeSort(int[] a) {
        mergeSortHelper(a, 0, a.length-1);
    }
    
    
    private static void mergeSortHelper(int[] a,int from, int to) {
        if (from < to) {
            int middle = (from + to) / 2;
            mergeSortHelper(a, from, middle);
            mergeSortHelper(a, middle + 1, to);
            merge(a, from, middle, to);
            printArray(a);
        }
    }
    
    private static void merge(int[] a, int from, int mid, int to) {
        int[] tmp = new int[to-from+1];
        int idx1 = from;
        int idx2 = mid + 1;
        int idx = 0;

        while (idx1 <= mid && idx2 <= to) {
            if (a[idx1] < a[idx2])
                tmp[idx] = a[idx1++];
            else 
                tmp[idx] = a[idx2++];
            idx++;
        }
        while (idx1 <= mid) 
            tmp[idx++] = a[idx1++];

        while (idx2 <= to)
            tmp[idx++] = a[idx2++];

        for (int k = from; k <= to; k++)
            a[k] = tmp[k-from];
 
    }
    
    
    // Insertion sort: Insert it in the right place. 'Card' dealers sorting.
    // Things to contemplate:
    //  Selecting the largest one to the top.
    //  NOT doing it in-place
    //  What if the list is already ordered? upside down?
    
    public static void insertionSort(int[] a) {
        for (int ii=1; ii < a.length; ++ii) {
            int tmp = a[ii];
            int idx = ii;
            while (idx > 0 && tmp < a[idx-1]) {
                a[idx] = a[idx-1];
                --idx;
            }
            a[idx] = tmp;
            printArray(a);
        }
    }
    
    

    // Selection sort: Picks the minimum every time
    // Things to contemplate:
    //  Selecting the largest one to the top.
    //  NOT doing it in-place
    //  What if the list is already ordered? upside down?
    
    public static void selectionSort(int[] a) {
        for (int ii=0; ii<a.length-1; ++ii){
            int idx = ii;
            for (int jj = ii + 1; jj < a.length; jj++){
                if (a[jj] < a[idx]) 
                    idx = jj;
            }
            // swap
            int temp = a[ii];
            a[ii] = a[idx];
            a[idx] = temp;
            
            printArray(a);
        }
    }
    
    // Bubble the largest to the top
    // Things to contemplate:
    //  Bubble the smallest one to the bottom.
    //  NOT doing it in-place
    //  What if the list is already ordered? upside down?
    public static void bubbleSort(int[] a)
    {
        // do the changeMade only later on
        boolean changeMade = true;
        for (int ii = a.length - 1; ii > 0 && changeMade ; --ii) 
        {
            changeMade = false;
            for (int jj = 0; jj < ii; ++jj) {
                if (a[jj] > a[jj + 1]) {
                    changeMade = true;
                    // swap
                    int tmp = a[jj + 1];
                    a[jj + 1] = a[jj];
                    a[jj] = tmp;
                }
            }
            printArray(a);
        }
    }
     
    
    public static void printArray(int[] a) {
        for (int ii=0; ii<a.length ;++ii)
            System.out.print(a[ii] + " ,");
        System.out.println();
    }
    
    
    
}
