

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
    
	//db deki order tablosunun nesnelerini bir liste þeklinde geri döndüren metod
	public List<Order> readingData(){
	   	 
	 	   try {
	 		   String q1="SELECT * FROM order";
	 		   Class.forName("com.mysql.jdbc.Driver");
	 		   con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT","root","1234");
	           ps = con.prepareStatement(q1);
	           //sorgunun execute edilmesi sonucu elde edilen çýktý rs deðiþkenine aktarýlýr
	           ResultSet rs = ps.executeQuery();
	           //Order türünde olan bir Array List yaratýlýr
	           List<Order> list = new ArrayList<>();
	           //rs içerisindeki nesneler tek tek gezilir ve herbiri için categoryModel türünde bir nesne oluþturulur
	           while ( rs.next() )
	           {
	        	   //tüm özellikleri kullanan yapýcý metod ile Order türünde bir nesne oluþturulur
	        	   Order order = new Order(rs.getInt("orderCode"),rs.getString("orderDate"),rs.getString("delivery"),rs.getString("paymentType"),rs.getString("memberUsername"));
	        	   //oluþturulan nesneler listeye eklenir
	        	   list.add(order);
	           }
	           return list;
	         
	        } 
	 	   //istenilen sýnýfýn bulunamamasý veya db ile ilgili bir sorun olmasý durumunda catch bloðu çalýþýp hatayý gösterir
	        catch ( ClassNotFoundException | SQLException exception ) {
	            System.out.println("Error: "+exception);
	            return null;
	        }
	 	   //PreparedStatement ve Connection açýk ise kapatýlýr ve bir hata alýnmasý durumda hata ekranda gösterilir
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
	
	//db ye Order türünde nesne ekleyen metod
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
		
	//db den Order türündeki bir nesnenin koduna göre silinmesini saðlayan metod 
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
			
	//Order türündeki bir nesnenin koduna göre bulunup 3 özelliðinin deðiþtirilmesini saðlayan metod	
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
