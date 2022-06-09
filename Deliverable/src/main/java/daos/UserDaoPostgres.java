package daos;

import com.revature.potus.Util.ConnectionUtil;
import com.revature.potus.models.AppUser;

import java.sql.*;
import java.util.List;

public class UserDaoPostgres implements UserDao{
    @Override
    public AppUser createUser(AppUser user) {

        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "insert into pusers values (default,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());


            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int generatedId = rs.getInt("id");

            user.setId(generatedId);
            return user;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public AppUser getUserById(int id) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "select * from pusers where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();

            rs.next();

            AppUser user = new AppUser();
            user.setId(id);
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            return user;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public AppUser getUserByUsername(String username) {
        return null;
    }

    @Override
    public AppUser getUserByUsernameAndPassword(String username, String password) {
        return null;
    }

    @Override
    public List<AppUser> getAllUsers() {
        return null;
    }
}
