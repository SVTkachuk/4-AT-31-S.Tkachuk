package case_1;

import java.util.Scanner;

public class StringProcessor {

    public static void main(String[] args) {
        //Task 2. Given a string, find the number of words in it.
        Scanner input = new Scanner(System.in);
        System.out.println("Write something:");
        String s = input.nextLine();
        System.out.printf("Words:");
        int numberOfWords = s.split(" ").length;
        System.out.println(numberOfWords);

        //Task 3. Given a string, show number of chars in each word
        for(String word:s.split(" ")){
            System.out.println(word + " -length:" + word.length());
        }
        //Task 4. Create function which takes 2 parameters:
        //1st(String) – text; 2nd (int) - index of word. Function should return number of chars in word by its index in text
        System.out.println("Chose word index:");
        int index = input.nextInt() -1;
        while(index > numberOfWords){
            System.out.println("Max index is: " + numberOfWords);
           index = input.nextInt() -1;
        }
        wordPicker(s,index);
    }
    private static void wordPicker(String str, int i) {
        System.out.println(str.split(" ")[i] +  " -length:" + str.split(" ")[i].length());
    }
}
