package Connector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entity.Cart;
import Entity.Product;


public class CartConnector  {

	public String host = "localhost";
	public int port = 3306;
	public String db_name ="demo";
    public String user_name ="root";
    public String password ="1234";
    public String databaseType="com.mysql.jdbc.Driver";
    public String url="jdbc:mysql://"+host+":"+port+"/"+db_name+","+user_name+","+password;
    public PreparedStatement ps=null;
    public Connection con=null;
    
	/*public List<Cart> readingData(int ProductID){
	   	 
	 	   try {
	 		   String sorgu="SELECT * FROM product WHERE ProductID=?";
	 		   Class.forName("com.mysql.jdbc.Driver");
	 		    con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT","root","1234");
	            ps=con.prepareStatement(sorgu);
	            ps.setInt(1,ProductID);
	            ResultSet rs=ps.executeQuery();
	            List<Cart> liste=new ArrayList<>();
	            while(rs.next())
	            {
	            	Cart product =new Cart(rs.getInt("ProductID"),rs.getString("ProductName"),rs.getInt("ProductPrice"),
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
	 		  con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT","root","1234");
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
	 	   
	     }*/
	
	
	public List<Cart> readingData(){
	   	 
	 	   try {
	 		   String query="SELECT * FROM cart";
	 		   Class.forName("com.mysql.jdbc.Driver");
	 		  con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT","root","1234");
	            ps=con.prepareStatement(query);
	            
	            ResultSet rs=ps.executeQuery();
	            List<Cart> liste=new ArrayList<>();
	            while(rs.next())
	            {
	            	Cart product=new Cart(rs.getInt("ProductID"),rs.getString("ProductName"),rs.getInt("ProductPrice"),
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
					String sorgu="DELETE FROM cart WHERE ProductID=?";
					Class.forName("com.mysql.jdbc.Driver");
					 con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT","root","1234");
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
			


		
			/*public void Update(Product product){
			
				try {
					String sorgu="UPDATE product SET ProductName=?,ProductPrice=?,Image=? WHERE ProductID=?";
					Class.forName("com.mysql.jdbc.Driver");
					 con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT","root","1234");
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
			       
				}*/
			
			public void Insert(Product product) {
				try {
					String sorgu="INSERT INTO demo.cart (ProductID, ProductName, ProductPrice, Image) values (?, ?, ?, ?)";
					Class.forName("com.mysql.jdbc.Driver");
					 con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT","root","1234");
					ps=con.prepareStatement(sorgu);	    
			        
					ps.setInt(1, product.getProductID());
		            ps.setString(2, product.getProductName());
		            ps.setInt(3, product.getProductPrice());
		            ps.setString(4, product.getImage());
		            
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
