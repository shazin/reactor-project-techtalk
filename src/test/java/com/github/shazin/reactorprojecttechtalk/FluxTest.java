package com.github.shazin.reactorprojecttechtalk;

import reactor.core.publisher.Flux;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.Date;

public class FluxTest {

    public static void main(String... args) throws Exception {
        //System.out.println(Arrays.asList("1", "2", "3").stream().map(s -> Integer.parseInt(s)).filter(i -> i > 1).count());

        // Flux.interval must be paired with a Sleep
        Flux.interval(Duration.ofSeconds(1)).map(l -> new Date()).subscribe(System.out::println);
        Thread.sleep(5000);

        // A Flux Range from 0 - 9 merged with Flux from Array
//        Flux.merge(Flux.range(0, 10), Flux.fromArray(new String[]{"1", "2", "3"})).subscribe(System.out::println, System.err::println, () -> {
//            System.out.println("Complete!");
//        });

        // A Flux Range from 0 - 9 zipped with Flux from Array
//        Flux.zip(Flux.range(0, 10), Flux.fromArray(new String[]{"1", "2", "3"}), (n1, n2) -> n1 + " " + n2).subscribe(System.out::println, System.err::println, () -> {
//            System.out.println("Complete!");
//        });

        // A Flux from Iterable which loads HTML from a URL and filter only content which is in en
//        Flux.fromIterable(Arrays.asList("http://www.google.com"))
//                .map(FluxTest::getHtmlContent)
//                .filter(html -> html.contains("en"))
//                .subscribe(System.out::println);

        // A Flux of 1 second ticks merged with Flux Range from 0 - 9
//        Flux.zip(Flux.interval(Duration.ofSeconds(1)), Flux.range(0, 10), (v1, v2) -> v1 + " " + v2).subscribe(System.out::println, System.err::println, () -> {
//            System.out.println("Complete!");
//        });

        //Mono.just("Test").subscribe(System.out::println, System.err::println, () -> {System.out.println("Completed!");});

        //Flux.range(0, 10).map(i -> String.valueOf(i)).subscribe(System.out::println);

        //Flux.just("A,B,C,D").flatMap(s -> Flux.fromIterable(Arrays.asList(s.split(",")))).subscribe(System.out::println);
    }

    public static String getHtmlContent(String u) {
        try {
            URL url = new URL(u);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            StringBuilder html = new StringBuilder();
            try(BufferedReader br = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()))) {
                String line = null;
                while ((line = br.readLine()) != null) {
                    html.append(line);
                }
            }

            return html.toString();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
