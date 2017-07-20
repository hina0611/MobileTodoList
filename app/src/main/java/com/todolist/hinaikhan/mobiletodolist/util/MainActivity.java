package com.todolist.hinaikhan.mobiletodolist.util;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import com.todolist.hinaikhan.mobiletodolist.R;
import com.todolist.hinaikhan.mobiletodolist.data.Item;
import com.todolist.hinaikhan.mobiletodolist.storage.DBHelper;
import com.todolist.hinaikhan.mobiletodolist.ui.adapterd.RecyclerViewItemListAdapter;
import com.todolist.hinaikhan.mobiletodolist.ui.dialog.AlertDialogFragment;
import com.todolist.hinaikhan.mobiletodolist.ui.listeners.ItemClickListener;

import static android.support.v4.app.DialogFragment.STYLE_NO_TITLE;

public class MainActivity extends AppCompatActivity implements ItemClickListener {

    private RecyclerView mRecyclerViewItemList;
    private ImageButton btnAddItems;
    private RecyclerViewItemListAdapter mListItemAdapter;
    private DBHelper dbHelper;
    private final static String TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerViewItemList = (RecyclerView) findViewById(R.id.rvItemList);
        btnAddItems = (ImageButton) findViewById(R.id.add);
        dbHelper = new DBHelper(this);

    }

    @Override
    protected void onStart(){
        super.onStart();
        btnAddItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialogFragment dialogFragment = new AlertDialogFragment();
                dialogFragment.setStyle(STYLE_NO_TITLE, 0);
                dialogFragment.show(getFragmentManager(), "insert");
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Cursor cursor = dbHelper.getAllItemList();
        mListItemAdapter = new RecyclerViewItemListAdapter(this, this, cursor);
        mRecyclerViewItemList.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerViewItemList.setAdapter(mListItemAdapter);
        mListItemAdapter.notifyDataSetChanged();


    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    @Override
    public void addOrUpdateItem(Item item) {
        if (item != null && item.getId() != null) {
            dbHelper.updateItems(item.getId().toString(), item.getTitle(), item.getYear(), item.getMonth(),
                    item.getDay(), item.getNote(), item.getPriority(), item.getStatus());
        } else {
            dbHelper.insertItems(item.getTitle(), item.getYear(), item.getMonth(),
                    item.getDay(), item.getNote(), item.getPriority(), item.getStatus());
        }

        refreshView();
    }

    public void deleteItem(Integer itemId) {
        dbHelper.deleteItems(itemId.toString());
        refreshView();
    }

    public void refreshView() {
        Cursor cursor = dbHelper.getAllItemList();
        cursor.moveToFirst();
        mListItemAdapter.setmCursorItem(cursor);
        mListItemAdapter.notifyDataSetChanged();
    }
}
