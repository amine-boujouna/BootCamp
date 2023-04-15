package com.example.botcampController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.botcampEntites.Fournisseur;
import com.example.botcampRepository.FournisseurRepository;

import java.util.List;

@Controller
public class FournisseurController {
    @Autowired
    private FournisseurRepository fournisseurRepository;

    @PostMapping("addfournisseur")
    public String addProvider(@Validated Fournisseur fournisseur, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "Fournisseur/addfournisseur";
        }
        fournisseurRepository.save(fournisseur);
        return "redirect:list";
    }
    @GetMapping("addfournisseur")
    public String showAddProviderForm(Model model) {
        Fournisseur Fournisseur = new Fournisseur(); 
        model.addAttribute("Fournisseur", Fournisseur);
        return "Fournisseur/addfournisseur";
    }

    @GetMapping("list")
    //@ResponseBody
    public String listProviders(Model model) {

        List<Fournisseur> lp = (List<Fournisseur>)fournisseurRepository.findAll();
        if(lp.size()==0)
            lp=null;
        model.addAttribute("fournisseurs", lp);
        return "Fournisseur/ListFournisseur";
    }
    @GetMapping("delete/{id}")
    public String deleteProvider(@PathVariable("id") long id) {
        Fournisseur fournisseur = fournisseurRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Invalid provider Id:" + id));
        System.out.println("suite du programme...");
        fournisseurRepository.delete(fournisseur);
        return "redirect:../list";
    }

    @GetMapping("edit/{id}")
    public String showProviderFormToUpdate(@PathVariable("id") long id, Model model) {
        Fournisseur fournisseur = fournisseurRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Invalid provider Id:" + id));

        model.addAttribute("fournisseur", fournisseur);

        return "Fournisseur/updatefournisseur";
    }



    @PostMapping("update")
    public String updateProvider(@Validated Fournisseur fournisseur, BindingResult result, Model model) {
    	fournisseurRepository.save(fournisseur);
        return"redirect:list";

    }

}
