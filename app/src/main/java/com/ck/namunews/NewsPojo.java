package com.ck.namunews;

public class NewsPojo {
    private NewsDTO[] itemList;

    public NewsDTO[] getItemList ()
    {
        return itemList;
    }

    public void setItemList (NewsDTO[] itemList)
    {
        this.itemList = itemList;
    }
}