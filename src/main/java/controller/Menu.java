package controller;

import dao.UserDao;
import model.User;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) throws SQLException {
        Menu menu = new Menu();
        menu.wyswietlMenu();





    }


    public void wyswietlMenu() throws SQLException {
        Scanner scr = new Scanner(System.in);
        UserDao userDao = new UserDao();
        System.out.println("Podaj wybor");
        System.out.println("1 = SAVE, czyli dodaj");
        System.out.println("2 = UPDATE");
        System.out.println("3 = DELETE");
        String wybor;

        do {
            wybor = scr.nextLine();
            switch (wybor) {
                case "1":
                    userDao.save(
                            new User("Wojciech", "Musial", "wojciech@email.com")
                    );
                    break;

                case "2":
                    int id_update = 0;
                    System.out.println("Wybierz id ktore ma zostac UPDATE");
                    id_update = scr.nextInt();

                    userDao.update(
                            new User(id_update, "Wojciech_update", "Musial_u", "wojciech@email.com_u")
                    );
                    break;

                case "3":
                    System.out.println("Wybierz id ktore ma zostac DELETE");
                    int id_delete = scr.nextInt();
                    userDao.delete(id_delete);
                    break;


            }
        }while (!wybor.equalsIgnoreCase("q"));


    }

}
