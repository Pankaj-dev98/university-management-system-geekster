package org.orgless.universityeventmanagement.Service;

import jakarta.transaction.Transactional;
import org.orgless.universityeventmanagement.entity.Student;
import org.orgless.universityeventmanagement.persistence.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.Branch;
import utils.StudentNotFoundException;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentDAO studentDAO;

    @Autowired
    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    @Transactional
    public String addStudent(Student student) {
        student.setId(0);
        studentDAO.save(student);
        return "STUDENT ADDED \n" + student;
    }

    @Override
    @Transactional
    public Student updateDeptById(int id, Branch department) {
        return studentDAO.updateDepartment(id, department);
    }

    @Override
    @Transactional
    public String deleteStudentById(int id) {
        if(studentDAO.deleteById(id))
            return "STUDENT DELETED [ID = " + id + "]";

        throw new StudentNotFoundException(id);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDAO.findAll();
    }

    @Override
    public Student getStudentById(int id) {
        Student s = studentDAO.find(id);

        if(s == null)
            throw new StudentNotFoundException(id);
        return s;
    }
}
