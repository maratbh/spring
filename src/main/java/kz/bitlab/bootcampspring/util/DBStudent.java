package kz.bitlab.bootcampspring.util;

import kz.bitlab.bootcampspring.model.Student;
import java.util.ArrayList;


public class DBStudent {
    private static ArrayList<Student> arrStudents = new ArrayList<>();

    static {
        arrStudents.add(new Student(1L, "Ilyas", "Zhuanyshev", 80, "B"));
        arrStudents.add(new Student(2L, "Marat", "Bokhashov", 70, "C"));
        arrStudents.add(new Student(3L, "Kuat", "Zhuanyshev", 60, "C"));
        arrStudents.add(new Student(4L, "Edil", "Bakenov", 49, "F"));
    }

    public static Student addStudent(Student Student){
        Student.setId(Long.valueOf(arrStudents.size() + 1));
        Student.setMark(Student.getMarkToScreen());
        arrStudents.add(Student);

        return Student;
    }

    public static Student getItem(Long id){
        return arrStudents.stream().filter(item -> item.getId().equals(id)).findFirst().orElse(null);
    }

    public static ArrayList<Student> getStudents(){
        return arrStudents;
    }
}