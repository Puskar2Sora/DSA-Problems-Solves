class Solution {
    public ArrayList<String> generateIp(String s) {
        ArrayList<String> res = new ArrayList<>();
        int n = s.length();
        if (n < 4 || n > 12) return res;
        for (int i = 1; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    String s1 = s.substring(0, i);
                    String s2 = s.substring(i, j);
                    String s3 = s.substring(j, k);
                    String s4 = s.substring(k);

                    if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
                        res.add(s1 + "." + s2 + "." + s3 + "." + s4);
                    }
                }
            }
        }
        return res;
    }
    private boolean isValid(String seg) {
        if (seg.length() > 3 || seg.isEmpty() || (seg.charAt(0) == '0' && seg.length() > 1)) {
            return false;
        }
        int val = Integer.parseInt(seg);
        return val >= 0 && val <= 255;
    }
}