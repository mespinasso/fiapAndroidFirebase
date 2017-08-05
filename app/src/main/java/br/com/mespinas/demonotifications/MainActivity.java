package br.com.mespinas.demonotifications;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.crashlytics.android.Crashlytics;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.FirebaseMessaging;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {

    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Fabric.with(this, new Crashlytics());

        setContentView(R.layout.activity_main);

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        FirebaseMessaging.getInstance().subscribeToTopic("mob");
    }

    //Habilitar o degug view do Firebase:
    // C:\opensource\Android_SDK\sdk\platform-tools\adb shell setprop debug.firebase.analytics.app br.com.mespinas.demonotifications.MainActivity

    public void clickMe(View v) {
        Bundle params = new Bundle();
        params.putString("NOME", "Matheus");
        mFirebaseAnalytics.logEvent("clickMe", params);
    }

    public void forcarCrash(View v) throws Exception {
        throw new Exception("Crash!");
    }
}
