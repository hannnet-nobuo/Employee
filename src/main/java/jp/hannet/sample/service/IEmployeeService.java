package jp.hannet.sample.service;

import java.util.List;

import jp.hannet.sample.model.Employee;

public interface IEmployeeService {
	Employee selectById(int id);
	List<Employee> selectAll();
	void save(Employee map);
	void delete(Employee map);
	void update(Employee map);
}
