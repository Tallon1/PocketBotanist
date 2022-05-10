package com.java.pocketbotanist.utils;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class FirebaseConstants {
    public static final StorageReference FIREBASE_IMAGE_REFERENCE = FirebaseStorage.getInstance()
            .getReference().child("plant_images");
}