package ru.vending;

public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();

        Product product1 = new Product("twix",100);
        Product product2 = new Bottle("coca-cola",110, 2);
        Product product3 = new Product("lays",80);

        vendingMachine.addProduct(product1);
        vendingMachine.addProduct(product2);
        vendingMachine.addProduct(product3);

        System.out.println(vendingMachine);

    }
}
