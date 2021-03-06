public class Garage {
    private Car[] cars;
    private Bike[] bikes;

    public Garage() {
        this.cars = new Car[100];
        this.bikes = new Bike[100];
    }

    public void addCar(String id, String registration, int age, float mileometer, int revisions) {
        for (int i = 0; i < cars.length; i++) {
            if (cars[i] == null) {
                cars[i] = new Car(id, registration, age, mileometer, revisions);
                break;
            }
        }
    }

    public void addBike(String id, String registration, int age, float mileometer, int revisions) {
        for (int i = 0; i < bikes.length; i++) {
            if (bikes[i] == null) {
                bikes[i] = new Bike(id, registration, age, mileometer, revisions);
                break;
            }
        }
    }

    public int getNumCars() {

        int sum = 0;

        for (int i = 0; cars[i] != null; i++) {
            sum++;
        }
        return sum;
    }

    public int getNumBikes() {

        int sum = 0;

        for (int i = 0; bikes[i] != null; i++) {
            sum++;
        }
        return sum;
    }

    public int carRevs() {

        int sum = 0;

        for (int i = 0; cars[i] != null; i++) {
            sum += cars[i].getRevs();
        }
        return sum;
    }

    public int bikeRevs() {

        int sum = 0;

        for (int i = 0; bikes[i] != null; i++) {
            sum += bikes[i].getRevs();
        }
        return sum;
    }

    public boolean hasCars() {
        return cars[0] != null;
    }
    public boolean hasBikes() {
        return bikes[0] != null;
    }

    // Note: não podem haver id's iguais! >:(
    public Car getCar(String id) {
        for (Car c: cars) {
            if (c == null)
                return null;
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    public Bike getBike(String id) {
        for (Bike b: bikes) {
            if (b.getId().equals(id)) {
                return b;
            }
        }
        return null;
    }
}
