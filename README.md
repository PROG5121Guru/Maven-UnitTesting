# Automated Testing with Maven and GitHub Actions

This repository is set up to demonstrate automated testing using Maven and GitHub Actions.

[Youtube video on how to-do it](https://youtu.be/oz0Qd5H4Onk)


## Maven Configuration

To configure Maven for automated testing, add the following code segment to your `pom.xml` file:

```xml
<packaging>jar</packaging>
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>2.21.0</version>
            <dependencies>
                <dependency>
                    <groupId>org.junit.platform</groupId>
                    <artifactId>junit-platform-surefire-provider</artifactId>
                    <version>1.2.0-M1</version>
                </dependency>
                <dependency>
                    <groupId>org.junit.jupiter</groupId>
                    <artifactId>junit-jupiter-engine</artifactId>
                    <version>5.2.0-M1</version>
                </dependency>
            </dependencies>
        </plugin>
    </plugins>
</build>
<dependencies>
```

Make sure to replace any existing <build> and <dependencies> sections in your pom.xml with the provided code segment.

## GitHub Actions
To set up GitHub Actions for automated testing, follow these steps:

Navigate to the "Actions" tab in your GitHub repository.
Click on "Set up a workflow yourself" to create a new workflow file.
Add the following code to the workflow file:
yaml
Copy code
```xml

name: Maven Automated Testing


on:
  push:
  workflow_dispatch:

jobs:
  build:

    runs-on: ubuntu-latest

    steps:
      - name: Checkout
        uses: actions/checkout@v1

      - name: Set up JDK 1.11
        uses: actions/setup-java@v2
        with:
          java-version: '22'
          distribution: 'adopt'

      - name: Build
        run: mvn --batch-mode -DskipTests package

      - name: Test
        run: mvn --batch-mode -Dmaven.test.failure.ignore=true test
```

This workflow file specifies that whenever there is a push or pull request on the main branch, 

## GitHub Actions will:

Set up a 22 Java Development Kit (JDK) version . You might need to change this to match what is created when you build the project . This value is showed at the bottom of the .pom file
Build the project using Maven.
Run tests using Maven.
Feel free to modify the workflow file according to your specific requirements.

That's it! Your repository is now configured for automated testing with Maven and GitHub Actions.
