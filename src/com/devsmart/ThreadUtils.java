package com.devsmart;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadUtils {

	
	public static final ExecutorService sIOThreads = Executors.newCachedThreadPool();
}
