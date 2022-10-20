package com.example.todoapp;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.UUID;

public class TaskFragment extends Fragment {
    private static final String ARG_TASK_ID = "taskArg";
    private Task task;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID taskId=(UUID)getArguments().getSerializable(ARG_TASK_ID);
        task=TaskStorage.getInstance().getTask(taskId);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (container != null) {
            EditText nameField = container.findViewById(R.id.task_name);
            if (nameField != null) {

                nameField.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                        //not implemented yet
                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        task.setName(s.toString());
                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        //not implemented yet
                    }
                });
            }
            Button dateButton = container.findViewById(R.id.task_date);
            if (dateButton != null) {
                dateButton.setText(task.getDate().toString());
                dateButton.setEnabled(false);
            }
            CheckBox doneCheckbox = container.findViewById(R.id.task_done);
            if (doneCheckbox != null) {
                doneCheckbox.setChecked(task.isDone());
                doneCheckbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
                    task.setDone(isChecked);
                });
            }
        }
        return inflater.inflate(R.layout.fragment_task, container, false);
    }
}
