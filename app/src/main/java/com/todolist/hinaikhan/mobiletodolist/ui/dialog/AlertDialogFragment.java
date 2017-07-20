package com.todolist.hinaikhan.mobiletodolist.ui.dialog;

import android.app.DialogFragment;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;
import com.todolist.hinaikhan.mobiletodolist.R;
import com.todolist.hinaikhan.mobiletodolist.data.Item;
import com.todolist.hinaikhan.mobiletodolist.storage.DBHelper;
import com.todolist.hinaikhan.mobiletodolist.ui.listeners.ItemClickListener;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hinaikhan on 7/17/17.
 * Alert dialog to add the data
 */

public class AlertDialogFragment extends DialogFragment {

    public static final String TAG = AlertDialogFragment.class.getSimpleName();

    private TextView taskName;
    private NumberPicker year;
    private NumberPicker month;
    private NumberPicker day;
    private TextView note;
    private Spinner priority;
    private Spinner status;
    private Button btnSubmit;
    private Button btnCancel;
    private DBHelper dbHelper;

    private Item item;

    private Map<String, Integer> priorityMapDetails;
    private Map<String, Integer> statusMapDetails;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_add_items, container);
        bindView(view);
        initMapStatus();
        postNumberPickerValue();
        initializeView();
        initListener();
        return view;
    }

    private void bindView(View view) {
        taskName = (TextView) view.findViewById(R.id.taskName);
        note = (TextView) view.findViewById(R.id.note);
        priority = (Spinner) view.findViewById(R.id.priority);
        status = (Spinner) view.findViewById(R.id.status);
        btnSubmit = (Button) view.findViewById(R.id.submit);
        btnCancel = (Button) view.findViewById(R.id.cancel);
        year = (NumberPicker) view.findViewById(R.id.numpic_year);
        month = (NumberPicker) view.findViewById(R.id.numpic_month);
        day = (NumberPicker) view.findViewById(R.id.numpic_date);
    }

    private void initMapStatus(){
        priorityMapDetails = new HashMap<String, Integer>();
        statusMapDetails = new HashMap<String, Integer>();

        priorityMapDetails.put("High", 0);
        priorityMapDetails.put("Regular", 1);
        priorityMapDetails.put("Low", 2);

        statusMapDetails.put("To Do", 0);
        statusMapDetails.put("Done", 1);

    }


    private void postNumberPickerValue(){
        year.setMaxValue(2025);
        year.setMinValue(2016);
        month.setMaxValue(12);
        month.setMinValue(1);
        day.setMaxValue(31);
        day.setMinValue(1);
    }

    @Override
    public void onResume(){
        super.onResume();
        Window openWindo = getDialog().getWindow();
        Point displaySize = new Point();
        Display display = openWindo.getWindowManager().getDefaultDisplay();
        display.getSize(displaySize);
        openWindo.setLayout((int)(displaySize.x * 0.9), WindowManager.LayoutParams.WRAP_CONTENT);
        openWindo.setGravity(Gravity.CENTER);
        dbHelper = new DBHelper(getActivity());

    }

    private void initListener(){
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ItemClickListener itemClickListener = (ItemClickListener) getActivity();
                Item anItem = new Item(taskName.getText().toString(), year.getValue(),
                        month.getValue(), day.getValue(), note.getText().toString(),
                        priority.getSelectedItem().toString(), status.getSelectedItem().toString());
                if(item != null){
                    anItem.setId(item.getId());
                }
                itemClickListener.addOrUpdateItem(anItem);
                dismiss();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }

    private void initializeView(){
        if (item != null) {
            taskName.setText(item.getTitle());
            year.setValue(item.getYear());
            day.setValue(item.getDay());
            month.setValue(item.getMonth());
            note.setText(item.getNote());
            priority.setSelection(priorityMapDetails.get(item.getPriority()));
            status.setSelection(statusMapDetails.get(item.getStatus()));
        } else {
            priority.setSelection(0);
            status.setSelection(0);
        }
    }

}
