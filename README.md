<p># AutoValueGenerator Intellij plugin to generate the overhead code for Google AutoValue classes</p>
<h1>AutoValueGenerator</h1>
<p>This project creates an intellij generator plugin used to generate the overhead code for <a href="https://github.com/google/auto/tree/master/value">Goole's AutoValue</a> classes. The .zip file in the main directory can be imported in intellij as a plugin. In the future, if the project is more mature, the plugin will be added to the plugin repositories.</p>

Before:

```java
package exer_1_2;

/**
 * Created by jvanheijst on 12/8/16.
 */
public class JustAClass {

    int someInteger;
    String justAString;
    AnotherAtomicInteger anotherAtomicInteger;

    public boolean thisFunctionSaysFalse(){
        return false;
    }

}
```
Press the selected key combination:

![alt tag](https://raw.githubusercontent.com/jfvh/AutoValueGenerator/master/preview.png)



after:
```java

package exer_1_2;

 import com.google.auto.value.AutoValue;



 /**
  * Created by jvanheijst on 12/8/16.
  */
 @Autovalue
public abstract  class JustAClass {

 public abstract int someInteger();

 public abstract String justAString();

 public abstract AnotherAtomicInteger anotherAtomicInteger();

 public static Builder builder(){
    return new AutoValue_JustAClass.Builder();
}

@AutoValue.Builder
public abstract static class Builder {

public abstract Builder someInteger(int someInteger);

public abstract Builder justAString(String justAString);

public abstract Builder anotherAtomicInteger(AnotherAtomicInteger anotherAtomicInteger);

public abstract JustAClass build();

 }

     public boolean thisFunctionSaysFalse(){
         return false;
     }




 }
```




