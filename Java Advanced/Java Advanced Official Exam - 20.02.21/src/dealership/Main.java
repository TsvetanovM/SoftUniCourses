package dealership;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("Toyota", "Yaris", 2007);
        Dealership dealership = new Dealership("Marto", 2);

        dealership.add(car1);

        dealership.add(new Car("Peugeot", "5008", 2018));
        System.out.println(dealership.buy("Toyota", "Yaris"));
        dealership.add(new Car("VW", "Passat", 2016));

        System.out.println(dealership.getCar("Toyota", "Yaris"));
        System.out.println(dealership.getLatestCar());
        System.out.println(dealership.getCount());
        System.out.println(dealership.getStatistics());
    }
}
