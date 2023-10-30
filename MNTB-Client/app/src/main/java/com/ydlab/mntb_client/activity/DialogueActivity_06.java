package com.ydlab.mntb_client.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.PagerTabStrip;
import androidx.viewpager.widget.ViewPager;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ydlab.mntb_client.R;
import com.ydlab.mntb_client.adapter.DialogueActivity_06_Tab_01_ListView_Adapter;
import com.ydlab.mntb_client.adapter.DialogueActivity_06_Tab_01_Spinner_01_Province_Adapter;
import com.ydlab.mntb_client.adapter.DialogueActivity_06_Tab_01_Spinner_02_College_Adapter;
import com.ydlab.mntb_client.adapter.DialogueActivity_06_Tab_01_Spinner_03_Major_Group_Adapter;
import com.ydlab.mntb_client.adapter.DialogueActivity_06_Tab_02_ListView_Adapter;
import com.ydlab.mntb_client.bean.CollegeInfo;
import com.ydlab.mntb_client.bean.MajorGroupInfo;
import com.ydlab.mntb_client.bean.MajorInfo;
import com.ydlab.mntb_client.bean.ProvinceInfo;
import com.ydlab.mntb_client.bean.VolunteerInfo;
import com.ydlab.mntb_client.ipojo.iUserCollectionInfo;
import com.ydlab.mntb_client.utils.HTTPUtils;
import com.ydlab.mntb_client.utils.SharedPreferencesUtils;

import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    志愿选择
 */
public class DialogueActivity_06 extends AppCompatActivity {
    private ViewPager viewPager;
    private PagerTabStrip pagerTabStrip;
    private ArrayList<View> view_container_list = new ArrayList<View>();
    private ArrayList<String> title_container_list = new ArrayList<String>();
    private int[] layouts = new int[]{R.layout.tab_01_dialogue_06, R.layout.tab_02_dialogue_06};
    private String[] titles = new String[]{"志愿选择", "我的收藏"};
    private View[] view = new View[2];
    private TextView textView_tittle;
    private ListView listView_major, listView_favorite;
    private ImageView imageView_back;

    private Spinner spinner_province_name, spinner_college_name, spinner_major_group_id;
    private List<ProvinceInfo> province_info_list = new ArrayList<>();
    private List<CollegeInfo> college_info_list = new ArrayList<>();
    private List<MajorGroupInfo> major_group_info_list = new ArrayList<>();
    private List<MajorInfo> major_info_list = new ArrayList<>();
    private List<iUserCollectionInfo> favorite_major_info_list = new ArrayList<>();

    private CheckBox checkbox_is_adjust;
    private Button button_confirm;
    private boolean checked;

    private String user_id = "";
    private String type = "1";
    private String stage_id = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogue_06);
        init(getIntent());
    }

    private void init(Intent intent) {
        viewPager = findViewById(R.id.viewPager);
        pagerTabStrip = findViewById(R.id.pagerTabStrip);
        textView_tittle = findViewById(R.id.textView_tittle);
        imageView_back = findViewById(R.id.imageView_back);

        user_id = SharedPreferencesUtils.getString(getApplicationContext(), "user_id", "");
        type = SharedPreferencesUtils.getString(getApplicationContext(), "type", "1");
        stage_id = SharedPreferencesUtils.getString(getApplicationContext(), "stage_id", "");

        textView_tittle.setText(intent.getStringExtra("tittle"));
        imageView_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        pagerTabStrip.setDrawFullUnderline(false);
        pagerTabStrip.setBackgroundColor(0x000000);
        pagerTabStrip.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        pagerTabStrip.setTabIndicatorColor(0x000000);
        pagerTabStrip.setTextSpacing(200);

        for (int i = 0; i < layouts.length; i++) {
            view[i] = LayoutInflater.from(this).inflate(layouts[i], null);
            view_container_list.add(view[i]);
            title_container_list.add(titles[i]);
        }

        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return view_container_list.size();
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                container.removeView(view_container_list.get(position));
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                container.addView(view_container_list.get(position));
                return view_container_list.get(position);
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view == object;
            }

            @Override
            public int getItemPosition(@NonNull Object object) {
                return super.getItemPosition(object);
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return title_container_list.get(position);
            }
        });

        spinner_province_name = view[0].findViewById(R.id.spinner_province_name);
        spinner_college_name = view[0].findViewById(R.id.spinner_college_name);
        spinner_major_group_id = view[0].findViewById(R.id.spinner_major_group_id);
        listView_major = view[0].findViewById(R.id.listView_major);
        listView_favorite = view[1].findViewById(R.id.listView_favorite);
        checkbox_is_adjust = view[0].findViewById(R.id.checkbox_is_adjust);
        button_confirm = view[0].findViewById(R.id.button_confirm);

        DialogueActivity_06_Tab_01_ListView_Adapter dialogueActivity_06_tab_01_listView_adapter = new DialogueActivity_06_Tab_01_ListView_Adapter(this, major_info_list);

        new Thread(new Runnable() {
            @Override
            public void run() {
                JSONObject jsonObject_ProvinceInfo = HTTPUtils.doGet("/provinceInfo/getProvinceList");
                province_info_list.clear();
                province_info_list.addAll(JSON.parseArray(jsonObject_ProvinceInfo.getString("data"), ProvinceInfo.class));
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        DialogueActivity_06_Tab_01_Spinner_01_Province_Adapter dialogueActivity_06_tab_01_spinner_01_province_adapter = new DialogueActivity_06_Tab_01_Spinner_01_Province_Adapter(DialogueActivity_06.this, province_info_list);
                        spinner_province_name.setAdapter(dialogueActivity_06_tab_01_spinner_01_province_adapter);
                    }
                });
            }
        }).start();

        spinner_province_name.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ProvinceInfo province_info = (ProvinceInfo) parent.getItemAtPosition(position);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        JSONObject jsonObject_CollegeInfo = HTTPUtils.doGet("/collegeInfo/getCollegeInfoList?type=" + type + "&province_id=" + province_info.getProvince_id());
                        college_info_list.clear();
                        college_info_list.addAll(JSON.parseArray(jsonObject_CollegeInfo.getString("data"), CollegeInfo.class));
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                DialogueActivity_06_Tab_01_Spinner_02_College_Adapter dialogueActivity_06_tab_01_spinner_02_college_adapter = new DialogueActivity_06_Tab_01_Spinner_02_College_Adapter(DialogueActivity_06.this, college_info_list);
                                spinner_college_name.setAdapter(dialogueActivity_06_tab_01_spinner_02_college_adapter);
                            }
                        });
                    }
                }).start();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner_college_name.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                CollegeInfo college_info = (CollegeInfo) parent.getItemAtPosition(position);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        JSONObject jsonObject_MajorGroupInfo = HTTPUtils.doGet("/majorScoreInfo/getMajorGroupInfoList?type=" + type + "&college_id=" + college_info.getCollege_id());
                        major_group_info_list.clear();
                        major_group_info_list.addAll(JSON.parseArray(jsonObject_MajorGroupInfo.getString("data"), MajorGroupInfo.class));
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                DialogueActivity_06_Tab_01_Spinner_03_Major_Group_Adapter dialogueActivity_06_tab_01_spinner_03_major_group_adapter = new DialogueActivity_06_Tab_01_Spinner_03_Major_Group_Adapter(DialogueActivity_06.this, major_group_info_list);
                                spinner_major_group_id.setAdapter(dialogueActivity_06_tab_01_spinner_03_major_group_adapter);
                            }
                        });
                    }
                }).start();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner_major_group_id.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                MajorGroupInfo major_group_info = (MajorGroupInfo) parent.getItemAtPosition(position);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        JSONObject jsonObject_MajorInfo = HTTPUtils.doGet("/majorScoreInfo/getMajorInfoList?type=" + type + "&college_id=" + major_group_info.getCollege_id() + "&major_group_id=" + major_group_info.getMajor_group_id());
                        major_info_list.clear();
                        major_info_list.addAll(JSON.parseArray(jsonObject_MajorInfo.getString("data"), MajorInfo.class));
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                dialogueActivity_06_tab_01_listView_adapter.notifyDataSetChanged();
                                dialogueActivity_06_tab_01_listView_adapter.click_order_list.clear();
                                Arrays.fill(dialogueActivity_06_tab_01_listView_adapter.click_order_str_s, "");//清空数组
                            }
                        });
                    }
                }).start();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        listView_major.setAdapter(dialogueActivity_06_tab_01_listView_adapter);

        button_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> click_order_list = dialogueActivity_06_tab_01_listView_adapter.click_order_list;
                Intent intent_temp = new Intent();
                int result_code = 0;
                if (!click_order_list.isEmpty() && major_info_list.size() > 0) {
                    VolunteerInfo volunteer_info = new VolunteerInfo();
                    volunteer_info.setUser_id(user_id);
                    volunteer_info.setStage_id(stage_id);
                    volunteer_info.setCollege_id(major_info_list.get(0).getCollege_id());
                    volunteer_info.setCollege_name(major_info_list.get(0).getCollege_name());
                    volunteer_info.setType(type);
                    volunteer_info.setMajor_group_id(major_info_list.get(0).getMajor_group_id());
                    volunteer_info.setMajor_group_name(major_info_list.get(0).getMajor_group_name());
                    volunteer_info.setIs_adjust(checkbox_is_adjust.isChecked() ? "1" : "0");
                    if (click_order_list.size() > 0) {
                        volunteer_info.setMajor_name_1(major_info_list.get(Integer.parseInt(click_order_list.get(0))).getMajor_name());
                        volunteer_info.setMajor_notes_1(major_info_list.get(Integer.parseInt(click_order_list.get(0))).getMajor_notes());
                    }
                    if (click_order_list.size() > 1) {
                        volunteer_info.setMajor_name_2(major_info_list.get(Integer.parseInt(click_order_list.get(1))).getMajor_name());
                        volunteer_info.setMajor_notes_2(major_info_list.get(Integer.parseInt(click_order_list.get(1))).getMajor_notes());
                    }
                    if (click_order_list.size() > 2) {
                        volunteer_info.setMajor_name_3(major_info_list.get(Integer.parseInt(click_order_list.get(2))).getMajor_name());
                        volunteer_info.setMajor_notes_3(major_info_list.get(Integer.parseInt(click_order_list.get(2))).getMajor_notes());
                    }
                    if (click_order_list.size() > 3) {
                        volunteer_info.setMajor_name_4(major_info_list.get(Integer.parseInt(click_order_list.get(3))).getMajor_name());
                        volunteer_info.setMajor_notes_4(major_info_list.get(Integer.parseInt(click_order_list.get(3))).getMajor_notes());
                    }
                    if (click_order_list.size() > 4) {
                        volunteer_info.setMajor_name_5(major_info_list.get(Integer.parseInt(click_order_list.get(4))).getMajor_name());
                        volunteer_info.setMajor_notes_5(major_info_list.get(Integer.parseInt(click_order_list.get(4))).getMajor_notes());
                    }
                    if (click_order_list.size() > 5) {
                        volunteer_info.setMajor_name_6(major_info_list.get(Integer.parseInt(click_order_list.get(5))).getMajor_name());
                        volunteer_info.setMajor_notes_6(major_info_list.get(Integer.parseInt(click_order_list.get(5))).getMajor_notes());
                    }
                    intent_temp.putExtra("volunteer_Info", volunteer_info);
                    intent_temp.putExtra("position", intent.getIntExtra("position", 0));
                    result_code = 1;
                }
                setResult(result_code, intent_temp);
                finish();
            }
        });

        DialogueActivity_06_Tab_02_ListView_Adapter dialogueActivity_06_tab_02_listView_adapter = new DialogueActivity_06_Tab_02_ListView_Adapter(this, favorite_major_info_list);
        listView_favorite.setAdapter(dialogueActivity_06_tab_02_listView_adapter);
        new Thread(new Runnable() {
            @Override
            public void run() {
                JSONObject jsonObject_UserCollectionInfo = HTTPUtils.doGet("/userCollectionInfo/getUserCollectionInfo?user_id=" + user_id);
                favorite_major_info_list.clear();
                favorite_major_info_list.addAll(JSON.parseArray(jsonObject_UserCollectionInfo.getString("data"), iUserCollectionInfo.class));
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        dialogueActivity_06_tab_02_listView_adapter.notifyDataSetChanged();
                    }
                });
            }
        }).start();
    }

}
