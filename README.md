# android-code-view
A code viewer with code syntax highlight for Android

# Install

If you are using gradle, add the following dependency to your build.gradle file:

compile 'com.github.chen0040:android-code-view:1.0.1'

If you are using maven, add the following dependency to your POM file.
```xml
<dependency>
  <groupId>com.github.chen0040</groupId>
  <artifactId>android-code-view</artifactId>
  <version>1.0.1</version>
  <type>aar</type>
</dependency>
```

# Usage

Include the following in your Android layout.xml file:

```xml
<com.github.chen0040.androidcodeview.SourceCodeView
android:id="@+id/codeViewer"
android:layout_width="match_parent"
android:layout_height="match_parent"
/>
```

To load some java code in the codeViewer for display, add the following code in your android Activity or Fragment:
 
```java
import com.github.chen0040.androidcodeview.SourceCodeView;

SourceCodeView codeView = (SourceCodeView)mainView.findViewById(R.id.codeViewer);
String javaSource="public class Program {\n\tpublic static void main(String[] args) { \n\t\tSystem.out.println(\"Hello World\"); \n }";
codeView.setCode(javaSource, "java");
```

