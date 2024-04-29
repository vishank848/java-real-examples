package org.example;

import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.NumberFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RecordExampleTest {
    @Test
    public void givenValidNameAndAddress_whenGetNameAndAddress_thenExpectedValuesReturned() {
        String name = "John Doe";
        String address = "100 Linda Ln.";
        RecordExample.Person person = new RecordExample.Person(name, address);
        assertEquals(name, person.name());
        assertEquals(address, person.address());
    }

    @Test
    public void givenSameNameAndAddress_whenEquals_thenPersonsEqual() {
        String name = "John Doe";
        String address = "100 Linda Ln.";

        RecordExample.Person person1 = new RecordExample.Person(name, address);
        RecordExample.Person person2 = new RecordExample.Person(name, address);

        assertTrue(person1.equals(person2));
    }

    @Test
    public void givenSameNameAndAddress_whenHashCode_thenPersonsEqual() {
        String name = "John Doe";
        String address = "100 Linda Ln.";

        RecordExample.Person person1 = new RecordExample.Person(name, address);
        RecordExample.Person person2 = new RecordExample.Person(name, address);

        assertEquals(person1.hashCode(), person2.hashCode());

        System.out.println(person1.toString());
    }

    @Test
    public void test1() throws IOException {
//        New File Methods
        Path filePath = Files.writeString(
                Files.createTempFile(Path.of("."), "demo", ".txt"), "Sample text");
        String fileContent = Files.readString(filePath);
        assertThat(fileContent).isEqualTo("Sample text");

//        The Not Predicate Method
        List<String> sampleList = Arrays.asList("Java", "\n \n", "Kotlin", " ");
        List<String> withoutBlanks = sampleList.stream()
                .filter(Predicate.not(String::isBlank))
                .collect(Collectors.toList());
        assertThat(withoutBlanks).containsExactly("Java", "Kotlin");
    }

    @Test
    public void test2() {
//        Collection to an Array
        List<String> sampleList = Arrays.asList("Java", "Kotlin");
        String[] sampleArray = sampleList.toArray(String[]::new);
        assertThat(sampleArray).containsExactly("Java", "Kotlin");
    }
    
    @Test
    public void test3() {
//        Local-Variable Syntax for Lambda
        List<String> sampleList = Arrays.asList("Java", "Kotlin");
        String resultString = sampleList.stream()
                .map((var x) -> x.toUpperCase())
                .collect(Collectors.joining(", "));
        assertThat(resultString).isEqualTo("JAVA, KOTLIN");
    }
    
    @Test
    public void test4() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(20))
                .build();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:9090" ))
                .build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        assertThat(httpResponse.body()).isEqualTo("Hello from the server!");
    }
    
    @Test
    public void test5() {
        assertThat(MainClass.class.isNestmateOf(MainClass.NestedClass.class)).isTrue();
        assertThat(MainClass.NestedClass.class.getNestHost()).isEqualTo(MainClass.class);
        Set<String> nestedMembers = Arrays.stream(MainClass.NestedClass.class.getNestMembers())
                .map(Class::getName)
                .collect(Collectors.toSet());
        assertThat(nestedMembers).contains(MainClass.class.getName(), MainClass.NestedClass.class.getName());
    }

    @Test
    public void givenString_thenRevertValue() {
        String text = "Baeldung";
        String transformed = text.transform(value ->
                new StringBuilder(value).reverse().toString()
        );

        assertEquals("gnudleaB", transformed);
    }

    @Test
    public void givenIdenticalFiles_thenShouldNotFindMismatch() throws IOException {
        Path filePath1 = Files.createTempFile("file1", ".txt");
        Path filePath2 = Files.createTempFile("file2", ".txt");
        Files.writeString(filePath1, "Java 12 Article");
        Files.writeString(filePath2, "Java 12 Article");

        long mismatch = Files.mismatch(filePath1, filePath2);
        assertEquals(-1, mismatch);
    }

    @Test
    public void givenDifferentFiles_thenShouldFindMismatch() throws IOException {
        Path filePath3 = Files.createTempFile("file3", ".txt");
        Path filePath4 = Files.createTempFile("file4", ".txt");
        Files.writeString(filePath3, "Java 12 Article");
        Files.writeString(filePath4, "Java 12 Tutorial");

        long mismatch = Files.mismatch(filePath3, filePath4);
        assertEquals(8, mismatch);
    }

    @Test
    public void givenSetOfNumbers_thenCalculateAverage() {
        double mean = Stream.of(1, 2, 3, 4, 5)/**/
                .collect(Collectors.teeing(Collectors.summingDouble(i -> i),
                        Collectors.counting(), (sum, count) -> sum / count));
        assertEquals(3.0, mean);
    }

    @Test
    public void givenNumber_thenCompactValues() {
        NumberFormat likesShort =
                NumberFormat.getCompactNumberInstance(new Locale("en", "US"), NumberFormat.Style.SHORT);
        likesShort.setMaximumFractionDigits(2);
        assertEquals("2.59K", likesShort.format(2592));

        NumberFormat likesLong =
                NumberFormat.getCompactNumberInstance(new Locale("en", "US"), NumberFormat.Style.LONG);
        likesLong.setMaximumFractionDigits(2);
        assertEquals("2.59 thousand", likesLong.format(2592));
    }

    @Test
    @SuppressWarnings("preview")
    public void whenSwitchingOnOperationSquareMe_thenWillReturnSquare() {
        var me = 4;
        var operation = "squareMe";
        var result = switch (operation) {
            case "doubleMe" -> {
                yield me * 2;
            }
            case "squareMe" -> {
                yield me * me;
            }
            default -> me;
        };

        assertEquals(16, result);
    }

    @Test
    public void whenTextBlocks_thenStringOperationsWorkSame() {
        String JSON_STRING
                = "{\r\n" + "\"name\" : \"Baeldung\",\r\n" + "\"website\" : \"https://www.%s.com/\"\r\n" + "}";

        String TEXT_BLOCK_JSON = """
                                {
                                    "name" : "Baeldung",
                                    "website" : "https://www.%s.com/"
                                }
                                """;
        assertThat(TEXT_BLOCK_JSON.contains("Baeldung")).isTrue();
        assertThat(TEXT_BLOCK_JSON.indexOf("www")).isGreaterThan(0);
        assertThat(TEXT_BLOCK_JSON.length()).isGreaterThan(0);

        assertThat(TEXT_BLOCK_JSON.formatted("baeldung").contains("www.baeldung.com")).isTrue();
        assertThat(String.format(JSON_STRING,"baeldung").contains("www.baeldung.com")).isTrue();

    }

}