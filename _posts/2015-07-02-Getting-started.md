---
layout: default
title: Getting started
---

## Getting started

Even though the purpose of this library is to remove the complexity that comes with having to extend custom **Activities** or **Fragments**, it still has to work within the bounds of the Android system. Because of this, a custom **Activity** or **Fragment** needs to be extended. But, hopefully with this library, this will be the only one that you will ever need to extend.

It all begins by extending one of the Aspect base classes:

* **AspectActivity**
* **AspectAppCompatActivity**
* **AspectFragmentActivity**
* **AspectFragment**
* **AspectDialogFragment**
* **AspectSupportFragment**
* **AspectSupportDialogFragment**

Doing so allows you to use the **@Aspects** annotation to attach *aspects*. The annotation take a list of aspects like so:


{% highlight java %}
@Aspects(aspects = {SomeAspect.class, AnotherAspect.class})
public class ExampleActivity extends AspectActivity {
}
{% endhighlight %}

With this mechanism, behavior can be added to a class without having to use inheritance. This, in turn, solves the diamond problem that comes with inheritance and is the cause of much grief among Android developers when using third party libraries, or with in-house code that needs to be shared across many classes.

For instance, imagine the two following Activities:

{% highlight java %}
public class AdActivity extends Activity {
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    // does some ad initialization
  }
}

public class AnalyticsActivity extends Activity {
  public void onStart() {
    super.onStart();
    // does some analytics initialization
  }

  public void onStop() {
    super.onStop();
    // does some analytics tear down
  }
}
{% endhighlight %}

An **Activity** that needs to inherit both the advertising behavior and the analytics behavior is facing the diamond problem. It can't inherit from both, so it either needs to inherit from one and do the other's work manually, or inherit from none and do both.

Of course, in the real world, this would be solved by having the work of ads and analytics be done by collaborators that the **Activity** would get injected and delegate the callbacks to those.

The problem with this approach is duplication. Many activities in the system would most likely need both behaviors, and some of them would need only one. The code to delegate the **Activity** callbacks would have to be duplicated in all the activities.

With *android-aspects*, this problem is solved like this:

{% highlight java %}
public class AdActivityAspect extends NoOpActivityAspect {
  public void onCreate(Activity activity, Bundle savedInstanceState) {
    // does some ad initialization
  }
}

public class AnalyticsActivityAspect extends NoOpActivityAspect {
  public void onStart(Activity activity) {
    // does some analytics initialization
  }

  public void onStop(Activity activity) {
    // does some analytics tear down
  }
}

@Aspects(aspects = {AdActivityAspect.class, AnalyticsActivityAspect.class})
public class MyActivity extends AspectActivity {
  // no custom code written
}
{% endhighlight %}

Note that the **Activity** has NO code regarding analytics or ads. Both behaviors were applied with no change in the **Activity** code. (also note the absence of calls to **super** in the aspects. **Aspect** is an interface. Both aspects in this example extends a no-op implementation of that interface for brevity)
