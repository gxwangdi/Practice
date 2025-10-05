
//Definition of ParentTreeNode:
class ParentTreeNode {
	public ParentTreeNode parent, left, right;
}

public class LowestCommonAncesterII {
	/**
	 * @param root
	 *            : The root of the tree
	 * @param A
	 *            , B: Two node in the tree
	 * @return: The lowest common ancestor of A and B
	 */
	public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root,
			ParentTreeNode A, ParentTreeNode B) {
		if (root == null || A == null || B == null) {
			return null;
		}
		ParentTreeNode cur = A;
		int aLen = 1;
		while (cur != null) {
			cur = cur.parent;
			aLen++;
		}
		cur = B;
		int bLen = 1;
		while (cur != null) {
			cur = cur.parent;
			bLen++;
		}
		ParentTreeNode longer;
		ParentTreeNode shorter;
		if (aLen >= bLen) {
			longer = A;
			shorter = B;
		} else {
			longer = B;
			shorter = A;
		}
		int diff = Math.abs(aLen - bLen);
		while (diff > 0) {
			longer = longer.parent;
			diff--;
		}
		while (shorter != null && longer != null && longer != shorter) {
			longer = longer.parent;
			shorter = shorter.parent;
		}
		if (longer == null || shorter == null) {
			return null;
		}
		return longer;
	}
}
