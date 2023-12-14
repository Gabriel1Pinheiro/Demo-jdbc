package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Scanner;
import java.util.Date;
import java.util.List;


public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== TESTE 1: seller findById ====");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println();

        System.out.println("=== TESTE 2: seller findyByDepartment ====");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj : list){
            System.out.println(obj);
        }

        System.out.println();

        System.out.println("=== TESTE 3: seller findAll ====");
        list = sellerDao.findAll();
        for (Seller obj : list){
            System.out.println(obj);
        }

        System.out.println();

        System.out.println("\n=== TESTE 4: seller insert =====");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Id novo inserido! = " + newSeller.getId());


        System.out.println();

        System.out.println("\n=== TESTE 5: seller update =====");
        seller = sellerDao.findById(1);
        seller.setName("Martha Waine");
        sellerDao.update(seller);
        System.out.println("Update completo!");

        System.out.println();

        System.out.println("\n=== TESTE 6: seller delete =====");
        System.out.println("Insira o id para teste de exclusão");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Delete completo!");

        sc.close();


    }
}
