public class InsertionSort extends Sort{


    //O(n2)
    static void sort(int[] a){

        for (int i=1;i<a.length;i++){
            int j=i;
            while (j>0 && a[j]<a[j-1]){
                swap(a,j,j-1);
                j--;
            }
        }

    }
}
