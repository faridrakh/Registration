package mitrais.test.registration.service;

import mitrais.test.registration.model.UserModel;

public interface UserService {
    String registerUser(UserModel user);
    String checkRegisteredEmail(String email);
    String checkRegisteredMobileNo(String mobile);
}
