package ru.job4j.solid.dip;

import java.util.Map;

public class Book {

    /*
    Данный класс нарушает принцип SRP, тк имеет реализацию методов хранилища страниц.
    Также он нарушает принцип DIP, тк не реализует интерфейс хранилища и не зависит от асбтракции.
     */
    private String name;
    private Integer id;

    /*
    В конструкторе идет прямая зависимость от мапы
     */
    public Book(String name, Integer id, Map<Integer, String> pages) {
        this.name = name;
        this.id = id;
        this.pages = pages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Map<Integer, String> pages;

    public void add(Page page) {
        pages.put(page.getId(), page.getText());
    }

    public void delete(Integer id) {
        pages.remove(id);
    }
}

