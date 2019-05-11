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
		  *第二步 
		  * 加载jdbc驱动器
		  */
		 try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("加载成功");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("加载失败");
			e.printStackTrace();
		}
		 /**
		  *第三步
		  * 连接jdbc驱动器
		  */
		 try {
			Connection con= (Connection) DriverManager.getConnection
					 ("jdbc:mysql://127.0.0.1:3306/shujuku","root","123");
			System.out.println("创建加载成功");
			//第四步
			 String cv =request.getParameter("user");
		     String kl=request.getParameter("password");
			Statement sta=(Statement) con.createStatement();
			int n=sta.executeUpdate("insert new_table values ('"+cv+"','"+kl+"')");
			System.out.println("更新"+n+"条");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("创建加载失败");
			e.printStackTrace();
		}
	}

	
	
}
