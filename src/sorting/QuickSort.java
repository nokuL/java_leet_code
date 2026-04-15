package sorting;

public class QuickSort {

    //given an array to sort
    //choose a pivot
    //do the partitiononing
    //recursively sort

    public static void quickSort(int [] inputArray , int lowIndex, int highIndex){

        if(lowIndex >=  highIndex) return ;

        int pivot = inputArray[highIndex];
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        //partitioning
        while(leftPointer < rightPointer){
            while(inputArray[leftPointer] <= pivot && leftPointer < rightPointer){
                leftPointer++;
            }
            while (inputArray[rightPointer]>= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }

            swap(inputArray, leftPointer, rightPointer);


        }
        swap(inputArray, leftPointer, highIndex);
        quickSort(inputArray, lowIndex, leftPointer -1);
        quickSort(inputArray, leftPointer +1 , highIndex);


    }

    private static void swap(int [] array, int leftPointer, int rightPointer){
        int temp = array[leftPointer];
        array[leftPointer] = array[rightPointer];
        array[rightPointer] = temp;

    }
}
