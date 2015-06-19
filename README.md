# Android Aspects

This library provides a lightweight mechanism for adding functionality to **Activities**, **Fragments** and **Applications** without modifying their source code, by using annotations.

Objects extending from **AspectActivity**, **AspectFragmentActivity**, **AspectFragment**, **AspectSupportFragment** and **AspectApplication**, can apply the **Aspects** annotation and provide a list of classes, called *aspects,* that add functionality at runtime.

For example, this is how an Aspect providing multidex functionality to the Application would look like:

### Example

*MultidexAspect.java*
```java
public class MultidexAspect extends NoOpApplicationAspect {
    @Override
    public void attachBaseContext(AspectApplication application, Context base) {
        MultiDex.install(application);
    }
}
```
*SampleApplication.java*
```java
@Aspects(aspects = MultidexAspect.class}
public class SampleApplication extends AspectApplication {
    // no custom code added for multidex here. 
    // This class inherits the behaviour of the aspect automatically
}
```

Custom aspect annotations can be created as well, for ease of reusability and for customization (aspects are inherited):

*Multidex.java*
```java
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Aspects(aspects = MultidexAspect.class}
public @interface Multidex {
}
```
*SampleApplication.java*
```java
@Multidex
public class SampleApplication extends AspectApplication {
    // same as before
}
```

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

License
----

Apache 2.0

