package pl.sdacademy.hibernate.management.app;

import pl.sdacademy.hibernate.management.model.Student;
import pl.sdacademy.hibernate.management.service.AddressService;
import pl.sdacademy.hibernate.management.service.StudentService;

import java.util.List;


public class UniversityManagementApp {

    public static void main(String[] args) {


        StudentService studentService=new StudentService();
        AddressService addressService=new AddressService();


            Student student=new Student("laaaaaaaala","laala","laala","laala");



       studentService.update(student);




    }

}
