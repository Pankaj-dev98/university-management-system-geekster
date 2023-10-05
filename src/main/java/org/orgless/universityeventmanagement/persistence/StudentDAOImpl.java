package org.orgless.universityeventmanagement.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.orgless.universityeventmanagement.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import utils.Branch;
import utils.StudentNotFoundException;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{
    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student updateDepartment(int id, Branch department) {
        Student s = entityManager.find(Student.class, id);

        if(s == null)
            throw new StudentNotFoundException(id);

        s.setDepartment(department);
        return entityManager.merge(s);
    }

    @Override
    public boolean deleteById(int id) {
        var query = entityManager.createQuery("delete from Student where id = :id");
        query.setParameter("id", id);

        int effect = query.executeUpdate();
        return effect > 0;
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = entityManager.createQuery("from Student", Student.class);
        return query.getResultList();
    }

    @Override
    public Student find(int id) {
        return entityManager.find(Student.class, id);
    }
}
