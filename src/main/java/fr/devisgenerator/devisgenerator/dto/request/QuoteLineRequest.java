package fr.devisgenerator.devisgenerator.dto.request;

import java.math.BigDecimal;

public record QuoteLineRequest(
        String description,
        Integer quantity,
        BigDecimal unitPrice
) {
}
