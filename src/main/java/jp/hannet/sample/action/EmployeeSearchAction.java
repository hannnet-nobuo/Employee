package jp.hannet.sample.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import jp.hannet.sample.model.Employee;
import jp.hannet.sample.service.IEmployeeService;

public class EmployeeSearchAction extends ActionSupport {
    
	private static final long serialVersionUID = -6238317023028624675L;
	private List<Employee> employees ;
	private int delid;
	
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

	public String execute() throws Exception {
		
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
