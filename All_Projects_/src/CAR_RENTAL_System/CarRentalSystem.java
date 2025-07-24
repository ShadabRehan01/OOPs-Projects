package CAR_RENTAL_System;
import java.util.*;
class CarRentalSystem {
    private List<Car> cars;
    private List<Customer> customers;
    private List<Rental> rentals;

    public CarRentalSystem() {
        cars=new ArrayList<>();
        customers=new ArrayList<>();
        rentals=new ArrayList<>();
    }
    public void addCar(Car car){
        cars.add(car);
    }
    public void addCustomer(Customer customer){
        customers.add(customer);
    }
    public void rentCar(Car car,Customer customer, int days){
        if(car.isAvailable()){
            car.rent();
            rentals.add(new Rental(car,customer,days));
        }else {
            System.out.println("Car is not available for rent.");
        }
    }
    public void returnCar(Car car){
        car.returnCar();
        Rental rentalToRemove =null;
        for (Rental rental: rentals){
            if(rental.getCar()==car){
                rentalToRemove=rental;
                break;
            }
        }
        if(rentalToRemove != null){
            rentals.remove(rentalToRemove);
        }else {
            System.out.println("Car was not rented");
        }
    }
    public void menu(){
        Scanner sc=new Scanner(System.in);
        while (true){
            System.out.println("=========*** WELCOME TO CAR RENTAL SYSTEM ***=========");
            System.out.println("1. Rent a Car");
            System.out.println("2. Return a Car");
            System.out.println("3. Exit");
            System.out.print("\nEnter your choice:");

            int choice=sc.nextInt();
            sc.nextLine(); //Consume nextLine
            if(choice==1)
            {
                System.out.println("\n== Rent a Car==\n");
                System.out.print("Enter your name: ");
                String customerName = sc.nextLine();

                System.out.println("\nAvailable Cars: ");
                for (Car car : cars) {
                    if (car.isAvailable()) {
                        System.out.println(car.getCar_id() + " - " + car.getBrand() + " - " + car.getModel());
                    }
                }
                System.out.print("\nEnter the car ID you want to rent: ");
                String carID = sc.nextLine();

                System.out.print("Enter the number of days for rental: ");
                int rentalDays = sc.nextInt();
                sc.nextLine(); //Consume nextLine

                Customer newCustomer = new Customer("CUS" + (customers.size() + 1), customerName);
                addCustomer(newCustomer);

                Car selectedCar = null;
                for (Car car : cars) {
                    if (car.getCar_id().equals(carID) && car.isAvailable()) {
                        selectedCar = car;
                        break;
                    }
                }
                if (selectedCar != null) {
                    double totalPrice = selectedCar.calculatePrice(rentalDays);
                    System.out.println("\n== Rental Information ===\n");
                    System.out.println("Customer ID: " + newCustomer.getCustomerid());
                    System.out.println("Customer name: " + newCustomer.getName());
                    System.out.println("Car: " + selectedCar.getBrand() + " " + selectedCar.getModel());
                    System.out.println("Rental Days: " + rentalDays);
                    System.out.printf("Total Price: $%.2f%n", totalPrice);

                    System.out.println("\nConfirm Rental (Y/N): ");
                    String confirm = sc.nextLine();

                    if (confirm.equalsIgnoreCase("Y")) {
                        rentCar(selectedCar, newCustomer, rentalDays);
                        System.out.println("\nCar rented Successfully.");
                    } else {
                        System.out.println("\nRental cancelled");
                    }
                }
                else {
                    System.out.println("\nInvalid Car selection or car not available for rent.");
                }
            } else if(choice==2) {
                System.out.println("\n== Return a car ==\n");
                System.out.print("Enter the Car ID you want to return: ");
                String carId = sc.nextLine();

                Car carToreturn = null;
                for (Car car : cars) {
                    if (car.getCar_id().equals(carId) && !car.isAvailable()) {
                        carToreturn = car;
                        break;
                    }
                }
                if (carToreturn !=null){
                    Customer customer=null;
                    for (Rental rental: rentals){
                        if(rental.getCar()==carToreturn){
                            customer = rental.getCustomer();
                            break;
                        }
                    }
                    if (customer != null){
                        returnCar(carToreturn);
                        System.out.println("Car return Successfully by "+customer.getName());
                    } else {
                        System.out.println("Car was not rented or rental information is missing.");
                    }
                }else {
                    System.out.println("Invalid car ID or car is not rented");
                }
           }else if(choice==3){
                break;
            } else {
                System.out.println("Invalid choice,Please enter a valid Option.");
            }
        }
        System.out.println("\nThank You for using the Car Rental System!");
    }
}
class MainSystem{
    public static void main(String[] args) {
        CarRentalSystem rentalSystem=new CarRentalSystem();

        Car car1 = new Car("C001","Toyota","Camry",60.0);
        Car car2 = new Car("C002","Honda","Accord",70.0);
        Car car3 = new Car("C003","Mahindra","Thar",150.0);

        rentalSystem.addCar(car1);
        rentalSystem.addCar(car2);
        rentalSystem.addCar(car3);

        rentalSystem.menu();
    }
}
