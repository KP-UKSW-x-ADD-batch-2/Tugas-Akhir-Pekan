/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import daos.EmployeeDao;
import daos.idaos.IEmployeeDao;
import java.sql.Connection;
import java.util.Scanner;
import models.EmployeeModel;
import tools.DbConnection;

/**
 *
 * @author Yosef Febrianes
 */
public class EmployeeTest {

    DbConnection connection = new DbConnection();
    IEmployeeDao iedao = new EmployeeDao(connection.GetConnection());
    Scanner scann = new Scanner(System.in);
    EmployeeModel r = new EmployeeModel();

    public static void main(String[] args) {

        DbConnection connection = new DbConnection();
        IEmployeeDao iedao = new EmployeeDao(connection.GetConnection());
        EmployeeTest e = new EmployeeTest();
        Scanner scann = new Scanner(System.in);
        int lanjut = 0;

        do {
            System.out.println("1 = Show");
            System.out.println("2 = Add");
            System.out.println("3 = Update");
            System.out.println("4 = Delete");
            System.out.println("5 = Search");
            System.out.print("pilih mana? = ");
            int a = scann.nextInt();

            switch (a) {
                case 1:
                    e.showw();
                    break;
                case 2:
                    e.insert();
                    break;
                case 3:
                    e.update();
                    break;
                case 4:
                    e.delete();
                    break;
                case 5:
                    e.searching();
                    break;
                default:
                    System.out.println("Pilih yang benar!");
                    break;

            }
            System.out.println("lagi? ");
            lanjut = scann.nextInt();
        } while (lanjut == 1);
    }

    void showw() {
        for (EmployeeModel h : iedao.getAll()) {
            System.out.println(h.getEmployeeId() + " | " + h.getFirstName() + " | " + h.getLastName() + " | " + h.getEmail() + " | " + h.getPhoneNumber() + " | " + h.getHireDate() + " | " + h.getJobId() + " | " + h.getSalary() + " | " + h.getCommisionPct() + " | " + h.getManagerId() + " | " + h.getDepartementId());
        }
    }

    void insert() {
        System.out.println("Masukkan ID! = ");
        String ei = scann.nextLine();

        System.out.println("Masukkan First Name! = ");
        String fn = scann.nextLine();

        System.out.println("Masukkan Last Name! = ");
        String ln = scann.nextLine();

        System.out.println("Masukkan Email! = ");
        String e = scann.nextLine();

        System.out.println("Masukkan Phone Number! = ");
        String pn = scann.nextLine();

        System.out.println("Masukkan Hire Date! = ");
        String hd = scann.nextLine();

        System.out.println("Masukkan Job ID! = ");
        String ji = scann.nextLine();

        System.out.println("Masukkan Salary! = ");
        String s = scann.nextLine();

        System.out.println("Masukkan Commision Pct! = ");
        String cp = scann.nextLine();

        System.out.println("Masukkan Manager ID! = ");
        String mi = scann.nextLine();

        System.out.println("Masukkan Departement ID! = ");
        String di = scann.nextLine();

        r.setEmployeeId(ei);
        r.setFirstName(fn);
        r.setLastName(ln);
        r.setEmail(e);
        r.setPhoneNumber(pn);
        r.setHireDate(hd);
        r.setJobId(ji);
        r.setSalary(s);
        r.setCommisionPct(cp);
        r.setManagerId(mi);
        r.setDepartementId(di);

        iedao.insert(r);
    }

    void update() {
        System.out.println("Masukkan ID! = ");
        String ei = scann.nextLine();

        System.out.println("Masukkan First Name! = ");
        String fn = scann.nextLine();

        System.out.println("Masukkan Last Name! = ");
        String ln = scann.nextLine();

        System.out.println("Masukkan Email! = ");
        String e = scann.nextLine();

        System.out.println("Masukkan Phone Number! = ");
        String pn = scann.nextLine();

        System.out.println("Masukkan Hire Date! = ");
        String hd = scann.nextLine();

        System.out.println("Masukkan Job ID! = ");
        String ji = scann.nextLine();

        System.out.println("Masukkan Salary! = ");
        String s = scann.nextLine();

        System.out.println("Masukkan Commision Pct! = ");
        String cp = scann.nextLine();

        System.out.println("Masukkan Manager ID! = ");
        String mi = scann.nextLine();

        System.out.println("Masukkan Departement ID! = ");
        String di = scann.nextLine();

        r.setEmployeeId(ei);
        r.setFirstName(fn);
        r.setLastName(ln);
        r.setEmail(e);
        r.setPhoneNumber(pn);
        r.setHireDate(hd);
        r.setJobId(ji);
        r.setSalary(s);
        r.setCommisionPct(cp);
        r.setManagerId(mi);
        r.setDepartementId(di);

        System.out.println(iedao.update(r));
    }

    void delete() {
        System.out.println("Masukkan ID! = ");
        String id = scann.nextLine();
        System.out.println(iedao.delete(id));
    }

    void searching() {
        System.out.println("Masukkan ID! = ");
        String fortune = scann.nextLine();

        String employeeId = fortune;
        iedao.search(employeeId).forEach((h) -> {
            System.out.println(h.getEmployeeId() + " | " + h.getFirstName() + " | " + h.getLastName() + " | " + h.getEmail() + " | " + h.getPhoneNumber() + " | " + h.getHireDate() + " | " + h.getJobId() + " | " + h.getSalary() + " | " + h.getCommisionPct() + " | " + h.getManagerId() + " | " + h.getDepartementId());
        });

    }
}
