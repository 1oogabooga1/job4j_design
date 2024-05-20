package ru.job4j.solid.dip;

import java.util.HashMap;

public class Library {

    /*
    Данный класс нарушает принцип DIP,
    тк не реализует интерфейс хранилища и не зависит от абстракции
     */
    private HashMap<Integer, String> lib;

     /*
    В конструкторе идет прямая зависимость от мапы
     */
    public Library(HashMap<Integer, String> lib) {
        this.lib = lib;
    }

    public void add(Book book) {
       lib.put(book.getId(), book.getName());
    }

    public void delete(Integer id) {
        lib.remove(id);
    }

    public Book findBook(Integer id) {
        String name = lib.get(id);
        if (name == null) {
            return null;
        }
        return new Book(name, id, new HashMap<>());
    }

    /*
    Логгирование напрямую зависит от консольного вывода, это нарушает прицнип DIP
     */
    public boolean takeBook(Integer id) {
        Book book =  findBook(id);
        boolean rsl = false;
        if (book == null) {
            System.out.println("Book not found");
            throw new IllegalArgumentException("Check id");
        } else {
            rsl = true;
        }
        return rsl;
    }
}
