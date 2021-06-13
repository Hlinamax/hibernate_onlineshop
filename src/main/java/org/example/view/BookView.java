package org.example.view;

import org.example.controller.BookController;
import org.example.entity.Book;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


public class BookView {
     private BookController bookController = new BookController();

    public void showBooks() throws SQLException {
        List<Book> books = bookController.getAllBooks();
        System.out.println("Список книг: ");
        books.forEach(book -> System.out.println(book.toString()));
    }

    public void createBook() throws SQLException {
        try {
            Book newBook = new Book();

            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите названия книги: ");
            String name = scanner.nextLine();
            newBook.setName(name);

            System.out.println("Введите год издания: ");
            String year = scanner.nextLine();
            newBook.setYear(year);

            System.out.println("Введите цену: ");
            String price = scanner.nextLine();
            newBook.setPrice(price);

            System.out.println("Введите категорию: ");
            String category = scanner.nextLine();
            newBook.setCategory(category);

            System.out.println("Введите количество: ");
            String count = scanner.nextLine();
            newBook.setCount(count);

            System.out.println("Введите описание: ");
            String descriprion = scanner.nextLine();
            newBook.setDescriprion(descriprion);


            bookController.saveBook(newBook);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBook() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id книги, которую хотите удалить: ");
        Long id = Long.parseLong(scanner.next());
        bookController.deleteBook(id);
    }

    public void updateBook() throws SQLException {
        try {
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Введите id книги, которую хотите обновить: ");
            Long id = Long.parseLong(scanner1.next());

            Book newBook;
            newBook = bookController.getBookById(id);

            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите названия книги: ");
            String name = scanner.nextLine();
            newBook.setName(name);

            System.out.println("Введите год издания: ");
            String year = scanner.nextLine();
            newBook.setYear(year);

            System.out.println("Введите цену: ");
            String price = scanner.nextLine();
            newBook.setPrice(price);

            System.out.println("Введите категорию: ");
            String category = scanner.nextLine();
            newBook.setCategory(category);

            System.out.println("Введите количество: ");
            String count = scanner.nextLine();
            newBook.setCount(count);

            System.out.println("Введите описание: ");
            String descriprion = scanner.nextLine();
            newBook.setDescriprion(descriprion);

            bookController.editBook(newBook);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getByIdBook() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите id книгу которго хотите найти:");
        Long id = Long.parseLong(scanner.next());
        try {
            if (bookController.getBookById(id) != null) {
                System.out.println(bookController.getBookById(id).toString());
            } else {
                System.out.println("Такой книги не существует в базе");
            }

        } catch (NullPointerException | SQLException e) {
            System.out.println("Это не число ");
            System.out.println("Попробуйте еще раз, пожалуйста");
            getByIdBook();
        }
    }


    public void run() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        boolean go = true;
        while (go) {
            System.out.println("\nВыберите опцию, пожалуйста : ");
            System.out.println("Введите число : ");
            System.out.println("1. Показать все книги");
            System.out.println("2. Добавить новую книгу");
            System.out.println("3. Удалить книгу ");
            System.out.println("4. Обновить информацию о книге ");
            System.out.println("5. Найти по id");
            System.out.println("6. Выйти");

            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    showBooks();
                    break;
                case 2:
                    createBook();
                    break;
                case 3:
                    deleteBook();
                    break;
                case 4:
                    updateBook();
                    break;
                case 5:
                    getByIdBook();
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
