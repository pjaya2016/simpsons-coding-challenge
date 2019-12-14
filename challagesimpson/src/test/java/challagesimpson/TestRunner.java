package challagesimpson;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
  public static void main(String[] args) {
    Result result = JUnitCore.runClasses(TestCharacterUtil.class);
    for (Failure failure : result.getFailures()) {
      System.out.println(failure.toString());
    }
    
    Result result2 = JUnitCore.runClasses(TestPharaseUtil.class);
    for (Failure failure : result.getFailures()) {
      System.out.println(failure.toString());
    }
  }
}
