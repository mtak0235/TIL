package collection.set.member;

public class MemberNoHashNoEq {
	private String id;

	public String getId() {
		return id;
	}

	public MemberNoHashNoEq(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "MemberNoHashNoEq{" +
			"id='" + id + '\'' +
			'}';
	}
}
