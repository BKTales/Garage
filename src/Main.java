import java.util.*;

public class Main {
    public static void main(String[] args)
    {
        try {
            int userInput = 0;
            Garage garage = new Garage();
            Scanner scan = new Scanner(System.in);
            System.out.println("\nSelect an option: \n1 - Add cars \n2 - Add bikes \n3 - Check garage \n"); //Output
            userInput = scan.nextInt(); scan.nextLine(); //Get user input.

            while (userInput != 0) {
                switch (userInput)
                {
                    case 1:
                        cars(scan, garage);
                        break;
                    case 2:
                        bikes(scan, garage);
                        break;
                    case 3:
                        seeGarage(scan, garage);
                        break;
                    default:
                        break;
                }
                System.out.println("\nSelect an option: \n1 - Add cars \n2 - Add bikes \n3 - Check garage \n"); //Output
                userInput = scan.nextInt(); scan.nextLine();
            }
            scan.close();
        }catch (Exception e){
            System.out.println("Invalid Input");
            main(args);
        }

    }
    private static void cars(Scanner scan, Garage garage)
    {
        System.out.print("ID: ");
        String id = scan.nextLine().trim();
        System.out.print("Registration: ");
        String registration = scan.nextLine().trim();
        System.out.print("Age: ");
        int age = scan.nextInt();
        System.out.print("Miles: ");
        float mileometer = scan.nextFloat();
        System.out.print("Revisions: ");
        int revisions = scan.nextInt();
        garage.addCar(id, registration, age, mileometer, revisions);
    }

    public static void bikes(Scanner scan, Garage garage)
    {
        System.out.print("ID: ");
        String id = scan.nextLine().trim();
        System.out.print("Registration: ");
        String registration = scan.nextLine().trim();
        System.out.print("Age: ");
        int Age = scan.nextInt();
        System.out.print("Miles: ");
        float mileometer = scan.nextFloat();
        System.out.print("Revisions: ");
        int revisions = scan.nextInt();
        garage.addBike(id, registration, Age, mileometer, revisions);
    }

    private static void seeGarage(Scanner scan, Garage garage)
    {
        if(garage.hasCars())
        {
            CarInterface(scan, garage);
        }
        if(garage.hasBikes()){
            BikeInterface(scan, garage);
        }
    }
    private static void CarInterface(Scanner scan, Garage garage)
    {
        String ans;
        System.out.println("You have " + garage.getNumCars() + " car(s).\n");
        System.out.println("Do you want to see how many revisions you got on your car (Y/N)");
            ans = scan.nextLine().trim();
            switch (ans)
            {
                case "Y":
                    System.out.println("You got " + garage.carRevs() + " revisions.");
                    System.out.println("Do you want to add revisions? (Y/N)");
                    ans = scan.nextLine();
                    switch (ans){
                        case "Y":
                            System.out.println("How many revision(s)?");
                            int revisionsToAdd = scan.nextInt(); scan.nextLine();
                            System.out.println("What's you car id?");
                            String carId = scan.nextLine().trim();
                            Car car = garage.getCar(carId);
                            for (int i = 0; i < revisionsToAdd; i++) {
                                if (car != null)
                                    car.addRev();
                            }
                            break;
                        default:
                            break;
                    }
                    break;
                case "N":
                    System.out.println("Okay, thanks.");
                    break;
                default:
                    System.out.println("System Error.");
            }
    }
    private static void BikeInterface(Scanner scan, Garage garage)
    {
        String ans;

        System.out.println("You got " + garage.getNumBikes() + "Bike(s)\n");

        System.out.println("Do you wish to see how many revisions have you got on your bike? (Y/N)\n");
        ans = scan.nextLine();
        switch (ans)
        {
            case "Y":
                System.out.println("You got " + garage.bikeRevs() + " revision(s).");
                System.out.println("Do you want to add any revisions? (Y/N)");
                ans = scan.nextLine().trim();
                switch (ans){
                    case "Y":
                        System.out.println("How many revisions?");
                        int revisionsToAdd = scan.nextInt();
                        System.out.println("What is the id of your bike?");
                        String id = scan.nextLine().trim();
                        Bike bike = garage.getBike(id);
                        for (int i = 0; i < revisionsToAdd; i++) {
                            bike.addRev();
                        }
                    default:
                        break;
                }
                break;
            case "N":
                System.out.println("Okay, thanks.");
                break;
            default:
                System.out.println("System Error.");
        }
    }
}

