package fr.devisgenerator.devisgenerator.dto.request;

public record ClientRequest(
        String name,
        String email,
        String phone,
        String address
) {
}
