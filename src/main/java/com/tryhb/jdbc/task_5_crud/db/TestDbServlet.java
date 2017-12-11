package com.tryhb.jdbc.task_5_crud.db;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

@WebServlet("/testdb")
public class TestDbServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = "springstudent";
        String pass = "springstudent";

        String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracked?useSSL=false";
        String driver = "com.mysql.jdbc.Driver";

        try{
            PrintWriter out = response.getWriter();

            out.println("Connecting");
            Class.forName(driver);

            Connection connection = DriverManager.getConnection(jdbcUrl, user, pass);
            out.println("Connected");
            connection.close();
        } catch (Exception e){
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}

