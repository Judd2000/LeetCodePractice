package combinationsum;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    List<List<Integer>> uniqueCandidates;

    int[] candidates;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        uniqueCandidates = new ArrayList<>();
        this.candidates = candidates;
        backtrack(0, target, new ArrayList<>());
        return uniqueCandidates;
    }

    private void backtrack(int start, int target, List<Integer> currPath) {
        if (target == 0) {
            uniqueCandidates.add(currPath);
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < this.candidates.length; i++) {
            List<Integer> newPath = new ArrayList<>(currPath);
            newPath.add(candidates[i]);
            backtrack(i, target - this.candidates[i], newPath);
        }
    }
}
