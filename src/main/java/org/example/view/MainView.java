package org.example.view;

import java.sql.SQLException;
import java.util.Scanner;

public class MainView {

    private static MainView mainView;
    private CustomerView customerView;
    private BookView bookView;
    private EdeliveryView edeliveryView;
    private OrderView orderView;

    public MainView() {
        customerView = new CustomerView();
        bookView = new BookView();
        edeliveryView = new EdeliveryView();
        orderView = new OrderView();
    }

    public static MainView getInstance() {
        if (mainView == null) {
            mainView = new MainView();
        }
        return mainView;
    }

    public void run() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        boolean go = true;
        while (go) {
            System.out.println("\nВыберите опцию для операции: ");
            System.out.println("Введите число : ");
            System.out.println("1. Покупатель");
            System.out.println("2. Книга");
            System.out.println("3. Заказ");
            System.out.println("4. Доставка");
            System.out.println("5. Выход");

            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    runCustomer();
                    break;
                case 2:
                    runBook();
                    break;
                case 3:
                    runOrder();
                    break;
                case 4:
                    runEdelivery();
                    break;
                case 5:
                    go = false;
                    break;
                default:
                    System.out.println("Не верное число");
                    System.out.println("Введите числа от 1 до 4, пожалуйста");
            }
        }
    }

    private void runCustomer() throws SQLException{
        customerView.run();
    }
    private void runBook() throws SQLException{
        bookView.run();
    }
    private void runOrder() throws SQLException{
        orderView.run();
    }
    private void runEdelivery() throws SQLException{
        edeliveryView.run();
    }
}