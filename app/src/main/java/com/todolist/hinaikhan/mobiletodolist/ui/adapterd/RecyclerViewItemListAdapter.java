package com.todolist.hinaikhan.mobiletodolist.ui.adapterd;

import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.todolist.hinaikhan.mobiletodolist.util.MainActivity;
import com.todolist.hinaikhan.mobiletodolist.R;
import com.todolist.hinaikhan.mobiletodolist.data.Item;
import com.todolist.hinaikhan.mobiletodolist.ui.dialog.AlertDialogFragment;
import com.todolist.hinaikhan.mobiletodolist.ui.listeners.ItemClickListener;

/**
 * Created by hinaikhan on 7/17/17.
 * Recycler view adapter class
 */

public class RecyclerViewItemListAdapter extends RecyclerView.Adapter<RecyclerViewItemListAdapter.ItemListAdapterViewHolder> {

    private final static String TAG = RecyclerViewItemListAdapter.class.getSimpleName();

    private Context mContext;
    private LayoutInflater mInflater;
    private Cursor mCursorItem;
    private ItemClickListener mItemClickListener;

    public RecyclerViewItemListAdapter(Context context, ItemClickListener itemClickListener, Cursor cursor) {
        mContext = context;
        mItemClickListener = itemClickListener;
        mCursorItem = cursor;
        mInflater = LayoutInflater.from(mContext);
    }

    public Cursor getmCursorItem() {
        return mCursorItem;
    }

    public void setmCursorItem(Cursor mCursorItem) {
        this.mCursorItem = mCursorItem;
    }

    @Override
    public ItemListAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_list_items, parent, false);
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        view.setLayoutParams(layoutParams);
        return new ItemListAdapterViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ItemListAdapterViewHolder viewHolder, final int position) {
        mCursorItem.moveToPosition(position);

        viewHolder.tvListTitle.setText(mCursorItem.getString(mCursorItem.getColumnIndex("title")));
        int year = mCursorItem.getInt(mCursorItem.getColumnIndex("year"));
        int month = mCursorItem.getInt(mCursorItem.getColumnIndex("month"));
        int day = mCursorItem.getInt(mCursorItem.getColumnIndex("day"));
        viewHolder.tvDate.setText(month + "/" + day + "/" + year);
        viewHolder.tvPriority.setText(mCursorItem.getString(mCursorItem.getColumnIndex("priority")));
        viewHolder.tvNote.setText(mCursorItem.getString(mCursorItem.getColumnIndex("note")));
        viewHolder.imgDeleteItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteItem(position);
            }
        });

        viewHolder.imgEditItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editItem(position);
            }
        });
    }


    @Override
    public int getItemCount() {
        return (mCursorItem != null ? mCursorItem.getCount() : 0);
    }

    public class ItemListAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,
            View.OnLongClickListener {

        protected TextView tvListTitle;
        protected TextView tvDate;
        protected TextView tvPriority;
        protected TextView tvNote;
        protected ImageView imgEditItem;
        protected ImageView imgDeleteItems;
        protected RelativeLayout mRelativeTitle;


        public ItemListAdapterViewHolder(View itemView) {
            super(itemView);
            tvListTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvDate = (TextView) itemView.findViewById(R.id.tv_date);
            tvPriority = (TextView) itemView.findViewById(R.id.tv_priority);
            tvNote = (TextView) itemView.findViewById(R.id.tv_note);
            imgEditItem = (ImageView) itemView.findViewById(R.id.img_edit_item);
            imgDeleteItems = (ImageView) itemView.findViewById(R.id.img_delete);
            mRelativeTitle = (RelativeLayout) itemView.findViewById(R.id.rl_item_title);

        }


        @Override
        public void onClick(View view) {
            tvListTitle.setOnClickListener(this);
            tvDate.setOnClickListener(this);
            tvPriority.setOnClickListener(this);
            tvNote.setOnClickListener(this);
            imgEditItem.setOnClickListener(this);
            imgDeleteItems.setOnClickListener(this);

            Cursor cursor = null;
            cursor.moveToFirst();

        }

        @Override
        public boolean onLongClick(View v) {

            return true;
        }

    }

    public void deleteItem(final int itemPosition) {
        new AlertDialog.Builder(mContext)
                .setTitle("Delete the entry?")
                .setMessage("Do you really want to delete this entry?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int position) {
                        mCursorItem.moveToPosition(itemPosition);
                        mItemClickListener.deleteItem(mCursorItem.getInt(mCursorItem.getColumnIndex("id")));
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();
    }

    public void editItem(final int itemPosition) {
        mCursorItem.moveToPosition(itemPosition);
        Item item = new Item(mCursorItem.getString(mCursorItem.getColumnIndex("title")),
                            mCursorItem.getInt(mCursorItem.getColumnIndex("year")),
                            mCursorItem.getInt(mCursorItem.getColumnIndex("month")),
                            mCursorItem.getInt(mCursorItem.getColumnIndex("day")),
                            mCursorItem.getString(mCursorItem.getColumnIndex("note")),
                            mCursorItem.getString(mCursorItem.getColumnIndex("priority")),
                            mCursorItem.getString(mCursorItem.getColumnIndex("status")));
        item.setId(mCursorItem.getInt(mCursorItem.getColumnIndex("id")));
        AlertDialogFragment dialogFragment = new AlertDialogFragment();
        dialogFragment.setItem(item);
        dialogFragment.setStyle(DialogFragment.STYLE_NO_TITLE, 0);
        dialogFragment.show(((MainActivity)mContext).getFragmentManager(), "Update");
    }
}






