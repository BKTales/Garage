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

    static int numCars;
    static int numBikes;
    static motInfo myBike = new motInfo();

    static carInfo myCar = new carInfo();



    static int revisionsCar;
    public static void main(String[] args)
    {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("\nSelecione uma opcao: \n1 - Adicionar carros \n2 - Adicionar motas \n3 - Verificar os garagem \n"); //Obter Output
        int opcao = scanner1.nextInt(); //Obter Input
        switch (opcao)
        {
            case 1:
                cars();
                main(args);
                break;
            case 2:
                bikes();
                main(args);
                break;
            case 3:
                seeGarage();
                main(args);
                break;
            case 4:
                break;
            default:
                main(args);
                break;
        }
    }

    private static void cars()
    {
        Scanner scanner2 = new Scanner(System.in);

            System.out.println("ID: ");
            myCar.ID = scanner2.nextLine();
            System.out.println("Registration: ");
            myCar.registration = scanner2.nextLine();
            System.out.println("Age: ");
            myCar.Age = scanner2.nextInt();
            System.out.println("Miles: ");
            myCar.mileometer = scanner2.nextFloat();
            System.out.println("Revisions: ");
            myCar.revisions = scanner2.nextInt();
            numCars ++;
    }

    private static int carRevs()
    {
            return myCar.revisions;
    }

    public static void bikes()
    {
        Scanner scanner3 = new Scanner(System.in);
        System.out.println("ID: ");
        myBike.ID = scanner3.nextLine();
        System.out.println("Registration: ");
        myBike.registration = scanner3.nextLine();
        System.out.println("Age: ");
        myBike.Age = scanner3.nextInt();
        System.out.println("Miles: ");
        myBike.mileometer = scanner3.nextFloat();
        System.out.println("Revisions: ");
        myBike.revisions = scanner3.nextInt();

        numBikes++;
    }
    private static int bikeRevs()
    {
        return myBike.revisions;
    }

    private static void seeGarage()
    {
        String answer01;
        String answer02;
        String answer03;
        int revisionstoAdd;

        Scanner scanner4 = new Scanner(System.in);

        System.out.println("You have " + numCars + " cars.\n");

        System.out.println("You have " + numBikes + " bikes.\n");

        if(balance())
        {
            System.out.println("You might need balance to ride a bike.");
        }
        if(numBikes != 0)
        {
            System.out.println("Do you wish to see how many revisions have you got on your bike? (Y/N)");
            answer01 = scanner4.nextLine();
            switch (answer01)
            {
                case "Y":
                    System.out.println("You got " + bikeRevs() + " revisions.");
                    break;
                case "N":
                    System.out.println("Okay, thanks.");
                    break;
                default:
                    System.out.println("System Error.");
            }
        }
        if(numCars != 0)
        {
            System.out.println("Do you with to see how many revisions have you got on your car (Y/N)");
            answer02 = scanner4.nextLine();
            switch (answer02)
            {
                case "Y":
                    System.out.println("You got " + carRevs() + " revisions.");
                    System.out.println("Do you want to add revisions? (Y/N)");
                    answer03 = scanner4.nextLine();
                    switch (answer03){
                        case "Y":
                            System.out.println("How many revisions?");
                            revisionstoAdd = scanner4.nextInt();
                        default:
                            break;

                    }
                    break;
                case "N":
                    System.out.println("Okay, thanks.");
                default:
                    System.out.println("System Error.");
            }
        }

    }
    private static boolean balance()
    {
        boolean balance;

        if(numBikes == 0)
        {
            balance = false;
        } else
            balance = true;

        return balance;
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