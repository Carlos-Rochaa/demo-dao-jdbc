package application;

import model.entities.Department;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Department obj = new Department(1, "books");
        Seller seller = new Seller(21, "Bob", "bob@gmail.com", new Date(), 3000.00, obj);

        System.out.println(seller);
    }
}