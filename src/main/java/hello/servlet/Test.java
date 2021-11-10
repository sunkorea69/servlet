package hello.servlet;
import java.util.*;


class Student {
    String name;
    int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }
}
public class Test {

    private static void selectionSort(int[] arr) {
        selectionSort(arr,0);
    }
 //                0,1,2,3,4,5,6
//    int[] arr = {3,6,2,8,1,4};
    private static void selectionSort(int[] arr, int start) {
    }
    private static void swap(int[] arr, int index1, int index2) {
    }
    private static void pritArray(int[] arr) {
    }

    public static void main(String[] args) {
        int[] arr = {3,6,2,8,1,4};
        pritArray(arr);
        selectionSort(arr);
        pritArray(arr);


        {
            List<Student> list = new ArrayList<Student>();

            list.add(new Student("a", 5));
            list.add(new Student("b", 10));
            list.add(new Student("c", 1));
            list.add(new Student("d", 52));
            list.add(new Student("e", 23));

            Collections.sort(list, new Comparator<Student>() {
                @Override
                public int compare(Student s1, Student s2) {
                    if (s1.getScore() < s2.getScore()) {
                        return -1;
                    } else if (s1.getScore() > s2.getScore()) {
                        return 1;
                    }
                    return 0;
                }
            });
            System.out.println("AA");
            for (Student s : list) {
//                System.out.println(s.getScore());
            }
        }



    }
}
