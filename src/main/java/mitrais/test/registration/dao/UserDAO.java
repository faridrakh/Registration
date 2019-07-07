package mitrais.test.registration.dao;

import mitrais.test.registration.model.UserModel;

public interface UserDAO {
    void registerUser(UserModel user);
    String checkRegisteredEmail(String email);
    String checkRegisteredMobileNo(String mobile);
}
