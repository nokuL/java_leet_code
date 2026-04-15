package arrays;

public class ContainerWithMostWater {

    //given an array with heights of water, calculate the max
    //contstraints; are there ever negative values ;
    //what is the max length range of the arra
    //can heights be zero ?
    //output: what should
    //

    //sudo
    //have two pointers, left starts at 0, right is at length -1
    //loop through the array
    //calculate the volume  = (right -left) * Math.min(height[left], height[right])
    //get maxVolume = Math.max(maxVolume, volume)
    //return maxVolume


    public static int mostWaterContainer(int [] heights){

        int volume = 0;
        int left = 0;
        int right = heights.length -1;
        int maxVolume = 0;

        while(left < right){

            int width = right - left;
            int height = Math.min(heights[right], heights[left]);

            volume = width * height;
           maxVolume = Math.max(maxVolume, volume);
           if(heights[left] < heights[right]){
               left ++;
           }else{
               right--;
           }

        }
        return  maxVolume;

    }
}
