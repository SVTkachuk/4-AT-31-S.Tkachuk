package case_4.Reflections;

import java.lang.reflect.Field;

public class ReflectionMain {
    public static void main(String[] args) {
        //Write a method which can work with any object using reflection. End user should be able use it like this:
        //get(object,”fieldName”) - return value of field
        //		put(object,”fieldName”,value) - put the value to field
        //		clear(object,”fieldName”) - put null or 0 to the field.
        //Methods should throw exceptions with explanations if something is wrong.

        Human human = new Human(43550,"Eje",45);

        getHuman(human,"humanId");
        putHuman(human,"name");
        getHuman(human,"name");
        clearHuman(human,"age");
        getHuman(human,"age");
    }

    private static void clearHuman(Object object, String fieldName) {
        Class humanClass=object.getClass();
        try {
            Field field = humanClass.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(object,null);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    private static void putHuman(Object object, String fieldName) {
        Class humanClass=object.getClass();
        try {
            Field field = humanClass.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(object,"Evie"); ;
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    private static void getHuman(Object object,String fieldName) {
    Class humanClass=object.getClass();
        try {
            Field field = humanClass.getDeclaredField(fieldName);
            field.setAccessible(true);
            System.out.println(field.get(object));  ;
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

}
