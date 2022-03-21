package case_2;

import java.util.*;

public class CheckPerformance {
    public static void main(String[] args) {
        // 4) Check performance for some List operations
        // (get(i), insertAfter(i), ..) for different collection implementations.
        List<String> arrayList = new ArrayList<>(List.of(("Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...")
                .split(" ")));
        ExpandList(arrayList);
        List<String> linkedList = new LinkedList<>(arrayList);
        System.out.println("array list 'get': "+checkGet(arrayList));
        System.out.println("linked list 'get': "+checkGet(linkedList));
        System.out.println("array list 'add': "+checkInsert(arrayList));
        System.out.println("linked list 'add': "+checkInsert(linkedList));
    }

    private static List<String> ExpandList(List<String> list) {
        for(int i=0;i<10;i++){
            list.addAll(list);
        }
        return list;
    }

    private static long checkInsert(List<String> arrayList) {
        long start = new Date().getTime();
        int size = arrayList.size();
        for(int i =0;i<1000;i++){
            int randomIndex = new Random().nextInt(size);
            arrayList.add(randomIndex,"s");
        }
        return new Date().getTime()-start;
    }

    private static long checkGet(List<String> arrayList) {
        long start = new Date().getTime();
        int size = arrayList.size();
        for(int i =0;i<1000;i++){
            int randomIndex = new Random().nextInt(size);
            int wSize = arrayList.get(randomIndex).length();
        }
        return new Date().getTime()-start;
    }

}
