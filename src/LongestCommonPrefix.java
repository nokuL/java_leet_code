import java.util.List;

public class LongestCommonPrefix {

    public static String getLongestPrefix(List<String> arrayList) {
         if(arrayList.size()==0)
             return "";
        String firstString = arrayList.get(0);
            for(int i = 1 ; i< arrayList.size(); i++){
               while(arrayList.get(i).indexOf(firstString)!=0){
                   firstString = firstString.substring(0, firstString.length() -1);
               }
            }


        return firstString;

    }
}
