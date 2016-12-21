package jp.hannet.sample.action;

import com.opensymphony.xwork2.ActionSupport;

import jp.hannet.sample.model.Employee;
import jp.hannet.sample.service.IEmployeeService;

public class EmployeeEditAction extends ActionSupport {
    
	private static final long serialVersionUID = 6748172158759628460L;
	
	private int id;
	private String name;
	private String enumber;
	private String update;
	
	private IEmployeeService employeeService; 
	
	public void setEmployeeService(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public String getUpdate() {
		return update;
	}

	public void setUpdate(String update) {
		this.update = update;
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

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String execute() throws Exception {
		
		Employee map = new Employee();
		map.setId(id);
		map.setName(name);
		map.setEnumber(enumber);				
		employeeService.update(map);
			
        return SUCCESS;
    }

}
