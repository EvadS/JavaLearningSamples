

#include "JniTest.h"
 
JNIEXPORT jint JNICALL Java_JniTest_showString(JNIEnv * jenv, jobject jobj, jstring message)
{
  const char *string = jenv->GetStringUTFChars(message, 0);
  printf("%s\n",string);
  jenv->ReleaseStringUTFChars(message, string);
 
  return 0;
}
