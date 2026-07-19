class Solution {
    public ArrayList<Integer> sortBySetBitCount(int[] arr) {
        List<List<Integer>> buckets = new ArrayList<>(32);
        for (int i = 0; i < 32; i++) {
            buckets.add(new ArrayList<>());
        }
        for (int num : arr) {
            int count = Integer.bitCount(num);
            buckets.get(count).add(num);
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 31; i >= 0; i--) {
            for (int num : buckets.get(i)) {
                result.add(num);
            }
        }
        return result;
    }
}
