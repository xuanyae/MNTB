package com.ydlab.mntb_client.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.ydlab.mntb_client.R;
import com.ydlab.mntb_client.bean.ScoreInfo;
import com.ydlab.mntb_client.utils.SharedPreferencesUtils;
import com.ydlab.mntb_client.utils.SwitchUtils;

import java.util.Arrays;

/*
    填写分数
 */
public class DialogueActivity_07 extends AppCompatActivity {
    private ImageView imageView_next;
    private RadioButton radioButton_1;
    private CheckBox checkBox_1, checkBox_2, checkBox_3, checkBox_4;
    private TextView textView_subject_4, textView_subject_5, textView_subject_6;
    private EditText editText_subject_1, editText_subject_2, editText_subject_3, editText_subject_4, editText_subject_5, editText_subject_6;
    private int[] subject_ids = new int[]{1, 1, 0, 0};//1化学,2生物,3地理,4政治;1表示选中,0表示未选中
    private String[] subject_names = new String[]{"化学：", "生物："};
    private int checkBox_selected_count = 2;
    private final int MAX_SELECTED_COUNT = 2;
    private boolean verify = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogue_07);
        init(getIntent());
    }

    private void init(Intent intent) {
        imageView_next = findViewById(R.id.imageView_next);
        radioButton_1 = findViewById(R.id.radioButton_1);
        checkBox_1 = findViewById(R.id.checkbox_1);
        checkBox_2 = findViewById(R.id.checkbox_2);
        checkBox_3 = findViewById(R.id.checkbox_3);
        checkBox_4 = findViewById(R.id.checkbox_4);
        textView_subject_4 = findViewById(R.id.textView_subject_4);
        textView_subject_5 = findViewById(R.id.textView_subject_5);
        textView_subject_6 = findViewById(R.id.textView_subject_6);
        editText_subject_1 = findViewById(R.id.editText_subject_1);
        editText_subject_2 = findViewById(R.id.editText_subject_2);
        editText_subject_3 = findViewById(R.id.editText_subject_3);
        editText_subject_4 = findViewById(R.id.editText_subject_4);
        editText_subject_5 = findViewById(R.id.editText_subject_5);
        editText_subject_6 = findViewById(R.id.editText_subject_6);

        radioButton_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    textView_subject_4.setText("物理：");
                } else {
                    textView_subject_4.setText("历史：");
                }
            }
        });

        checkBox_1.setOnCheckedChangeListener(checkedChangeListener);
        checkBox_2.setOnCheckedChangeListener(checkedChangeListener);
        checkBox_3.setOnCheckedChangeListener(checkedChangeListener);
        checkBox_4.setOnCheckedChangeListener(checkedChangeListener);
        checkBox_3.setEnabled(false);
        checkBox_4.setEnabled(false);

        ScoreInfo score_info = new ScoreInfo();
        score_info.setSubject_score_1("");
        score_info.setSubject_score_2("");
        score_info.setSubject_score_3("");
        score_info.setSubject_score_4("");
        score_info.setSubject_score_5("");
        score_info.setSubject_score_6("");
        score_info.setSubject_score_7("");
        score_info.setSubject_score_8("");
        score_info.setSubject_score_9("");
        score_info.setTotal_score("");
        score_info.setType("");
        imageView_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String score_str_1 = editText_subject_1.getText().toString();
                String score_str_2 = editText_subject_2.getText().toString();
                String score_str_3 = editText_subject_3.getText().toString();
                String score_str_4 = editText_subject_4.getText().toString();
                String score_str_5 = editText_subject_5.getText().toString();
                String score_str_6 = editText_subject_6.getText().toString();
                if (score_str_1.equals("") || score_str_2.equals("") || score_str_3.equals("") || score_str_4.equals("") || score_str_5.equals("") || score_str_6.equals("")) {
                    verify = false;
                } else {
                    int score_1 = Integer.parseInt(score_str_1);
                    int score_2 = Integer.parseInt(score_str_2);
                    int score_3 = Integer.parseInt(score_str_3);
                    int score_4 = Integer.parseInt(score_str_4);
                    int score_5 = Integer.parseInt(score_str_5);
                    int score_6 = Integer.parseInt(score_str_6);
                    score_info.setTotal_score(Integer.toString(score_1 + score_2 + score_3 + score_4 + score_5 + score_6));
                    if ((score_1 < 150 && score_1 > 0) && (score_2 < 150 && score_2 > 0) && (score_3 < 150 && score_3 > 0)) {
                        score_info.setSubject_score_1(score_str_1);
                        score_info.setSubject_score_2(score_str_2);
                        score_info.setSubject_score_3(score_str_3);
                    } else {
                        verify = false;
                    }
                    if ((score_4 < 100 && score_4 > 0) && (score_5 < 100 && score_5 > 0) && (score_6 < 100 && score_6 > 0)) {
                        if (radioButton_1.isChecked()) {//物理
                            score_info.setSubject_score_4(score_str_4);
                        } else {//历史
                            score_info.setSubject_score_5(score_str_4);
                        }
                        if (subject_ids[0] == 1 && subject_ids[1] == 1) {//化学、生物
                            score_info.setSubject_score_6(score_str_5);
                            score_info.setSubject_score_7(score_str_6);
                        } else if (subject_ids[0] == 1 && subject_ids[2] == 1) {//化学、地理
                            score_info.setSubject_score_6(score_str_5);
                            score_info.setSubject_score_8(score_str_6);
                        } else if (subject_ids[0] == 1 && subject_ids[3] == 0) {//化学、政治
                            score_info.setSubject_score_6(score_str_5);
                            score_info.setSubject_score_9(score_str_6);
                        } else if (subject_ids[1] == 1 && subject_ids[2] == 1) {//生物、地理
                            score_info.setSubject_score_7(score_str_5);
                            score_info.setSubject_score_8(score_str_6);
                        } else if (subject_ids[1] == 1 && subject_ids[3] == 1) {//生物、政治
                            score_info.setSubject_score_7(score_str_5);
                            score_info.setSubject_score_9(score_str_6);
                        } else {//地理、政治
                            score_info.setSubject_score_8(score_str_5);
                            score_info.setSubject_score_9(score_str_6);
                        }
                    } else {
                        verify = false;
                    }
                }
                if (verify) {
                    score_info.setType(score_info.getSubject_score_4() != null ? "1" : "2");
                    Intent intent_2 = new Intent(DialogueActivity_07.this, DialogueActivity_02.class);
                    startActivity(intent_2);

                    SharedPreferencesUtils.putString(getApplicationContext(), "total_score", "");
                    SharedPreferencesUtils.putString(getApplicationContext(), "subject_score_1", "");
                    SharedPreferencesUtils.putString(getApplicationContext(), "subject_score_2", "");
                    SharedPreferencesUtils.putString(getApplicationContext(), "subject_score_3", "");
                    SharedPreferencesUtils.putString(getApplicationContext(), "subject_score_4", "");
                    SharedPreferencesUtils.putString(getApplicationContext(), "subject_score_5", "");
                    SharedPreferencesUtils.putString(getApplicationContext(), "subject_score_6", "");
                    SharedPreferencesUtils.putString(getApplicationContext(), "subject_score_7", "");
                    SharedPreferencesUtils.putString(getApplicationContext(), "subject_score_8", "");
                    SharedPreferencesUtils.putString(getApplicationContext(), "subject_score_9", "");
                    SharedPreferencesUtils.putString(getApplicationContext(), "type", "");

                    SharedPreferencesUtils.putString(getApplicationContext(), "total_score", score_info.getTotal_score());
                    SharedPreferencesUtils.putString(getApplicationContext(), "subject_score_1", score_info.getSubject_score_1());
                    SharedPreferencesUtils.putString(getApplicationContext(), "subject_score_2", score_info.getSubject_score_2());
                    SharedPreferencesUtils.putString(getApplicationContext(), "subject_score_3", score_info.getSubject_score_3());
                    SharedPreferencesUtils.putString(getApplicationContext(), "subject_score_4", score_info.getSubject_score_4());
                    SharedPreferencesUtils.putString(getApplicationContext(), "subject_score_5", score_info.getSubject_score_5());
                    SharedPreferencesUtils.putString(getApplicationContext(), "subject_score_6", score_info.getSubject_score_6());
                    SharedPreferencesUtils.putString(getApplicationContext(), "subject_score_7", score_info.getSubject_score_7());
                    SharedPreferencesUtils.putString(getApplicationContext(), "subject_score_8", score_info.getSubject_score_8());
                    SharedPreferencesUtils.putString(getApplicationContext(), "subject_score_9", score_info.getSubject_score_9());
                    SharedPreferencesUtils.putString(getApplicationContext(), "type", score_info.getType());

                    SwitchUtils.toSwitch(getApplicationContext(), intent.getStringExtra("next_dialogue_id"));
                    overridePendingTransition(R.anim.activity_open_in_anim, R.anim.activity_close_out_anim);
                } else {
                    Toast.makeText(getApplicationContext(), "请输入正确的分数", Toast.LENGTH_SHORT).show();
                    verify = true;
                }

            }
        });
    }

    CompoundButton.OnCheckedChangeListener checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                // 检查是否超过允许的最大选中数量（这里是2个）
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

            if (checkBox_1.isChecked()) {
                subject_ids[0] = 1;
            } else {
                subject_ids[0] = 0;
            }
            if (checkBox_2.isChecked()) {
                subject_ids[1] = 1;
            } else {
                subject_ids[1] = 0;
            }
            if (checkBox_3.isChecked()) {
                subject_ids[2] = 1;
            } else {
                subject_ids[2] = 0;
            }
            if (checkBox_4.isChecked()) {
                subject_ids[3] = 1;
            } else {
                subject_ids[3] = 0;
            }
            int subject_names_index = 0;
            Arrays.fill(subject_names, "");//清空数组
            for (int i = 0; i < subject_ids.length; i++) {
                if (subject_ids[i] == 1) {
                    switch (i) {
                        case 0:
                            subject_names[subject_names_index] = "化学：";
                            subject_names_index++;
                            break;
                        case 1:
                            subject_names[subject_names_index] = "生物：";
                            subject_names_index++;
                            break;
                        case 2:
                            subject_names[subject_names_index] = "地理：";
                            subject_names_index++;
                            break;
                        case 3:
                            subject_names[subject_names_index] = "政治：";
                            subject_names_index++;
                            break;
                    }
                }
            }
            if (!subject_names[0].equals("") && !subject_names[1].equals("")) {
                textView_subject_5.setText(subject_names[0]);
                textView_subject_6.setText(subject_names[1]);
            }
        }
    };

    private void disableUncheckedCheckboxes() {
        if (!checkBox_1.isChecked()) {
            checkBox_1.setEnabled(false);
        }
        if (!checkBox_2.isChecked()) {
            checkBox_2.setEnabled(false);
        }
        if (!checkBox_3.isChecked()) {
            checkBox_3.setEnabled(false);
        }
        if (!checkBox_4.isChecked()) {
            checkBox_4.setEnabled(false);
        }
    }

    private void enableAllCheckboxes() {
        checkBox_1.setEnabled(true);
        checkBox_2.setEnabled(true);
        checkBox_3.setEnabled(true);
        checkBox_4.setEnabled(true);
    }
}
