public  class Sort {


    public static void main(String... args){

        int[] array={12,4,8,1,9,6,10,18,11,3};

        SelectionSort.sort(array);
        print(array);

        array = new int[]{154, 245, 568, 324, 654, 324};
        InsertionSort.sort(array);
        print(array);
    }

    private static void print(int[] array) {
        System.out.println(" ");
        for (int i :
                array) {
            System.out.print(i+" ");

        }
    }
    protected static void swap(int[] array, int i, int min) {
        int temp=array[i];
        array[i]=array[min];
        array[min]=temp;
    }
}
