package com.devsmart;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import android.os.Handler;
import android.os.Looper;

public abstract class BackgroundTask implements Runnable {

	public static Future<?> runBackgroundTask(BackgroundTask task, ExecutorService service){
		task.mMainThreadHandler = new Handler(Looper.getMainLooper());
		return service.submit(task);
	}

	private Handler mMainThreadHandler;

	public abstract void onBackground();

	public void onFinished() {}

	@Override
	public final void run() {
		try {
			onBackground();
		} finally {
			mMainThreadHandler.post(new Runnable(){

				@Override
				public void run() {
					onFinished();
				}
			});
		}

	}

}
