package com.emarkova.session18.recycler;

public enum  ItemType {
    HTTP(1), PICASSO(2), GLIDE(3), FRESCO(4);

    private int type;

    ItemType(int i) {
        this.type = i;
    }

    public int getType() {
        return type;
    }

}
