package jp.hannet.sample.action;

import com.opensymphony.xwork2.ActionSupport;

import jp.hannet.sample.model.Employee;
import jp.hannet.sample.service.IEmployeeService;

public class EmployeeNewAction extends ActionSupport {

	private static final long serialVersionUID = 8970475785140651428L;
	private String name;
	private String enumber;
	
	private IEmployeeService employeeService;

	public void setEmployeeService(IEmployeeService employeeService) {
		this.employeeService = employeeService;
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

	public String execute() throws Exception {
		if (name != null && enumber != null) {
			
			Employee map = new Employee();
			map.setName(name);
			map.setEnumber(enumber);
			employeeService.save(map);
			return "finish";
		}
		return SUCCESS;
	}
}
