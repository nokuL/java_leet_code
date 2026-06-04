package generic;

public class Fibonacci {


    //given two numbers to start with, print the fibonacci series
    //what kind of numbers are they ? int , float , double?
    //are there ever negative numbers ?
    //whats the limit, as in how many numbers am i printing?
    //whats the output like ? print as i go ? or you want a list ?


    //sudo
    //given two numbers
    //num1 = 0, num2 = 1
    //loop through starting from i = 2 , since you alrdy have the first 2 nums
    //compute the 3rd number
    //assign num1 to num2 , and num2 to num3 , loop again to get the third number until we get to the limit


    public void fibonacci(int n){

        int num1 = 0, num2 = 1;
        System.out.println("Num1   "+ num1 +" Num2  "+num2);
        for(int i = 2; i<n ; i++){
            int num3 = num1 + num2;
            System.out.println("Num3  "+ num3);

            num1 = num2;
            num2 = num3;
        }
    }
}
