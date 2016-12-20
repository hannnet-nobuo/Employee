package jp.hannet.sample.action;


import org.apache.struts2.dispatcher.HttpParameters;
import org.apache.struts2.interceptor.HttpParametersAware;

import com.opensymphony.xwork2.ActionSupport;

import jp.hannet.sample.model.Employee;
import jp.hannet.sample.service.IEmployeeService;

public class EmployeeEditAction extends ActionSupport implements HttpParametersAware {
    
	private static final long serialVersionUID = 6748172158759628460L;
	
	private int id;
	private String name;
	private String enumber;
	private String update;
	private HttpParameters param;
	
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
		
		String strId = param.get("id").getValue();
		int id = Integer.parseInt(strId);
		
		if (name == null && enumber == null) {
			// 結果取得
			Employee map = employeeService.selectById(id);
			id = map.getId();
			name = map.getName();
			enumber = map.getEnumber();
		} else {
			Employee map = new Employee();
			map.setId(id);
			map.setName(name);
			map.setEnumber(enumber);				
			employeeService.update(map);
			return "finish";
		}
			
        return SUCCESS;
    }

	public void setParameters(HttpParameters arg0) {
		param = arg0;
		
	}

}
