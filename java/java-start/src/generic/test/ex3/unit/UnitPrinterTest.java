package generic.test.ex3.unit;

public class UnitPrinterTest {
	public static void main(String[] args) {
		Shuttle<BioUnit> shuttle = new Shuttle<>();
		shuttle.in(new Marine("마린", 40));
		Shuttle<BioUnit> shuttle1 = new Shuttle<>();
		shuttle1.in(new Zergling("저글링", 35));
		Shuttle<BioUnit> shuttle2 = new Shuttle<>();
		shuttle2.in(new Zealot("질럿", 100));

		UnitPrinter.printV1(shuttle);
		UnitPrinter.printV2(shuttle);

	}
}
