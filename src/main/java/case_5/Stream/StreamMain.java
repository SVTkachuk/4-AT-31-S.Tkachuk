package case_5.Stream;

import java.util.*;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        //Input - collection of employees(simple model with few fields: name, mail, salary…).
        List<Cat> list =new ArrayList<>( Arrays.asList(
        new Cat("Enda",8,"Birman"),
        new Cat("Ela",5,"Bengal"),
        new Cat("Ray",10,"British"),
        new Cat("Virgo",4,"Havana"),
        new Cat("Bemba",2,"LaPerm")
        ));
        System.out.println(list);

        //Using stream functionality sort the list,
        list = (List<Cat>) list.stream().sorted(Comparator.comparing(Cat::getName)).collect(Collectors.toList());
        System.out.println("Sorted by name:");
        System.out.println(list);

        //filter it (ex: salary should be more than 1000$).

        List<Cat> oldCats = list.stream().filter(p -> p.getAge() > 7).collect(Collectors.toList());
        System.out.println("Old cats:");
        System.out.println(oldCats);

        List<Cat> britishBreed = list.stream().filter(p -> p.getBreed() == "British").collect(Collectors.toList());
        System.out.println("British cats:");
        System.out.println(britishBreed);
    }


}
