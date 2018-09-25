import java.util.Arrays;

/**
 * WordGram objects represent a k-gram of strings/words.
 * 
 * @author Zhecheng Sheng
 *
 */

public class WordGram {
	
	private String[] myWords;   
	private String myToString;  // cached string
	private int myHash;         // cached hash value

	/**
	 * Create WordGram (add comments)
	 * @param source
	 * @param start
	 * @param size
	 */
	public WordGram(String[] source, int start, int size) {
		myWords = new String[size];
		// TODO: initialize myWords and ...
		for(int i = 0;i < size;i++ ) {
			myWords[i] = source[start];
			start++;
		}
		myToString = null;
		myHash = 0;
	}

	/**
	 * Return string at specific index in this WordGram
	 * @param index in range [0..length() ) for string 
	 * @return string at index
	 */
	public String wordAt(int index) {
		if (index < 0 || index >= myWords.length) {
			throw new IndexOutOfBoundsException("bad index in wordAt "+index);
		}
		return myWords[index];
	}

	/**
	 * Return the order or the size of the WordGram
	 * @return
	 */
	public int length(){
		int k = this.myWords.length;
		return k;
	}


	@Override
	public boolean equals(Object o) {
		if (! (o instanceof WordGram) || o == null){
			return false;
		}

	    // TODO: complete this method

		WordGram wg = (WordGram) o;
		if(myWords.length == wg.myWords.length) {
			if(Arrays.equals(myWords, wg.myWords)) {
					return true;
				}
				else {
					return false;
				}
			}		
			else { 
				return false;
				}
			}

	@Override
	public int hashCode(){
		// TODO: complete this method
		if(myHash == 0 ) {
		myHash = this.toString().hashCode();
		}
		return myHash;
	}
	

	/**
	 * Create and complete this comment
	 * @param last is last String of returned WordGram
	 * @return
	 */
	public WordGram shiftAdd(String last) {
		WordGram wg = new WordGram(myWords,0,myWords.length);
		// TODO: Complete this method
		for(int i = 1; i < wg.myWords.length;i++) {
			wg.myWords[i-1] = this.myWords[i];
			
		}
		wg.myWords[myWords.length-1] = last;
		
		return wg;
	}

	@Override
	public String toString(){
		// TODO: Complete this method
		if(myToString == null) {
		myToString = String.join(" ", myWords);
		}
		return myToString;
	}
}
