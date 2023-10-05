package org.orgless.universityeventmanagement.persistence;

import org.orgless.universityeventmanagement.entity.Student;
import utils.Branch;

import java.util.List;

public interface StudentDAO {
    void save(Student student);

    Student updateDepartment(int id, Branch department);

    boolean deleteById(int id);

    List<Student> findAll();
    Student find(int id);



}
