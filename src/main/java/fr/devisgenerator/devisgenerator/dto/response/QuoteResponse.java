package fr.devisgenerator.devisgenerator.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record QuoteResponse(
        Long id,
        String number,
        String status,
        BigDecimal totalHt,
        BigDecimal totalTva,
        BigDecimal totalTtc,
        LocalDateTime createdAt,
        ClientResponse client,
        AppUserResponse user
) {
}
