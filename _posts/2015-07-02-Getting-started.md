---
layout: default
title: Getting started
---

## Getting started

It all begins by extending one of the Aspect base classes:

* AspectActivity
* AspectAppCompatActivity
* AspectFragmentActivity
* AspectFragment
* AspectDialogFragment
* AspectSupportFragment
* AspectSupportDialogFragment

By extending one of these classes, you can use the **@Aspects** annotation to attach *aspects*. The annotation take a list of aspects like so:


{% highlight java %}
@Aspects(aspects = {SomeAspect.class, AnotherAspect.class})
public class ExampleActivity extends AspectActivity {
}
{% endhighlight %}
