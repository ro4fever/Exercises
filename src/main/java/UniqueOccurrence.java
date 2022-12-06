public class UniqueOccurrence {

    static boolean count = false;

    static int[] arr = new int[1000];

    static void inputArrayData(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 1000) - 1000;
        }

    }

    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    static void checkArrayNumberOccurrences(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j])
                    count = true;
                else count = false;
            }
        }
    }


    public static void main(String[] args) {
        inputArrayData(arr);
        printArray(arr);
        checkArrayNumberOccurrences(arr);

        System.out.println(count);
    }
}
