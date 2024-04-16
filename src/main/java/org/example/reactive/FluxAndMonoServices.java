package org.example.reactive;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class FluxAndMonoServices {
    public static void main(String[] args) {
        var fluxAndMonoServices = new FluxAndMonoServices();
//        fluxAndMonoServices.fruitMono().subscribe(s -> System.out.println(STR."Mono -> s = \{s}"));
//        fluxAndMonoServices.fruitMonoOnError().subscribe(s -> System.out.println(STR."Mono -> s = \{s}"));
//        fluxAndMonoServices.fruitsMonoZipWith().subscribe(s -> System.out.println(STR."Mono -> s = \{s}"));
//        fluxAndMonoServices.fruitMonoFlatMap().subscribe(s -> System.out.println(STR."Mono -> s = \{s}"));
//        fluxAndMonoServices.fruitMonoFlatMapMany().subscribe(s -> System.out.println(STR."Mono -> s = \{s}"));
        
//        fluxAndMonoServices.fruitsFlux().subscribe(s -> System.out.println(STR."Mono -> s = \{s}"));
//        fluxAndMonoServices.fruitsFluxMap().subscribe(s -> System.out.println(STR."Mono -> s = \{s}"));
//        fluxAndMonoServices.fruitsFluxFilter(5).subscribe(s -> System.out.println(STR."Mono -> s = \{s}"));
//        fluxAndMonoServices.fruitsFluxFlatMap().subscribe(s -> System.out.println(STR."Mono -> s = \{s}"));
        fluxAndMonoServices.fruitsFluxFlatMapAsync().subscribe(s -> System.out.println(STR."Mono -> s = \{s}"));
    }

    private Flux<String> fruitsFlux() {
        return Flux.fromIterable(List.of("Mango","Orange","Banana")).log();
    }
    
    private Flux<String> fruitsFluxMap() {
        return Flux.fromIterable(List.of("Mango","Orange","Banana"))
            .map(String::toUpperCase).log();
    }

    private Flux<String> fruitsFluxFilter(int number) {
        return Flux.fromIterable(List.of("Mango","Orange","Banana"))
            .filter(s -> s.length() > number);
    }

    public Flux<String> fruitsFluxFlatMap() {
        return Flux.fromIterable(List.of("Mango","Orange","Banana"))
            .flatMap(s -> Flux.just(s.split("")))
            .log();
    }

    private Flux<String> fruitsFluxFlatMapAsync() {
        return Flux.fromIterable(List.of("Mango","Orange","Banana"))
            .flatMap(s -> Flux.just(s.split(""))
                .delayElements(Duration.ofMillis(
                    new Random().nextInt(1000)
                )))
            .log();
    }

    private Mono<String> fruitMono() {
        return Mono.just("Mango").log();
    }

    private Mono<String> fruitMonoOnError() {
        return Mono.just("Mango").log()
            .then(Mono.error(new RuntimeException("Error Occurred while publishing data")));
    }

    private Mono<String> fruitsMonoZipWith() {
        var fruits = Mono.just("Mango");
        var veggies = Mono.just("Tomato");
        return fruits.zipWith(veggies, (first, second) -> STR."\{first} : \{second}").log();
    }

    private Mono<List<String>> fruitMonoFlatMap() {
        return Mono.just("Mango")
            .flatMap(s -> Mono.just(List.of(s.split(""))))
            .log();
    }

    private Flux<String> fruitMonoFlatMapMany() {
        return Mono.just("Mango")
            .flatMapMany(s -> Flux.just(s.split("")))
            .log();
    }

}
