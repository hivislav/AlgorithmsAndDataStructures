public class NoteBook {

    private String brand;
    private int price;
    private int ddr;
    private int priority;

    public NoteBook(String brand, int price, int ddr, int priority) {
        this.brand = brand;
        this.price = price;
        this.ddr = ddr;
        this.priority = sortPriority(brand); // поле для присвоения приоритета бренду для последующей сортировки
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDdr() {
        return ddr;
    }

    public void setDdr(int ddr) {
        this.ddr = ddr;
    }

    public int getPriority() {
        return priority;
    }

    public int setPriority() {
        return priority;
    }

    // метод присвоения приоритета бренду

    private int sortPriority(String brand){
        int priority = 0;

        if (brand == "Lenuvo")
        {priority = 1;}
        if (brand == "Asos")
        {priority = 2;}
        if (brand == "MacNote")
        {priority = 3;}
        if (brand == "Eser")
        {priority = 4;}
        if (brand == "Xamiou")
        {priority = 5;}

        return priority;
    }

}
