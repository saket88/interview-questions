public class SelectionSort {

    public static void main(String... args){

        int[] array={12,4,8,1,9,6,10,18,11,3};
        selectionSort(array);
        for (int i :
                array) {
            System.out.print(i+" ");

        }
    }

    private static void selectionSort(int[] array) {
        for (int i=0;i<array.length;i++){

            int min=i;
            for (int j=i+1;j<array.length;j++){
                if(array[j]<array[min])
                       min=j;
            }
            swap(array,i,min);
        }
    }

    private static void swap(int[] array, int i, int min) {
        int temp=array[i];
        array[i]=array[min];
        array[min]=temp;
    }


}
