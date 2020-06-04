package com.example.coen268project.Presentation;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.example.coen268project.Firebase.CallBack;
import com.example.coen268project.Firebase.FirebaseRepository;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class Utility extends FirebaseRepository {
    private StorageReference storageReference;
    private static String currentUserId;

    public Utility()
    {
        storageReference = FirebaseStorage.getInstance().getReference();
    }

    public static enum ItemStatus
    {
        POSTED,
        SOLD,
        BOOKED
    }

    public static enum CommunicationType
    {
        TEXT,
        AUDIO,
        VIDEO
    }

    public static enum BillingStatus
    {
        PENDING,
        DELIVERED,
        RECEIVED
    }

    public static enum Category
    {
        CATEGORY1("Sofa and Dining"),
        CATEGORY2("Bed and Wardrobes"),
        CATEGORY3("Home Decor and Garden"),
        CATEGORY4("Kids Furniture"),
        CATEGORY5("Other Household Items");

        private final String name;

        Category(String s) {
            name = s;
        }

        public boolean equalsName(String otherName) {
            return name.equals(otherName);
        }

        public String toString() {
            return this.name;
        }

        public static String[] toArray() {
            ArrayList<String> categoryArray = new ArrayList<>();
            for (Category category: Category.values()
                 ) {
                    categoryArray.add(category.name);
            }
            return  categoryArray.toArray(new String[0]);
        }
    }

    public static String getCurrentUserId() {
        return "HShwnTE38jNhhTZTczkfj3CAJmK2";
    }

    public static void setCurrentUserId(String currentUserId) {
        Utility.currentUserId = currentUserId;
    }

    public void uploadImageToStorage(String name, Uri contentUri, final CallBack callBack){
        firebaseUploadImageToStorage(storageReference, name, contentUri, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                callBack.onSuccess(object);
            }

            @Override
            public void onError(Object object) {
                callBack.onError(object);
            }
        },getCurrentUserId());
    }

    public StorageReference getProfilePicture(final String pictureName)
    {
        StorageReference images = storageReference.child("images/");
        final StorageReference[] reference = new StorageReference[1];
        images.listAll()
                .addOnSuccessListener(new OnSuccessListener<ListResult>() {
                    @Override
                    public void onSuccess(ListResult listResult) {
                        for (StorageReference item : listResult.getItems()) {
                          if(item.getName().equals(pictureName)) {

                              reference[0] = FirebaseStorage.getInstance().getReference().child(item.getPath());
                          }
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                    }
                });

                /*Glide.with(this)
                .load(storageReference)
                .into(image);*/
            return reference[0];
    }

    public void getItemPicture(final String pictureName, final CallBack callback) {
        StorageReference images = storageReference.child("images/");
        final StorageReference[] reference = new StorageReference[1];
        images.listAll()
                .addOnSuccessListener(new OnSuccessListener<ListResult>() {
                    @Override
                    public void onSuccess(ListResult listResult) {
                        for (StorageReference item : listResult.getItems()) {
                            if (item.getName().equals(pictureName)) {
                                reference[0] = FirebaseStorage.getInstance().getReference().child(item.getPath());
                            }
                        }
                        callback.onSuccess(reference[0]);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        callback.onError(null);
                    }
                });

                /*Glide.with(this)
                .load(storageReference)
                .into(image);*/
    }
}
