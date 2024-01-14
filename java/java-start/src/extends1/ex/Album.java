package extends1.ex;

public class Album extends Item {
    String artist;

    public Album(String album, int price, String artist) {
        super(album, price);
        this.artist = artist;
    }

    @Override
    public void print() {
        super.print();
        System.out.println(String.format("- 아티스트:%s\t", artist));

    }
}
