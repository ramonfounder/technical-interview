public class MaximumNumberVowels {
    public static void main(String[] args) {
        MaximumNumberVowels maximumNumberVowels = new MaximumNumberVowels();

        // Test case 1
        String s1 = "abciiidef";
        int k1 = 3;
        System.out.println(maximumNumberVowels.maxVowels(s1, k1)); // Output: 3

        // Test case 2
        String s2 = "aeiou";
        int k2 = 2;
        System.out.println(maximumNumberVowels.maxVowels(s2, k2)); // Output: 2

        // Test case 3
        String s3 = "leetcode";
        int k3 = 3;
        System.out.println(maximumNumberVowels.maxVowels(s3, k3)); // Output: 2
    }

    public int maxVowels(String s, int k) {
        int maxVowels = 0;
        int currentVowels = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i < k) {
                if (isVowel(s.charAt(i))) {
                    currentVowels++;
                }
            } else {
                if (isVowel(s.charAt(i))) {
                    currentVowels++;
                }
                if (isVowel(s.charAt(i - k))) {
                    currentVowels--;
                }
            }
            maxVowels = Math.max(maxVowels, currentVowels);
        }
        return maxVowels;
    }

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}

