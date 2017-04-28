package by.netcracker.bsuir.pz2.daoInterface;

import by.netcracker.bsuir.pz2.entity.Student;

import java.util.List;

public interface StudentDao {
    boolean create(Student student);
    Student getStudentById(int studentId);
    boolean update(Student student);
    boolean delete(Student student);

    List<Student> getAll();
}
