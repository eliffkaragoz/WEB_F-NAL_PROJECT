package Entity;

public class Cart {

	private int ProductID;
	private String ProductName;
	private int ProductPrice;
	private String Image;

		
	public Cart(int ProductID) {
	
		this.ProductID = ProductID;
	}

	
	public Cart(int ProductID,  String ProductName, int ProductPrice , String Image) {
	
		this.ProductID = ProductID;
		this.Image = Image;
		this.ProductName = ProductName;
		this.ProductPrice = ProductPrice;
	}


	public Cart(String ProductName, int ProductPrice) {
		super();
		this.ProductName = ProductName;
		this.Image = Image;

		this.ProductPrice = ProductPrice;
	
	}


	

	public int getProductID() {
		return ProductID;
	}


	public void setProductID(int productID) {
		ProductID = productID;
	}


	public String getProductName() {
		return ProductName;
	}


	public void setProductName(String productName) {
		ProductName = productName;
	}


	public int getProductPrice() {
		return ProductPrice;
	}


	public void setProductPrice(int productPrice) {
		ProductPrice = productPrice;
	}

	public String getImage() {
		return Image;
	}


	public void setImage(String image) {
		Image = image;
	}

	




   
   
}
