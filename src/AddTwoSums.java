import java.util.LinkedList;

public class AddTwoSums {
    public static LinkedList<Integer> addTwoSums(LinkedList<Integer> integerLinkedList1, LinkedList<Integer> linkedList2) throws NumberFormatException {

        LinkedList<Integer> linkedListResult = new LinkedList<>();

        int count = 0;

        StringBuilder stringBuilder1 = new StringBuilder();

        StringBuilder stringBuilder2 = new StringBuilder();

        for (int i = 0; i < integerLinkedList1.size(); i++) {
            stringBuilder1.append(integerLinkedList1.get(i));
        }

        for (int i = 0; i < linkedList2.size(); i++) {
            stringBuilder2.append(linkedList2.get(i));
        }
        int num1 = Integer.parseInt(stringBuilder1.reverse().toString());
        int num2 = Integer.parseInt(stringBuilder2.reverse().toString());

        String resultString = String.valueOf(num1 + num2);

        while (count < resultString.length()) {
            linkedListResult.add(Integer.parseInt(Character.toString(resultString.charAt(count))));
            count++;
        }

        return linkedListResult;
    }

}
