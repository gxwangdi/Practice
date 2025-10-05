/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Cousinsinbinarytree {
    public int findDepth(TreeNode node, int x)
    {
        int depth = -1;

        if(node == null)
        {
            return depth;
        }
        if( (node.val == x) || (depth = findDepth(node.left,x ))>=0 ||(depth = findDepth(node.right,x ))>=0)
        {
            depth =  depth +1;
        }
        return depth;
        }


    public TreeNode parent(TreeNode node, int x)
    {
        TreeNode temp = null;
        if(node == null)
        {
            return temp;
        }
        if ( (node.left!=null && node.left.val ==x) ||  (node.right!=null && node.right.val ==x) )
        {
            temp = node;
        }
        else
        {
           temp =  parent(node.left, x)!=null ? parent(node.left, x) : parent(node.right, x);
        }
        return temp;
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        return ((findDepth(root, x)==findDepth(root, y)) && !(parent(root, x) == parent(root, y)));
    }
//     public boolean isCousins(TreeNode root, int x, int y) {
//         if(root == null) return false;

//         Queue<TreeNode> q = new LinkedList<>();
//         q.add(root);

//         while(!q.isEmpty()){

//             int size = q.size();
//             boolean foundX = false, foundY=false;
//              // loop through nodes on same level
//             for(int i=0; i<size; i++){

//                 TreeNode node = q.poll();

//                 if(node.val == x)
//                     foundX = true;
//                 else if(node.val == y)
//                     foundY = true;

//                 // found both
//                 if(foundX && foundY)
//                     return true;

//                 if(node.left != null)
//                     q.add(node.left);
//                 if(node.right != null)
//                     q.add(node.right);
//                 // check x and y are not siblings
//                 if(node.left != null && node.right != null){
//                     if((node.left.val == x && node.right.val == y)
//                        || (node.left.val == y && node.right.val == x))
//                         return false;
//                 }
//             }
//             // if one found in currentl level, no need to find second as they are not going to be cousins
//             if(foundX != foundY)
//                 return false;
//         }
//             return false;
//     }


//     public boolean isCousins(TreeNode root, int x, int y) {
//         if (root.val == x || root.val == y) {
//             return false;
//         }
//         return getDepth(root, x, y, 0) == -2;
//     }

//     // return -2 for isCousins underneath, -1 for not found any, positive num for finding one.
//     private int getDepth(TreeNode node, int x, int y, int depth) {
//         if (node == null) {
//             return -1;
//         }
//         if (node.val == x || node.val == y) {
//             return depth;
//         }
//         int left = getDepth(node.left, x, y, depth+1);
//         int right = getDepth(node.right, x, y, depth+1);
//         if (left == right) {
//             if (left == 1) {
//                 return -1;
//             } if (left == -1) {
//                 return -1;
//             } else {
//                 return -2;
//             }
//         }
//         if (left == -2 || right == -2) {
//             return -2;
//         }
//         if (left > 0) {
//             return left;
//         }
//         return right;
//     }
}
