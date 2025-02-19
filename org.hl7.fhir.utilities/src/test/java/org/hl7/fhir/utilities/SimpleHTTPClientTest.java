package org.hl7.fhir.utilities;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimpleHTTPClientTest {
  @Test
  public void testSimpleHTTPClient() throws IOException {

    SimpleHTTPClient http = new SimpleHTTPClient();
    String url = "https://hl7.org/fhir/us/core/package-list.json?nocache=" + System.currentTimeMillis();

    SimpleHTTPClient.HTTPResult res = http.get(url, "application/json");

//    System.out.println(res.getCode());
//    System.out.println(new String(res.getContent(), StandardCharsets.UTF_8));
    assertTrue(res.getCode() != 400);
  }
}