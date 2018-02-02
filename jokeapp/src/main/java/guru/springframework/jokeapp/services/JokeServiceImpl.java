package guru.springframework.jokeapp.services;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.springframework.stereotype.Service;

@Service
public class JokeServiceImpl implements JokeService {


 private final ChuckNorrisQuotes chuckNorrisQuotes;

    public JokeServiceImpl(ChuckNorrisQuotes chuckNorrisQuotes) {
        this.chuckNorrisQuotes = new ChuckNorrisQuotes();//so instance created only once by spring
    }

    public String getJoke(){
    return chuckNorrisQuotes.getRandomQuote();
    }
}
