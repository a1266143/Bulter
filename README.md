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
	}
Step 2. Add the dependency
-
	dependencies {
	        
		compile 'com.github.a1266143:Bulter:V1.0.*'

	}


Already have dependencies below
-
    compile 'com.android.support:appcompat-v7:25.3.1'
    compile 'com.zhy:okhttputils:2.6.2'
    compile 'com.google.code.gson:gson:2.2.4'
