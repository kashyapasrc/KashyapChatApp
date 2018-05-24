package com.kashyap.kashyapchatapp.ui.activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.kashyap.kashyapchatapp.R;
import com.kashyap.kashyapchatapp.ui.models.ChatModel;
import com.kashyap.kashyapchatapp.utils.Constants;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class SharedElementAnimation extends AppCompatActivity {


    ImageView profileAvatar;
    ChatModel mChatModel;

    public void onCreate(Bundle savedStateInstance) {
        super.onCreate(savedStateInstance);

        setContentView(R.layout.activity_shared_element_transistion);
        initView();
        Bundle extras = getIntent().getExtras();

        mChatModel = (ChatModel) extras.get(Constants.CHAT_MODEL_KEY);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String imageTransitionName = extras.getString(Constants.SharedElementTransistionKey);
            profileAvatar.setTransitionName(imageTransitionName);
        }
        findViewById(R.id.options_layout).setVisibility(View.INVISIBLE);
        Picasso.get()
                .load(R.drawable.default_profile_picture)
                .noFade()
                .into(profileAvatar, new Callback() {
                    @Override
                    public void onSuccess() {
                        findViewById(R.id.options_layout).setVisibility(View.VISIBLE);
                        supportStartPostponedEnterTransition();
                    }

                    @Override
                    public void onError(Exception e) {
                        supportStartPostponedEnterTransition();

                    }


                });
        profileAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        findViewById(R.id.rootLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        findViewById(R.id.ic_chat_icon_imageview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                Intent intent = ChatActivity.getIntentWithNewTask(SharedElementAnimation.this);
                intent.putExtra(Constants.CHAT_MODEL_KEY, mChatModel);
                startActivity(intent);


            }
        });

    }

    private void initView() {
        profileAvatar = findViewById(R.id.activity_shared_element_transistion_imageview);
    }


    public void onBackPressed() {
        findViewById(R.id.options_layout).setVisibility(View.INVISIBLE);
        supportFinishAfterTransition();
        super.onBackPressed();

    }
}
