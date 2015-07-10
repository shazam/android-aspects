---
layout: default
---

## Have you ever had to extend multiple Activities?

A common occurrence in the Android ecosystem is the requirement to extend a
custom class (usually an **Activity**) to inherit the behavior of some library.
This leads to a problem, when 2 or more libraries are needed, and they both
have a custom Activity that needs to be extended.

*android-aspects* aims, not only to solve this problem, but
make the implementation of cross cutting concerns in your app easy to
implement and maintain.

It allows you to do cool things like:

{% highlight java %}
@WithPageView(pageName = "my_page_name")
@WithAd(siteId = 65168)
public class MyActivity extends AspectActivity {
    // no custom code written, but activity has ads and analytics behaviour
}
{% endhighlight %}

read on to find out how this can be achieved.

### Introduction

The library provides a lightweight mechanism for adding functionality to **Activities**, **Fragments** and **Applications** without modifying their source code, by using annotations.

Objects extending from **AspectActivity**, **AspectFragmentActivity**, **AspectAppCompatActivity**, **AspectFragment**, **AspectSupportFragment** and **AspectApplication**, can apply the **Aspects** annotation and
provide a list of classes, called *aspects*, that add functionality at runtime.

For example, this is how an **Aspect** providing *multidex* functionality to the
**Application** would look:

#### Example

*MultidexAspect.java*
{% highlight java %}
public class MultidexAspect extends NoOpApplicationAspect {
    @Override
    public void attachBaseContext(AspectApplication application, Context base) {
        MultiDex.install(application);
    }
}

@Aspects(aspects = MultidexAspect.class}
public class SampleApplication extends AspectApplication {
    // no custom code added for multidex here.
    // This class gets the behaviour of the aspect automatically
}
{% endhighlight %}

Custom aspect annotations can be created as well, for ease of reuse and for customization (aspects are inherited):

{% highlight java %}
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Aspects(aspects = MultidexAspect.class}
public @interface Multidex {
}

@Multidex
public class SampleApplication extends AspectApplication {
    // same as before
}
{% endhighlight %}

### Installation

The library is published on Maven Central. To use it, include this in your dependencies:

{% highlight groovy %}
compile 'com.shazam.android:aspects:1.0.0'
{% endhighlight %}

note that you will also need to have Maven Central to your list of repositories:

{% highlight groovy %}
repositories {
    mavenCentral()
}
{% endhighlight %}
