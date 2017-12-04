package netdb.courses.softwarestudio.recommander;

import java.io.Reader;

import netdb.courses.softwarestudio.recommander.analysis.Analyzer;
import netdb.courses.softwarestudio.recommander.analysis.LetterTokenizer;
import netdb.courses.softwarestudio.recommander.analysis.LowerCaseFilter;
import netdb.courses.softwarestudio.recommander.analysis.StemFilter;
import netdb.courses.softwarestudio.recommander.analysis.StopFilter;
import netdb.courses.softwarestudio.recommander.analysis.TokenFilter;
import netdb.courses.softwarestudio.recommander.analysis.TokenStream;
import netdb.courses.softwarestudio.recommander.analysis.Tokenizer;

/**
 * An {@link Analyzer} implementation specialized for the definition objects
 * having the "title" and "description" fields.
 */
public class DefAnalyzer extends Analyzer {

	@Override
	public TokenStream tokenStream(Reader input) {
		//Decorator pattern
		//把Bad改成新創的
		Tokenizer tokenizer = new LetterTokenizer(input);
		TokenFilter lowerCaseFilter = new LowerCaseFilter(tokenizer);
		TokenFilter stopFilter = new StopFilter(lowerCaseFilter);
		TokenFilter stemFilter = new StemFilter(stopFilter);
		
		return stemFilter;
	}

}
