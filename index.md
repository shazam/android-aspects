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

The library provides a lightweight mechanism for adding functionality to **Activities**, **Fragments** and **Applications** without modifying their source code, by using annotations.

Objects extending from **AspectActivity**, **AspectFragmentActivity**, **AspectAppCompatActivity**, **AspectFragment**, **AspectSupportFragment** and **AspectApplication**, can apply the **Aspects** annotation and
provide a list of classes, called *aspects*, that add functionality at runtime.

For example, this is how an **Aspect** providing *multidex* functionality to the
**Application** would look like:

#### Example

*MultidexAspect.java*
{% highlight java %}
public class MultidexAspect extends NoOpApplicationAspect {
    @Override
    public void attachBaseContext(AspectApplication application, Context base) {
        MultiDex.install(application);
    }
}
{% endhighlight %}

*SampleApplication.java*
{% highlight java %}
@Aspects(aspects = MultidexAspect.class}
public class SampleApplication extends AspectApplication {
    // no custom code added for multidex here.
    // This class inherits the behaviour of the aspect automatically
}
{% endhighlight %}

Custom aspect annotations can be created as well, for ease of reusability and for customization (aspects are inherited):

*Multidex.java*
{% highlight java %}
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Aspects(aspects = MultidexAspect.class}
public @interface Multidex {
}
{% endhighlight %}

*SampleApplication.java*
{% highlight java %}
@Multidex
public class SampleApplication extends AspectApplication {
    // same as before
}
{% endhighlight %}

## Installation

Note that, for now, the library is not published on a public repository like Maven Central, but will be very shortly. In the meantime you can either include it in your project as a simple module, or you can install it in a local repository by doing:

{% highlight sh %}
$ git clone https://github.com/shazam/android-aspects.git
$ cd android-aspects
$ ./gradlew clean uploadArchives -PSNAPSHOT_REPOSITORY_URL="file:///{path_to_your_local)/.m2"
{% endhighlight %}

and then include it in your dependencies:

{% highlight groovy %}
compile 'com.shazam.android:aspects:1.0.0-SNAPSHOT'
{% endhighlight %}

note that you will also need to add your local repository to your list of repositories, since the android plugin will cause the default mavenLocal() repository to point to the one provided by the Android sdk:

{% highlight groovy %}
repositories {
    maven { url "${System.env.HOME}/.m2" }
}
{% endhighlight %}
