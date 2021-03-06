package array_tasks;

public class labs5_3 {
    public static void main(String[] args) {
        //System.out.println("Enter size of array: ");
        //Scanner input = new Scanner(System.in);
        int size = 6, mul = 1, sum = 0;
        int firstState = -1, secondState = 0; //'-1' undefined state
        int isWithZero = 0; //if our array start with zero this flag = true
        int[] array = new int[size];
        array[0] = 10;
        array[1] = 12;
        array[2] = 0;
        array[3] = -1;
        array[4] = 2;
        array[5] = 0;
        //for (int i = 0; i < size; i++)
        //       array[i] = (int)(0 + (Math.random() * 10));
        System.out.print("Source array:");
        for (int i = 0; i < size; i++)
            System.out.print(" " + array[i]);
        for (int i = 0; i < size; i++)
            if (i % 2 == 0)
                mul *= array[i];
        for (int i = 0; i < size; i++) {
            if (array[i] == 0 && firstState != -1) {
                isWithZero++;
                secondState = i;
                System.out.print(";{secondState = " + secondState + "}");
            }
            if (array[i] == 0 && firstState == -1) {
                firstState = i;
                isWithZero++;
                System.out.print("\r\n{firstState = " + firstState + "}");
            }
        }
            if (isWithZero != 2) {
                try {
                    throw new NullPointerException("two zeros nothing found");
                }
                catch(NullPointerException e){
                    System.out.print("\r\n" + e);
                }
            }
            else {
                for (int i = firstState; i < secondState; ++i)
                    sum += array[i];
                System.out.println("\r\nProduct of array elements with even numbers = " + mul + "\r\nThe sum of numbers located between 0 = " + sum);
                System.out.print("modified array:");
                sort(array, size);
                show(array, size);
            }
    }
    static int[] sort(int[] array, int size){
        int nn = size, tmp;
        for (int i = 0; i < nn; i++){
            if (array[i] < 0){
                tmp = array[i];
                for (int j = i; j < size-1; ++j){
                    array[j] = array[j+1];
                }
                array[size-1] = tmp;
                --nn;
                --i;
            }
        }
        return (array);
    }
    static void show(int[] array, int size){
        for (int i = 0; i < size; i++)
            System.out.print(" " + array[i]);
    }
}
