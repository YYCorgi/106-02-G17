package d0602;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import tetris.Name;


public class InsertData {

	public void fxxk() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		} catch (Exception ex) {
			// handle the error
		}

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/selection?" + "user=root&password=0000&serverTimezone=UTC&useSSL=false");
			Statement stmt2 = conn.createStatement();
			ResultSet rs2 = stmt2.executeQuery("select s.id, name, score"
					+ " from terist s");
			int index=1;
			while (rs2.next()) {
				//System.out.println(rs2.getInt(1) + "\t" + rs2.getString(2) + "\t" + rs2.getInt(3) );
				index++;
			}
			
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO terist (id,name,score) VALUES (?,?,?);");
			stmt.setInt(1,index);
			stmt.setString(2,Name.user_name); 
			stmt.setInt(3,(int) Name.fs);
			stmt.executeUpdate();

			ResultSet rs = stmt.executeQuery("select s.id, name, score"
					+ " from terist s ORDER BY score DESC");

			while (rs.next()) {
				System.out.println(
						rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3) );
				
						
			}

		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		JFrame jframe = new JFrame("Leaderboard");
		jframe.setSize(300, 500);
		jframe.setVisible(true);
		JPanel p=new JPanel();
		JLabel jLabel = new JLabel();
		jLabel.setText("name                             score");
		jframe.getContentPane().add(jLabel);
		p.add(jLabel);
		jframe.add(p,BorderLayout.CENTER);


	}

	public void InsertData() {
		// TODO Auto-generated method stub
		
	}
}