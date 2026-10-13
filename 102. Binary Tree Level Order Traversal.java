class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();

            for (int i = q.size(); i > 0; i--) {
                TreeNode n = q.poll();
                level.add(n.val);

                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
            }

            ans.add(level);
        }
        return ans;
    }
}
