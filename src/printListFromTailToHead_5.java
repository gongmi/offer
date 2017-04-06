import java.util.ArrayList;

public class printListFromTailToHead_5 {
	ArrayList<Integer> res = new ArrayList<>();

	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		if (listNode != null) {
			printListFromTailToHead(listNode.next);
			res.add(listNode.val);
		}
		return res;
	}
}