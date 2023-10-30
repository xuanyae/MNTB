package com.ydlab.mntb_client.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ydlab.mntb_client.R;
import com.ydlab.mntb_client.activity.DialogueActivity_06;
import com.ydlab.mntb_client.bean.VolunteerInfo;

import java.util.List;

public class DialogueActivity_05_Adapter extends BaseAdapter {
    private Context context;
    private Activity activity;
    public List<VolunteerInfo> volunteer_info_list;

    public DialogueActivity_05_Adapter(Context context, Activity activity, List<VolunteerInfo> volunteer_info_list) {
        this.context = context;
        this.activity = activity;
        this.volunteer_info_list = volunteer_info_list;
    }

    @Override
    public int getCount() {
        return volunteer_info_list.size();
    }

    @Override
    public Object getItem(int position) {
        return volunteer_info_list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        ViewHolder viewHolder = null;
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_view_item_dialogue_05, null);
            viewHolder = new ViewHolder();
            viewHolder.textView_college_major_group = view.findViewById(R.id.textView_college_major_group);
            viewHolder.textView_college_group = view.findViewById(R.id.textView_college_group);
            viewHolder.textView_major_group = view.findViewById(R.id.textView_major_group);
            viewHolder.textView_adjust = view.findViewById(R.id.textView_adjust);
            viewHolder.textView_add_or_delete = view.findViewById(R.id.textView_add_or_delete);
            viewHolder.textView_major_name_1 = view.findViewById(R.id.textView_major_name_1);
            viewHolder.textView_major_notes_1 = view.findViewById(R.id.textView_major_notes_1);
            viewHolder.textView_major_name_2 = view.findViewById(R.id.textView_major_name_2);
            viewHolder.textView_major_notes_2 = view.findViewById(R.id.textView_major_notes_2);
            viewHolder.textView_major_name_3 = view.findViewById(R.id.textView_major_name_3);
            viewHolder.textView_major_notes_3 = view.findViewById(R.id.textView_major_notes_3);
            viewHolder.textView_major_name_4 = view.findViewById(R.id.textView_major_name_4);
            viewHolder.textView_major_notes_4 = view.findViewById(R.id.textView_major_notes_4);
            viewHolder.textView_major_name_5 = view.findViewById(R.id.textView_major_name_5);
            viewHolder.textView_major_notes_5 = view.findViewById(R.id.textView_major_notes_5);
            viewHolder.textView_major_name_6 = view.findViewById(R.id.textView_major_name_6);
            viewHolder.textView_major_notes_6 = view.findViewById(R.id.textView_major_notes_6);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        VolunteerInfo volunteer_info = volunteer_info_list.get(position);
        viewHolder.textView_college_major_group.setText(volunteer_info.getTextView_college_major_group());
        viewHolder.textView_college_group.setText(volunteer_info.getCollege_name());
        viewHolder.textView_major_group.setText(volunteer_info.getMajor_group_name());
        viewHolder.textView_adjust.setText(volunteer_info.getIs_adjust());
        if (volunteer_info.getTextView_add_or_delete().equals("0")) {
            viewHolder.textView_add_or_delete.setText("添加");
        } else {
            viewHolder.textView_add_or_delete.setText("删除");
        }
        viewHolder.textView_major_name_1.setText(volunteer_info.getMajor_name_1());
        viewHolder.textView_major_notes_1.setText(volunteer_info.getMajor_notes_1());
        viewHolder.textView_major_name_2.setText(volunteer_info.getMajor_name_2());
        viewHolder.textView_major_notes_2.setText(volunteer_info.getMajor_notes_2());
        viewHolder.textView_major_name_3.setText(volunteer_info.getMajor_name_3());
        viewHolder.textView_major_notes_3.setText(volunteer_info.getMajor_notes_3());
        viewHolder.textView_major_name_4.setText(volunteer_info.getMajor_name_4());
        viewHolder.textView_major_notes_4.setText(volunteer_info.getMajor_notes_4());
        viewHolder.textView_major_name_5.setText(volunteer_info.getMajor_name_5());
        viewHolder.textView_major_notes_5.setText(volunteer_info.getMajor_notes_5());
        viewHolder.textView_major_name_6.setText(volunteer_info.getMajor_name_6());
        viewHolder.textView_major_notes_6.setText(volunteer_info.getMajor_notes_6());

        viewHolder.textView_add_or_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (volunteer_info_list.get(position).getTextView_add_or_delete().equals("0")){
                    Intent intent = new Intent(activity, DialogueActivity_06.class);
                    intent.putExtra("position", position);
                    intent.putExtra("tittle", volunteer_info_list.get(position).getTextView_college_major_group());
                    activity.startActivityForResult(intent, 1);
                }else {
                    volunteer_info_list.get(position).setUser_id("");
                    volunteer_info_list.get(position).setVolunteer_order("");
                    volunteer_info_list.get(position).setType("");
                    volunteer_info_list.get(position).setCollege_id("");
                    volunteer_info_list.get(position).setCollege_name("");
                    volunteer_info_list.get(position).setMajor_group_id("");
                    volunteer_info_list.get(position).setMajor_group_name("");
                    volunteer_info_list.get(position).setIs_adjust("");
                    volunteer_info_list.get(position).setMajor_name_1("");
                    volunteer_info_list.get(position).setMajor_notes_1("");
                    volunteer_info_list.get(position).setMajor_name_2("");
                    volunteer_info_list.get(position).setMajor_notes_2("");
                    volunteer_info_list.get(position).setMajor_name_3("");
                    volunteer_info_list.get(position).setMajor_notes_3("");
                    volunteer_info_list.get(position).setMajor_name_4("");
                    volunteer_info_list.get(position).setMajor_notes_4("");
                    volunteer_info_list.get(position).setMajor_name_5("");
                    volunteer_info_list.get(position).setMajor_notes_5("");
                    volunteer_info_list.get(position).setMajor_name_6("");
                    volunteer_info_list.get(position).setMajor_notes_6("");
                    volunteer_info_list.get(position).setTextView_add_or_delete("0");
                    notifyDataSetChanged();
                }
            }
        });

        return view;
    }

    class ViewHolder {
        TextView textView_college_major_group;
        TextView textView_college_group;
        TextView textView_major_group;
        TextView textView_adjust;
        TextView textView_add_or_delete;
        TextView textView_major_name_1;
        TextView textView_major_notes_1;
        TextView textView_major_name_2;
        TextView textView_major_notes_2;
        TextView textView_major_name_3;
        TextView textView_major_notes_3;
        TextView textView_major_name_4;
        TextView textView_major_notes_4;
        TextView textView_major_name_5;
        TextView textView_major_notes_5;
        TextView textView_major_name_6;
        TextView textView_major_notes_6;
    }
}
