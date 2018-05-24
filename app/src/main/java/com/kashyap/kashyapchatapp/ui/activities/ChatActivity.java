package com.kashyap.kashyapchatapp.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.kashyap.kashyapchatapp.R;
import com.kashyap.kashyapchatapp.ui.fragments.chatItem.ChatItemFragment;
import com.kashyap.kashyapchatapp.ui.models.ChatModel;
import com.kashyap.kashyapchatapp.utils.*;

public class ChatActivity extends AppCompatActivity {

    public static Intent getIntent(Context context) {
        return new Intent(context, ChatActivity.class);
    }

    public static Intent getIntentWithNewTask(Context context) {
        Intent intent = getIntent(context);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        Intent intent = getIntent();
        if (intent != null && intent.getExtras() != null) {
            Bundle bundle = intent.getExtras();
            ChatModel chatModel = (ChatModel) bundle.get(Constants.CHAT_MODEL_KEY);
            Log.i("ChatKey",""+chatModel.getId());
            setFragmentOnUI(chatModel);
        }
    }

    private void setFragmentOnUI(ChatModel chatModel) {
        Fragment fragment = ChatItemFragment.newInstance(chatModel);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_layout, fragment, fragment.getClass().getSimpleName())
                .commit();
    }

}
