package com.example.botcampController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.botcampEntites.Fournisseur;
import com.example.botcampEntites.Produit;
import com.example.botcampRepository.FournisseurRepository;
import com.example.botcampRepository.ProduitRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
@Controller
public class ProduitController {
    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private FournisseurRepository fournisseurRepository;
    public static String uploadDirectory = System.getProperty("user.dir")+"/src/main/resources/static/uploads";
    @PostMapping("addproduit")
    public String addProduit(@Validated Produit produit, BindingResult result, @RequestParam(name = "fournisseurId",required = false) Long f,
                              @RequestParam("files") MultipartFile[] files)
    {
        Fournisseur
        fournisseur=fournisseurRepository.findById(f)
                .orElseThrow(()-> new IllegalArgumentException("Invalid fournisseur Id:" + f));
        produit.setIdFourniseur(fournisseur);
        StringBuilder fileName = new StringBuilder();
        MultipartFile file = files[0];
        Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());

        fileName.append(file.getOriginalFilename());
        try {
            Files.write(fileNameAndPath, file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        produit.setPhotoProfil(fileName.toString());
      //  produit.setPhotoFace(fileName.toString());
        produitRepository.save(produit);
        return "redirect:listp";
    }
    @GetMapping("addproduit")
    public String showAddProduitForm(Model model) {
        model.addAttribute("fournisseurs",fournisseurRepository.findAll());
        model.addAttribute("Produit", new Produit());
        return "Produit/addproduit";
    }

    @GetMapping("listp")
    //@ResponseBody
    public String listProduit(Model model) {

        List<Produit> lp = (List<Produit>)produitRepository.findAll();
        if(lp.size()==0)
            lp=null;
        model.addAttribute("produits", lp);
        return "Produit/Listproduit";
    }
    @GetMapping("deleteproduit/{id}")
    public String deleteProduit(@PathVariable("id") long id) {
        Produit produit = produitRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Invalid produit Id:" + id));
        System.out.println("suite du programme...");
        produitRepository.delete(produit);
        return "redirect:../listp";
    }

    @GetMapping("editproduit/{id}")
    public String showProduitFormToUpdate(@PathVariable("id") long id, Model model) {
        Produit produit = produitRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Invalid provider Id:" + id));

        model.addAttribute("produit", produit);

        return "Produit/updateproduit";
    }



    @PostMapping("updateproduit")
    public String updateProduit(@Validated Produit produit, BindingResult result, Model model) {
        produitRepository.save(produit);
        return"redirect:listp";

    }
}