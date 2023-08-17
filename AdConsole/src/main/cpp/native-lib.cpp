#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring

Java_com_ads_data_Api_APIClient_fetchdatastring(JNIEnv *env, jclass clazz) {
    return env->NewStringUTF("https://uniqstarinfotech.com/");
}