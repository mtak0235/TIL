package immutable.address;


public class MemberV2 {
    private String nam;
    private ImmutableAddress address;

    public MemberV2(String name, ImmutableAddress address) {
        this.nam = name;
        this.address = address;
    }

    public ImmutableAddress getAddress() {
        return address;
    }

    public void setAddress(ImmutableAddress address) {
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
