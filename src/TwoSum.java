public class TwoSum {

    public static int [] twoSum(int [] array, int target) throws ArrayIndexOutOfBoundsException{
        int count = 0;
        int currentNumber = 0;
        int [] arrayResult = new int[2];
        while(count < array.length){
            currentNumber = array[count];
            for(int i = count +1 ; i< array.length; i++){
                if(currentNumber + array[i] == target){
                    arrayResult[0] = count;
                    arrayResult[1] = i;
                }
            }
            count++;
        }
        return arrayResult;
    }
}
