package com.ydlab.mntb_client.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

import com.ydlab.mntb_client.R;
import com.ydlab.mntb_client.utils.SharedPreferencesUtils;
import com.ydlab.mntb_client.utils.SwitchUtils;

/*
    选择省份
 */
public class DialogueActivity_02 extends AppCompatActivity {
    private ImageView imageView_next;
    private Button button_confirm, button_cancel;
    private String[] province_ids = new String[]{"11", "12", "13", "14", "15", "21", "22", "23", "31", "32", "33", "34", "35", "36", "37",
            "41", "42", "43", "44", "45", "46", "50", "51", "52", "53", "54", "61", "62", "63", "64", "65"};
    private String[] province_names = new String[]{"北京", "天津", "河北", "山西", "内蒙古", "辽宁", "吉林", "黑龙江", "上海", "江苏", "浙江",
            "安徽", "福建", "江西", "山东", "河南", "湖北", "湖南", "广东", "广西", "海南", "重庆", "四川", "贵州", "云南", "西藏", "陕西",
            "甘肃", "青海", "宁夏", "新疆"};
    private CheckBox checkbox_1, checkbox_2, checkbox_3, checkbox_4, checkbox_5, checkbox_6, checkbox_7, checkbox_8, checkbox_9, checkbox_10,
            checkbox_11, checkbox_12, checkbox_13, checkbox_14, checkbox_15, checkbox_16, checkbox_17, checkbox_18, checkbox_19, checkbox_20,
            checkbox_21, checkbox_22, checkbox_23, checkbox_24, checkbox_25, checkbox_26, checkbox_27, checkbox_28, checkbox_29, checkbox_30,
            checkbox_31;
    private int[] checkbox_select_ids = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private String select_ids_str = "";
    private int checkBox_selected_count = 0;
    private final int MAX_SELECTED_COUNT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogue_02);
        init(getIntent());
    }

    private void init(Intent intent) {
        imageView_next = findViewById(R.id.imageView_next);
        button_confirm = findViewById(R.id.button_confirm);
        button_cancel = findViewById(R.id.button_cancel);

        checkbox_1 = findViewById(R.id.checkbox_1);
        checkbox_2 = findViewById(R.id.checkbox_2);
        checkbox_3 = findViewById(R.id.checkbox_3);
        checkbox_4 = findViewById(R.id.checkbox_4);
        checkbox_5 = findViewById(R.id.checkbox_5);
        checkbox_6 = findViewById(R.id.checkbox_6);
        checkbox_7 = findViewById(R.id.checkbox_7);
        checkbox_8 = findViewById(R.id.checkbox_8);
        checkbox_9 = findViewById(R.id.checkbox_9);
        checkbox_10 = findViewById(R.id.checkbox_10);
        checkbox_11 = findViewById(R.id.checkbox_11);
        checkbox_12 = findViewById(R.id.checkbox_12);
        checkbox_13 = findViewById(R.id.checkbox_13);
        checkbox_14 = findViewById(R.id.checkbox_14);
        checkbox_15 = findViewById(R.id.checkbox_15);
        checkbox_16 = findViewById(R.id.checkbox_16);
        checkbox_17 = findViewById(R.id.checkbox_17);
        checkbox_18 = findViewById(R.id.checkbox_18);
        checkbox_19 = findViewById(R.id.checkbox_19);
        checkbox_20 = findViewById(R.id.checkbox_20);
        checkbox_21 = findViewById(R.id.checkbox_21);
        checkbox_22 = findViewById(R.id.checkbox_22);
        checkbox_23 = findViewById(R.id.checkbox_23);
        checkbox_24 = findViewById(R.id.checkbox_24);
        checkbox_25 = findViewById(R.id.checkbox_25);
        checkbox_26 = findViewById(R.id.checkbox_26);
        checkbox_27 = findViewById(R.id.checkbox_27);
        checkbox_28 = findViewById(R.id.checkbox_28);
        checkbox_29 = findViewById(R.id.checkbox_29);
        checkbox_30 = findViewById(R.id.checkbox_30);
        checkbox_31 = findViewById(R.id.checkbox_31);

        button_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disableUncheckedCheckboxes();
                imageView_next.setVisibility(View.VISIBLE);

                /*
                if (checkbox_1.isChecked()) {
                    checkbox_select_ids[0] = 1;
                }
                if (checkbox_2.isChecked()) {
                    checkbox_select_ids[1] = 1;
                }
                if (checkbox_3.isChecked()) {
                    checkbox_select_ids[2] = 1;
                }
                if (checkbox_4.isChecked()) {
                    checkbox_select_ids[3] = 1;
                }
                if (checkbox_5.isChecked()) {
                    checkbox_select_ids[4] = 1;
                }
                if (checkbox_6.isChecked()) {
                    checkbox_select_ids[5] = 1;
                }
                if (checkbox_7.isChecked()) {
                    checkbox_select_ids[6] = 1;
                }
                if (checkbox_8.isChecked()) {
                    checkbox_select_ids[7] = 1;
                }
                if (checkbox_9.isChecked()) {
                    checkbox_select_ids[8] = 1;
                }
                if (checkbox_10.isChecked()) {
                    checkbox_select_ids[9] = 1;
                }
                if (checkbox_11.isChecked()) {
                    checkbox_select_ids[10] = 1;
                }
                if (checkbox_12.isChecked()) {
                    checkbox_select_ids[11] = 1;
                }
                if (checkbox_13.isChecked()) {
                    checkbox_select_ids[12] = 1;
                }
                if (checkbox_14.isChecked()) {
                    checkbox_select_ids[13] = 1;
                }
                if (checkbox_15.isChecked()) {
                    checkbox_select_ids[14] = 1;
                }
                if (checkbox_16.isChecked()) {
                    checkbox_select_ids[15] = 1;
                }
                if (checkbox_17.isChecked()) {
                    checkbox_select_ids[16] = 1;
                }
                if (checkbox_18.isChecked()) {
                    checkbox_select_ids[17] = 1;
                }
                if (checkbox_19.isChecked()) {
                    checkbox_select_ids[18] = 1;
                }
                if (checkbox_20.isChecked()) {
                    checkbox_select_ids[19] = 1;
                }
                if (checkbox_21.isChecked()) {
                    checkbox_select_ids[20] = 1;
                }
                if (checkbox_22.isChecked()) {
                    checkbox_select_ids[21] = 1;
                }
                if (checkbox_23.isChecked()) {
                    checkbox_select_ids[22] = 1;
                }
                if (checkbox_24.isChecked()) {
                    checkbox_select_ids[23] = 1;
                }
                if (checkbox_25.isChecked()) {
                    checkbox_select_ids[24] = 1;
                }
                if (checkbox_26.isChecked()) {
                    checkbox_select_ids[25] = 1;
                }
                if (checkbox_27.isChecked()) {
                    checkbox_select_ids[26] = 1;
                }
                if (checkbox_28.isChecked()) {
                    checkbox_select_ids[27] = 1;
                }
                if (checkbox_29.isChecked()) {
                    checkbox_select_ids[28] = 1;
                }
                if (checkbox_30.isChecked()) {
                    checkbox_select_ids[29] = 1;
                }
                if (checkbox_31.isChecked()) {
                    checkbox_select_ids[30] = 1;
                }
                 */

                select_ids_str = "";

                /*
                if (checkbox_1.isChecked()) {
                    select_ids_str += "11,";
                }
                if (checkbox_2.isChecked()) {
                    select_ids_str += "12,";
                }
                if (checkbox_3.isChecked()) {
                    select_ids_str += "13,";
                }
                if (checkbox_4.isChecked()) {
                    select_ids_str += "14,";
                }
                if (checkbox_5.isChecked()) {
                    select_ids_str += "15,";
                }
                if (checkbox_6.isChecked()) {
                    select_ids_str += "21,";
                }
                if (checkbox_7.isChecked()) {
                    select_ids_str += "22,";
                }
                if (checkbox_8.isChecked()) {
                    select_ids_str += "23,";
                }
                if (checkbox_9.isChecked()) {
                    select_ids_str += "31,";
                }
                if (checkbox_10.isChecked()) {
                    select_ids_str += "32,";
                }
                if (checkbox_11.isChecked()) {
                    select_ids_str += "33,";
                }
                if (checkbox_12.isChecked()) {
                    select_ids_str += "34,";
                }
                if (checkbox_13.isChecked()) {
                    select_ids_str += "35,";
                }
                if (checkbox_14.isChecked()) {
                    select_ids_str += "36,";
                }
                if (checkbox_15.isChecked()) {
                    select_ids_str += "37,";
                }
                if (checkbox_16.isChecked()) {
                    select_ids_str += "41,";
                }
                if (checkbox_17.isChecked()) {
                    select_ids_str += "42,";
                }
                if (checkbox_18.isChecked()) {
                    select_ids_str += "43,";
                }
                if (checkbox_19.isChecked()) {
                    select_ids_str += "44,";
                }
                if (checkbox_20.isChecked()) {
                    select_ids_str += "45,";
                }
                if (checkbox_21.isChecked()) {
                    select_ids_str += "46,";
                }
                if (checkbox_22.isChecked()) {
                    select_ids_str += "50,";
                }
                if (checkbox_23.isChecked()) {
                    select_ids_str += "51,";
                }
                if (checkbox_24.isChecked()) {
                    select_ids_str += "52,";
                }
                if (checkbox_25.isChecked()) {
                    select_ids_str += "53,";
                }
                if (checkbox_26.isChecked()) {
                    select_ids_str += "54,";
                }
                if (checkbox_27.isChecked()) {
                    select_ids_str += "61,";
                }
                if (checkbox_28.isChecked()) {
                    select_ids_str += "62,";
                }
                if (checkbox_29.isChecked()) {
                    select_ids_str += "63,";
                }
                if (checkbox_30.isChecked()) {
                    select_ids_str += "64,";
                }
                if (checkbox_31.isChecked()) {
                    select_ids_str += "65,";
                }
                 */

                if (checkbox_1.isChecked()) {
                    select_ids_str = "11";
                }
                if (checkbox_2.isChecked()) {
                    select_ids_str = "12";
                }
                if (checkbox_3.isChecked()) {
                    select_ids_str = "13";
                }
                if (checkbox_4.isChecked()) {
                    select_ids_str = "14";
                }
                if (checkbox_5.isChecked()) {
                    select_ids_str = "15";
                }
                if (checkbox_6.isChecked()) {
                    select_ids_str = "21";
                }
                if (checkbox_7.isChecked()) {
                    select_ids_str = "22";
                }
                if (checkbox_8.isChecked()) {
                    select_ids_str = "23";
                }
                if (checkbox_9.isChecked()) {
                    select_ids_str = "31";
                }
                if (checkbox_10.isChecked()) {
                    select_ids_str = "32";
                }
                if (checkbox_11.isChecked()) {
                    select_ids_str = "33";
                }
                if (checkbox_12.isChecked()) {
                    select_ids_str = "34";
                }
                if (checkbox_13.isChecked()) {
                    select_ids_str = "35";
                }
                if (checkbox_14.isChecked()) {
                    select_ids_str = "36";
                }
                if (checkbox_15.isChecked()) {
                    select_ids_str = "37";
                }
                if (checkbox_16.isChecked()) {
                    select_ids_str = "41";
                }
                if (checkbox_17.isChecked()) {
                    select_ids_str = "42";
                }
                if (checkbox_18.isChecked()) {
                    select_ids_str = "43";
                }
                if (checkbox_19.isChecked()) {
                    select_ids_str = "44";
                }
                if (checkbox_20.isChecked()) {
                    select_ids_str = "45";
                }
                if (checkbox_21.isChecked()) {
                    select_ids_str = "46";
                }
                if (checkbox_22.isChecked()) {
                    select_ids_str = "50";
                }
                if (checkbox_23.isChecked()) {
                    select_ids_str = "51";
                }
                if (checkbox_24.isChecked()) {
                    select_ids_str = "52";
                }
                if (checkbox_25.isChecked()) {
                    select_ids_str = "53";
                }
                if (checkbox_26.isChecked()) {
                    select_ids_str = "54";
                }
                if (checkbox_27.isChecked()) {
                    select_ids_str = "61";
                }
                if (checkbox_28.isChecked()) {
                    select_ids_str = "62";
                }
                if (checkbox_29.isChecked()) {
                    select_ids_str = "63";
                }
                if (checkbox_30.isChecked()) {
                    select_ids_str = "64";
                }
                if (checkbox_31.isChecked()) {
                    select_ids_str = "65";
                }
            }
        });

        button_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView_next.setVisibility(View.INVISIBLE);
                enableAllCheckboxes();
            }
        });

        imageView_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferencesUtils.putString(getApplicationContext(), "province_id", select_ids_str);
                System.out.println(SharedPreferencesUtils.getString(getApplicationContext(), "province_id", "?"));
                SwitchUtils.toSwitch(getApplicationContext(), intent.getStringExtra("next_dialogue_id"));
                overridePendingTransition(R.anim.activity_open_in_anim, R.anim.activity_close_out_anim);
            }
        });

        imageView_next.setVisibility(View.INVISIBLE);

        checkbox_1.setOnCheckedChangeListener(checkedChangeListener);
        checkbox_2.setOnCheckedChangeListener(checkedChangeListener);
        checkbox_3.setOnCheckedChangeListener(checkedChangeListener);
        checkbox_4.setOnCheckedChangeListener(checkedChangeListener);
        checkbox_5.setOnCheckedChangeListener(checkedChangeListener);
        checkbox_6.setOnCheckedChangeListener(checkedChangeListener);
        checkbox_7.setOnCheckedChangeListener(checkedChangeListener);
        checkbox_8.setOnCheckedChangeListener(checkedChangeListener);
        checkbox_9.setOnCheckedChangeListener(checkedChangeListener);
        checkbox_10.setOnCheckedChangeListener(checkedChangeListener);
        checkbox_11.setOnCheckedChangeListener(checkedChangeListener);
        checkbox_12.setOnCheckedChangeListener(checkedChangeListener);
        checkbox_13.setOnCheckedChangeListener(checkedChangeListener);
        checkbox_14.setOnCheckedChangeListener(checkedChangeListener);
        checkbox_15.setOnCheckedChangeListener(checkedChangeListener);
        checkbox_16.setOnCheckedChangeListener(checkedChangeListener);
        checkbox_17.setOnCheckedChangeListener(checkedChangeListener);
        checkbox_18.setOnCheckedChangeListener(checkedChangeListener);
        checkbox_19.setOnCheckedChangeListener(checkedChangeListener);
        checkbox_20.setOnCheckedChangeListener(checkedChangeListener);
        checkbox_21.setOnCheckedChangeListener(checkedChangeListener);
        checkbox_22.setOnCheckedChangeListener(checkedChangeListener);
        checkbox_23.setOnCheckedChangeListener(checkedChangeListener);
        checkbox_24.setOnCheckedChangeListener(checkedChangeListener);
        checkbox_25.setOnCheckedChangeListener(checkedChangeListener);
        checkbox_26.setOnCheckedChangeListener(checkedChangeListener);
        checkbox_27.setOnCheckedChangeListener(checkedChangeListener);
        checkbox_28.setOnCheckedChangeListener(checkedChangeListener);
        checkbox_29.setOnCheckedChangeListener(checkedChangeListener);
        checkbox_30.setOnCheckedChangeListener(checkedChangeListener);
        checkbox_31.setOnCheckedChangeListener(checkedChangeListener);
    }

    CompoundButton.OnCheckedChangeListener checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                // 检查是否超过允许的最大选中数量
                if (checkBox_selected_count >= MAX_SELECTED_COUNT) {
                    buttonView.setChecked(false);
                } else {
                    checkBox_selected_count++;
                }
            } else {
                checkBox_selected_count--;
            }

            // 检查未选中的复选框数量并禁用
            if (checkBox_selected_count >= MAX_SELECTED_COUNT) {
                disableUncheckedCheckboxes();
            } else {
                enableAllCheckboxes();
            }
        }
    };

    private void disableUncheckedCheckboxes() {
        checkbox_1.setEnabled(false);
        checkbox_2.setEnabled(false);
        checkbox_3.setEnabled(false);
        checkbox_4.setEnabled(false);
        checkbox_5.setEnabled(false);
        checkbox_6.setEnabled(false);
        checkbox_7.setEnabled(false);
        checkbox_8.setEnabled(false);
        checkbox_9.setEnabled(false);
        checkbox_10.setEnabled(false);
        checkbox_11.setEnabled(false);
        checkbox_12.setEnabled(false);
        checkbox_13.setEnabled(false);
        checkbox_14.setEnabled(false);
        checkbox_15.setEnabled(false);
        checkbox_16.setEnabled(false);
        checkbox_17.setEnabled(false);
        checkbox_18.setEnabled(false);
        checkbox_19.setEnabled(false);
        checkbox_20.setEnabled(false);
        checkbox_21.setEnabled(false);
        checkbox_22.setEnabled(false);
        checkbox_23.setEnabled(false);
        checkbox_24.setEnabled(false);
        checkbox_25.setEnabled(false);
        checkbox_26.setEnabled(false);
        checkbox_27.setEnabled(false);
        checkbox_28.setEnabled(false);
        checkbox_29.setEnabled(false);
        checkbox_30.setEnabled(false);
        checkbox_31.setEnabled(false);
    }

    private void enableAllCheckboxes() {
        checkbox_1.setEnabled(true);
        checkbox_2.setEnabled(true);
        checkbox_3.setEnabled(true);
        checkbox_4.setEnabled(true);
        checkbox_5.setEnabled(true);
        checkbox_6.setEnabled(true);
        checkbox_7.setEnabled(true);
        checkbox_8.setEnabled(true);
        checkbox_9.setEnabled(true);
        checkbox_10.setEnabled(true);
        checkbox_11.setEnabled(true);
        checkbox_12.setEnabled(true);
        checkbox_13.setEnabled(true);
        checkbox_14.setEnabled(true);
        checkbox_15.setEnabled(true);
        checkbox_16.setEnabled(true);
        checkbox_17.setEnabled(true);
        checkbox_18.setEnabled(true);
        checkbox_19.setEnabled(true);
        checkbox_20.setEnabled(true);
        checkbox_21.setEnabled(true);
        checkbox_22.setEnabled(true);
        checkbox_23.setEnabled(true);
        checkbox_24.setEnabled(true);
        checkbox_25.setEnabled(true);
        checkbox_26.setEnabled(true);
        checkbox_27.setEnabled(true);
        checkbox_28.setEnabled(true);
        checkbox_29.setEnabled(true);
        checkbox_30.setEnabled(true);
        checkbox_31.setEnabled(true);
    }
}
