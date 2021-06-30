package app;

import java.io.IOException;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws IOException, InterruptedException {
    String defaultEmail = "playtech@1secmail.com";
    System.out.println(EmailLookup.getEmailsFromAddress(defaultEmail));
  }

}
