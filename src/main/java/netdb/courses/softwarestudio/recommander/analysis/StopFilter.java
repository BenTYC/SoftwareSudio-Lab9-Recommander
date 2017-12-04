package netdb.courses.softwarestudio.recommander.analysis;

import netdb.courses.softwarestudio.recommander.util.CharArraySet;

public class StopFilter extends TokenFilter {
	
	//Type改成CharArraySet
	private final CharArraySet stopSet;

	public StopFilter(TokenStream input, String... stopWords) {
		super(input);
		this.stopSet = makeStopSet(stopWords == null || stopWords.length == 0 ? 
				getDefaultStopWords() : stopWords);
	}
	
	//修改return type 和 add的method
	protected CharArraySet makeStopSet(String... stopWords) {
		CharArraySet set = new CharArraySet();
		for(String w : stopWords)
			if(w != null) 
				set.add(w.toCharArray(), w.length());
		return set;
	}
	
	protected String[] getDefaultStopWords() {
		return new String[] { "a", "an", "and", "are", "as", "at", "be", "but",
				"by", "for", "if", "in", "into", "is", "it", "no", "not", "of",
				"on", "or", "s", "such", "that", "the", "their", "then",
				"there", "these", "they", "this", "to", "was", "will", "with" };
	}

	/**
	 * Returns the next input Token whose term is not a stop word.
	 * 
	 * <p>FIXME 
	 * Avoid excessive creation of String using {@link CharArraySet}.</P>
	 */
	@Override
	public final boolean incrementToken() throws Exception {
		if(input.incrementToken()){
			//檢查此token是否為stopWord 是→跳過，return下個結果
			if( stopSet.contains(input.getToken().getTermBuffer(), input.getToken().getTermLength()) )
				return this.incrementToken();
			return true;
		}
		else
			return false;
		/*
		
		while(input.incrementToken()) {
			if(!stopSet.contains(token.getTermBuffer(), token.getTermLength()))
				return true;
			// else, the loop continues
		}
		// end of stream
 		return false;
		
		*/
	}
}
