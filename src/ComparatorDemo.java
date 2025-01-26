import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Student{
    // We can also implement the comparable interface to use the sort method for strings without the Comparator
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Students{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

//    public compareTo(Student that){
//        return this.age>that.age?1:-1;
//    }
}

public class ComparatorDemo {
    public static void main(String[] args) {
//        Comparator<Integer> sortByNameLength = new Comparator<Integer>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                if (o1.length() > o2.length()){
//                    return 1;
//                }else{
//                    return -1;
//                }
//
//            }
//        };

        Comparator<Student> studentComparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.name.length()>o2.name.length()){
                    return 1;
                }else{
                    return -1;
                }
            }
        };

//        Comparator<Student> studentComparator = (o1,o2)->{
//            if(o1.name.length()>o2.name.length()){
//                      return 1;
//                  }else{
//                       return -1;
//                  }
//        }; We can also do like this using the Lambda Expression


        ArrayList<Student> studentsArrayList = new ArrayList<Student>();
        studentsArrayList.add(new Student("Abishek",20));
        studentsArrayList.add(new Student("Enoth",21));
        studentsArrayList.add(new Student("Lithish",19));
        Collections.sort(studentsArrayList,studentComparator);
        for(Student s : studentsArrayList){
            System.out.println(s);
        }
    }
}

// Comparator - A third person compares the students
// Comparable - The students themselves compare each other
//
