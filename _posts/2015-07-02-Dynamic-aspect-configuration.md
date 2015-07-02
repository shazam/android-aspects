---
layout: default
title: Dynamic aspect configuration
---

## Dynamic aspect configuration

The aspect examples shown in [Custom aspect annotations]({% post_url 2015-07-03-Custom-aspect-annotations %}) were a bit more useful than the ones shown in [Getting Started]({% post_url 2015-07-04-Getting-started %}), but there are many cases where a more dynamic configuration is required.

For example, the analytics aspect has no way of adding extra parameters that are determined dynamically, after some piece of information is fetched from the network for example.

This is where *dynamic aspect configuration* comes in handy. To configure an aspect dynamically, apart from the custom annotation defined in the previous example, a new **Interface** is required as well. For example:

{% highlight java %}
public class AnalyticsActivityAspect extends NoOpActivityAspect {
  private Page page;

  public void onCreate(Activity activity, Bundle savedInstanceState) {
    page = findPageFromAnnotation(activity);
    allowObjectToConfigurePage(page, activity);
  }
  public void onStart(Activity activity) {
    // does some analytics initialization
  }
  public void onStop(Activity activity) {
    // does some analytics tear down using page object (name and extra parameters)
  }
  private Page findPageFromAnnotation(Object annotatedObject) {
    WithPageView annotation annotatedObject.getClass().getAnnotation(WithPageView.class);
    return annotation.page();
  }
  private void allowObjectToConfigurePage(Page page, Object object) {
    if (object instanceof PageConfiguration) {
      ((PageConfiguration)object).configure(page);
    }
  }
}

public interface PageConfiguration {
  void configure(Page page);
}

public interface Page {
  String getPageName();
  Map<String, String> getParams();
}

@Documented
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
@Aspects(aspects = {AnalyticsActivityAspect.class})
public @interface WithPageView {
  Page page();
}
{% endhighlight %}

Allowing an **Activity** to dynamically configure the page is now very simple:

{% highlight java %}
@WithPageView(page = MyPage.class)
public class MyActivity extends AspectActivity implements PageConfiguration {

  public void onStart() {
    loadASongFromTheInternet();
  }
  public void onSongLoaded(Song song) {
    page.addParam("songName", song.getName());
  }
  public void configure(Page page) {
    this.page = page;
  }
}

public class MyPage implements Page {
  private Map<String, String> params = new HashMap<>();
  public String getPageName() {
    return "my_page";
  }
  public void addParam(String key, String value) {
    params.add(key, value);
  }
  public Map<String, String> getParams() {
    return params;
  }
}
{% endhighlight %}

What happens here is a bit more involved. The aspect retrieves a **Page** object like in the before example where it retrieved the page name as a string. Then it allows the annotated object to configure that page object if it implements a specific interface (**PageConfiguration**).

The activity implements said interface, so it receives a call to the **configure()** method. In this specific example, the data from the network haven't been loaded yet, so it holds on to the page object. When the **Song** is fetched from the network, it puts any needed extra parameters to the **Page** object.

The aspect will use that **Page** object when the activity stops (via the **onStop()** callback) to send the appropriate analytics event, which will now contain the dynamically loaded parameter **songName**.
