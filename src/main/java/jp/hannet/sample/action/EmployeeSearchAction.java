package jp.hannet.sample.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import jp.hannet.sample.model.Employee;
import jp.hannet.sample.service.IEmployeeService;

public class EmployeeSearchAction extends ActionSupport {
    
	private static final long serialVersionUID = -6238317023028624675L;
	private List<Employee> employees ;
	private int delid;
	private String newEmployee;
	
	private int id;
	private String name;
	private String enumber;
	
	private IEmployeeService employeeService; 
	
	public void setEmployeeService(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	public int getDelid() {
		return delid;
	}

	public void setDelid(int delid) {
		this.delid = delid;
	}

	public List<Employee> getEmployees() {
		return employees;
	}
	
	public String getNewEmployee() {
		return newEmployee;
	}

	public void setNewEmployee(String newEmployee) {
		this.newEmployee = newEmployee;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEnumber() {
		return enumber;
	}

	public void setEnumber(String enumber) {
		this.enumber = enumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String execute() throws Exception {
		if(newEmployee != null) {
			return INPUT;
		} else if(id != 0) {
			// 結果取得
			Employee map = employeeService.selectById(id);
			id = map.getId();
			name = map.getName();
			enumber = map.getEnumber();
			return "edit";
		}
		
		if (delid != 0) {
			Employee delMap = new Employee();
			delMap.setId(delid);
			// 削除
			employeeService.delete(delMap);
		}
		// 結果取得
		employees = employeeService.selectAll();
        return SUCCESS;
    }
}
