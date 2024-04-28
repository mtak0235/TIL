package immutable.address;


public class MemberV1 {
    private String nam;
    private Address address;

    public MemberV1(String name, Address address) {
        this.nam = name;
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "MemberV1{" +
                "nam='" + nam + '\'' +
                ", address=" + address +
                '}';
    }
}
