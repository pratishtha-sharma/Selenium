package StoredProcedureTesting;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SPTesting {
	
	Connection con = null;
	Statement stmt = null;
	ResultSet rs;
	CallableStatement cStmt;
	ResultSet rs1, rs2;
	
	
	@BeforeClass
	
	void setup() throws SQLException {
		
		con= DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "root");
		
	}
	
	@AfterClass
	void tearDown() throws SQLException {
		con.close();
	}
	
	//@Test(priority=1)
	void test_storedProdcedureExist() throws SQLException {
		stmt = con.createStatement();
		rs = stmt.executeQuery("show procedure status where name = 'SelectAllCustomers'");
		rs.next();
		
		//to check if the stored procedure name mentioned in name column is same as SP name
		Assert.assertEquals(rs.getString("Name"), "SelectAllCustomers");	
	}
	
	//@Test(priority=2)
	void test_SelectAllCustomers() throws SQLException {
		cStmt = con.prepareCall("{call SelectAllCustomers()}");
		// result set of SP
		rs1 = cStmt.executeQuery();
		
		// result set of query that is used in SP
		stmt = con.createStatement();
		rs2 = stmt.executeQuery("select * from customers");
		
		//compare rs1 and rs2
		
		Assert.assertEquals(compareResultSets(rs1, rs2), true); 
		
	}
	
	//@Test (priority =3)
	void test_SPwithargs() throws SQLException {
		cStmt = con.prepareCall("{call SelectAllCustomersByCity(?)}");
		//we can not pass input parameter directly with SP call so we need to set the string
		cStmt.setString(1, "Singapore");
		
		// result set of SP
		rs1 = cStmt.executeQuery();
		
		// result set of query that is used in SP
		stmt = con.createStatement();
		rs2 = stmt.executeQuery("select * from customers where city = 'Singapore'");
		
		//compare rs1 and rs2
		
		Assert.assertEquals(compareResultSets(rs1, rs2), true); 
		
	}
	
//	@Test (priority =4)
	void test_SPwith2args() throws SQLException {
		cStmt = con.prepareCall("{call SelectAllCustomersByCityAndPin(?,?)}");
		//we can not pass input parameter directly with SP call so we need to set the string
		cStmt.setString(1, "Singapore");
		cStmt.setString(2, "079903");
		
		// result set of SP
		rs1 = cStmt.executeQuery();
		
		// result set of query that is used in SP
		stmt = con.createStatement();
		rs2 = stmt.executeQuery("select * from customers where city = 'Singapore' and postalCode= '079903' ");
		
		//compare rs1 and rs2
		
		Assert.assertEquals(compareResultSets(rs1, rs2), true); 
		
	}
	
	
	@Test (priority =5)
	void test_get_order_by_cust() throws SQLException {
		
		cStmt = con.prepareCall("{call get_Order_By_Customer(?,?,?,?,?)}");
		
		cStmt.setInt(1, 141);
		cStmt.registerOutParameter(2, Types.INTEGER);
		cStmt.registerOutParameter(3, Types.INTEGER);
		cStmt.registerOutParameter(4, Types.INTEGER);
		cStmt.registerOutParameter(5, Types.INTEGER);
		
		cStmt.executeQuery();
		
		//to access output variables and store them in variable
		int shipped = cStmt.getInt(2);
		int canceled =  cStmt.getInt(3);
		int resolved = cStmt.getInt(4);
		int disputed = cStmt.getInt(5);
		
		System.out.println(shipped+" "+canceled+" "+resolved+" "+disputed);
		
		stmt = con.createStatement();
		rs = stmt.executeQuery("select\r\n"
				+ "(select count(*) as shipped from orders where customerNumber = 141 and status = 'shipped') as Shipped,\r\n"
				+ "(select count(*) as canceled from orders where customerNumber = 141 and status = 'canceled') as Canceled,\r\n"
				+ "(select count(*) as resolved from orders where customerNumber = 141 and status = 'resolved') as Resolved,\r\n"
				+ "(select count(*) as disputed from orders where customerNumber = 141 and status = 'disputed') as Disputed");
		
		
		rs.next();
		
	}
	
	
	
		
	
	
	// java method to compare 2 result sets
	public boolean compareResultSets(ResultSet rs1, ResultSet rs2) throws SQLException {
			while (rs1.next()) {
				rs2.next();
				int count = rs1.getMetaData().getColumnCount();
				for (int i=1; i<= count; i++) {
					if(!StringUtils.equals(rs1.getString(i), rs2.getString(i))) {
						return false;
					}
				}
			}
			return true;
			
		}
		
		
	

}
