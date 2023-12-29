package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();
        System.out.println("=== TEST1: seller findById");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);


        Department department = new Department(2, null);
        System.out.println("\n=== TEST2: seller findByDepartment");
        List<Seller> list = sellerDao.findByDepartment(department);

        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n=== TEST3: seller findAll");
        list = sellerDao.findAll();

        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n=== TEST4: seller insert");
        Seller seller1 = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.00, department);
        sellerDao.insert(seller1);
        System.out.println("Inserted! New id: " + seller1.getId());

        System.out.println("\n=== TEST5: seller update");

        seller = sellerDao.findById(1);
        seller.setName("Marta Wayne");
        sellerDao.update(seller);
        System.out.println("Update Complete");
    }
}