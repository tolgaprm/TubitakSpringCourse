package yte.intern.springweb.rest_template;

public record Comment(
        Long postId,
        Long id,
        String name,
        String email,
        String body
) {
}
