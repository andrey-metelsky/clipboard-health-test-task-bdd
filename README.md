# Test Assignment for the Senior Automation QA position at the Clipboard Health project 

This is [BDD](https://cucumber.io/docs/bdd/) test project for UI automated testing of **https://www.amazon.in/**.

This automation framework consists of:

* JAVA 1.8
* Serenity BDD ([official online Serenity documentation source](https://serenity-bdd.github.io/theserenitybook/latest/index.html)):
  * Serenity – 3.3.0
  * Serenity Cucumber6 – 3.3.0
* Maven:
  * Maven Surefire Plugin – 3.0.0-M5
  * Maven Failsafe Plugin – 3.0.0-M5
  * Maven Compiler Plugin – 3.8.1


## How to install
Prerequisites : 
* JDK 1.8 or higher https://www.java.com/en/download/
* IDE (Eclipse, IntelliJ, etc) https://www.jetbrains.com/idea/download/
* Maven https://maven.apache.org/download.cgi

1. Clone project from https://gitlab.com/metelsky.andrey/leaseplan-be
2. Import dependencies (in IntelliJ IDEA: right-click on the *pom.xml*->Maven->Reload Project)

## How to run tests?
There are several options:
* from cmd with Maven command:
  * to run all scenarios and generate Serenity report:  *cd to/the/project/directory*, run *mvn clean verify*;
  * to run all scenarios in the feature file: *mvn integration-test -Dcucumber.filter.tags="@RunThisFeature"*, where *@RunThisFeature* is a tag placed on top of the feature file;
  * to run a single scenario: *mvn integration-test -Dcucumber.filter.tags="@RunThisTest"*, where *@RunThisTest* is a tag placed on top of the specific scenario; 
* from IDE, for example from IntelliJ IDEA: 
  * to run a single test: right-click on the scenario in the *.feature* file->Run;
  * all tests: right-click on the *runners/AmazonRunner*->Run
* or run GitLab pipeline in the CI/CD->Pipelines, and found html report by clicking on the job name in the Jobs section, and then click Browse in the Job Artifacts in the right menu;

## How to write new tests?
1. Create new feature file in the *src/test/resources/features*;
2. Write new scenarios in the feature file in the BDD format using Gherkin syntax. (https://cucumber.io/docs/gherkin/);
3. Create new step definitions file in the *src/test/java/com/clipboardhealth/stepdefinitions/frontend*;
4. Create new page object java class which the *src/test/java/com/clipboardhealth/implementations/pages*;
5. Write step definitions for scenarios from the feature file, use page objects from previous step. Follow these links for more details: https://cucumber.io/docs/cucumber/step-definitions/ and https://cucumber.io/docs/gherkin/step-organization/;
6. Add new feature file to the @CucumberOptions/features in the existing runner *src/test/java/com/clipboardhealth/runners/AmazonRunner.java*, or create new runner in the same folder;

## How to generate report
1. Run "aggregate" task of the serenity-maven-plugin;
2. Find generated report *clipboard-health-test-task/target/site/serenity/index.html*;