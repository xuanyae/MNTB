package com.ydlab.mntb_client.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ydlab.mntb_client.R;
import com.ydlab.mntb_client.bean.MajorInfo;
import com.ydlab.mntb_client.utils.ArrayListUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DialogueActivity_06_Tab_01_ListView_Adapter extends BaseAdapter {
    private Context context;
    private List<MajorInfo> major_info_list;
    public List<String> click_order_list = new ArrayList<>(); // 保存点击顺序的列表
    public String[] click_order_str_s = new String[50];

    public DialogueActivity_06_Tab_01_ListView_Adapter(Context context, List<MajorInfo> major_info_list) {
        this.context = context;
        this.major_info_list = major_info_list;
    }

    @Override
    public int getCount() {
        return major_info_list.size();
    }

    @Override
    public Object getItem(int position) {
        return major_info_list.get(position);
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
            view = LayoutInflater.from(context).inflate(R.layout.list_view_item_dialogue_06_tab_01, null);
            viewHolder = new ViewHolder();
            viewHolder.textView_major_name = view.findViewById(R.id.textView_major_name);
            viewHolder.textView_major_notes = view.findViewById(R.id.textView_major_notes);
            viewHolder.textView_major_score_1 = view.findViewById(R.id.textView_major_score_1);
            viewHolder.textView_major_score_2 = view.findViewById(R.id.textView_major_score_2);
            viewHolder.textView_major_score_3 = view.findViewById(R.id.textView_major_score_3);
            viewHolder.textView_major_score_4 = view.findViewById(R.id.textView_major_score_4);
            viewHolder.textView_major_score_5 = view.findViewById(R.id.textView_major_score_5);
            viewHolder.imageView_select_tab_01 = view.findViewById(R.id.imageView_select_tab_01);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        MajorInfo major_info = major_info_list.get(position);
        viewHolder.textView_major_name.setText(major_info.getMajor_name());
        viewHolder.textView_major_notes.setText(major_info.getMajor_notes());
        viewHolder.textView_major_score_1.setText(major_info.getMajor_score_1());
        viewHolder.textView_major_score_2.setText(major_info.getMajor_score_2());
        viewHolder.textView_major_score_3.setText(major_info.getMajor_score_3());
        viewHolder.textView_major_score_4.setText(major_info.getMajor_score_4());
        viewHolder.textView_major_score_5.setText(major_info.getMajor_score_5());
        if (click_order_str_s != null) {
            viewHolder.imageView_select_tab_01.setText(click_order_str_s[position]);
        }

        viewHolder.imageView_select_tab_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click_order_list.add(position + "");
                click_order_list = ArrayListUtils.removeDuplicateElements(click_order_list);
                click_order_list = click_order_list.subList(0, click_order_list.size() < 6 ? click_order_list.size() : 6);//限制报6个专业
//                click_order_str_s = new String[major_info_list.size()];
//                click_order_str_s = new String[50];
                Arrays.fill(click_order_str_s, "");//清空数组
                for (int i = 0; i < click_order_list.size(); i++) {
                    click_order_str_s[Integer.parseInt(click_order_list.get(i))] = (i + 1) + "";
                }
                notifyDataSetChanged();
            }
        });
        return view;
    }

    class ViewHolder {
        TextView textView_major_name;
        TextView textView_major_notes;
        TextView textView_major_score_1;
        TextView textView_major_score_2;
        TextView textView_major_score_3;
        TextView textView_major_score_4;
        TextView textView_major_score_5;
        TextView imageView_select_tab_01;
    }
}
