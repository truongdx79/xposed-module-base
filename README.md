1.  Trong AndroidManifests  
    thẻ meta-data xposedminversion để giá trị 82 cho các dòng máy có api level \< 27 và 93 cho api level > 27

*   cụ thể cấu hình build cho 93  
    `defaultConfig {`  
    `applicationId "com.example.myone"`  
    `minSdk 28`  
    `targetSdk 33`  
    `versionCode 1`  
    `versionName "1.0"`  
    `}`
*   cụ thể cấu hình build cho 82  
    `defaultConfig {`  
    `applicationId "com.example.myone"`  
    `minSdk 21`  
    `targetSdk 26`  
    `versionCode 1`  
    `versionName "1.0"`  
    `}`

1.  Thiết lập Module trong LSPosed khi chọn app nào thì checked app đó.  
    Ví dụ: Chọn checked app device info HW & Facebook

\--> điều này sẽ tác động đến việc hàm handleLoadPackage sẽ lắng nghe các app được checked bên trên khi các app loaded.  
`public class XposedMain implements IXposedHookLoadPackage {`  
`@Override`  
`public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {`  
`XposedBridge.log("PACKAGE-NAME: "+lpparam.packageName);`  
`}`  
}

\====================  
Tham khảo  
https://github.com/rovo89/XposedBridge/wiki/Development-tutorial  
https://github.com/LSPosed/LSPosed/wiki/New-XSharedPreferences
