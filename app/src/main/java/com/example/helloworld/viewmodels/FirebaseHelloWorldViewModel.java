package com.example.helloworld.viewmodels;

import androidx.annotation.Nullable;

import com.example.helloworld.datamodels.FirebaseHelloWorldModel;
import com.example.helloworld.models.OnGetDataListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.Map;
import java.util.function.Consumer;

public class FirebaseHelloWorldViewModel {

    private FirebaseHelloWorldModel model;

    public FirebaseHelloWorldViewModel() {
        model = new FirebaseHelloWorldModel();
    }

    public void getHelloWorld(OnGetDataListener<String> activityCallback) {
        model.getHelloWorld((queryDocumentSnapshots, e) -> {
            if (e != null) {
                System.out.println("Error reading Hello World: " + e);
                activityCallback.onFailure();
                return;
            }

            if (queryDocumentSnapshots != null) {
                Map<String, Object> data = queryDocumentSnapshots.getData();
                if (data != null) {
                    Object helloWorld = data.get("helloWorld");
                    if (helloWorld != null) {
                        String value = helloWorld.toString();
                        activityCallback.onSuccess(value);
                    }
                }
            }
        });

    }

    public void clear() {
        model.clear();
    }
}