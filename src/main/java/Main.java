public class Main {

    private static String[] brandArr = {"Lenuvo", "Asos", "MacNote", "Eser", "Xamiou"};
    private static String brand;
    private static int price;
    private static int ddr;
    private static int number;


    public static void main(String[] args) {
        number = 10000;

        NoteBook[] noteBooks = new NoteBook[number];
        for (int i = 0; i < number; i++) {
            noteBooks[i] = new NoteBook(randomBrand(brand), randomPrice(price), randomDdr(ddr), 0);
            System.out.println(noteBooks[i].getBrand() + " " + noteBooks[i].getPrice() + " " + noteBooks[i].getDdr());
        }

        System.out.println("===============После сортировки===============");

        Sort.sort(noteBooks);

        for (int i = 0; i < number; i++) {
            System.out.println(noteBooks[i].getBrand() + " " + noteBooks[i].getPrice() + " " + noteBooks[i].getDdr());
        }
    }

    private static String randomBrand(String brand){
        int i = (int) (brandArr.length * Math.random());
        brand = brandArr[i];
        return brand;
    }

    private static int randomPrice(int price){
        int stepPrice = 50;
        int min = 500;
        int max = 2000;

        price = (int)((min / stepPrice + Math.random() * ((max - min + stepPrice) / stepPrice))) * stepPrice;
        return price;
    }
    private static int randomDdr(int ddr){
        int stepDdr = 4;
        int min = 4;
        int max = 24;

        ddr = (int)((min / stepDdr + Math.random() * ((max - min + stepDdr) / stepDdr))) * stepDdr;
        return ddr;
    }
}
