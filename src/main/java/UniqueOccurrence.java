import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class UniqueOccurrence {

//    Constraints:
//
//            1 <= arr.length <= 1000
//            -1000 <= arr[i] <= 1000


//    int[] arr = {-3,0,1,-3,1,1,1,-3,10,0}; //true
//    int[] arr = {1,2}; //false
//    int[] arr = {1,2,2,1,1,3}; //true


    int[] arr = new int[1000];

    void inputArrayData(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 2000) - 1000;
        }
    }

    void printArray(int[] arr) {
        System.out.println("Array size is: " + arr.length);
        System.out.println(Arrays.toString(arr));
        System.out.println("-----------------------------------------");
    }

    boolean checkArrayNumberOccurrences(int[] arr) {

        int[] distinctArr = Arrays.stream(arr)
                .distinct()
                .toArray();

        int count = 0;

        List<Integer> tempList = new LinkedList<>();

        for (int i = 0; i < distinctArr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (distinctArr[i] == arr[j]) count++;
            }
            if (count > 0) {
                tempList.add(count);

            }
            count = 0;
        }

        if (tempList.size() == 0) return false;
        else {
            for (int i = 0; i < tempList.size(); i++) {
                for (int j = i + 1; j < tempList.size(); j++) {
                    if (tempList.get(i) == tempList.get(j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {

        UniqueOccurrence unique = new UniqueOccurrence();

        unique.inputArrayData(unique.arr);
        unique.printArray(unique.arr);
        boolean count = unique.checkArrayNumberOccurrences(unique.arr);

        System.out.println(count);
    }
}
