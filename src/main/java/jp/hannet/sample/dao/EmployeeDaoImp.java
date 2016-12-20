package jp.hannet.sample.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import jp.hannet.sample.model.Employee;

@Repository
public class EmployeeDaoImp implements IEmployeeDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Employee selectById(int id) {
		Employee map = null;
		Session session = getSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Employee> cr = builder.createQuery(Employee.class);
		Root<Employee> root = cr.from(Employee.class);

		cr.select(root).where(builder.equal(root.<String>get("id"), id));

		try {
			map = session.createQuery(cr).getSingleResult();
		} catch (NoResultException e) {
			
		}

		return map;
	}

	@Override
	public void save(Employee map) {
		getSession().save(map);
	}

	@Override
	public void delete(Employee map) {
		getSession().delete(map);
	}

	@Override
	public void update(Employee map) {
		getSession().update(map);

	}

	@Override
	public List<Employee> selectAll() {
		Session session = getSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Employee> cr = builder.createQuery(Employee.class);
		Root<Employee> root = cr.from(Employee.class);
		cr.select(root);
		return session.createQuery(cr).getResultList();
	}

}
