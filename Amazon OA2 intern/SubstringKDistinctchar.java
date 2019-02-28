class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		List<String> result = subStringsLessKDist( "awaglkawaglk", 4);
		if( result.size() == 0 )
			System.out.println("No result");
 
		for( int i = 0; i < result.size(); i++){
			System.out.println(result.get(i));
		}
	}
 
	public static List<String> subStringsLessKDist(String inputString, int num)
	{
		if (inputString == null || inputString.length() == 0)
			return new ArrayList<>();
 
		Set<String> res = new HashSet<>();
		int[] table = new int[26];
		int len = inputString.length();
		if (len < num) return new ArrayList<>();
			int count = 0;
 
		int idx = 0;
		for (idx = 0; idx < len; idx++) {
			if (idx >= num) {
				if (count == num - 1) {
					res.add(inputString.substring(idx - num, idx));
				}	
 
				if (--table[inputString.charAt(idx - num) - 'a'] == 0) {
					count--;
				}
 
			}
 
			if (table[inputString.charAt(idx) - 'a']++ == 0) {
				count++;
			}
		}
 
		if (count == num - 1)
			res.add(inputString.substring(idx - num, idx));
 
		return new ArrayList<String>(res);
	}
 // METHOD SIGNATURE ENDS
 }
