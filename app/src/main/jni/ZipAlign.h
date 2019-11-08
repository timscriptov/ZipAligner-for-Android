#include <jni.h>

#ifndef _Included_com_mcal_zipalign_utils_ZipAlign
#define _Included_com_mcal_zipalign_utils_ZipAlign
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     com_mcal_zipalign_utils_ZipAlign
 * Method:    ZipAlign
 * Signature: (Ljava/lang/String;Ljava/lang/String;)Z
 */
JNIEXPORT jboolean JNICALL Java_com_mcal_zipalign_utils_ZipAligner_ZipAlign
(JNIEnv *, jclass, jstring, jstring);

/*
 * Class:     com_mcal_zipalign_utils_ZipAlign
 * Method:    isZipAligned
 * Signature: (Ljava/lang/String;)Z
 */
JNIEXPORT jboolean JNICALL Java_com_mcal_zipalign_utils_ZipAligner_isZipAligned
(JNIEnv *, jclass, jstring);

#ifdef __cplusplus
}
#endif
#endif
