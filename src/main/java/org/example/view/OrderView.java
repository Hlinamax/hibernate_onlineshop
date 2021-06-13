package org.example.view;

import org.example.controller.OrderController;
import org.example.entity.Order;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


public class OrderView {
    private OrderController orderController = new OrderController();

    public void showOrders() throws SQLException {
        List<Order> orders = orderController.getAllOrders();
        System.out.println("Список покупателей: ");
        orders.forEach(order -> System.out.println(order.toString()));
    }

    public void createOrder() throws SQLException {
        try {
            Order newOrder = new Order();

            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите название Заказа: ");
            String name = scanner.nextLine();
            newOrder.setName(name);

            System.out.println("Введите цену Заказа: ");
            String price = scanner.nextLine();
            newOrder.setPrice(price);

            orderController.saveOrder(newOrder);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteOrder() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id заказа, которого хотите удалить: ");
        Long id = Long.parseLong(scanner.next());
        orderController.deleteOrder(id);
    }

    public void updateOrder() throws SQLException {
        try {
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Введите id покупателя, которого хотите обновить: ");
            Long id = Long.parseLong(scanner1.next());

            Order newOrder;
            newOrder = orderController.getOrderById(id);

            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите название Заказа: ");
            String name = scanner.nextLine();
            newOrder.setName(name);

            System.out.println("Введите цену Заказа: ");
            String price = scanner.nextLine();
            newOrder.setPrice(price);

            orderController.editOrder(newOrder);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getByIdOrder() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите id заказа который хотите найти:");
        Long id = Long.parseLong(scanner.next());
        try {
            if (orderController.getOrderById(id) != null) {
                System.out.println(orderController.getOrderById(id).toString());
            } else {
                System.out.println("Такого заказа не существует в базе");
            }

        } catch (NullPointerException | SQLException e) {
            System.out.println("Это не число ");
            System.out.println("Попробуйте еще раз, пожалуйста");
            getByIdOrder();
        }
    }


    public void run() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        boolean go = true;
        while (go) {
            System.out.println("\nВыберите опцию, пожалуйста : ");
            System.out.println("Введите число : ");
            System.out.println("1. Показать все заказы");
            System.out.println("2. Добавить новый заказ");
            System.out.println("3. Удалить заказ ");
            System.out.println("4. Обновить информацию о заказе ");
            System.out.println("5. Найти по id");
            System.out.println("6. Выйти");

            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    showOrders();
                    break;
                case 2:
                    createOrder();
                    break;
                case 3:
                    deleteOrder();
                    break;
                case 4:
                    updateOrder();
                    break;
                case 5:
                    getByIdOrder();
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