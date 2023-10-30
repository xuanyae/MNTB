package com.ydlab.mntb_client.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ydlab.mntb_client.R;
import com.ydlab.mntb_client.bean.MajorInfo;
import com.ydlab.mntb_client.ipojo.iUserCollectionInfo;

import java.util.List;

public class DialogueActivity_06_Tab_02_ListView_Adapter extends BaseAdapter {
    private Context context;
    private List<iUserCollectionInfo> favorite_major_info_list;

    public DialogueActivity_06_Tab_02_ListView_Adapter(Context context, List<iUserCollectionInfo> favorite_major_info_list) {
        this.context = context;
        this.favorite_major_info_list = favorite_major_info_list;
    }

    @Override
    public int getCount() {
        return favorite_major_info_list.size();
    }

    @Override
    public Object getItem(int position) {
        return favorite_major_info_list.get(position);
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
            view = LayoutInflater.from(context).inflate(R.layout.list_view_item_dialogue_06_tab_02, null);
            viewHolder = new ViewHolder();
            viewHolder.textView_college_name = view.findViewById(R.id.textView_college_name);
            viewHolder.textView_major_group_id = view.findViewById(R.id.textView_major_group_id);
            viewHolder.textView_major_name = view.findViewById(R.id.textView_major_name);
            viewHolder.textView_major_notes = view.findViewById(R.id.textView_major_notes);
            viewHolder.textView_major_score_1 = view.findViewById(R.id.textView_major_score_1);
            viewHolder.textView_major_score_2 = view.findViewById(R.id.textView_major_score_2);
            viewHolder.textView_major_score_3 = view.findViewById(R.id.textView_major_score_3);
            viewHolder.textView_major_score_4 = view.findViewById(R.id.textView_major_score_4);
            viewHolder.textView_major_score_5 = view.findViewById(R.id.textView_major_score_5);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        iUserCollectionInfo i_iUserCollectionInfo = favorite_major_info_list.get(position);
        viewHolder.textView_college_name.setText(i_iUserCollectionInfo.getCollectionCollegeName());
        viewHolder.textView_major_group_id.setText(i_iUserCollectionInfo.getCollectionMajorGroupId());
        viewHolder.textView_major_name.setText(i_iUserCollectionInfo.getCollectionMajorName());
        viewHolder.textView_major_notes.setText(i_iUserCollectionInfo.getCollectionMajorNotes());
        viewHolder.textView_major_score_1.setText(i_iUserCollectionInfo.getMajorScore1());
        viewHolder.textView_major_score_2.setText(i_iUserCollectionInfo.getMajorScore2());
        viewHolder.textView_major_score_3.setText(i_iUserCollectionInfo.getMajorScore3());
        viewHolder.textView_major_score_4.setText(i_iUserCollectionInfo.getMajorScore4());
        viewHolder.textView_major_score_5.setText(i_iUserCollectionInfo.getMajorScore5());
        return view;
    }

    class ViewHolder {
        TextView textView_college_name;
        TextView textView_major_group_id;
        TextView textView_major_name;
        TextView textView_major_notes;
        TextView textView_major_score_1;
        TextView textView_major_score_2;
        TextView textView_major_score_3;
        TextView textView_major_score_4;
        TextView textView_major_score_5;
    }
}
