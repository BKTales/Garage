public class Car
{
    private String id;
    private String registration;
    private int age;
    private float mileometer;
    private int revisions;

    public Car(String id, String registration, int age, float mileometer, int revisions) {
        this.id = id;
        this.registration = registration;
        this.age = age;
        this.mileometer = mileometer;
        this.revisions = revisions;
    }

    public void addRev() {
        revisions++;
    }

    public int getRevs() {
        return revisions;
    }

    public float getMil(){
        return mileometer;
    }

    public void updateMiles(float miles){
        mileometer += miles;
    }

    public String getId() {
        return id;
    }

}
