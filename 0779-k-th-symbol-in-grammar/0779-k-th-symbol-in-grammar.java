class Solution {
    public int kthGrammar(int n, int k) {
      

        // Base condition
        if (n == 1) {
            return 0;
        }

        int length = 1 << (n - 1);
        int half = length / 2;

        // k is in the first half
        if (k <= half) {
            return kthGrammar(n - 1, k);
        }

        // k is in the second half
        return 1 - kthGrammar(n - 1, k - half);
    }

        
    
}