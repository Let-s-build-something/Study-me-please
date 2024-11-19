# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

##---------------Begin: proguard configuration for Gson  ----------
# Gson uses generic type information stored in a class file when working with fields. Proguard
# removes such information by default, so configure it to keep all of it.
-keepattributes Signature

# For using GSON @Expose annotation
-keepattributes *Annotation*

# Gson specific classes
-keep class sun.misc.Unsafe { *; }

# Application classes that will be serialized/deserialized over Gson
-keep class com.google.gson.examples.android.model.** { *; }
-keep class com.google.common.collect.stream.** { *; }
# Keep AutoValue Memoized classes
-keep class com.google.auto.value.extension.memoized.** { *; }
-dontwarn com.google.auto.value.extension.memoized.**
# Keep Guava Streams classes
-keep class com.google.common.collect.Streams { *; }
-dontwarn com.google.common.collect.**
# Keep KotlinPoet JavaPoet Interop classes
-keep class com.squareup.kotlinpoet.javapoet.** { *; }
-dontwarn com.squareup.kotlinpoet.javapoet.**



-keep class study.me.please.data.** { *; }
-keep class study.me.please.ui.units.** { *; }
-keep class study.me.please.ui.session.** { *; }
-keep class study.me.please.ui.components.** { *; }
-keep class study.me.please.data.io.** { *; }
-keep class study.me.please.data.io.*
-keep class study.me.please.base.navigation.** { *; }
-keep class * implements com.google.gson.TypeAdapterFactory
-keep class * implements com.google.gson.JsonSerializer
-keep class * implements com.google.gson.JsonDeserializer

-keepclassmembers enum * { *; }
-keep class com.google.code.gson.* { *; }
-keepattributes *Annotation*, Signature, Exception
-keepclassmembers,allowobfuscation class * {
  @com.google.gson.annotations.SerializedName <fields>;
}
-keep @com.google.auto.service.AutoService class * { *; }
-keepnames class com.google.auto.service.**
-dontwarn com.google.auto.service.**

# Keep javax.lang.model classes
-keep class javax.lang.model.** { *; }
-dontwarn javax.lang.model.**

# Keep javax.tools for diagnostics and processing
-keep class javax.tools.** { *; }
-dontwarn javax.tools.**

# Keep Annotation Processing utilities
-keep class javax.annotation.processing.** { *; }
-dontwarn javax.annotation.processing.**

-keep class * extends androidx.room.RoomDatabase
-keep @androidx.room.Entity class *
-dontwarn androidx.room.paging.**

-if class androidx.credentials.CredentialManager
-keep class androidx.credentials.playservices.** {
  *;
}

##---------------End: proguard configuration for Gson  ----------