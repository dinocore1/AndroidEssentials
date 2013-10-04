LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)
  
# Build all java files in the java subdirectory
LOCAL_SRC_FILES := $(call all-java-files-under, src)

# Any libraries that this library depends on
LOCAL_JAVA_LIBRARIES := libandroidsupport

# The name of the jar file to create
LOCAL_MODULE := com.devsmart.android.essentials

# Build a static jar file.
include $(BUILD_STATIC_JAVA_LIBRARY)