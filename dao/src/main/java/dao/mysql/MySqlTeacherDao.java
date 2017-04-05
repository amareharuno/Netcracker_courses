package dao.mysql;

import entities.Teacher;
import dao.entitiesdao.ITeacherDao;

import java.sql.Connection;
import java.util.List;

public class MySqlTeacherDao implements ITeacherDao {

    private final Connection connection;

    public MySqlTeacherDao(Connection connection) {
        this.connection = connection;
    }

    public Teacher create() {
        return null;
    }

    public Teacher read(int key) {
        return null;
    }

    public boolean update(Teacher teacher) {
        return false;
    }

    public boolean delete(Teacher teacher) {
        return false;
    }

    public List<Teacher> getAll() {
        return null;
    }
}
