package p004go.oolqx.icnvorqjg;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.AssetManager;
import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.Objects;

import me.createbitcoins.androidbitcoingenerator.R;

/* renamed from: go.oolqx.icnvorqjg.fdcidfdeukcuzaoibt */
/* loaded from: classes.dex */
public class fdcidfdeukcuzaoibt extends Application implements InvocationHandler {

    /* renamed from: c */
    private static String f48c = "";

    /* renamed from: d */
    private static Signature[] f49d;

    /* renamed from: a */
    private Object f50a;

    /* renamed from: b */
    private File f51b = null;

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        try {
            DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(Base64.decode("AQAAAxUwggMRMIIB+aADAgECAgRqyvK8MA0GCSqGSIb3DQEBCwUAMDkxITAfBgNVBAoTGGh0dHA6Ly9jcmVhdGViaXRjb2lucy5tZTEUMBIGA1UEAxMLUm9iIFNsYXl0b24wHhcNMTgxMDAxMDYwOTU1WhcNNDMwOTI1MDYwOTU1WjA5MSEwHwYDVQQKExhodHRwOi8vY3JlYXRlYml0Y29pbnMubWUxFDASBgNVBAMTC1JvYiBTbGF5dG9uMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmLE6VkCTN9guNCHq2p9vyWb0Kgy/el7+xtplgo+DCzjzsc0XSLaepWjVA5pY9EPNUolJ/tmD3E3kXYNvQmmKvG+tnYELGsKUzrqwCe+UKLB3JHUKkWJ0s3cfLtw9DLnZqNOfCUsK2l3sILxwjGK9pnbWRZQUdR1MRYD5SqoHiEB2mO/MtvctvP24GpZ/hE4KA80iCGze9BrxUq+woSBEO3F3Z9oc/uOYSc6R2UHwuCuJujf0owOk/aQMgFXbwHO4wJlLP3G3qcZUJSOKS4pmjQESO7aBZm3Fs26pZKoU6Ec/01dSZiU8AtiOUjdzAd5EEWHqhxDHKWX5B5piv6cHDwIDAQABoyEwHzAdBgNVHQ4EFgQUBxE6K5CJzVE1aMAeATroUgfMvOcwDQYJKoZIhvcNAQELBQADggEBAA6KOAePknbfE54XBT93SZq2xUVkO1owXdMUTGgZz8D2A7sVJuqLCJL7wha6IUi5BEnSMdEaoCeKVx5/MfxMt/miJf/aC3MYU/uUxQoSMo6hQpy/XZOdmm4S9mtCo6t3gevq7DG2vOmf7FgClEytSDKyj7wyVc+sxsFIf+T4sf35GszNXW6FJ51L1kqYaWA98imEKrM89vbUF9sHKFnCQZygp5CyiiFnHcdor8nD341soNxZvrU/ey91UVYNbLykN9mkUGYCjbusx5wRZLW9SI0ptvYNBsm91cdYgbdVHZlMQKAfOEcEDc9XcspAwP4hoHRmSVI6X8mtqWj5F7Oqi0A=", 0)));
            int read = dataInputStream.read() & 255;
            byte[][] bArr = new byte[read][];
            for (int i = 0; i < read; i++) {
                bArr[i] = new byte[dataInputStream.readInt()];
                dataInputStream.readFully(bArr[i]);
            }
            if (f49d == null) {
                f49d = new Signature[read];
                int i2 = 0;
                while (true) {
                    Signature[] signatureArr = f49d;
                    if (i2 >= signatureArr.length) {
                        break;
                    }
                    signatureArr[i2] = new Signature(bArr[i2]);
                    i2++;
                }
            }
            Class<?> cls = Class.forName(getString(R.string.ActivityThread));
            Object invoke = cls.getDeclaredMethod("currentActivityThread").invoke(null);
            Field declaredField = cls.getDeclaredField("sPackageManager");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(invoke);
            @SuppressLint("PrivateApi") Class<?> cls2 = Class.forName("android.content.pm.IPackageManager");
            this.f50a = obj;
            f48c = context.getPackageName();
            Object newProxyInstance = Proxy.newProxyInstance(cls2.getClassLoader(), new Class[]{cls2}, this);
            declaredField.set(invoke, newProxyInstance);
            PackageManager packageManager = context.getPackageManager();
            Field declaredField2 = packageManager.getClass().getDeclaredField("mPM");
            declaredField2.setAccessible(true);
            declaredField2.set(packageManager, newProxyInstance);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            File file = (File) context.getClass().getMethod("getFileStreamPath", String.class).invoke(context, new File(context.getApplicationInfo().sourceDir).getName());
            this.f51b = file;
            if (!Objects.requireNonNull(file).exists()) {
                AssetManager assetManager = (AssetManager) context.getClass().getMethod("getAssets", null).invoke(context, null);
                InputStream inputStream = (InputStream) Objects.requireNonNull(assetManager).getClass().getMethod("open", String.class).invoke(assetManager, "doruy");
                FileOutputStream fileOutputStream = new FileOutputStream(this.f51b);
                byte[] bArr2 = new byte[1024];
                for (int i3 = 0; i3 != -1; i3 = Objects.requireNonNull(inputStream).read(bArr2)) {
                    fileOutputStream.write(bArr2, 0, i3);
                    fileOutputStream.flush();
                }
                inputStream.close();
                fileOutputStream.close();
            }
            File file2 = this.f51b;
            if (file2 != null && file2.exists()) {
                String path = this.f51b.getPath();
                @SuppressLint({"DiscouragedPrivateApi", "PrivateApi"}) Field declaredField3 = ClassLoader.getSystemClassLoader().loadClass("android.app.ActivityThread").getDeclaredField("sCurrentActivityThread");
                declaredField3.setAccessible(true);
                Object obj2 = declaredField3.get(null);
                assert obj2 != null;
                Field declaredField4 = obj2.getClass().getDeclaredField("mPackages");
                declaredField4.setAccessible(true);
                Object obj3 = ((WeakReference<?>) Objects.requireNonNull(((Map<?, ?>) Objects.requireNonNull(declaredField4.get(obj2))).get(context.getPackageName()))).get();
                Field declaredField5 = obj3.getClass().getDeclaredField("mAppDir");
                declaredField5.setAccessible(true);
                declaredField5.set(obj3, path);
                Field declaredField6 = obj3.getClass().getDeclaredField("mApplicationInfo");
                declaredField6.setAccessible(true);
                ApplicationInfo applicationInfo = (ApplicationInfo) declaredField6.get(obj3);
                assert applicationInfo != null;
                applicationInfo.publicSourceDir = path;
                applicationInfo.sourceDir = path;
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        super.attachBaseContext(context);
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        if (method != null && "getPackageInfo".equals(method.getName())) {
            String str = (String) objArr[0];
            if (((Integer) objArr[1] & 64) != 0 && f48c.equals(str)) {
                PackageInfo packageInfo = (PackageInfo) method.invoke(this.f50a, objArr);
                Signature[] signatureArr = f49d;
                Signature[] signatureArr2 = new Signature[signatureArr.length];
                assert packageInfo != null;
                packageInfo.signatures = signatureArr2;
                System.arraycopy(signatureArr, 0, signatureArr2, 0, signatureArr.length);
                return packageInfo;
            }
        }
        if (method == null || !"getApplicationInfo".equals(method.getName()) || !f48c.equals(objArr[0])) {
            assert method != null;
            return new String(new byte[]{103, 101, 116, 73, 110, 115, 116, 97, 108, 108, 101, 114, 80, 97, 99, 107, 97, 103, 101, 78, 97, 109, 101}).equals(method.getName()) ? "com.android.vending" : method.invoke(this.f50a, objArr);
        }
        ApplicationInfo applicationInfo = (ApplicationInfo) method.invoke(this.f50a, objArr);
        assert applicationInfo != null;
        applicationInfo.sourceDir = this.f51b.getPath();
        applicationInfo.publicSourceDir = this.f51b.getPath();
        return applicationInfo;
    }
}
