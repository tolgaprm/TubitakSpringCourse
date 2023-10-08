package yte.intern.springweb.rest_template;

public record Post(
        Long userId,
        Long id,
        String title,
        String body

) {
}