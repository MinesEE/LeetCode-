// 187. Repeated DNA Sequences
// All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
// 
// Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
// 
// Example:
// 
// Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
// 
// Output: ["AAAAACCCCC", "CCCCCAAAAA"]
class HashTable187 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<String>();
        
        if (s.length() <= 10) return list;
        
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        
        int pos = 0;
        while (pos <= s.length() - 10) {
            String temp = s.substring(pos, pos + 10);
            if (hashMap.containsKey(temp)) {
               if (list.contains(temp)) {
                   pos++;
                   continue;
               } else list.add(temp);
            } else {
                hashMap.put(temp, pos);
            }
            pos++;
        }
        return list;
    }
}