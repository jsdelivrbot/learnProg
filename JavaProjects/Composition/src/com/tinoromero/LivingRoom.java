package com.tinoromero;

public class LivingRoom {
    private int width;
    private int length;
    private Table table;
    private Couch couch;

    public LivingRoom(int width, int length, Table table, Couch couch) {
        this.width = width;
        this.length = length;
        this.table = table;
        this.couch = couch;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public Table getTable() {
        return table;
    }

    public Couch getCouch() {
        return couch;
    }

    public void confyGuests() {
        couch.sitGuests();
        serveBeverages();
    }

    private void serveBeverages() {
        table.serveTable();
    }
}
