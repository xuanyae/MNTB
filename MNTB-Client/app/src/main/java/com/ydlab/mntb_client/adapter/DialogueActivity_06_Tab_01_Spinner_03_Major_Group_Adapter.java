package com.ydlab.mntb_client.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.ydlab.mntb_client.bean.MajorGroupInfo;

import java.util.List;

public class DialogueActivity_06_Tab_01_Spinner_03_Major_Group_Adapter extends ArrayAdapter<MajorGroupInfo> {
    private List<MajorGroupInfo> major_group_info_list;
    private LayoutInflater layoutInflater;

    public DialogueActivity_06_Tab_01_Spinner_03_Major_Group_Adapter(@NonNull Context context, List<MajorGroupInfo> major_group_info_list) {
        super(context, android.R.layout.simple_spinner_item, major_group_info_list);
        this.major_group_info_list = major_group_info_list;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(android.R.layout.simple_spinner_item, parent, false);
        }
        TextView textView = convertView.findViewById(android.R.id.text1);
        textView.setText(major_group_info_list.get(position).getMajor_group_name());
        return convertView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(android.R.layout.simple_spinner_dropdown_item, parent, false);
        }
        TextView textView = convertView.findViewById(android.R.id.text1);
        textView.setText(major_group_info_list.get(position).getMajor_group_name());
        return convertView;
    }
}
