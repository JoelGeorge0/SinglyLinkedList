package JGT190002;

// class product implements the IDedObject
// with getID() and printID()
// product class has 3 attributes product id, product name and supplierName
class Product implements IDedObject {
    private int productID;
    private String productName;
    private String supplierName;

    public Product(int productID, String productName, String supplierName){ // creates product with atributes Product ID, name and supplier
        this.productID = productID; // sets the value passed in to the attribute of the object product
        this.productName = productName;// sets the value passed in to the attribute of the object product
        this.supplierName = supplierName;// sets the value passed in to the attribute of the object product
    }

    public int getID() { // the constructor return the product ID
        return productID;
    }

    // the constructs prints all the attributes
    public void printID() {
        System.out.println("Your Product ID number: " + productID);
        System.out.println("Your Product name: " + productName);
        System.out.println("Your Supplier name: " + supplierName);
    }

}
