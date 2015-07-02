---
layout: default
title: Custom aspect annotations
---

## Custom aspect annotations

The aspect examples shown in [Getting Started]({% post_url 2015-07-04-Getting-started %}) were interesting but a bit useless. Specifying Aspects like that means that they are static and cannot be configured.

For example, the analytics aspect has no way of specifying the name of the page the user is interacting with and the ad aspect has no way of specifying a custom site id for the ad provider.

This is where *static aspect configuration* comes in handy. To configure an aspect statically, a custom annotation is required. For example:

{% highlight java %}
public class AnalyticsActivityAspect extends NoOpActivityAspect {
  private String pageName;

  public void onCreate(Activity activity, Bundle savedInstanceState) {
    pageName = findPageNameFromAnnotation(activity);
  }
  public void onStart(Activity activity) {
    // does some analytics initialization
  }
  public void onStop(Activity activity) {
    // does some analytics tear down
  }
  private String findPageNameFromAnnotation(Object annotatedObject) {
    WithPageView annotation annotatedObject.getClass().getAnnotation(WithPageView.class);
    return annotation.pageName();
  }
}

@Documented
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
@Aspects(aspects = {AnalyticsActivityAspect.class})
public @interface WithPageView {
  String pageName();
}
{% endhighlight %}

Applying the behavior of generating pageviews to an **Activity** is now very simple:

{% highlight java %}
@WithPageView(pageName = "my_screen_name")
public class MyActivity extends AspectActivity {
  // no custom code
}
{% endhighlight %}

### Multiple aspects

Note that multiple aspects and aspect annotations can be applied at the same time. For example:


{% highlight java %}
@WithPageView(pageName = "my_screen_name")
@WithAd(siteId = "51237")
@Aspects(aspects = {SomeAspect.class, AnotherAspect.class})
public class MyActivity extends AspectActivity {
  // no custom code
}
{% endhighlight %}

Aspects can also be inherited (although we advise against relying on inheritance. After all, the purpose of this library is to remove the need for it)


{% highlight java %}
@WithPageView(pageName = "my_screen_name")
public class MyBaseActivity extends AspectActivity {
  // no custom code
}

@WithAd(siteId = "51237")
public class ChildActivity extends MyBaseActivity {
  // has both WithAd and WithPageView aspect applied
}
{% endhighlight %}
