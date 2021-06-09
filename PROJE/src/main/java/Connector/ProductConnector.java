package Connector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import Entity.Product;


public class ProductConnector  {

	public String host = "localhost";
	public int port = 3306;
	public String db_name ="demo";
    public String user_name ="root";
    public String password ="root";
    public String databaseType="com.mysql.jdbc.Driver";
    public String url="jdbc:mysql://"+host+":"+port+"/"+db_name+","+user_name+","+password;
    public PreparedStatement ps=null;
    public Connection con=null;
    
	public List<Product> readingData(int ProductID){
	   	 
	 	   try {
	 		   String sorgu="SELECT * FROM product WHERE ProductID=?";
	 		   Class.forName("com.mysql.jdbc.Driver");
	 		    con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT","root","root");
	            ps=con.prepareStatement(sorgu);
	            ps.setInt(1,ProductID);
	            ResultSet rs=ps.executeQuery();
	            List<Product> liste=new ArrayList<>();
	            while(rs.next())
	            {
	            	Product product =new Product(rs.getInt("ProductID"),rs.getString("ProductName"),rs.getInt("ProductPrice"),
	            			rs.getString("Image"));
	            		
	            	liste.add(product);
	            }
	            return liste;
	           
	        } 
	        catch (ClassNotFoundException | SQLException exception) {
	            System.out.println("Bir hata meydana geldi:"+exception);
	            return null;
	        }
	 	   finally{ 
	            try {
	                if(con!=null){ 
	                    con.close();
	                }
	                if(ps!=null){ 
	                    ps.close();
	                }
	            } catch (SQLException sqlException) {
	                System.out.println("Bir hata meydana geldi:"+sqlException);
	            }
	        }
	 	   
	     }
	
	public Product readingData(Product product){
		Product uye = null;
	 	   try {
	 		   String sorgu="SELECT * FROM product WHERE ProductID=?";
	 		   Class.forName("com.mysql.jdbc.Driver");
	 		  con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT","root","root");
	            ps=con.prepareStatement(sorgu);
	            ps.setInt(1,product.getProductID());
	            ResultSet rs=ps.executeQuery();
	         
	           
	            product =new Product(rs.getInt("ProductID"),rs.getString("ProductName"),rs.getInt("ProductPrice"),
            			rs.getString("Image"));
	            
	            return product;
	         
	        } 
	        catch (ClassNotFoundException | SQLException exception) {
	            System.out.println("Bir hata meydana geldi:"+exception);
	            return uye;
	        }
	 	   finally{ 
	            try {
	                if(con!=null){ 
	                    con.close();
	                }
	                if(ps!=null){ 
	                    ps.close();
	                }
	            } catch (SQLException sqlException) {
	                System.out.println("Bir hata meydana geldi:"+sqlException);
	            }
	        }
	 	   
	     }
	
	
	public List<Product> readingData(){
	   	 
	 	   try {
	 		   String query="SELECT * FROM product";
	 		   Class.forName("com.mysql.jdbc.Driver");
	 		  con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT","root","root");
	            ps=con.prepareStatement(query);
	            
	            ResultSet rs=ps.executeQuery();
	            List<Product> liste=new ArrayList<>();
	            while(rs.next())
	            {
	            	Product product=new Product(rs.getInt("ProductID"),rs.getString("ProductName"),rs.getInt("ProductPrice"),
	            			rs.getString("Image"));
	            	liste.add(product);
	            }
	            return liste;
	         
	        } 
	        catch (ClassNotFoundException | SQLException exception) {
	            System.out.println("Bir hata meydana geldi:"+exception);
	            return null;
	        }
	 	   finally{ 
	            try {
	                if(con!=null){ 
	                    con.close();
	                }
	                if(ps!=null){ 
	                    ps.close();
	                }
	            } catch (SQLException sqlException) {
	                System.out.println("Bir hata meydana geldi:"+sqlException);
	            }
	        }
	 	   
	     }
		
		
		
			public void Remove(Product product){
	 	  
				
				try {
					String sorgu="DELETE FROM product WHERE ProductID=?";
					Class.forName("com.mysql.jdbc.Driver");
					 con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT","root","root");
					ps=con.prepareStatement(sorgu);	    
		            ps.setInt(1, product.getProductID());
		            ps.executeUpdate();
		 	   }
		           
		            catch(ClassNotFoundException | SQLException exception)
		            {
		                System.out.println(exception);
		            
		            }
		            finally 
		            {
		                try {
		                    if(con!=null){
		                        con.close();
		                    }
		                    if(ps!=null){
		                        ps.close();
		                    }
		                }
		                catch(SQLException sqlException)
		                {
		                    System.out.println(sqlException);
		                }
		            }
		            
				}
			


		
			public void Update(Product product){
			
				try {
					String sorgu="UPDATE product SET ProductName=?,ProductPrice=?,Image=? WHERE ProductID=?";
					Class.forName("com.mysql.jdbc.Driver");
					 con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT","root","root");
					ps=con.prepareStatement(sorgu);	    
			        
		            ps.setString(1, product.getProductName());
		            ps.setInt(2, product.getProductPrice());
		            ps.setString(3, product.getImage());
		            ps.setInt(4, product.getProductID());
		            
			        ps.executeUpdate();
				   }
			       
			        catch(ClassNotFoundException | SQLException exception)
			        {
			            System.out.println(exception);
			         
			        }
			        finally 
			        {
			            try {
			                if(con!=null){
			                    con.close();
			                }
			                if(ps!=null){
			                    ps.close();
			                }
			            }
			            catch(SQLException sqlException)
			            {
			                System.out.println(sqlException);
			            }
			        }
			       
				}
			
			

			
	
}
