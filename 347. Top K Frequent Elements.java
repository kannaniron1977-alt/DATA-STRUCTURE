class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums)
            map.put(n, map.getOrDefault(n, 0) + 1);

        return map.entrySet().stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .limit(k)
                .mapToInt(e -> e.getKey())
                .toArray();
    }
}
