package nested.nested.ex1;

import java.sql.SQLOutput;

public class NetworkMessage {
  private String contents;

  public NetworkMessage(String contents) {
    this.contents = contents;
  }

  public void print() {
    System.out.println(contents);
  }
}
