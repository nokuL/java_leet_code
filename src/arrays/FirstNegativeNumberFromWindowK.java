package arrays;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class FirstNegativeNumberFromWindowK {


    public static List<Integer>firstNegNum(int []input , int k) {

        // what is k ? 3
        //what am i tracking ? the indicies of negative numbers
        //what am i computing per window ? the 1st neg number

        //sudo
        //build first window
        //loop from 0 to k
        //add all neg from 0 to k to dequeue
        //record result by peeking and append to list
        //loop from right 0 k to less than length of array
        //if element is neg, add to dequeue
        //if dequeue is not empty and the value indicie in dequeue == right -k , remove that value
        //record the remaining top of queue in result

        List<Integer>result = new ArrayList<>();
        ArrayDeque<Integer>arrayDeque = new ArrayDeque<>();

        if(input.length < k ){
            throw new IllegalArgumentException();
        }

        //first window
        for(int i = 0; i < k; i++){
            if(input[i] < 0){
                arrayDeque.addLast(i);
            }
        }
        if(!arrayDeque.isEmpty()){
            result.add(input[arrayDeque.peekFirst()]);
        }else{
            result.add(0);
        }

        for(int right = k; right < input.length; right++){
            //add
            if(input[right] < 0){
                arrayDeque.addLast(right);
            }

            //evict
            if(!arrayDeque.isEmpty() && arrayDeque.peekFirst() == right -k){
                arrayDeque.pollFirst();
            }

            if(!arrayDeque.isEmpty()){
                result.add(input[arrayDeque.peekFirst()]);


            }else {
                result.add(0);
            }

        }
        return  result;


    }
}
