package com.example.botcampEntites;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "produit")

public class Produit {
	  @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="produit_id")
	    private Long id;
		@Column(name="libelle")
	    private String libelle;
		@Column(name="photoFace")
	    private String photoFace;
		@Column(name="photoProfil")
	    private String photoProfil;
		@Column(name="prix")
	    private int prix;
		@Column(name="description")
	    private String description;
		@Column(name="quantiteStock")
	    private int quantiteStock;
		@Column(name="prixPromotion")
	    private String prixPromotion;
		@Column(name="dateExpiration")
	    private Date dateExpiration;

	    @ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "fournisseur_id", nullable = false)
	    private Fournisseur idFourniseur;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getLibelle() {
			return libelle;
		}

		public void setLibelle(String libelle) {
			this.libelle = libelle;
		}

		public String getPhotoFace() {
			return photoFace;
		}

		public void setPhotoFace(String photoFace) {
			this.photoFace = photoFace;
		}

		public String getPhotoProfil() {
			return photoProfil;
		}

		public void setPhotoProfil(String photoProfil) {
			this.photoProfil = photoProfil;
		}

		public int getPrix() {
			return prix;
		}

		public void setPrix(int prix) {
			this.prix = prix;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public int getQuantiteStock() {
			return quantiteStock;
		}

		public void setQuantiteStock(int quantiteStock) {
			this.quantiteStock = quantiteStock;
		}

		public String getPrixPromotion() {
			return prixPromotion;
		}

		public void setPrixPromotion(String prixPromotion) {
			this.prixPromotion = prixPromotion;
		}

		public Date getDateExpiration() {
			return dateExpiration;
		}

		public void setDateExpiration(Date dateExpiration) {
			this.dateExpiration = dateExpiration;
		}

		public Fournisseur getIdFourniseur() {
			return idFourniseur;
		}

		public void setIdFourniseur(Fournisseur idFourniseur) {
			this.idFourniseur = idFourniseur;
		}

}
