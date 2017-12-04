public class ProblemSolver {
	public static void permutation(String str) { 
	    permutation("", str); 
	}
	private static void permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0) {
	    	if(Integer.parseInt(prefix.substring(0,3)) + Integer.parseInt(prefix.substring(3,6)) == Integer.parseInt(prefix.substring(6,9))) {
	    		System.out.println(prefix.substring(0,3) + "+" + prefix.substring(3,6) + "=" + prefix.substring(6,9));
	    	}
	    }
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}
	public static void main(String[] args) {
		permutation("123456789");
	}
}