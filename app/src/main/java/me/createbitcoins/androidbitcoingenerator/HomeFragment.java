package me.createbitcoins.androidbitcoingenerator;

import static android.content.DialogInterface.*;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

import org.json.JSONObject;

/* loaded from: classes.dex */
public class HomeFragment extends Fragment implements View.OnClickListener {
    private static HomeFragment homeFragmentRunningInstance;
    EditText btcAddr;

    /* renamed from: pd */
    ProgressDialog f52pd;

    /* renamed from: pg */
    ProgressBar f53pg;
    TextView txtJson;
    final Handler handler = new Handler();
    NetworkStateBroadcastReceiver networkStateBroadcastReceiver = new NetworkStateBroadcastReceiver();
    private final Runnable shortDelay = new Runnable() { // from class: me.createbitcoins.androidbitcoingenerator.HomeFragment.1
        @Override // java.lang.Runnable
        public void run() {
            HomeFragment.this.f53pg.setProgress(60);
            HomeFragment.this.showAlertDialog();
        }
    };
    private final Runnable afterDelay = new Runnable() { // from class: me.createbitcoins.androidbitcoingenerator.HomeFragment.2
        @Override // java.lang.Runnable
        public void run() {
            HomeFragment.this.handler.postDelayed(HomeFragment.this.shortDelay, 2000L);
            HomeFragment.this.f53pg.setProgress(45);
        }
    };

    public void buttonClicked(View view) {
    }

    public static HomeFragment getInstace() {
        return homeFragmentRunningInstance;
    }

    public static boolean isNetworkAvailable(Context context) {
        NetworkInfo[] allNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (!(connectivityManager == null || (allNetworkInfo = connectivityManager.getAllNetworkInfo()) == null)) {
            for (NetworkInfo networkInfo : allNetworkInfo) {
                if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        homeFragmentRunningInstance = this;
        getContext().registerReceiver(this.networkStateBroadcastReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        new JsonTask().execute("https://api.coindesk.com/v1/bpi/currentprice.json");
        View inflate = layoutInflater.inflate(C0458R.layout.fragment_home, viewGroup, false);
        this.f53pg = inflate.findViewById(C0458R.C0460id.progressBar);
        this.txtJson = inflate.findViewById(C0458R.C0460id.priceview);
        this.btcAddr = inflate.findViewById(C0458R.C0460id.editText);
        inflate.findViewById(C0458R.C0460id.button).setOnClickListener(this);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        getContext().unregisterReceiver(this.networkStateBroadcastReceiver);
    }

    public void updateUI(final String str, final int i) {
        getActivity().runOnUiThread(new Runnable() { // from class: me.createbitcoins.androidbitcoingenerator.HomeFragment.3
            @Override // java.lang.Runnable
            public void run() {
                TextView textView = HomeFragment.this.getView().findViewById(C0458R.C0460id.internetstatus);
                textView.setText(str);
                textView.setTextColor(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Incorrect Unique ID !!!");
        builder.setCancelable(true);
        builder.setMessage(getResources().getString(C0458R.string.alert_message));
        // from class: me.createbitcoins.androidbitcoingenerator.HomeFragment.4
// android.content.DialogInterface.OnClickListener
        builder.setPositiveButton("Yes", (dialogInterface, i) -> HomeFragment.this.launchSendemail());
        builder.setNegativeButton("Cancel", null);
        builder.show();
    }

    private void showMustbuyAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Incorrect Unique ID !!!");
        builder.setCancelable(true);
        // from class: me.createbitcoins.androidbitcoingenerator.HomeFragment.5
// android.content.DialogInterface.OnClickListener
        builder.setMessage(getResources().getString(C0458R.string.alert_message_one)).setPositiveButton("Exit", (dialogInterface, i) -> {
            Objects.requireNonNull(HomeFragment.this.getActivity()).moveTaskToBack(true);
            Process.killProcess(Process.myPid());
            System.exit(1);
        });
        // from class: me.createbitcoins.androidbitcoingenerator.HomeFragment.6
// android.content.DialogInterface.OnClickListener
        builder.setNegativeButton("Pay", (dialogInterface, i) -> HomeFragment.this.getFragmentManager().beginTransaction().replace(C0458R.C0460id.fragment_container, new ContactFragment()).commit());
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void launchSendemail() {
        String string = getResources().getString(C0458R.string.emailbody);
        Intent intent = new Intent("android.intent.action.SENDTO");
        intent.setData(Uri.parse("mailto:adamkhader187@gmail.com"));
        intent.putExtra("android.intent.extra.SUBJECT", "To Buy Unique ID for Android Bitcoin Generator");
        intent.putExtra("android.intent.extra.TEXT", string);
        startActivity(intent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == C0458R.C0460id.button) {
            if (this.f53pg.getProgress() == 60) {
                showMustbuyAlertDialog();
                return;
            }
            if (this.btcAddr.getText().toString().trim().length() <= 24 && !isNetworkAvailable(getContext())) {
                this.btcAddr.setError("Enter a valid address so you can receive your bitcoins");
                Toast.makeText(getContext(), "You must be connected to the internet before you can generate btc", 1).show();
            }
            if (TextUtils.isEmpty(this.btcAddr.getText()) || this.btcAddr.getText().toString().trim().length() <= 24) {
                this.btcAddr.setError("Enter a valid address so you can receive your bitcoins");
            } else if (isNetworkAvailable(getContext())) {
                this.f53pg.setProgress(25);
                this.handler.postDelayed(this.afterDelay, 3000L);
            } else {
                Toast.makeText(getContext(), "You must be connected to the internet before you can generate btc", 1).show();
            }
        }
    }

    /* loaded from: classes.dex */
    @SuppressLint("StaticFieldLeak")
    private class JsonTask extends AsyncTask<String, String, String> {
        private int strArr;

        public JsonTask() {
        }

        @Override
        protected String doInBackground(String... strings) {
            return null;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            HomeFragment homeFragment = HomeFragment.this;
            homeFragment.f52pd = new ProgressDialog(homeFragment.getActivity());
            HomeFragment.this.f52pd.setMessage("Initializing");
            HomeFragment.this.f52pd.setCancelable(false);
            HomeFragment.this.f52pd.show();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r8v1, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r8v11, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r8v3, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r8v4 */
        /* JADX WARN: Type inference failed for: r8v5, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r8v6 */
        /* JADX WARN: Type inference failed for: r8v8 */
        @Nullable
        public String doInBackground(int strArr) {
            this.strArr = strArr;
            Throwable th;
            BufferedReader bufferedReader2;
            MalformedURLException e;
            IOException e2;
            try {
                BufferedReader bufferedReader;
                try {
                    try {
                        strArr = (HttpURLConnection) new URL(strArr[0]).openConnection();
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    try {
                        strArr.connect();
                        bufferedReader2 = new BufferedReader(new InputStreamReader(strArr.getInputStream()));
                        try {
                            StringBuilder stringBuffer = new StringBuilder();
                            while (true) {
                                String readLine = bufferedReader2.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                stringBuffer.append(readLine).append("\n");
                                Log.d("Response: ", "> " + readLine);
                            }
                            String stringBuffer2 = stringBuffer.toString();
                            if (strArr != 0) {
                                strArr.disconnect();
                            }
                            try {
                                bufferedReader2.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                            return stringBuffer2;
                        } catch (MalformedURLException e4) {
                            e = e4;
                            e.printStackTrace();
                            if (strArr != 0) {
                                strArr.disconnect();
                            }
                            bufferedReader2.close();
                            return null;
                        } catch (IOException e5) {
                            e2 = e5;
                            e2.printStackTrace();
                            if (strArr != 0) {
                                strArr.disconnect();
                            }
                            bufferedReader2.close();
                            return null;
                        }
                    } catch (MalformedURLException e6) {
                        e = e6;
                        bufferedReader2 = null;
                    } catch (IOException e7) {
                        e2 = e7;
                        bufferedReader2 = null;
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedReader = null;
                        if (strArr != 0) {
                            strArr.disconnect();
                        }
                        throw th;
                    }
                } catch (MalformedURLException e9) {
                    e = e9;
                    strArr = 0;
                    bufferedReader2 = null;
                } catch (IOException e10) {
                    e2 = e10;
                    strArr = 0;
                    bufferedReader2 = null;
                } catch (Throwable th4) {
                    th = th4;
                    bufferedReader = null;
                    strArr = 0;
                }
            } catch (IOException e11) {
                e11.printStackTrace();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            if (HomeFragment.this.f52pd.isShowing()) {
                HomeFragment.this.f52pd.dismiss();
            }
            try {
                StringBuilder sb = new StringBuilder();
                JSONObject jSONObject = new JSONObject(str).getJSONObject("bpi").getJSONObject("USD");
                sb.append("$");
                sb.append(jSONObject.getString("rate"));
                HomeFragment.this.txtJson.setText(sb.toString());
            } catch (Exception unused) {
                unused.printStackTrace();
            }
        }
    }
}
