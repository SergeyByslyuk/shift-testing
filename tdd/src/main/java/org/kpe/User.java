package org.kpe;

public class User {

    private long id;

    private int money;

    public User(long id, int money) {
        this.id = id;
        this.money = money;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
