package CAR_RENTAL_System;
class Car {
    private String car_id; //car001
    private String brand; //Mahindra
    private String model; //Thar
    private double basePricePerDay;
    private boolean isAvailable; // true/false
    public Car(String car_id,String brand,String model,double basePricePerDay){
        this.car_id=car_id;
        this.brand=brand;
        this.model=model;
        this.basePricePerDay=basePricePerDay;
        this.isAvailable=true;
    }
    public String getCar_id(){
        return car_id;
    }
    public String getBrand(){
        return brand;
    }
    public String getModel(){
        return model;
    }
    public double calculatePrice(int rentalDays){
        return basePricePerDay * rentalDays;
    }
    public boolean isAvailable(){
        return isAvailable;
    }
    public void rent(){
        isAvailable=false;
    }
    public void returnCar(){
        isAvailable=true;
    }
}
