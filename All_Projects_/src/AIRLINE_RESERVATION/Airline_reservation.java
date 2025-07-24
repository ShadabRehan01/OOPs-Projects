package AIRLINE_RESERVATION;
import java.util.Scanner;
public class Airline_reservation {
    static int []seats = new int[11];//Starting index of array is always Zero & default value of Array will be Zero
    static Scanner sc = new Scanner(System.in);
    public static void displaySeat(){
        for (int i=1; i<seats.length; i++){
            System.out.println("Seat " +i+": " + (seats[i]==0 ? "Available" : "Reserved"));
        }
    }
    public static int Travel(String place){
        String []loc={"Agra","Delhi","Mumbai","Kolkata","Howrah","Kanpur","Lucknow","Patna","Jaipur"};
        int flag=0;
        int count=0;
        for (int i=0; i< loc.length; i++){
            if(loc[i].equalsIgnoreCase(place)){
                flag=1;
                count=count*count+100;
                break;
            }
            count++;
        }
        if(flag==1){
            return count;
        }else {
            return 1;
        }
    }
    public static void reserveSeat(){
        System.out.print("\nEnter Seat number to reserve: ");
        int seat=sc.nextInt();
        if(seats[seat] == 0){
            seats[seat] = 1;
            System.out.println("Seat "+ seat+ " reserve Successfully");
        }else {
            System.out.println("Seat "+ seat+ " is already reserved");
        }
    }

    public static void main(String[] args) {
        System.out.println("======*** WELCOME TO XYZ AIRLINE SYSTEM ***======");
        while (true){
            System.out.println("\nPlease select an option:");
            System.out.println("1. View available seats");
            System.out.println("2. Choose Origin and Destination Place");
            System.out.println("3. Exit");
            int choice=sc.nextInt();

            switch (choice) {
                case 1 -> displaySeat();
                case 2 -> {
                    System.out.print("Enter the Origin place: ");
                    String Origin=sc.nextLine();
                    sc.nextLine();
                    System.out.print("Enter the Destination place: ");
                    String destination=sc.nextLine();
                    Travel(Origin);

                    int count=Travel(destination);
                    if(count==1){
                        System.out.println("Please Enter valid place Name");
                        break;
                    }
                    System.out.println("Fare to "+destination+" is $"+count);
                    System.out.print("Do you want to book Seat Y/N: ");
                    String ch=sc.nextLine();
                    if(ch.equalsIgnoreCase("Y")){
                        reserveSeat();
                    }
                }
                case 3 -> {
                    System.out.println("\nThank you for using XYZ Airline");
                    System.exit(0);
                }
                default -> System.out.println("Please Enter the valid choice");
            }
        }
    }
}
