package lang.object.equals;

import java.util.Objects;

public class UserV2 {
    private String id;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        UserV2 userV2 = (UserV2) object;
        return Objects.equals(id, userV2.id);
//        UserV2 v2 = (UserV2) object;
//        return id.equals(v2.id);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hashCode(id);
//    }

    public UserV2(String id) {
        this.id = id;
    }
}
