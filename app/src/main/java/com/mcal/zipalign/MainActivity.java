package com.mcal.zipalign;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.widget.Toast;
import com.mcal.zipalign.utils.ZipAligner;
import java.io.File;

public class MainActivity extends Activity {
	String path = Environment.getExternalStorageDirectory() + "/Android";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		if (Build.VERSION.SDK_INT >= 23) {
			if (checkSelfPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Settings.ACTION_MANAGE_OVERLAY_PERMISSION) != PackageManager.PERMISSION_GRANTED) {
				requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Settings.ACTION_MANAGE_OVERLAY_PERMISSION}, 1);
			}
		}
		zipAlign(new File(path + "/app.apk"));
    }
	
	@SuppressLint("WrongConstant")
    public void zipAlign(final File file) {
        new Thread(new Runnable() {
			@Override
			public void run() {
				if(ZipAligner.isZipAligned(file.toString())) {
					showToast("Apk aligned");
					return;
				}
				boolean b = ZipAligner.ZipAlign(file.toString(),
											  file.toString().substring(0, file.toString().length() - 4) + "-aligned"
											  + file.toString().substring(file.toString().length() - 4));
				if(b)
					showToast("Aligned apk completed");
				else
					showToast("Aligned apk failed");
			}
		}).start();
    }
	
	public void showToast(final String msg) {
        this.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
			}
		});
    }
}
