package arrays;

public class MaximumProfit {

    //given an array of prices , find the best day to buy and best day to sell
//constraints :
// are values all positive ?
//what am i supposed to return if all values are the same and there is no profit ?
//what is the expected maximum number of days ?
//can it contain zeros
//can array be empty ? what should i do ?

// essentially looking for the biggest diff between the numbers, with the lowest being on the left and biggest on the right
//initialise selling price as array[1]
//initialise buyingPrice as array[0]
// initiatlise maxProfit as 0;
//initiatlise currentProfit
//loop thorugh the array,
//if sellingPrice is less than buyingprice ,, reset, buyingPrice = sellingPrice
//else profit = selling - buying
//maxProfit = max(profit, maxProfit);
//return maxProfit;


    public static int maximumProfit(int[] inputArray){

        if(inputArray == null || (inputArray.length == 0)){
            throw new IllegalArgumentException("Invalid input");

        }

        if(inputArray.length == 1){
            return 0;
        }
        int buyingPrice = inputArray[0];
        int sellingPrice = 0;
        int currentProfit = 0;
        int maxProfit = 0;

        for(int i = 1; i < inputArray.length; i++){
            sellingPrice = inputArray[i];
        if(sellingPrice < buyingPrice ){
            buyingPrice = sellingPrice;

        }else{
            currentProfit = sellingPrice - buyingPrice;

        }
        maxProfit = Math.max(maxProfit, currentProfit);

        }
        return  maxProfit;
    }
}
