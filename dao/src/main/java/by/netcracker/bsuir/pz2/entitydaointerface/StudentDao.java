package by.netcracker.bsuir.pz2.entitydaointerface;

import by.netcracker.bsuir.pz2.entity.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDao {
    public boolean create(Student student) throws SQLException;
    public Student getStudentById(int studentId);
    public boolean update(Student student);
    public boolean delete(Student student);

    public List<Student> getAll();
}
