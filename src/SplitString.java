public class SplitString {

    public static String splitString(String str) {
        char[] chars = str.toCharArray();
        String string1 = "";
        String string2 = "";
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {
            try {
                if( (chars[i]==' ')||(chars[i]=='\n') ){
                    string1 = str.substring(0, i );
                    string2 = str.substring(i + 1);
                }
            } catch (Exception e) {

            }

        }
        stringBuilder.append(string2);
        stringBuilder.append(" ");
        stringBuilder.append(string1);
        return stringBuilder.toString();
    }
}