package by.netcracker.bsuir.pz2.mysql;

import by.netcracker.bsuir.pz2.connectionPool.ConnectionPool;
import by.netcracker.bsuir.pz2.daoInterface.UserDao;
import by.netcracker.bsuir.pz2.entity.User;

import java.util.List;

public class MySqlUserDao implements UserDao{

    private ConnectionPool connectionPool = ConnectionPool.getInstance();

    private MySqlUserDao() {
    }

    @Override
    public boolean create(User user) {
        return false;
    }

    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean delete(int userId) {
        return false;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    private static class Handler {
        private static final MySqlUserDao INSTANCE = new MySqlUserDao();
    }

    public static UserDao getInstance() {
        return Handler.INSTANCE;
    }
}
