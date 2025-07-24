package Car_Showroom_Management;

import java.util.Scanner;

public class Cars extends Showroom implements Utility {
    String car_Name;
    String car_color;
    String car_fuel_type;
    int car_price;
    String car_type; //HONDA_CITY,SUV,LUXURY
    String car_transmission; // AUTOMATIC OR MANUAL
    @Override
    public void get_details(){
        System.out.println("Name: "+car_Name);
        System.out.println("Color: "+car_color);
        System.out.println("Fuel Type: "+car_fuel_type);
        System.out.println("Price: "+car_price);
        System.out.println("CAR TYPE: "+car_type);
        System.out.println("Transmission: "+car_transmission);
    }
    @Override
    public void set_details(){
        Scanner sc= new Scanner(System.in);
        System.out.println("============================== *** ENTER CAR DETAILS *** =============================");
        System.out.println();
        System.out.print("CAR NAME: ");
        car_Name=sc.nextLine();
        System.out.print("CAR COLOR: ");
        car_color=sc.nextLine();
        System.out.print("CAR FUEL TYPE(PETROL/DIESEL/ELECTRIC): ");
        car_fuel_type=sc.nextLine();
        System.out.print("CAR PRICE: ");
        car_price= sc.nextInt();
        sc.nextLine();
        System.out.print("CAR TYPE (SUV/LUXURY/Sports_Car/Sedan/Wagon/Convertible/Coupe): ");
        car_type=sc.nextLine();
        System.out.print("TRANSMISSION TYPE (AUTOMATIC/MANUAL): ");
        car_transmission= sc.nextLine();

        total_cars_in_stock++;
    }
}
