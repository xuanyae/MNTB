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
    选择专业类别
 */
public class DialogueActivity_03 extends AppCompatActivity {
    private ImageView imageView_next;
    private Button button_confirm, button_cancel;
    private CheckBox checkbox_1, checkbox_2, checkbox_3, checkbox_4, checkbox_5, checkbox_6, checkbox_7, checkbox_8, checkbox_9, checkbox_10,
            checkbox_12;
    private String[] major_field_code_s = new String[]{"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "12"};
    private String[] major_field_s = new String[]{"哲学", "经济学", "法学", "教育学", "文学", "历史学", "理学", "工学", "农学", "医学", "管理学"};
    private int[] checkbox_select_ids = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private String select_ids_str = "";
    private int checkBox_selected_count = 0;
    private final int MAX_SELECTED_COUNT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogue_03);
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
        checkbox_12 = findViewById(R.id.checkbox_12);

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
                    select_ids_str += "01,";
                }
                if (checkbox_2.isChecked()) {
                    select_ids_str += "02,";
                }
                if (checkbox_3.isChecked()) {
                    select_ids_str += "03,";
                }
                if (checkbox_4.isChecked()) {
                    select_ids_str += "04,";
                }
                if (checkbox_5.isChecked()) {
                    select_ids_str += "05,";
                }
                if (checkbox_6.isChecked()) {
                    select_ids_str += "06,";
                }
                if (checkbox_7.isChecked()) {
                    select_ids_str += "07,";
                }
                if (checkbox_8.isChecked()) {
                    select_ids_str += "08,";
                }
                if (checkbox_9.isChecked()) {
                    select_ids_str += "09,";
                }
                if (checkbox_10.isChecked()) {
                    select_ids_str += "10,";
                }
                if (checkbox_12.isChecked()) {
                    select_ids_str += "12,";
                }
                 */

                if (checkbox_1.isChecked()) {
                    select_ids_str = "01";
                }
                if (checkbox_2.isChecked()) {
                    select_ids_str = "02";
                }
                if (checkbox_3.isChecked()) {
                    select_ids_str = "03";
                }
                if (checkbox_4.isChecked()) {
                    select_ids_str = "04";
                }
                if (checkbox_5.isChecked()) {
                    select_ids_str = "05";
                }
                if (checkbox_6.isChecked()) {
                    select_ids_str = "06";
                }
                if (checkbox_7.isChecked()) {
                    select_ids_str = "07";
                }
                if (checkbox_8.isChecked()) {
                    select_ids_str = "08";
                }
                if (checkbox_9.isChecked()) {
                    select_ids_str = "09";
                }
                if (checkbox_10.isChecked()) {
                    select_ids_str = "10";
                }
                if (checkbox_12.isChecked()) {
                    select_ids_str = "12";
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
                SharedPreferencesUtils.putString(getApplicationContext(), "major_field_code", select_ids_str);
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
        checkbox_12.setOnCheckedChangeListener(checkedChangeListener);
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
        checkbox_12.setEnabled(false);
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
        checkbox_12.setEnabled(true);
    }
}
