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
 * An analyzer of query strings. Note the current implementation does not
 * support advanced query syntax such as "...", *, ?, or ~, etc.
 */
public class TermQueryAnalyzer extends Analyzer {

	@Override
	public TokenStream tokenStream(Reader input) {
        Tokenizer tokenizer = new LetterTokenizer(input);
        TokenFilter lowerCaseFilter = new LowerCaseFilter(tokenizer);
        TokenFilter stopFilter = new StopFilter(lowerCaseFilter);
        TokenFilter stemFilter = new StemFilter(stopFilter);
        
        return stemFilter;
	}

}
