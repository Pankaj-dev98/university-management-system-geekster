package org.orgless.universityeventmanagement.Service;

import org.orgless.universityeventmanagement.entity.Student;
import utils.Branch;

import java.util.List;

public interface StudentService {
    String addStudent(Student student);

    Student updateDeptById(int id, Branch department);

    String deleteStudentById(int id);
    List<Student> getAllStudents();
    Student getStudentById(int id);
}
