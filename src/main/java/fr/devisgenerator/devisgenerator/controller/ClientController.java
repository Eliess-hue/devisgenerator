package fr.devisgenerator.devisgenerator.controller;

import fr.devisgenerator.devisgenerator.dto.request.ClientRequest;
import fr.devisgenerator.devisgenerator.dto.response.ClientResponse;
import fr.devisgenerator.devisgenerator.entity.AppUser;
import fr.devisgenerator.devisgenerator.service.ClientService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    public ResponseEntity<ClientResponse> create(
            @Valid @RequestBody ClientRequest request,
            @AuthenticationPrincipal AppUser user) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(clientService.create(request, user));
    }

    @GetMapping
    public List<ClientResponse> findAll(
            @AuthenticationPrincipal AppUser user) {

        return clientService.findAll(user);
    }

    @GetMapping("/{id}")
    public ClientResponse findById(
            @PathVariable Long id,
            @AuthenticationPrincipal AppUser user) {

        return clientService.findById(id, user);
    }

    @PutMapping("/{id}")
    public ClientResponse update(
            @PathVariable Long id,
            @Valid @RequestBody ClientRequest request,
            @AuthenticationPrincipal AppUser user) {

        return clientService.update(id, request, user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id,
            @AuthenticationPrincipal AppUser user) {

        clientService.delete(id, user);

        return ResponseEntity.noContent().build();
    }
}