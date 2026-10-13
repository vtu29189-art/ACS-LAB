class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    private void dfs(TreeNode node, int depth, List<Integer> result) {
        if (node == null) {
            return;
        }

        // If visiting this depth for the first time, add the node value
        if (depth == result.size()) {
            result.add(node.val);
        }

        // Traverse right branch first, then left
        dfs(node.right, depth + 1, result);
        dfs(node.left, depth + 1, result);
    }
}