package me.createbitcoins.androidbitcoingenerator;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.widget.Toast;

/* loaded from: classes.dex */
public class NetworkStateBroadcastReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            return;
        }
        if (intent.getBooleanExtra("noConnectivity", false)) {
            HomeFragment.getInstace().updateUI(" Disconnected", Color.parseColor("#FF0000"));
            return;
        }
        Toast.makeText(context, "Injection Service available.", 1).show();
        HomeFragment.getInstace().updateUI(" Online", Color.parseColor("#09FB10"));
    }
}
