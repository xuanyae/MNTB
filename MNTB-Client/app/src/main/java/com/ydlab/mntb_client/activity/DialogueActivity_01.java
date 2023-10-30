package com.ydlab.mntb_client.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.ydlab.mntb_client.R;
import com.ydlab.mntb_client.utils.SwitchUtils;

/*
    基础对话界面
 */
public class DialogueActivity_01 extends AppCompatActivity {
    private LottieAnimationView loading;
    private ImageView imageView_npc, imageView_next;
    private String npc_id = "1";
    private String loading_time = "0";
    private String dialogue_content = "\u3000\u3000";
    private TextView textView_dialogue_content, textView_dialogue_extras_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogue_01);
        init(getIntent());
    }

    private void init(Intent intent) {
        imageView_npc = findViewById(R.id.imageView_npc);
        imageView_next = findViewById(R.id.imageView_next);
        loading = findViewById(R.id.lottie_animation_view);
        textView_dialogue_content = findViewById(R.id.textView_dialogue_content);
        textView_dialogue_extras_content = findViewById(R.id.textView_dialogue_extras_content);

        npc_id = intent.getStringExtra("npc_id");
        loading_time = intent.getStringExtra("loading_time");
        switch (npc_id) {
            case "1":
                imageView_npc.setImageResource(R.drawable.pic_npc_01);
                break;
            case "2":
                imageView_npc.setImageResource(R.drawable.pic_npc_02);
                break;
            case "3":
                imageView_npc.setImageResource(R.drawable.pic_npc_03);
                break;
            case "4":
                imageView_npc.setImageResource(R.drawable.pic_npc_04);
                break;
            case "5":
                imageView_npc.setImageResource(R.drawable.pic_npc_05);
                break;
            case "6":
                imageView_npc.setImageResource(R.drawable.pic_npc_06);
                break;
            default:
                imageView_npc.setVisibility(View.INVISIBLE);
                break;
        }
        textView_dialogue_content.setText("\u3000\u3000" + intent.getStringExtra("dialogue_content"));
        textView_dialogue_extras_content.setText(intent.getStringExtra("dialogue_extras_content"));

        /*
            VISIBLE:0  意思是可见的
            INVISIBILITY:4 意思是不可见的，但还占着原来的空间
            GONE:8  意思是不可见的，不占用原来的布局空间
         */
        imageView_next.setVisibility(View.GONE);
        loading.setVisibility(View.VISIBLE);

        if (loading_time == null) {
            imageView_next.setVisibility(View.VISIBLE);
            loading.setVisibility(View.GONE);
            imageView_next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String dialogue_flag = intent.getStringExtra("dialogue_flag");
                    if (dialogue_flag == null) {
                        SwitchUtils.toSwitch(getApplicationContext(), intent.getStringExtra("next_dialogue_id"));
                        overridePendingTransition(R.anim.activity_open_in_anim, R.anim.activity_close_out_anim);
                    } else if (!dialogue_flag.equals("1")) {
                        Intent intent_back = new Intent(DialogueActivity_01.this, MainActivity.class);
                        startActivity(intent_back);
                    }else {
                        SwitchUtils.toSwitch(getApplicationContext(), intent.getStringExtra("next_dialogue_id"));
                        overridePendingTransition(R.anim.activity_open_in_anim, R.anim.activity_close_out_anim);
                    }
                }
            });
        } else {
            new CountDownTimer(Integer.parseInt(loading_time) * 1000, 1000) {

                public void onTick(long millisUntilFinished) {
                    // 每秒回调一次，这里不需要处理
                }

                public void onFinish() {
                    // 在5秒后更新界面
                    SwitchUtils.toSwitch(getApplicationContext(), intent.getStringExtra("next_dialogue_id"));
                    overridePendingTransition(R.anim.activity_open_in_anim, R.anim.activity_close_out_anim);
                }
            }.start();
        }
    }
}
