/*
Adrian Paiva 100864588
Patrick Gomes Sanches

Comp 3095 - Assignment 1
CRN - 13099
 */

package Model;

/*
 Adrian Paiva 100864588
Patrick Gomes Sanches

Comp 3095 - Assignment 2
CRN - 13099
 */
public class Product {
    
    private int id;
    private String name;
    private String description;
    private double price;
    private String image;
    private int category;
    
    private int quantityInStock;

    
    public Product()
    {
        
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }
    public int getCategory()
    {
        return category;
    }
    /*
    public void incrementQuanity()
    {
        setQuantity(getQuantity() + 1);
    }
    public void decrementQuanity()
    {
        setQuantity(getQuantity() - 1);
    }
    public double getTotalItemCost()
    {
        return price * quantity;
    }
    */
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setCategory(int category) {
        this.category = category;
    }
    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

}
