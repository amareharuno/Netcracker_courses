package by.netcracker.bsuir.pz2.daoInterface;

import by.netcracker.bsuir.pz2.entity.Student;

import java.util.List;

public interface StudentDao {
    public boolean create(Student student);
    public Student getStudentById(int studentId);
    public boolean update(Student student);
    public boolean delete(Student student);

    public List<Student> getAll();
}
