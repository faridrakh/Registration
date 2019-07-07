package mitrais.test.registration.dao;

import mitrais.test.registration.model.UserModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    private SessionFactory sessionFactory;

    public UserDAOImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void registerUser(UserModel user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public String checkRegisteredEmail(String email) {
        List<UserModel> userResult;
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select email from UserModel where email = :email");
        query.setParameter("email", email);
        userResult = query.getResultList();
        if(userResult.size() > 0){
            return "1";
        }
        return "0";
    }

    @Override
    public String checkRegisteredMobileNo(String mobile) {
        List<UserModel> userResult;
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select mobileNumber from UserModel where mobileNumber = :mobile");
        query.setParameter("mobile", mobile);
        userResult = query.getResultList();
        if(userResult.size() > 0){
            return "1";
        }
        return "0";
    }
}
