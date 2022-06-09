package daos;

import com.revature.potus.models.AppUser;

import java.util.List;

public interface UserDao {

    AppUser createUser(AppUser user);

    AppUser getUserById(int id);

    AppUser getUserByUsername(String username);

    AppUser getUserByUsernameAndPassword(String username, String password);

    List<AppUser> getAllUsers();
}
