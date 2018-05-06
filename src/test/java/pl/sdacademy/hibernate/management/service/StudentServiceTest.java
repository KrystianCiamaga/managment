package pl.sdacademy.hibernate.management.service;


import org.junit.Assert;
import org.junit.Test;
import pl.sdacademy.hibernate.management.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceTest {


    private StudentService studentService=new StudentService();


    @Test
    public void findAll(){

        List<Student> all = studentService.findAll();

        all.forEach(s->System.out.println());

    }


    @Test
    public void findById(){

        List<Student> students=new ArrayList<>();

        students.add(new Student("jeden","jeden","jeden","jeden"));
        students.add(new Student("dwa","dwa","dwa","dwa"));
        students.add(new Student("trzy","trzy","trzy","trzy"));

        students.get(0).setId(1);
        students.get(1).setId(3);
        students.get(2).setId(3);

        System.out.println();


    }







}