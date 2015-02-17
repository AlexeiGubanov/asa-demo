package org.swas.dao.hibernate;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.swas.dao.UserDao;
import org.swas.domain.User;

import java.util.List;

/**
 * Sample hibernate implementation of {@code UserDao}
 */
@Repository
public class UserDaoImpl extends GenericDaoImpl<User, Long> implements UserDao {

  public UserDaoImpl() {
    super(User.class);
  }

  public User findByLogin(String login) {
    DetachedCriteria detachedCriteria = getDetachedCriteria();
    detachedCriteria.add(Restrictions.eq("login", login).ignoreCase());
    return (User) getExecutableCriteria(detachedCriteria).uniqueResult();
  }

  public User findByEmail(String email) {
    DetachedCriteria detachedCriteria = getDetachedCriteria();
    detachedCriteria.add(Restrictions.eq("email", email).ignoreCase());
    return (User) getExecutableCriteria(detachedCriteria).uniqueResult();
  }

  public boolean isLoginExists(String login) {
    DetachedCriteria detachedCriteria = getDetachedCriteria();
    detachedCriteria.add(Restrictions.eq("login", login).ignoreCase());
    detachedCriteria.setProjection(Projections.rowCount());
    return (Long) getExecutableCriteria(detachedCriteria).uniqueResult() > 0;

  }

  public boolean isEmailExists(String email) {
    DetachedCriteria detachedCriteria = getDetachedCriteria();
    detachedCriteria.add(Restrictions.eq("email", email).ignoreCase());
    detachedCriteria.setProjection(Projections.rowCount());
    return (Long) getExecutableCriteria(detachedCriteria).uniqueResult() > 0;
  }

  public User findByActivationCode(String code) {
    DetachedCriteria detachedCriteria = getDetachedCriteria();
    detachedCriteria.add(Restrictions.eq("activationCode", code).ignoreCase());
    return (User) getExecutableCriteria(detachedCriteria).uniqueResult();
  }

  public List<User> search(String keyword) {
    DetachedCriteria detachedCriteria = getDetachedCriteria();
    detachedCriteria.add(Restrictions.disjunction().add(Restrictions.ilike("email", keyword, MatchMode.ANYWHERE)).add
        (Restrictions.ilike("login", keyword, MatchMode.ANYWHERE)).add(Restrictions.ilike("name", keyword, MatchMode
        .ANYWHERE)));
    return getExecutableCriteria(detachedCriteria).list();
  }
}
