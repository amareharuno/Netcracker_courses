package dao.mysql;

import entities.Student;
import dao.entitiesdao.IStudentDao;

import java.sql.Connection;
import java.util.List;

public class MySqlStudentDao implements IStudentDao{

    private final Connection connection;

    public MySqlStudentDao(Connection connection) {
        this.connection = connection;
    }

    public Student create() {
        return null;
    }

    public Student read(int key) {
        return null;
    }

    public boolean update(Student student) {
        return false;
    }

    public boolean delete(Student student) {
        return false;
    }

    public List<Student> getAll() {
        return null;
    }
}
