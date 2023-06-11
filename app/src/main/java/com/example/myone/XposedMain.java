package com.example.myone;

import android.os.Build;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class XposedMain implements IXposedHookLoadPackage {
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        XposedBridge.log("PACKAGE-NAME: "+lpparam.packageName);
        XposedHelpers.setStaticObjectField(Build.class, "MODEL", "Hol-U19");
        XposedHelpers.setStaticObjectField(Build.class, "BRAND", "HUAWEI");
        XposedBridge.log("---------STATIC FIELD---------");
        String strFingerPrint = XposedHelpers.getStaticObjectField(Build.class,"FINGERPRINT").toString();
        XposedBridge.log("FINGERPRINT: " +strFingerPrint);
    }
}
