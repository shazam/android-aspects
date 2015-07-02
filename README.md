# Android Aspects

### Have you ever had to extend multiple Activities?

This library provides a lightweight mechanism for adding functionality to **Activities**, **Fragments** and **Applications** without modifying their source code, by using annotations.

It allows you to do cool things like:

#### Example

```java
@WithPageView(pageName = "my_page_name")
@WithAd(siteId = 65168)
public class MyActivity extends AspectActivity {
    // no custom code written, but activity has ads and analytics behaviour
}
```

For more information on how this can be achieved, visit the project site at [http://shazam.github.io/android-aspects/](http://shazam.github.io/android-aspects/)

### Version
1.0.0-SNAPSHOT

### Installation

Note that, for now, the library is not published on a public repository like Maven Central, but will be very shortly. In the meantime you can either include it in your project as a simple module, or you can install it in a local repository by doing:

```sh
$ git clone https://github.com/shazam/android-aspects.git
$ cd android-aspects
$ ./gradlew clean uploadArchives -PSNAPSHOT_REPOSITORY_URL="file:///{path_to_your_local)/.m2"
```
and then include it in your dependencies:

```groovy
compile 'com.shazam.android:aspects:1.0.0-SNAPSHOT'
```

note that you will also need to add your local repository to your list of repositories, since the android plugin will cause the default mavenLocal() repository to point to the one provided by the Android sdk:

```groovy
repositories {
    maven { url "${System.env.HOME}/.m2" }
}
```

License
----

Apache 2.0
