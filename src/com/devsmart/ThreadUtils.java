package com.devsmart;

import android.content.Context;
import android.os.Handler;

public class ThreadUtils {

	
	private Handler mMainThread;

	public ThreadUtils(Context context) {

		mMainThread = new Handler();
	}
}
