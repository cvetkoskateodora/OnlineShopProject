package com.onlineshop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnlineShopProject1Application {

	
		    public Connection connect() {

		        Connection conn = null;

		        try {

		            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "teodora823002" );

		            System.out.println("You are successfully connected to the PostgreSQL database server.");

		        } catch (SQLException e) 

		        {

		            System.out.println(e.getMessage());

		        }



		        return conn;

		    }



		    /**

		     * @param args the command line arguments

		     */

		    public static void main(String[] args) {
				SpringApplication.run(OnlineShopProject1Application.class, args);
				{ 


		        OnlineShopProject1Application conn = new OnlineShopProject1Application();

		       conn.connect();

		    }
	}
	
	

}
