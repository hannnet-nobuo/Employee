package jp.hannet.sample.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import jp.hannet.sample.dao.IEmployeeDao;
import jp.hannet.sample.model.Employee;

@Service
public class EmployeeServiceImp implements IEmployeeService {
	
	private IEmployeeDao dao;

	public void setDao(IEmployeeDao dao) {
		this.dao = dao;
	}

	@Override
	@Transactional(readOnly = true)
	public Employee selectById(int id) {
		return dao.selectById(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void save(Employee map) {
		dao.save(map);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Employee map) {
		dao.delete(map);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(Employee map) {
		dao.update(map);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Employee> selectAll() {
		return dao.selectAll();
	}
}
