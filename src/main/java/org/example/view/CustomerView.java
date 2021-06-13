package org.example.view;

import org.example.controller.CustomerController;
import org.example.entity.Customer;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class CustomerView {
    private CustomerController customerController = new CustomerController();

    public void showCustomers() throws SQLException {
        List<Customer> customers = customerController.getAllCustomers();
        System.out.println("Список покупателей: ");
        customers.forEach(customer -> System.out.println(customer.toString()));
    }

    public void createCustomer() throws SQLException {
        try {
        Customer newCustomer = new Customer();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        newCustomer.setName(name);

        System.out.println("Введите адрес эл.почты: ");
        String email = scanner.nextLine();
        newCustomer.setEmail(email);

        System.out.println("Введите телефон: ");
        String phone = scanner.nextLine();
        newCustomer.setPhone(phone);

        System.out.println("Введите пароль: ");
        String password = scanner.nextLine();
        newCustomer.setPassword(password);


        customerController.saveCustomer(newCustomer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCustomer() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id покупателя, которого хотите удалить: ");
        Long id = Long.parseLong(scanner.next());
        customerController.deleteCustomer(id);
    }

    public void updateCustomer() throws SQLException {
        try {
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Введите id покупателя, которого хотите обновить: ");
            Long id = Long.parseLong(scanner1.next());

            Customer newCustomer;
            newCustomer = customerController.getCustomerById(id);

            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите имя: ");
            String name = scanner.nextLine();
            newCustomer.setName(name);

            System.out.println("Введите адрес эл.почты: ");
            String email = scanner.nextLine();
            newCustomer.setEmail(email);

            System.out.println("Введите телефон: ");
            String phone = scanner.nextLine();
            newCustomer.setPhone(phone);

            System.out.println("Введите пароль: ");
            String password = scanner.nextLine();
            newCustomer.setPassword(password);

            customerController.editCustomer(newCustomer);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getByIdCustomer() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите id покупателя которго хотите найти:");
        Long id = Long.parseLong(scanner.next());
        try {
            if (customerController.getCustomerById(id) != null) {
                System.out.println(customerController.getCustomerById(id).toString());
            } else {
                System.out.println("Такого покупателя не существует в базе");
            }

        } catch (NullPointerException | SQLException e) {
            System.out.println("Это не число ");
            System.out.println("Попробуйте еще раз, пожалуйста");
            getByIdCustomer();
        }
    }


    public void run() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        boolean go = true;
        while (go) {
            System.out.println("\nВыберите опцию, пожалуйста : ");
            System.out.println("Введите число : ");
            System.out.println("1. Показать всех покупателей");
            System.out.println("2. Добавить нового покупателя");
            System.out.println("3. Удалить покупателя ");
            System.out.println("4. Обновить информацию о покупателе ");
            System.out.println("5. Найти по id");
            System.out.println("6. Выйти");

            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    showCustomers();
                    break;
                case 2:
                    createCustomer();
                    break;
                case 3:
                    deleteCustomer();
                    break;
                case 4:
                    updateCustomer();
                    break;
                case 5:
                    getByIdCustomer();
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
