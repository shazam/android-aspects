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
1.0.0

### Installation

The library is published on Maven Central. To use it, include this in your dependencies:

```groovy
compile 'com.shazam.android:aspects:1.0.0'
```

note that you will also need to have Maven Central to your list of repositories:

```groovy
repositories {
    mavenCentral()
}
```

License
----

Apache 2.0
