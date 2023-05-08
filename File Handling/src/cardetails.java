import java.io.Serializable;

public class cardetails implements Serializable{
	private int id;
    private String name;
    private int price;

    public cardetails(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCompany() {
        return price;
    }

    @Override
    public String toString() {
        return id+" "+name+" "+price;
    }

}
