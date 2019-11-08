#include "ZipAlign.h"
#include <zipalign/zipalign.h>
#include <cstdlib>

extern "C"
JNIEXPORT jboolean JNICALL Java_com_mcal_zipalign_utils_ZipAligner_ZipAlign
(JNIEnv *env, jclass cls, jstring str1, jstring str2) {
    const char *s1 = env->GetStringUTFChars(str1, nullptr);
    const char *s2 = env->GetStringUTFChars(str2, nullptr);
    if (zipalign(s1, s2, 9, 0) != 1) return JNI_FALSE;
    else return JNI_TRUE;
}

extern "C"
JNIEXPORT jboolean JNICALL Java_com_mcal_zipalign_utils_ZipAligner_isZipAligned
(JNIEnv *env, jclass cls, jstring str) {
    const char *s = env->GetStringUTFChars(str, nullptr);
    if(zipalign_is_aligned(s, 9) == 1) return JNI_TRUE;
    else return JNI_FALSE;
}
