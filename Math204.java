// 204. Count Primes
// Count the number of prime numbers less than a non-negative number, n.
// 
// Example:
// 
// Input: 10
// Output: 4
// Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

class Math204 {
    public int countPrimes(int n) {
        if (n <= 1) return 0;
        if (n == 2) return 0;
        
        if (isPrime( n - 1)) {
            return 1 + countPrimes(n - 1);
        } else {
            return countPrimes(n - 1);
        }
    }
    
    private boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
// basic solution 
// class Math204 {
//     public int countPrimes(int n) {
//         if (n <= 1) return 0;
//         
//         int count = 0;
//         for (int i = 2; i < n; i++) {
//             if (isPrime(i)) count++;
//         }
//         return count;
//     }
//     
//     private boolean isPrime(int n) {
//         for (int i = 2; i <= Math.sqrt(n); i++) {
//             if (n % i == 0) {
//                 return false;
//             }
//         }
//         return true;
//     }
// }