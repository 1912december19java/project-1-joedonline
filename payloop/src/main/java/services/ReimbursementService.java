package services;

import java.util.ArrayList;

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

}
