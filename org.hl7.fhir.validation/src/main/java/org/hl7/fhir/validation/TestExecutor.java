package org.hl7.fhir.validation;

import com.google.common.reflect.ClassPath;
import org.apache.commons.collections.ArrayStack;
import org.hl7.fhir.utilities.tests.BaseTestingUtilities;
import org.junit.platform.console.options.CommandLineOptions;
import org.junit.platform.console.tasks.ConsoleTestExecutor;
import org.junit.platform.launcher.listeners.TestExecutionSummary;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.*;
import java.security.ProtectionDomain;
import java.util.*;
import java.util.stream.Collectors;

public class TestExecutor {

  public static void printJunitClasses() {

    String classpath = System.getProperty("java.class.path");
    String[] classPathValues = classpath.split(File.pathSeparator);
    System.out.println(Arrays.toString(classPathValues));
    try {

    ClassLoader classLoader =org.junit.platform.commons.util.ClassLoaderUtils.getDefaultClassLoader();

      ClassPath classPath = ClassPath.from(classLoader);

      Set<ClassPath.ClassInfo> classes = classPath.getAllClasses();

      List<String> testClasses = classes.stream().filter(classInfo -> classInfo.getSimpleName().equals("Test") && classInfo.getPackageName().contains("junit"))
        .map(classInfo -> classInfo.getResourceName())
        .collect(Collectors.toList());

      for (String aClass : testClasses.stream().sorted().collect(Collectors.toList())) {
        String path = classLoader.getResource(aClass).toExternalForm();
        System.out.println(path);
      }

    }  catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static void exploreDiscoveryRequestBuilder(CommandLineOptions options) {

  }

  public static void main(String[] args) {
    executeTests();
  }
  public static void executeTests() {
    printJunitClasses();

    //System.setProperty("java.locale.providers", "COMPAT");

    System.out.println("env : " + System.getenv("java.locale.providers"));
    System.out.println("prop: " + System.getProperty("java.locale.providers"));

    PrintWriter out = new PrintWriter(System.out);
    PrintWriter err = new PrintWriter(System.err);

    //String dir = System.getenv(FHIR_TEST_CASES_ENV);
    //System.out.println("FHIR Test Cases Directory: " + dir);

    CommandLineOptions clo = new CommandLineOptions();

    BaseTestingUtilities.setFhirTestCasesDirectory("/Users/david.otasek/IN/2021-12-02-fhir-test-cases-by-directory/fhir-test-cases");


    clo.setScanClasspath(true);

    Path myNewPath = null;

    myNewPath = Paths.get("/Users/david.otasek/IdeaProjects/org.hl7.fhir.core/org.hl7.fhir.validation/target/org.hl7.fhir.validation-5.6.46-SNAPSHOT-tests.jar");

    if(!Files.exists(myNewPath, new LinkOption[0])) {
      throw new RuntimeException("BLAH");
    }

    clo.setAdditionalClasspathEntries(Arrays.asList(myNewPath));
    //clo.setSelectedPackages(Arrays.asList(XhtmlParserTests.class.getPackage().getName()));

    clo.setIncludedEngines(Arrays.asList("junit-vintage","junit-jupiter"));
    //clo.setExcludedPackages(Arrays.asList("org.hl7.fhir.r4.test"));
    //clo.setIncludedPackages(Arrays.asList("org.hl7.fhir.validation.tests"));
    try {
      ConsoleTestExecutor cte = new ConsoleTestExecutor(clo);

      exploreDiscoveryRequestBuilder(clo);

      TestExecutionSummary testExecutionSummary = cte.execute(out);

      // A System.exit is necessary because some okhttp3 mockwebserver tests leave threads running for a considerable
      // amount of time beyond the end of all other tests.
      System.exit(0);
    } catch (Exception exception) {
      exception.printStackTrace();
      System.err.println();
    }
  }

  private static void printClassPath() {
    ClassLoader cl = ClassLoader.getSystemClassLoader();

    URL[] urls = ((URLClassLoader)cl).getURLs();

    for(URL url: urls){
      System.out.println(url.getFile());
    }
  }

}
