package mitrais.test.registration.service;

import mitrais.test.registration.dao.UserDAO;
import mitrais.test.registration.helper.CommonUtils;
import mitrais.test.registration.model.UserModel;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private UserDAO userDAO;
    private CommonUtils commonUtils = new CommonUtils();

    public UserServiceImpl(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    @Override
    public String registerUser(UserModel user) {
        user.setId(commonUtils.generateUUID());
        user.setDtCreate(new Date());
        try {
            if((!"1".equals(checkRegisteredEmail(user.getEmail()))) &&
                    (!"1".equals(checkRegisteredMobileNo(user.getMobileNumber())))){
                userDAO.registerUser(user);
            }
        } catch (HibernateException e){
            return "0";
        }
        return "1";
    }

    @Override
    public String checkRegisteredEmail(String email) {
        String result = userDAO.checkRegisteredEmail(email);
        return result;
    }

    @Override
    public String checkRegisteredMobileNo(String mobile) {
        String result = userDAO.checkRegisteredMobileNo(mobile);
        return result;
    }
}
