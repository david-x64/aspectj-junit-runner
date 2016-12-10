# aspectj-junit-runner
Allows AspectJ Weaving of the class(es) under test at loadtime.

[Download JAR](https://github.com/david-888/aspectj-junit-runner/tree/master/dist/aspectj-junit-runner-0.0.1.jar "aspectj-junit-runner-0.0.1.jar")

To enable AspectJ load time weaving place this annotation on your test class:

    @RunWith(AspectJUnit4Runner.class)

Optionally you may want to add something to your classpath for a specific test class.
This is maybe the case if you want to put a ``META-INF/aop.xml`` file on the classpath for the test.
In this case use a combination of these two annotations on your test class:

    @RunWith(AspectJUnit4Runner.class)
    @AspectJConfig(classpathAdditions = "src/test/hello-resources")

You can also look at the example in the source directory under ``src/test/java``.
A very simple example can be found in the test sources in package ``eu.haobao.junit.aspectj.example``.

This JUnit Runner works out of the box in Eclipse and Gradle.
But if you run the tests with Maven you will probably have to configure the maven-surefire-plugin.
This works for me with Maven, but have a look at this [documentation](http://maven.apache.org/surefire/maven-surefire-plugin/examples/class-loading.html "Maven Surefire Documentation") too:

    <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-surefire-plugin</artifactId>
        <version>2.19.1</version>
        <configuration>
            <useSystemClassLoader>true</useSystemClassLoader>
            <useManifestOnlyJar>false</useManifestOnlyJar>
        </configuration>
    </plugin>

**Any feedback and improvements are welcome!**
