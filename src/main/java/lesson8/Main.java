package lesson8;

public class Main {

    public static void main(String[] args) {
        HashTableChain<Product, Integer> hashTableChain = new HashTableImplChain<>(5);

        hashTableChain.put(new Product(0, "Пельмени"), 100);
        hashTableChain.put(new Product(0, "Пельмени"), 1000);
        hashTableChain.put(new Product(0, "Пельмени"), 1500);
        hashTableChain.put(new Product(1, "Морковь"), 100);
        hashTableChain.put(new Product(1, "Морковь"), 50);
        hashTableChain.put(new Product(2, "Арбуз"), 200);
        hashTableChain.put(new Product(3, "Авокадо"), 1000);
        hashTableChain.put(new Product(8, "Сельдерей"), 99);
        hashTableChain.put(new Product(8, "Сельдерей"), 120);
        hashTableChain.put(new Product(8, "Сельдерей"), 125);
        hashTableChain.put(new Product(8, "Сельдерей"), 78);

        hashTableChain.display();

        hashTableChain.remove(new Product(0, "Пельмени"));
        hashTableChain.remove(new Product(0, "Пельмени"));
        hashTableChain.remove(new Product(0, "Пельмени"));

        hashTableChain.display();

        hashTableChain.put(new Product(0, "Пельмени"), 99999);
        hashTableChain.put(new Product(0, "Пельмени"), 116);

        hashTableChain.display();

    }
}
