package extends1.ex;

public class Movie extends Item {
    String director;
    String actor;

    public Movie(String name, int price, String director, String actor) {
        super(name, price);
        this.director = director;
        this.actor = actor;
    }

    @Override
    public void print() {
        super.print();
        System.out.println(String.format("감독:%s\t, 배우:%s\t", director, actor));
    }

}
