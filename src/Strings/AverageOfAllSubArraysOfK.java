package Strings;

import java.util.ArrayList;
import java.util.List;

public class AverageOfAllSubArraysOfK {

    //given an array, return the average of subarrays of k
    //constraints
    //what is the length range of the expected array
    //am i returninthe maximum average or an array of all subaarrays ?
    //can array be empty ? what is the expected behaviour then ?
    //can array contain float values or just int ?
    //can k be larger than the length of the array ?
    //
    //
    //sudo code
    //handle edge cases, empty array, k bigger than expected
    //have a result list ,
    //build first window, find average of the first sub array, loop from 0 to K , summ up and divide by k
    //build second window, loop from k up to less array.length
    //for each iteration add item to right , remove item to left , divide by K , append average to result array
    //return  result array

    public static List<Double> averageOfAllSubs(Double [] numbers , int k){

        Double sum = 0.0;
        Double average = 0.0;

        if(numbers == null || k > numbers.length || numbers.length == 0 ){
            throw new IllegalArgumentException();

        }
        List<Double> resultList = new ArrayList<>();
        for(int i = 0; i < k; i++ ){
            sum += numbers[i];

        }
        average = sum / k;
        resultList.add(average);

        //building second window
        for(int right = k; right< numbers.length; right++){
            sum += numbers[right];
            sum-=numbers[right-k];
            average = sum /k;
            resultList.add(average);
        }
        return  resultList;
    }
}
