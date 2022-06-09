package daos;

import com.revature.potus.Util.ConnectionUtil;
import com.revature.potus.models.AppUser;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoPostgres implements UserDao {
    public UserDaoPostgres() throws SQLException {
    }

    @Override
    public AppUser createUser(AppUser user) {

        try (Connection conn = ConnectionUtil.getInstance().getConnection()) {

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
        try (Connection conn = ConnectionUtil.getInstance().getConnection()) {
            String sql = "select * from pusers where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
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

        List<AppUser> todousers = new ArrayList<>();

        try (Connection conn = ConnectionUtil.getInstance().getConnection()) {
            String sql = "select * from pusers";
            PreparedStatement query = conn.prepareStatement(sql);
            ResultSet rs = query.executeQuery();


            while (rs.next()) {
                AppUser tuser = new AppUser();
                tuser.setId(rs.getInt("id"));
                tuser.setUsername(rs.getString("username"));
                tuser.setPassword(rs.getString("password"));
                todousers.add(tuser);
            }
        } catch (SQLException e) {
            System.err.println("An error occurred with FlashcardDAO");
        }
        return todousers;

    }


}
