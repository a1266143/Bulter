How to
==
To get a Git project into your build:

Step 1. Add the JitPack repository to your build file
-

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}Copy
Step 2. Add the dependency
-
	dependencies {
	        
		compile 'com.github.a1266143:Bulter:V1.0.*'

	}
“—”–µƒ“¿¿µø‚
-
    compile 'com.android.support:appcompat-v7:25.3.1'
    compile 'com.jakewharton:butterknife:8.6.0'
    annotationProcessor 'com.jakewharton:butterknife-compiler:8.6.0'
    compile 'com.zhy:okhttputils:2.6.2'
    compile 'com.google.code.gson:gson:2.2.4'
    compile 'org.greenrobot:greendao:3.2.2'
    compile 'com.google.dagger:dagger:2.11'
    annotationProcessor 'com.google.dagger:dagger-compiler:2.11'