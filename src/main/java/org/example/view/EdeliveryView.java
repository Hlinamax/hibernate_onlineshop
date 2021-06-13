package org.example.view;

import org.example.controller.EdeliveryController;
import org.example.entity.Book;
import org.example.entity.Edelivery;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class EdeliveryView {
    private EdeliveryController edeliveryController = new EdeliveryController();

    public void showEdeliverys() throws SQLException {
        List<Edelivery> edeliverys = edeliveryController.getAllEdeliverys();
        System.out.println("Список покупателей: ");
        edeliverys.forEach(edelivery -> System.out.println(edelivery.toString()));
    }

    public void createEdelivery() throws SQLException {
        try {
            Edelivery newEdelivery = new Edelivery();

            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите количество книг: ");
            String countOfBooks = scanner.nextLine();
            newEdelivery.setCountOfBooks(countOfBooks);

            System.out.println("Введите Дату доставки: ");
            String date = scanner.nextLine();
            newEdelivery.setDate(date);



            edeliveryController.saveEdelivery(newEdelivery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEdelivery() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id доставки, который хотите удалить: ");
        Long id = Long.parseLong(scanner.next());
        edeliveryController.deleteEdelivery(id);
    }

    public void updateEdelivery() throws SQLException {
        try {
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Введите id доставки, которого хотите обновить: ");
            Long id = Long.parseLong(scanner1.next());

            Edelivery newEdelivery;
            newEdelivery = edeliveryController.getEdeliveryById(id);

            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите количество книг: ");
            String countOfBooks = scanner.nextLine();
            newEdelivery.setCountOfBooks(countOfBooks);

            System.out.println("Введите Дату доставки: ");
            String date = scanner.nextLine();
            newEdelivery.setDate(date);

            edeliveryController.editEdelivery(newEdelivery);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getByIdEdelivery() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите id доставки который хотите найти:");
        Long id = Long.parseLong(scanner.next());
        try {
            if (edeliveryController.getEdeliveryById(id) != null) {
                System.out.println(edeliveryController.getEdeliveryById(id).toString());
            } else {
                System.out.println("Такой доставки не существует в базе");
            }

        } catch (NullPointerException | SQLException e) {
            System.out.println("Это не число ");
            System.out.println("Попробуйте еще раз, пожалуйста");
            getByIdEdelivery();
        }
    }


    public void run() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        boolean go = true;
        while (go) {
            System.out.println("\nВыберите опцию, пожалуйста : ");
            System.out.println("Введите число : ");
            System.out.println("1. Показать все доставки");
            System.out.println("2. Добавить новую доставку");
            System.out.println("3. Удалить доставку ");
            System.out.println("4. Обновить информацию о доставке ");
            System.out.println("5. Найти по id");
            System.out.println("6. Выйти");

            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    showEdeliverys();
                    break;
                case 2:
                    createEdelivery();
                    break;
                case 3:
                    deleteEdelivery();
                    break;
                case 4:
                    updateEdelivery();
                    break;
                case 5:
                    getByIdEdelivery();
                    break;
                case 6:
                    go = false;
                    break;
                default:
                    System.out.println("Неверное число!");
                    System.out.println("Введите число от 1 до 6, пожалуйста");
            }
        }
    }
}