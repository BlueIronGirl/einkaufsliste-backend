package com.example.einkaufsliste.controller;

import java.util.List;

import com.example.einkaufsliste.entity.Artikel;
import com.example.einkaufsliste.service.ArtikelService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class ArtikelController {
    private final ArtikelService artikelService;

    /**
     * Alle Artikel von dem aktiven Einkaufszettel abfragen
     *
     * @return alle Artikel als Liste
     */
    @GetMapping("/artikels")
    public ResponseEntity<List<Artikel>> selectAllArtikel() {
        return ResponseEntity.ok(artikelService.selectAllArtikel());
    }

    /**
     * Lade einen bestimmten Artikel mit der Id
     *
     * @param id id
     * @return Artikel
     * @throws Exception wenn der Artikel nicht gefunden wurde
     */
    @GetMapping("/artikels/{id}")
    public ResponseEntity<Artikel> selectArtikel(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(artikelService.selectArtikel(id));
    }

    /**
     * Neuen Artikel erfassen. Dabei wird der Erstellungszeitpunkt auf den aktuellen Zeitpunkt gesetzt
     *
     * @param artikel zu speichernder Artikel
     * @return erfasster Artikel
     */
    @PostMapping(value = "/artikels", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Artikel> createArtikel(@Valid @RequestBody Artikel artikel) {
        return ResponseEntity.ok(artikelService.createArtikel(artikel));
    }

    /**
     * Bestehenden Artikel aktualisieren. Wenn dabei der Artikel auf gekauft gesetzt wird, wird der Kaufzeitpunkt auf den aktuellen Zeitpunkt gesetzt
     *
     * @param artikelData zu speichernder Artikel
     * @param id          ID des Artikels
     * @return aktualisierter Artikel
     * @throws Exception Artikel wurde nicht gefunden
     */
    @PutMapping("/artikels/{id}")
    public ResponseEntity<Artikel> updateArtikel(@Valid @RequestBody Artikel artikelData, @PathVariable Long id) throws Exception {
        return ResponseEntity.ok(artikelService.updateArtikel(artikelData, id));
    }

    /**
     * Loesche bestehenden Artikel
     *
     * @param id ID des Artikels
     * @return geloeschter Artikel
     * @throws Exception Artikel wurde nicht gefunden
     */
    @DeleteMapping("/artikels/{id}")
    public ResponseEntity<Artikel> deleteArtikel(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(artikelService.deleteArtikel(id));
    }
}
