import java.util.Scanner;

/* TIPOS DE VARIAVEIS
    boolean - true / false
    String - "hello", "bye", " "
    char = 'a', 'b', '3'
    int = -1, 0, 2, 8
    float = 2.5, -1.2
    String[][] - array de Strings
*/

public class Main {
    public static void main(String[] args)
    {
        Garage garage = new Garage();
        Scanner scan = new Scanner(System.in);
        System.out.println("\nSelecione uma opcao: \n1 - Adicionar carros \n2 - Adicionar motas \n3 - Verificar os garagem \n"); //Obter Output
        int opcao = scan.nextInt(); scan.nextLine(); //Obter Input
        while (opcao != 0) {
            switch (opcao)
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
            System.out.println("\nSelecione uma opcao: \n1 - Adicionar carros \n2 - Adicionar motas \n3 - Verificar os garagem \n"); //Obter Output
            opcao = scan.nextInt(); scan.nextLine();
        }
        scan.close();
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

        String ans = "";

        System.out.println("You have " + garage.getNumCars() + " cars.\n");

        System.out.println("You have " + garage.getNumBikes() + " bikes.\n");

        if(garage.balance())
        {
            System.out.println("You might need balance to ride a bike.");
        }
        if(garage.hasBikes())
        {
            System.out.println("Do you wish to see how many revisions have you got on your bike? (Y/N)");
            ans = scan.nextLine();
            switch (ans)
            {
                case "Y":
                    System.out.println("You got " + garage.bikeRevs() + " revisions.");
                    System.out.println("Do you want to add revisions? (Y/N)");
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
        if(garage.hasCars())
        {
            System.out.println("Do you with to see how many revisions have you got on your car (Y/N)");
            ans = scan.nextLine().trim();
            switch (ans)
            {
                case "Y":
                    System.out.println("You got " + garage.carRevs() + " revisions.");
                    System.out.println("Do you want to add revisions? (Y/N)");
                    ans = scan.nextLine();
                    switch (ans){
                        case "Y":
                            System.out.println("How many revisions?");
                            int revisionsToAdd = scan.nextInt();
                            System.out.println("What is the id of your car?");
                            String id = scan.nextLine().trim();
                            Car car = garage.getCar(id);
                            for (int i = 0; i < revisionsToAdd; i++) {
                                if (car != null)
                                    car.addRev();
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
}




/*
Programa: [Do While] (Para Java)
Menu que permite adicionar carros e motas no sistema - V
Método que diz é preciso equilibrio -> Mota - Verdadeiro ; Carro - Falso -> V
O Carro tem que ter: ID (String), Matricula (String), Idade (int), Conta KMs (float), Revisões (int) -> V
A Mota tem que ter: ID (String), Matricula (String), Idade (int), Conta KMs (float), Revisões (int) -> V

Adicionar Carros -> V
Adicionar Motas -> V

Ver os Kms (Carro; Mota)
Dar update nos Kms (Carro; Mota)

Obter o nº de Revisões (Carro; Mota) -> V
Update Revisões (Carro; Mota)

O programa quando inicializa cria um garagem com carros e motas;
Criar garagem virtual.

Quantos veiculos tem na garagem - V

Aux -> Quantos carros || Quantas motas. - V
 */