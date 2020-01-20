package repositories.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import models.Reimbursement;
import repositories.queries.Actions;
import repositories.queries.MyStatements;
import repositories.utilities.DataAccessObject;

public class ReimbursementDAOImpl extends DataAccessObject implements ReimbursementDAO {

	PreparedStatement stmt;
	ResultSet rs = null;
	Reimbursement reimbursement;
	
	public ReimbursementDAOImpl() {
		
	}

	@Override
	public ArrayList<Reimbursement> getAllPendingRequests(String employeeId) {
		ArrayList<Reimbursement> allPendingRequests = new ArrayList<Reimbursement>();
		reimbursement = new Reimbursement();
		try {
			stmt = MyStatements.sendQuery(Actions.GET_ALL_PENDING_REQUESTS());
			stmt.setString(1, employeeId);
			stmt.setString(2, "pending");
			if (stmt.execute()) {
				rs = stmt.getResultSet();
			}
			System.out.println("[ReimbursementDAOImpl] getAllPendingRequests() -> rs: " + rs);
			while (rs.next()) {
				reimbursement.setId(rs.getString(1));
				reimbursement.setAmount(rs.getDouble(2));
				reimbursement.setStatus(rs.getString(3));
				reimbursement.setDateSubmitted(rs.getString(4));
				reimbursement.setDateApproved(rs.getString(5));
				reimbursement.setEmployeeId(rs.getString(6));
				allPendingRequests.add(reimbursement);
			}
			System.out.println("[ReimbursementDAOImpl] getAllPendingRequests() allPendingRequests: " + allPendingRequests);
			return allPendingRequests;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allPendingRequests;
	}

	@Override
	public void addNew(Properties props) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

}
