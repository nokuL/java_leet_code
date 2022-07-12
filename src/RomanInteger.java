import java.util.HashMap;

public class RomanInteger {

    public  static int romanToInt(String roman) throws ArrayIndexOutOfBoundsException{
        HashMap<String , Integer>hashMap = new HashMap();
        hashMap.put("I", 1);
        hashMap.put("V", 5);
        hashMap.put("X", 10);
        hashMap.put("L", 50);
        hashMap.put("C" , 100);
        hashMap.put("D", 500);
        hashMap.put("M", 1000);

        int number = 0;

        char [] chars = roman.toCharArray();
        for(int i =0 ; i<=chars.length-1; i++){

            if(!hashMap.containsKey(Character.toString(chars[i]))){
                throw new IllegalArgumentException("Invalid character");
            }
            if(chars[i] == 'I' && i!= chars.length-1){
                if (chars[i+1] == 'V') {
                    number  += 4;
                    i++;
                }else if
                (chars[i+1]== 'X'){
                    number += 9;
                    i++;
                }else{
                    number += hashMap.get("I");
                }
            }else if
            (chars[i] == 'X' &&i!= chars.length-1){
                if (chars[i+1] == 'L') {
                    number += 40;
                    i++;
                }else if
                 (chars[i+1]== 'C'){
                    number += 90;
                    i++;
                }else{
                    number += hashMap.get("X");
                }
            }
            else if(chars[i] == 'C' &&i!= chars.length-1){
                if (chars[i+1] == 'D') {
                    number  += 400;
                    i++;
                }else if
                (chars[i+1]== 'M'){
                    number += 900;
                    i++;
                }else{
                    number += hashMap.get("C");
                }
            }else {
                number += hashMap.get(Character.toString(chars[i]));
            }

        }

        return number;

    }
}
