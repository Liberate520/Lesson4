package ru.vending;

public class Product {
    private String name;
    private double price;


    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

//    public void setPrice(double price) {
//        this.price = price;
//    }

    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }


    @Override
    public String toString() {
        return "name: " + name + ", price: " + price +"p.";
    }

////    @Override // метод 2
//    public String toString() {
//        return "ru.vending.Product{" +
//                "name='" + name + '\'' +
//                ", price=" + price +
//                '}';
//    }
}
