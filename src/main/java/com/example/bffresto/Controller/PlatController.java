package com.example.bffresto.Controller;

import com.example.bffresto.Entites.Plat;
import com.example.bffresto.Service.PlatService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plats")
public class PlatController {


        private final PlatService platService;

        @Autowired
        public PlatController(PlatService platService) {
            this.platService = platService;
        }

        @Operation(summary = "Ajoute un plat", description = "Ajout d'un nouveau plat.")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "OK - Plat ajouté", content = {@io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json")}),
                @ApiResponse(responseCode = "403", description = "Forbidden - Accès interdit"),
                @ApiResponse(responseCode = "404", description = "Not Found - Ajout non éffectué"),
                @ApiResponse(responseCode = "500", description = "Internal Server Error - Erreur interne du serveur")
        })
        @PostMapping
        public ResponseEntity<Plat> ajouterPlat(@RequestBody Plat plat) {
            Plat nouveauPlat = platService.ajouterPlat(plat);
            return new ResponseEntity<>(nouveauPlat, HttpStatus.CREATED);
        }

        @Operation(summary = "Retourne la liste des plats", description = "Retourne les informations de tous les plats.")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "OK - Plats trouvés", content = {@io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json")}),
                @ApiResponse(responseCode = "403", description = "Forbidden - Accès interdit"),
                @ApiResponse(responseCode = "404", description = "Not Found - Plats non trouvés"),
                @ApiResponse(responseCode = "500", description = "Internal Server Error - Erreur interne du serveur")
        })
        @GetMapping("/listplat")
        public ResponseEntity<List<Plat>> obtenirPlatsDisponibles() {
            List<Plat> plats = platService.obtenirPlatsDisponibles();
            return new ResponseEntity<>(plats, HttpStatus.OK);
        }

        @Operation(summary = "Obtenir les informations sur un plat", description = "Retourne les informations détaillées sur un plat en fonction de son ID.")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "OK - Plat trouvé", content = {@io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json")}),
                @ApiResponse(responseCode = "403", description = "Forbidden - Accès interdit"),
                @ApiResponse(responseCode = "404", description = "Not Found - Plat non trouvé"),
                @ApiResponse(responseCode = "500", description = "Internal Server Error - Erreur interne du serveur")
        })
        @GetMapping("/{platId}")
        public ResponseEntity<Plat> obtenirInfoPlat(@PathVariable Long platId) {
            Plat plat = platService.obtenirInfoPlat(platId);
            if (plat != null) {
                return new ResponseEntity<>(plat, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        @Operation(summary = "Modifie les informations d'un plat", description = "Modifie les informations d'un plat en fonction de son ID.")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "OK - Plat trouvé", content = {@io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json")}),
                @ApiResponse(responseCode = "403", description = "Forbidden - Accès interdit"),
                @ApiResponse(responseCode = "404", description = "Not Found - Plat non trouvé"),
                @ApiResponse(responseCode = "500", description = "Internal Server Error - Erreur interne du serveur")
        })
        @PutMapping("/{platId}")
        public ResponseEntity<Plat> mettreAJourInfoPlat(@PathVariable Long platId, @RequestBody Plat plat) {
            Plat platMisAJour = platService.mettreAJourInfoPlat(platId, plat);
            if (platMisAJour != null) {
                return new ResponseEntity<>(platMisAJour, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

}
