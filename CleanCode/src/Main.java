import java.util.ArrayList;
import java.util.List;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
	public static void main(String[] args) {
		int d;

		int elapsedTimeInDays;
		int daysSinceCreation;
	}
	public List<int[]> getThem() {
		List<int[]> list1 = new ArrayList<int[]>();
		for (int[] x : theList) {
			if (x[0] == 4)
				list1.add(x);
		}
		return list1;
	}
	public List<int[]> getFlaggedCells() {
		List<int[]> flaggedCells = new ArrayList<>();
		for (int[] cell : gameBoard) {
			if (cell[STATUS_VALUE] == FLAGGED)
				flaggedCells.add(cell);
		}
		return flaggedCells;
	}

	public List<Cell> getFlaggedCells() {
		List<Cell> flaggedCells = new ArrayList<>();
		for (Cell cell : gameBoard) {
			if (cell.isFlagged())
				flaggedCells.add(cell);
		}
		return flaggedCells;
	}
}
