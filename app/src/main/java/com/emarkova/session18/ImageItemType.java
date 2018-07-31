package com.emarkova.session18;

import com.emarkova.session18.recycler.ItemType;

public class ImageItemType {
    private ItemType itemType;
    public ImageItemType(int i)
    {
        switch (i){
            case 1:
                itemType = ItemType.HTTP;
                break;
            case 2:
                itemType = ItemType.PICASSO;
                break;
            case 3:
                itemType = ItemType.GLIDE;
                break;
            case 4:
                itemType = ItemType.FRESCO;
                break;
        }
    }

    public ItemType getItemType() {
        return itemType;
    }
}
