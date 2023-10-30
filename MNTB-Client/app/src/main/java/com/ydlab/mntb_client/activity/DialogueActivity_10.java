package com.ydlab.mntb_client.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ydlab.mntb_client.R;

import cn.bmob.v3.ai.BmobAI;
import cn.bmob.v3.ai.ChatMessageListener;

/*
    咨询回答界面
 */
public class DialogueActivity_10 extends AppCompatActivity {
    private ImageView imageView_npc, imageView_back;
    private TextView textView_dialogue_content;
    private String npc_id = "5";
    BmobAI bmobAI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogue_10);
        init(getIntent());
    }

    private void init(Intent intent) {
        imageView_npc = findViewById(R.id.imageView_npc);
        imageView_back = findViewById(R.id.imageView_back);
        textView_dialogue_content = findViewById(R.id.textView_dialogue_content);

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

        //创建Bmob AI实例
        bmobAI = new BmobAI();
        bmobAI.Connect();

        //发送对话信息
        bmobAI.Chat(intent.getStringExtra("question"), "text_user", new ChatMessageListener() {
            @Override
            public void onMessage(String message) {
                //消息流的形式返回AI的结果
                Log.d("ai", message);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView_dialogue_content.setText(textView_dialogue_content.getText() + message);
                    }
                });
            }

            @Override
            public void onFinish(String message) {
                //一次性返回全部结果，这个方法需要等待一段时间，友好性较差
                Log.d("ai", message);
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        textView_dialogue_content.setText(message);
//                    }
//                });
            }

            @Override
            public void onError(String error) {
                //OpenAI的密钥错误或者超过OpenAI并发时，会返回这个错误
                Log.d("ai", "连接发生异常了" + error);
            }

            @Override
            public void onClose() {
                Log.d("ai", "连接被关闭了");
            }
        });

        imageView_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bmobAI.Stop();
                finish();
            }
        });
    }
}
