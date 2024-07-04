package generic.test.ex3;

public class AnimalHospitalV2<T> {
    private T animal;

    public void set(T animal) {
        this.animal = animal;
    }

    public void checkup() {
        /**
         * compile err
         */
//        System.out.println("동물 이름: " + animal.getName());
//        System.out.println("동물 크기: " + animal.getSize());
//        animal.sound();
    }

    public T bigger(T target) {
//        return animal.getSize() > target.getSize() ? animal : target; compile err
        return null;
    }
}
