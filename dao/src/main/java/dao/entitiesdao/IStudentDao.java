package dao.entitiesdao;

import entities.Student;

import java.util.List;

public interface IStudentDao {
    public Student create();
    public Student read(int key);
    public boolean update(Student student);
    public boolean delete(Student student);

    public List<Student> getAll();
}
