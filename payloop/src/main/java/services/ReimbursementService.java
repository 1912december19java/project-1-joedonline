package services;

import java.util.ArrayList;
import java.util.Properties;

import models.Reimbursement;
import repositories.dao.ReimbursementDAOImpl;

public class ReimbursementService {

	private ReimbursementDAOImpl reimbursementDAOImpl;

	public ReimbursementService(ReimbursementDAOImpl reimbursementDAOImpl) {
		this.reimbursementDAOImpl = reimbursementDAOImpl;
	}
	
	public ArrayList<Reimbursement> getAllPendingRequests(String employeeId) {
		System.out.println("[ReimbursementService] getAllPendingRequests(String employeeId): " + this.reimbursementDAOImpl.getAllPendingRequests(employeeId));
		return this.reimbursementDAOImpl.getAllPendingRequests(employeeId);
	}

	public ArrayList<Reimbursement> getAllResolvedRequests(String employeeId) {
		return this.reimbursementDAOImpl.getAllResolvedRequests(employeeId);
	}
	
	public String saveReimbursementRequest(Properties props) {
		return this.reimbursementDAOImpl.saveReimbursementRequest(props);
	}
	
	public void addNew(Properties props) {
		System.out.println("[EmployeeService] addNew(Properties props): " + props.elements().toString());
		this.reimbursementDAOImpl.update(props);
	}

	public void update(Properties props) {
		System.out.println("[EmployeeService] update(Properties props): " + props.elements().toString());
		this.reimbursementDAOImpl.update(props);
	}

	public void delete(Properties props) {
		System.out.println("[EmployeeService] delete(Properties props): " + props.elements().toString());
		this.reimbursementDAOImpl.delete(props);
	}

}
