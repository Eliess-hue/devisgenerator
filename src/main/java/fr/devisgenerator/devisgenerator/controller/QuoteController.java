package fr.devisgenerator.devisgenerator.controller;

import fr.devisgenerator.devisgenerator.dto.request.QuoteLineRequest;
import fr.devisgenerator.devisgenerator.dto.request.QuoteRequest;
import fr.devisgenerator.devisgenerator.dto.response.QuoteResponse;
import fr.devisgenerator.devisgenerator.entity.AppUser;
import fr.devisgenerator.devisgenerator.service.QuoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quotes")
@RequiredArgsConstructor
public class QuoteController {

    private final QuoteService quoteService;

    @PostMapping
    public ResponseEntity<QuoteResponse> create(
            @RequestBody QuoteRequest request,
            @AuthenticationPrincipal AppUser user) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(quoteService.create(request, user));
    }

    @GetMapping
    public List<QuoteResponse> findAll(
            @AuthenticationPrincipal AppUser user) {

        return quoteService.findAll(user);
    }

    @GetMapping("/{id}")
    public QuoteResponse findById(
            @PathVariable Long id,
            @AuthenticationPrincipal AppUser user) {

        return quoteService.findById(id, user);
    }

    @PutMapping("/{id}")
    public QuoteResponse update(
            @PathVariable Long id,
            @RequestBody QuoteRequest request,
            @AuthenticationPrincipal AppUser user) {

        return quoteService.update(id, request, user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id,
            @AuthenticationPrincipal AppUser user) {

        quoteService.delete(id, user);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/lines")
    public ResponseEntity<QuoteResponse> addLine(
            @PathVariable Long id,
            @RequestBody QuoteLineRequest request,
            @AuthenticationPrincipal AppUser user) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        quoteService.addLine(
                                id,
                                request,
                                user
                        )
                );
    }

    @DeleteMapping("/{quoteId}/lines/{lineId}")
    public QuoteResponse deleteLine(
            @PathVariable Long quoteId,
            @PathVariable Long lineId,
            @AuthenticationPrincipal AppUser user) {

        return quoteService.deleteLine(
                quoteId,
                lineId,
                user
        );
    }
}