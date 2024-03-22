import java.util.ArrayList;
import java.util.List;

public class CandyProblem {

    public static void main(String[] args) {
        CandyProblem candyProblem = new CandyProblem();

        // Test case 1
        int[] candies1 = {2, 3, 5, 1, 3};
        int extraCandies1 = 3;
        System.out.println(candyProblem.kidsWithCandies(candies1, extraCandies1));

        // Test case 2
        int[] candies2 = {4, 2, 1, 1, 2};
        int extraCandies2 = 1;
        System.out.println(candyProblem.kidsWithCandies(candies2, extraCandies2));

        // Test case 3
        int[] candies3 = {12, 1, 12};
        int extraCandies3 = 10;
        System.out.println(candyProblem.kidsWithCandies(candies3, extraCandies3));
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = 0;
        for (int candy : candies) {
            if (candy > maxCandies) {
                maxCandies = candy;
            }
        }

        List<Boolean> result = new ArrayList<>();
        for (int candy : candies) {
            result.add(candy + extraCandies >= maxCandies);
        }

        return result;
    }
}
