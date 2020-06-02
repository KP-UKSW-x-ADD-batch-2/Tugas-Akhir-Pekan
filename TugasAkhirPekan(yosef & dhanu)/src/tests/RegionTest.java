/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import daos.RegionDao;
import daos.idaos.IRegionDao;
import java.sql.Connection;
import java.util.Scanner;
import models.RegionModel;
import tools.DbConnection;

/**
 *
 * @author Yosef Febrianes
 */
public class RegionTest {

    DbConnection connection = new DbConnection();
    IRegionDao irdao = new RegionDao(connection.GetConnection());
    Scanner scann = new Scanner(System.in);
    RegionModel r = new RegionModel();

    public static void main(String[] args) {
        DbConnection connection = new DbConnection();
        IRegionDao irdao = new RegionDao(connection.GetConnection());
        RegionTest r = new RegionTest();
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
                    r.show();
                    break;
                case 2:
                    r.insert();
                    break;
                case 3:
                    r.update();
                    break;
                case 4:
                    r.delete();
                    break;
                case 5:
                    r.searching();
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
        for (RegionModel h : irdao.getAll()) {
            System.out.println(h.getRegionId() + " | " + h.getRegionName());
        }
    }

    void insert() {
        System.out.println("Masukkan ID! = ");
        String id = scann.nextLine();

        System.out.println("Masukkan Nama! = ");
        String nama = scann.nextLine();

        r.setRegionId(id);
        r.setRegionName(nama);

        irdao.insert(r);
    }

    void update() {
        System.out.println("Masukkan ID! = ");
        String id = scann.nextLine();
        System.out.println("Masukkan Nama! = ");
        String nama = scann.nextLine();

        r.setRegionId(id);
        r.setRegionName(nama);

        System.out.println(irdao.update(r));
    }

    void delete() {
        System.out.println("Masukkan ID! = ");
        String id = scann.nextLine();
        System.out.println(irdao.delete(id));
    }

    void searching() {
        System.out.println("Masukkan ID! = ");
        String fortune = scann.nextLine();

        String regionId = fortune;
        irdao.search(regionId).forEach((regi) -> {
            System.out.println(regi.getRegionId() + " || " + regi.getRegionName());
        });

    }

}
