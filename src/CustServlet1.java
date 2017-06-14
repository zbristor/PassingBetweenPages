

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CustServlet1
 */
@WebServlet("/CustServlet1")
public class CustServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		HttpSession session = request.getSession();
		
		
		String LastName=request.getParameter("LastName");
		String nextURL="/CustJSP1.jsp";
		request.setAttribute("LastName", LastName);
		
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt=null;
		//String norm = null;
		String sql = "select FirstName, LastName, StreetAddress,City,State,ZipCode, EmailAddress, Position, customers.AddressID from customers,Address,tblPosition "
					+ "where customers.AddressID=Address.AddressID AND customers.PositionID=tblPosition.PositionID AND customers.LastName=?";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Customers?"+ "user=root&password=password");
            pstmt = con.prepareStatement(sql);
            //
            pstmt.setString(1, LastName);
            rs = pstmt.executeQuery();
            rs.next();
          	String message=rs.getString("FirstName");
          	session.setAttribute("session_FirstName",message);
          	String message2=rs.getString("LastName");
    		session.setAttribute("session_LastName",message2);
    		String message3=rs.getString("StreetAddress");
    		session.setAttribute("session_StreetAddress",message3);
    		String message4=rs.getString("City");
    		session.setAttribute("session_City",message4);
    		String message5=rs.getString("State");
    		session.setAttribute("session_State",message5);
    		String message6=rs.getString("ZipCode");
    		session.setAttribute("ZipCode",message6);
    		String message7=rs.getString("EmailAddress");
    		session.setAttribute("session_EmailAddress",message7);
    		String message8=rs.getString("Position");
    		session.setAttribute("session_Position",message8);
    		String message9=rs.getString("customers.AddressID");
    		session.setAttribute("session_customers.AddressID",message9);
          	
          	
          	/*
          	 *       		String message2="LastName";
        		request.setAttribute("LastName",message2);
        		String message3="StreetAddress";
        		request.setAttribute("StreetAddress",message3);
        		String message4="City";
        		request.setAttribute("City",message4);
        		String message5="State";
        		request.setAttribute("State",message5);
        		String message6="ZipCode";
        		request.setAttribute("ZipCode",message6);
        		String message7="EmailAddress";
        		request.setAttribute("EmailAddress",message7);
        		String message8="Position";
        		request.setAttribute("Position",message8);
        		String message9="customers.AddressID";
        		request.setAttribute("customers.AddressID",message9);*/
          	 
            
		}catch (SQLException e){
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				getServletContext().getRequestDispatcher(nextURL).forward(request, response);
				rs.close();
				pstmt.close();
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	
	}
	
}
		
		
		
		
		/*
		
		
		
		}

*/
