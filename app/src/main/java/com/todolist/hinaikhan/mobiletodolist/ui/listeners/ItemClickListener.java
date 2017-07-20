package com.todolist.hinaikhan.mobiletodolist.ui.listeners;

import com.todolist.hinaikhan.mobiletodolist.data.Item;

/**
 * Created by hinaikhan on 7/17/17.
 */

public interface ItemClickListener {

    public void addOrUpdateItem(Item item);
    public void deleteItem(Integer itemId);

}
