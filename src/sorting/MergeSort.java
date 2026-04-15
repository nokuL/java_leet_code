package sorting;

public class MergeSort {

    //given an array of integers , sort it
    //using merge sort technique
    //constraints, ascending or descending order ? , is it inplace or i can use extra memory ? what is the maximum limit of numbers
    //split the array int two, repeatedly until there are individual elements
    //sort recurssively ,then combine result
    //return result


    public static void mergeSort(int[] inputArrayA, int start, int end){

        if (start >= end) return;

            int mid = (start+end)/2;

            mergeSort(inputArrayA, start, mid);

            mergeSort(inputArrayA, mid +1 , end);

            merge(inputArrayA, start, mid, end);
    }


    public static int[] merge(int[] inputArrayA , int start, int mid, int end){

        int i = start;
        int j = mid +1;
        int resultArrayLength = end - start +1;
        int resultArray [] = new int [resultArrayLength];
        int k = 0;

        while(i<= mid && j<= end){
            if(inputArrayA[i]<inputArrayA[j]){
                resultArray[k] = inputArrayA[i];
                k++;
                i++;
            }else{
                resultArray[k] = inputArrayA[j];
                k++;
                j++;
            }

        }
        while(i<=mid){
            resultArray[k] = inputArrayA[i];
            i++;
            k++;

        }
        while(j<=end){
            resultArray[k] = inputArrayA[j];
            j++;
            k++;
        }

        for(int z = 0; z < resultArrayLength; z++){
            inputArrayA[start +z] = resultArray[z];

        }


        return resultArray;

    }
}
