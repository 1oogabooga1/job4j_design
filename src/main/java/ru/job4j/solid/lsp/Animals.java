package ru.job4j.solid.lsp;

public class Animals {
    String name;

    int hunger;
    public Animals(String name, int hunger) {
        this.name = name;
        this.hunger = hunger;
    }

    public String feed(int food) {
        if (hunger < 5) {
            throw new IllegalArgumentException("you are not hungry");
        }
        if (food < 0) {
            throw new IllegalArgumentException("that is not enough");
        }
        return "you are not hungry anymore";
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
       /*
       ставим определеноое условие, согласно которому нельзя иметь голод меньше нуля
        */
        if (hunger < 0) {
            throw new IllegalArgumentException();
        }
        this.hunger = hunger;
    }

    public class Cow extends Animals {
        public Cow(String name, int hunger) {
            super(name, hunger);
        }

        @Override
        public String feed(int food) {
            /*
            здесь в прервом условии мы нарушаем прицнип LSP, тк усиляем предусловие.
             */
            if (hunger < 10) {
                throw new IllegalArgumentException("you are not hungry");
            }
            /*
            убираем условие, согласно которому существует недостаточное количество еды для животного
            тем самым ослабляем постусловие и нарушаем принцип LSP
             */
            return "You are not hungry anymore";
        }
        @Override
        public void setHunger(int hunger) {
            /*
            забываем сделать проверку на голод < 0, тем самым нарушаем принцип LSP
             */
            this.hunger = hunger;
        }

    }

}
