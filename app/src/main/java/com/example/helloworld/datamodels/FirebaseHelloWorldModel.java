package com.example.helloworld.datamodels;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.ListenerRegistration;

import java.util.ArrayList;
import java.util.List;

public class FirebaseHelloWorldModel {

    private FirebaseFirestore db;
    private List<ListenerRegistration> listeners;

    public FirebaseHelloWorldModel() {
        db = FirebaseFirestore.getInstance();
        listeners = new ArrayList<>();
    }

    public void getHelloWorld(EventListener<DocumentSnapshot> viewModelCallback) {
        DocumentReference helloWorldRef = db.collection("matches").document("helloWorld");
        ListenerRegistration registration = helloWorldRef.addSnapshotListener(viewModelCallback);
        listeners.add(registration);
    }

    public void clear() {
        listeners.forEach(ListenerRegistration::remove);
    }

}