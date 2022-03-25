package case_4.Generic;

import case_4.Reflections.Human;

import java.util.*;

public class GenericMain {
    public static void main(String[] args) {
        //Make two different comparators for your Custom class (simple java class with few fields).
        // End users should be able to use ‘min’, ‘max’, ‘sort’ methods with that comparators.
    HumanById id = new HumanById();
        HumanByAge age = new HumanByAge();
        HumanByName name = new HumanByName();


        List<Human> list = new ArrayList<>(Arrays.asList(
                new Human(43550,"Eje",45),
                new Human(436321,"Ada",33),
                new Human(7,"vEr",88)
        ));
        System.out.println(list);
        //sort
        Collections.sort(list, id);
        System.out.println("SORTED BY ID:");
        System.out.println(list);

        Collections.sort(list, age);
        System.out.println("SORTED BY AGE:");
        System.out.println(list);

        Collections.sort(list, name);
        System.out.println("SORTED BY NAME:");
        System.out.println(list);

        //max & min
        System.out.println("MAX ID:");
        System.out.println(Collections.max(list,id));
        System.out.println("MIN ID:");
        System.out.println(Collections.min(list,id));
        System.out.println("MAX AGE:");
        System.out.println(Collections.max(list,age));
        System.out.println("MIN AGE:");
        System.out.println(Collections.min(list,age));
        System.out.println("MIN NAME:");
        System.out.println(Collections.min(list,name));
        System.out.println("MAX NAME:");
        System.out.println(Collections.max(list,name));
    }

    //Comparators
    public static class HumanById implements Comparator<Human> {

        public int compare(Human h1, Human h2) {
            return h1.getHumanId() - h2.getHumanId();
        }
    }
    public static class HumanByAge implements Comparator<Human> {

        public int compare(Human h1, Human h2) {
            return h1.getAge() - h2.getAge();
        }
    }
    public static class HumanByName implements Comparator<Human> {

        public int compare(Human h1, Human h2) {
            return h1.getName().compareTo(h2.getName());
        }
    }
}

