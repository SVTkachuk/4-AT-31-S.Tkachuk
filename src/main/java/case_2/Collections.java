package case_2;

import javax.swing.*;
import java.util.*;
import java.util.Arrays;

public class Collections {
    public static void main(String[] args) {
        // 1) Implement an application to work with a list. In the 1st half of the
        // list replace all elements E1 with E2
        System.out.println("task 1");
        Integer e1 =1;
        Integer e2 =10;
        List<Integer> collection1 = new ArrayList<>(Arrays.asList(1,2,1,4,5,6,1,8,9));
        System.out.println(collection1);
        for(int i=0 ; i<collection1.size()/2;i++){
            if(collection1.get(i).equals(e1)){
                collection1.set(i,e2);
            }
        }
        System.out.println(collection1);
        //2) Input: matrix of integers.
        // a) Print out matrix in reverse order.
        // b) Print out matrix with unique values (delete duplicates)
        System.out.println("task 2");
        List<List<Integer>> collection2 = new ArrayList<>(Arrays.asList(
                Arrays.asList(1,1,1),
                Arrays.asList(2,2,3),
                Arrays.asList(4,4,5)
        ));
        for(int i=0; i <collection2.size();i++){
            System.out.println();
            for(int j =0;j< collection2.get(0).size();j++){
                System.out.print(collection2.get(i).get(j)+" ");
            }
        }
        System.out.println("");
        System.out.println("Reverse:");
        for(int i=0; i <collection2.size();i++){

            for(int j =0;j< collection2.get(0).size();j++){
                System.out.print(collection2.get(j).get(i)+" ");
            }
            System.out.println();
        }
        Set<Integer> uniqueElements = new HashSet<>();
        for(int i=0; i <collection2.size();i++){
            for(int j =0;j< collection2.get(0).size();j++){
                if(uniqueElements.contains(collection2.get(i).get(j))){
                    collection2.get(i).set(j,0);
                }
                else{
                    uniqueElements.add(collection2.get(i).get(j));
                }
            }
        }
        System.out.println();
        System.out.println("Unique:");
        for(int i=0; i <collection2.size();i++){

            for(int j =0;j< collection2.get(0).size();j++){
                System.out.print(collection2.get(i).get(j)+" ");
            }
            System.out.println();
        }
        //3) Given: String with big text (more than 1000 words).
        // Write a method that calculates the numbers of words for each letter that starts the word.
        System.out.println("Task 3");
        String inputString = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum ac faucibus enim. " +
                "Pellentesque non porttitor lacus. In interdum tempus odio, sed cursus orci pretium nec. " +
                "Cras auctor mauris dui, nec sagittis tellus luctus in. Sed ac tincidunt libero. Nunc sed sodales diam. " +
                "In nec turpis massa. Quisque sollicitudin mauris et justo fermentum iaculis." +
                " Maecenas pulvinar, risus vitae congue maximus, quam lorem molestie dolor, in volutpat arcu eros id mauris.";
        Map<String,Integer> result_3 = new HashMap<>();
        Arrays.stream(inputString.split(" ")).forEach(w->{
            String key = String.valueOf(w.charAt(0));
            result_3.putIfAbsent(key,0);
            result_3.put(key,result_3.get(key)+1);

        });
        System.out.println(result_3);

    }

}
