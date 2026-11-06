package com.example.aula.aula5.controller;

import com.example.aula.aula5.model.Pet;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/pets")
public class PetController {

    @GetMapping("/pets")
    public String pets() {
        return "Bem-vinda ao Pet Shop Elas Tech!";
    }

    @GetMapping("/horario")
    public String horario(){
        return "Abrimos de segunda a sábado, das 8h às 18h.";
    }

    @GetMapping("/destaque")
    public Pet pet(){
        return new Pet("Thor", "Cachorro", 3 );
    }

    @GetMapping("/banho")
    public String banho(@RequestParam(defaultValue = "Seu pet") String nome){
        return nome + " está tomando banho!";

    }

    @GetMapping("/novo/{nome}")
    public Pet novoPet(@PathVariable String nome){
        return new Pet(nome, "Gato", 1);
    }

    // sem ?anos= retorna o erro 400 porque está esperando um parametro para funcionar
    @GetMapping("/idade-humana")
    public String idadeHumana(@RequestParam int idade){
        return idade + " anos de pet equivalem a " + (idade*7) + " anos humanos!";
    }

    @GetMapping("/consulta")
    public String consulta(@RequestParam String pet, @RequestParam String vet){
        return pet + " tem consulta com a Dra. " + vet + "!";
    }
}
