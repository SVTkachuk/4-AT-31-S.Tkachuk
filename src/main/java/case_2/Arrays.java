package case_2;

public class Arrays {
    public static void main(String[] args) {
       // 1) Find max number in array: 5, 9, 3, 2, 0, -4, -8.3, 3, -4
        System.out.println("Task 1");
    double[] array_1 ={5,9,3,2,0,-4,-8.3,-4};
    double max_number = array_1[0];
    for(double e:array_1){
    if (e>max_number){
        max_number =e;
            }
        System.out.printf(e+" ");
        }

        System.out.println("max number: " + max_number);
        //2) Given array: {1, 6, 3, 3, 4, 5, 5, 6, 0}. Print array with only unique values, which are sorted.
        System.out.println("Task 2");
        int[] array_2 = {1,6,3,3,4,5,5,6,0};
        java.util.Arrays.sort(array_2);
        int[] result_2 = new int[array_2.length];

        int j=0;
        int unique_amount=1;
        for(int i=0;i<array_2.length;i++){
            if(!contains(result_2,array_2[i])) {
                result_2[++j] = array_2[i];
                unique_amount++;
            }
        }
        for(int i=0;i<unique_amount;i++) {
            System.out.printf(result_2[i]+" ");
        }
       // 3) Given an array, e.g. "12", "23", "34", "12", "56", "67“. Replace all values “12” to “replaced”
        System.out.println("");
        System.out.println("task 3");
        String[] array_3 = {"12", "23", "34", "12", "56", "67"};
        for(String e:array_3){
            if(e.equals("12")){
                e = "replaced";
            }
            System.out.printf(e+" ");
        }
        //4) Print any array in reverse mode (from the end)
        System.out.println("");
        System.out.println("task 4");
        int[] array_4 = {1,2,3,4,5,6,7,8};
        int[] result_4 = new int[array_4.length];
        int k=0;
        for(int i=array_4.length-1; i>=0;i--){
            result_4[k++]=array_4[i];
        }
        for(int e:result_4){
            System.out.printf(e+" ");
        }
        }



    private static boolean contains(int[] array, int element) {
        for(int e:array){
            if(element == e){
                return true;
            }
        }
        return false;
    }


}
