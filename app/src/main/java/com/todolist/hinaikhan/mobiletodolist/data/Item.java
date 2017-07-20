package com.todolist.hinaikhan.mobiletodolist.data;

import android.database.Cursor;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by hinaikhan on 7/17/17.
 * list of items declare in the main layout
 */

public class Item {

    private Integer id;
    private String title;
    private int year;
    private int month;
    private int day;
    private String note;
    private String priority;
    private String status;

    public Item(String title, int year, int month, int day, String note, String priority, String status) {
        this.title = title;
        this.year = year;
        this.month = month;
        this.day = day;
        this.note = note;
        this.priority = priority;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
