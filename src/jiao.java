import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


public class jiao extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/**
		  *�ڶ��� 
		  * ����jdbc������
		  */
		 try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("���سɹ�");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("����ʧ��");
			e.printStackTrace();
		}
		 /**
		  *������
		  * ����jdbc������
		  */
		 try {
			Connection con= (Connection) DriverManager.getConnection
					 ("jdbc:mysql://127.0.0.1:3306/shujuku","root","123");
			System.out.println("�������سɹ�");
			//���Ĳ�
			 String cv =request.getParameter("user");
		     String kl=request.getParameter("password");
			Statement sta=(Statement) con.createStatement();
			int n=sta.executeUpdate("insert new_table values ('"+cv+"','"+kl+"')");
			System.out.println("����"+n+"��");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("��������ʧ��");
			e.printStackTrace();
		}
	}

	
	
}
