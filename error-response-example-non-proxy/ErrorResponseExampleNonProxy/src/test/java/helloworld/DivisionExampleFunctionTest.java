package helloworld;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.appsdeveloperblog.aws.errorresponse.lambda.DivisionExampleFunction;
import org.junit.Test;

public class DivisionExampleFunctionTest {
/*  @Test
  public void successfulResponse() {
    DivisionExampleFunction divisionExampleFunction = new DivisionExampleFunction();
    APIGatewayProxyResponseEvent result = divisionExampleFunction.handleRequest(null, null);
    assertEquals(200, result.getStatusCode().intValue());
    assertEquals("application/json", result.getHeaders().get("Content-Type"));
    String content = result.getBody();
    assertNotNull(content);
    assertTrue(content.contains("\"message\""));
    assertTrue(content.contains("\"hello world\""));
    assertTrue(content.contains("\"location\""));
  }*/
}
