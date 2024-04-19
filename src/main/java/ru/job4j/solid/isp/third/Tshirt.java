package ru.job4j.solid.isp.third;

public class Tshirt implements Clothes {
    /**
     * Данный класс зависит от етодов getHood and getSleeves,
     * но тк у футболки в норме нет рукавов и капюшона, эти методы бесполезны
     * Данная ошибка ведет к нарушению прицнипа ISP
     */
    @Override
    public void pickColor() {
        System.out.println("I pick white color");
    }

    @Override
    public void getHood() {
        System.out.println("Impossible");
    }

    @Override
    public void getMaterial() {
        System.out.println("Cotton");
    }

    @Override
    public void getSleeves() {
        System.out.println("Impossible");
    }
}
