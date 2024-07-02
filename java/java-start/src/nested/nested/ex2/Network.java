package nested.nested.ex2;

public class Network {
  private static class NetworkMessage {
    private String contents;

    public NetworkMessage(String contents) {
      this.contents = contents;
    }

    public void print() {
      System.out.println(contents);
    }
  }
  public void sendMessage(String text) {
    NetworkMessage networkMessage = new NetworkMessage(text);
    networkMessage.print();
  }

}
