package repositories.dao;

import java.util.ArrayList;

import models.Reimbursement;

public interface ReimbursementDAO {

	ArrayList<Reimbursement> getAllPendingRequests(String employeeId);
	
}
