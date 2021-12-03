package com.company;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//get a quote from a flight agency
public class FlightService {

    public Stream<CompletableFuture<Quote>> getQuotes(){
        var sites = List.of("site 1", "site 2", "site 3");
        return sites.stream().map(this::getQuote);
    }

    public CompletableFuture<Quote> getQuote(String site){
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Getting a quote from " + site);
            var random = new Random();
            LongTask.simulate(1000 + random.nextInt(2000));
            var price = 100 + random.nextInt(10);
            return new Quote(site, price);
                });
    }
}
