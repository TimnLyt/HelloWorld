package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.helloworld.models.OnGetDataListener;
import com.example.helloworld.viewmodels.FirebaseHelloWorldViewModel;

public class SimpleFirebaseExample extends AppCompatActivity {

    private FirebaseHelloWorldViewModel vm;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frag2_layout);
        vm = new FirebaseHelloWorldViewModel();

        textView = findViewById(R.id.crazy);

        vm.getHelloWorld(new OnGetDataListener<String>() {
            @Override
            public void onSuccess(String dataResponse) {
                textView.setText(dataResponse);
            }

            @Override
            public void onFailure() {
                System.out.println("Looks like some error happened when we tried to get helloWorld");
            }
        });
    }

    @Override
    protected void onPause() {
        vm.clear();
        super.onPause();
    }
}