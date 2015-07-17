package ch02;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ch02/ProcessMemberServlet")
public class ProcessMemberServlet extends HttpServlet {
	private static final long serialVersionUID=1L;
	
	public ProcessMemberServlet(){
		
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");	
		try {
			String id = req.getParameter("mId");
			String password = req.getParameter("pswd");
			String name = req.getParameter("mName");
			String address = req.getParameter("mAddress");
			String phone = req.getParameter("mPhone");
			String birthday = req.getParameter("mBirthday");
			java.sql.Date date =null;
			try {
				date = java.sql.Date.valueOf(birthday);
			} catch (Exception e) {
				e.printStackTrace();
			}		
			Timestamp ts = new Timestamp(System.currentTimeMillis());
			String weight = req.getParameter("mWeight");
			double dWeight = -1;
			try {
				dWeight = Double.parseDouble(weight.trim());
			} catch (NumberFormatException e) {
				;
			} catch (NullPointerException e){
				;
			}
			
			MemberBean mb = new MemberBean(id,password,name,address,phone,date,ts,dWeight);
			MemberFileIO mfio = new MemberFileIO("c:\\data\\member.dat");
			mfio.insertMember(mb);
			req.setAttribute("memberBean",mb);
			RequestDispatcher rd =
					req.getRequestDispatcher("/ch02/InsertMemberSuccess.jsp");
			rd.forward(req,resp);
			return;
		} catch (IOException e) {
			RequestDispatcher rd =
					req.getRequestDispatcher("/ch02/InsertMemberError.jsp");
			rd.forward(req,resp);
			return;
		}
	}
	
	
}
