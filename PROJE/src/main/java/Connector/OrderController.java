

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;

@SuppressWarnings("unused")
public class OrderController {
	
	public String host = "localhost";
	public int port = 3306;
	public String db_name ="demo";
    public String user_name ="root";
    public String password ="1234";
    public String databaseType="com.mysql.jdbc.Driver";
    public String url="jdbc:mysql://"+host+":"+port+"/"+db_name+","+user_name+","+password;
    public PreparedStatement ps = null;
    public Connection con = null;
    
	//db deki order tablosunun nesnelerini bir liste �eklinde geri d�nd�ren metod
	public List<Order> readingData(){
	   	 
	 	   try {
	 		   String q1="SELECT * FROM order";
	 		   Class.forName("com.mysql.jdbc.Driver");
	 		   con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT","root","1234");
	           ps = con.prepareStatement(q1);
	           //sorgunun execute edilmesi sonucu elde edilen ��kt� rs de�i�kenine aktar�l�r
	           ResultSet rs = ps.executeQuery();
	           //Order t�r�nde olan bir Array List yarat�l�r
	           List<Order> list = new ArrayList<>();
	           //rs i�erisindeki nesneler tek tek gezilir ve herbiri i�in categoryModel t�r�nde bir nesne olu�turulur
	           while ( rs.next() )
	           {
	        	   //t�m �zellikleri kullanan yap�c� metod ile Order t�r�nde bir nesne olu�turulur
	        	   Order order = new Order(rs.getInt("orderCode"),rs.getString("orderDate"),rs.getString("delivery"),rs.getString("paymentType"),rs.getString("memberUsername"));
	        	   //olu�turulan nesneler listeye eklenir
	        	   list.add(order);
	           }
	           return list;
	         
	        } 
	 	   //istenilen s�n�f�n bulunamamas� veya db ile ilgili bir sorun olmas� durumunda catch blo�u �al���p hatay� g�sterir
	        catch ( ClassNotFoundException | SQLException exception ) {
	            System.out.println("Error: "+exception);
	            return null;
	        }
	 	   //PreparedStatement ve Connection a��k ise kapat�l�r ve bir hata al�nmas� durumda hata ekranda g�sterilir
	 	    finally { 
	            try {
	                if(con != null){ 
	                    con.close();
	                }
	                if(ps != null){ 
	                    ps.close();
	                }
	            } 
	            catch (SQLException sqlException) {
	                System.out.println("Error: "+sqlException);
	            }
	        }
	 	   
	    }
	
	//db ye Order t�r�nde nesne ekleyen metod
	public void Add ( Order order ){
			
	 	   try {
	 		   String q1 = "INSERT INTO order(orderDate,processing,preparation,shipping,delivery,paymentType,memberUsername) VALUES(?,?,?,?,?,?,?)";
	 		   Class.forName("com.mysql.jdbc.Driver");
	 		   con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT","root","1234");
	           ps = con.prepareStatement(q1);
	           ps.setString(1, order.getOrderDate());
	           ps.setString(2, order.getDelivery());
	           ps.setString(3, order.getPaymentType());
	           ps.setString(4, order.getMemberUsername());

	           ps.executeUpdate();
	 	   }
	       catch ( ClassNotFoundException | SQLException exception ) {
	                System.out.println(exception);
	                setErrorMessage(exception.toString());
	       }
	       finally {
	    	   try {
	    		   if(con != null){
	    			   con.close();
	               }
	               if(ps != null){
	            	   ps.close();
	               }
	           }
	           catch(SQLException sqlException) {
	        	   System.out.println(sqlException);
	           }
	      }
	}
		
	//db den Order t�r�ndeki bir nesnenin koduna g�re silinmesini sa�layan metod 
	public void Remove ( Order order){
	 	
		int i=0;
		try {
			String q1="DELETE FROM order WHERE orderCode=?";
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT","root","1234");
			ps = con.prepareStatement(q1);	    
	        ps.setInt(1, order.getOrderCode());
	        i = ps.executeUpdate();
		}
	    catch ( ClassNotFoundException | SQLException exception ) {
	    	System.out.println(exception);
	        setErrorMessage(exception.toString());
	    }
	    finally {
	    	try {
	    		if(con != null){
	    			con.close();
	            }
	            if(ps != null){
	            	ps.close();
	            }
	        }
	    	catch ( SQLException sqlException ) {
	    		System.out.println(sqlException);
	        }
	    }
	    if(i>0) {
	    	System.out.println("Record Deleted...");
	    }
	    else {
	    	System.out.println("Record Not Deleted...");
	    }
	}
			
	//Order t�r�ndeki bir nesnenin koduna g�re bulunup 3 �zelli�inin de�i�tirilmesini sa�layan metod	
	public void Update ( Order order ){
		  
		int i = 0;
		try {
			String q1 = "UPDATE order SET orderDate=?,delivery=?,paymentType=? WHERE orderCode=?";
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT","root","1234");
			ps = con.prepareStatement(q1);	    
		       
		    ps.setString(1, order.getOrderDate());
		    ps.setString(2, order.getDelivery());
		    ps.setString(3, order.getPaymentType());
		    ps.setInt(4, order.getOrderCode());
		         
		    i = ps.executeUpdate();
		}
		catch ( ClassNotFoundException | SQLException exception ) {
			System.out.println(exception);
		    setErrorMessage(exception.toString());
		}
		finally {
			try {
				if(con != null){
					con.close();
		        }
		        if(ps != null){
		        	ps.close();
		        }
		    }
		    catch ( SQLException sqlException ) {
		    	System.out.println(sqlException);
		    }
		}
		if(i>0) {
			System.out.println("Updated Successfully...");
		}
	    else {
	       	System.out.println("Update Failed...");
	    }
	}
}
