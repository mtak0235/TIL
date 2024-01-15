package class1;

public class MovieReview {
    String title;
    String contents;

    @Override
    public String toString() {
        return "영화 제목:"  + title + ',' +
                "\t리뷰:" + contents;
    }
}
