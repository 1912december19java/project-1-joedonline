package repositories.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Properties;

import models.Reimbursement;
import repositories.queries.Actions;
import repositories.queries.MyStatements;
import repositories.utilities.DataAccessObject;
import repositories.utilities.RandomGenerator;

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
			stmt = MyStatements.sendQuery(Actions.GET_ALL_BY_REIMBURSEMENT_STATUS());
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
			System.out.println(
					"[ReimbursementDAOImpl] getAllPendingRequests() allPendingRequests: " + allPendingRequests);
			return allPendingRequests;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allPendingRequests;
	}

	@Override
	public ArrayList<Reimbursement> getAllResolvedRequests(String employeeId) {
		ArrayList<Reimbursement> allResolvedRequests = new ArrayList<Reimbursement>();
		reimbursement = new Reimbursement();
		try {
			stmt = MyStatements.sendQuery(Actions.GET_ALL_BY_REIMBURSEMENT_STATUS());
			stmt.setString(1, employeeId);
			stmt.setString(2, "resolved");
			if (stmt.execute()) {
				rs = stmt.getResultSet();
			}
			System.out.println("[ReimbursementDAOImpl] getAllResolvedRequests() -> rs: " + rs);
			while (rs.next()) {
				reimbursement.setId(rs.getString(1));
				reimbursement.setAmount(rs.getDouble(2));
				reimbursement.setStatus(rs.getString(3));
				reimbursement.setDateSubmitted(rs.getString(4));
				reimbursement.setDateApproved(rs.getString(5));
				reimbursement.setEmployeeId(rs.getString(6));
				allResolvedRequests.add(reimbursement);
			}
			System.out.println(
					"[ReimbursementDAOImpl] getAllResolvedRequests() allResolvedRequests: " + allResolvedRequests);
			return allResolvedRequests;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allResolvedRequests;
	}

	public String saveReimbursementRequest(Properties props) {
		String jsonString = "{ \"isSubmitted\": false }";
		try {
			stmt = MyStatements.sendQuery(Actions.SAVE_NEW_REIMBURSEMENT_REQUEST());
			String reimbursementId = "R" + RandomGenerator.digits(7);
			System.out.println("[ReimbursementDAOImpl] reimbursementId: " + reimbursementId);
			DecimalFormat decimalFormat = new DecimalFormat("#.##");
			Double amount = Double.parseDouble(props.getProperty("amount"));
			System.out.println("[ReimbursementDAOImpl] amount: " + decimalFormat.format(amount));
			stmt.setString(1, reimbursementId);
			stmt.setDouble(2, amount);
			stmt.setString(3, "pending");
			stmt.setString(4, props.getProperty("todaysDate"));
			stmt.setString(5, "tbd");
			stmt.setString(6, props.getProperty("employeeId"));
			stmt.setString(7, props.getProperty("receiptUrl"));
			stmt.execute();
			jsonString = "{ \"isSubmitted\": true }";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jsonString;
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
