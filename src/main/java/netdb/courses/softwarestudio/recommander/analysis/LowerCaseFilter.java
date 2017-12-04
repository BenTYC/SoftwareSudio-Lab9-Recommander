package netdb.courses.softwarestudio.recommander.analysis;

public final class LowerCaseFilter extends TokenFilter {

	public LowerCaseFilter(TokenStream input) {
		super(input);
	}
	
	/**
	 * FIXME 
	 * Avoided excessive creation of String objects using char[].
	 */
	@Override
	public final boolean incrementToken() throws Exception {
		if(input.incrementToken()){
			//把Token拿出來lowercase		
			char[] termBuff = token.getTermBuffer();
			for(int i=0; i < token.getTermLength(); i++)
				termBuff[i] = Character.toLowerCase(termBuff[i]);
			
			return true;
		}
		else
			return false;
	}

}