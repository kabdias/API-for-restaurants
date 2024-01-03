package com.example.bffresto.Controller;

import com.example.bffresto.Entites.Type;
import com.example.bffresto.Service.TypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/type")
public class TypeController {


    public TypeService typeService;

    public TypeController(TypeService typeService){

        this.typeService = typeService;
    }

    @Operation(summary = "Retoune la liste des types de plat" ,  description = "Récupère la liste des types de plat")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK - types trouvés", content ={@io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "403", description = "Forbidden - Accès interdit"),
            @ApiResponse(responseCode = "404", description = "Not Found - Types non trouvés"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error - Erreur interne du serveur")
    })
    @GetMapping("types")
    public ResponseEntity<List<Type>> listType(){

        List<Type> listType = typeService.optenirTypeDisponible();
        return ResponseEntity.status(HttpStatus.OK).body(listType);
    }

    @Operation(summary = "Obtenir les informations sur un type de plat", description = "Retourne les informations détaillées sur un type de plat en fonction de son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK - Type trouvé", content = {@io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "403", description = "Forbidden - Accès interdit"),
            @ApiResponse(responseCode = "404", description = "Not Found - Type non trouvé"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error - Erreur interne du serveur")
    })
    @GetMapping("/{typeID}")
    public ResponseEntity<Type> obtenirInfoType(@PathVariable long typeID){
        Type type = typeService.obtenirType(typeID);
        return ResponseEntity.status(HttpStatus.OK).body(type);
    }

    @Operation(summary = "Ajoute un type de plat", description = "Ajout d'un nouveau type de plat.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK - Type ajouté", content = {@io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "403", description = "Forbidden - Accès interdit"),
            @ApiResponse(responseCode = "404", description = "Not Found - Ajout non éffectué"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error - Erreur interne du serveur")
    })
    @PostMapping
    public ResponseEntity<Type> ajoutType(@RequestBody Type type){
        Type newType = typeService.ajoutTypePlat(type);
        return ResponseEntity.status(HttpStatus.CREATED).body(newType);
    }


    @Operation(summary = "Modifie les informations d'un type de plat", description = "Modifie les informations d'un type de plat en fonction de son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK - Type trouvé", content = {@io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "403", description = "Forbidden - Accès interdit"),
            @ApiResponse(responseCode = "404", description = "Not Found - Type non trouvé"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error - Erreur interne du serveur")
    })
    @PutMapping("{typeId}")
    public ResponseEntity<Type> modifierType(long typeId, @RequestBody Type newtype){
        Type type = typeService.mettreAJourInfoType(typeId,newtype);
        return ResponseEntity.status(HttpStatus.OK).body(type);
    }
}
