public class SelectionSort extends Sort{

    //Time complexity is O(n2)
    static void sort(int[] array) {
        System.out.println(SelectionSort.class.getCanonicalName());
        for (int i=0;i<array.length;i++){
            int min=i;
            for (int j=i+1;j<array.length;j++){
                if(array[j]<array[min])
                       min=j;
            }
            swap(array,i,min);
        }
    }




}
