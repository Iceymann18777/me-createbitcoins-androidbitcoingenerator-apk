package androidx.core.p003os;

import android.os.Build;
import android.os.Handler;
import android.os.Message;

/* renamed from: androidx.core.os.HandlerCompat */
/* loaded from: classes.dex */
public final class HandlerCompat {
    public static boolean postDelayed(Handler handler, Runnable runnable, Object obj, long j) {
        if (Build.VERSION.SDK_INT >= 28) {
            return handler.postDelayed(runnable, obj, j);
        }
        Message obtain = Message.obtain(handler, runnable);
        obtain.obj = obj;
        return handler.sendMessageDelayed(obtain, j);
    }

    private HandlerCompat() {
    }
}
