/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import daos.LocationDao;
import daos.idaos.ILocationDao;
import java.sql.Connection;
import java.util.Scanner;
import models.LocationModel;
import tools.DbConnection;

/**
 *
 * @author Yosef Febrianes
 */
public class LocationTest {

    DbConnection connection = new DbConnection();
    ILocationDao ildao = new LocationDao(connection.GetConnection());
    Scanner scann = new Scanner(System.in);
    LocationModel l = new LocationModel();

    public static void main(String[] args) {

        DbConnection connection = new DbConnection();
        ILocationDao ildao = new LocationDao(connection.GetConnection());
        LocationTest l = new LocationTest();
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
                    l.show();
                    break;
                case 2:
                    l.insert();
                    break;
                case 3:
                    l.update();
                    break;
                case 4:
                    l.delete();
                    break;
                case 5:
                    l.searching();
                    break;
                default:
                    System.out.println("Pilih yang benar!");
                    break;

            }
            System.out.println("lagi? ");
            lanjut = scann.nextInt();
        } while (lanjut == 1);

    }

    void show() {
        for (LocationModel h : ildao.getAll()) {
            System.out.println(h.getLocationId() + " | " + h.getStreetAddress() + " | " + h.getPostalCode() + " | " + h.getCity() + " | " + h.getStateProvince() + " | " + h.getCountryId());
        }
    }

    void insert() {
        System.out.println("Masukkan Location ID! = ");
        String id = scann.nextLine();
        System.out.println("Masukkan Street Address! = ");
        String sa = scann.nextLine();
        System.out.println("Masukkan Postal Code! = ");
        String pc = scann.nextLine();
        System.out.println("Masukkan City! = ");
        String c = scann.nextLine();
        System.out.println("Masukkan State Province ! = ");
        String sp = scann.nextLine();
        System.out.println("Masukkan Country ID! = ");
        String ci = scann.nextLine();

        l.setLocationId(id);
        l.setStreetAddress(sa);
        l.setPostalCode(pc);
        l.setCity(c);
        l.setStateProvince(sp);
        l.setCountryId(ci);

        ildao.insert(l);
    }
    
        void update() {
        System.out.println("Masukkan Location ID! = ");
        String id = scann.nextLine();
        System.out.println("Masukkan Street Address! = ");
        String sa = scann.nextLine();
        System.out.println("Masukkan Postal Code! = ");
        String pc = scann.nextLine();
        System.out.println("Masukkan City! = ");
        String c = scann.nextLine();
        System.out.println("Masukkan State Province ! = ");
        String sp = scann.nextLine();
        System.out.println("Masukkan Country ID! = ");
        String ci = scann.nextLine();

        l.setLocationId(id);
        l.setStreetAddress(sa);
        l.setPostalCode(pc);
        l.setCity(c);
        l.setStateProvince(sp);
        l.setCountryId(ci);

        System.out.println(ildao.update(l));
    }

    void delete() {
        System.out.println("Masukkan ID! = ");
        String id = scann.nextLine();
        System.out.println(ildao.delete(id));
    }
    
        void searching() {
        System.out.println("Masukkan ID! = ");
        String fortune = scann.nextLine();

        String locationId = fortune;
        ildao.search(locationId).forEach((h) -> {
    System.out.println(h.getLocationId() + " | " + h.getStreetAddress() + " | " + h.getPostalCode() + " | " + h.getCity() + " | " + h.getStateProvince() + " | " + h.getCountryId());
        });

    }
}
