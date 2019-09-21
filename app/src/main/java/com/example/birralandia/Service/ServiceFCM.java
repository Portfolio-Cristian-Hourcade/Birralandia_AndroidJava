package com.example.lavaderocolores.Service;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.lavaderocolores.MainActivity;
import com.example.lavaderocolores.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

import static com.firebase.ui.auth.ui.phone.SubmitConfirmationCodeFragment.TAG;

public class ServiceFCM {
    public void ServiceFCM(){}

    public static void getToken(){
        Log.e("ENTRO","ENTRO ACACAACAACACA");
        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if (!task.isSuccessful()) {
                            Log.e("", "getInstanceId failed");
                            return;
                        }

                        // Get new Instance ID token
                        String token = task.getResult().getToken();
                        Log.e("ras", ""+token);
                    }
                });

    }


}
