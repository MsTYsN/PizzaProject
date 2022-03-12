package com.mestaoui.pizzaproject.beans;

public class Produit {
    private int id;
    private String nom;
    private int nbrIngredients;
    private int photo;
    private int ingredientsPhoto;
    private int dureePhoto;
    private String duree;
    private int parcourir;
    private int info;
    private int supprimer;
    private String detailsIngredients;
    private String description;
    private String preparation;
    private static int comp = 0;

    public Produit() {}

    public Produit(String nom, int nbrIngredients, int photo, int ingredientsPhoto, int dureePhoto, String duree, int parcourir, int info, int supprimer, String detailsIngredients, String description, String preparation) {
        this.id = ++comp;
        this.nom = nom;
        this.nbrIngredients = nbrIngredients;
        this.photo = photo;
        this.ingredientsPhoto = ingredientsPhoto;
        this.dureePhoto = dureePhoto;
        this.duree = duree;
        this.parcourir = parcourir;
        this.info = info;
        this.supprimer = supprimer;
        this.detailsIngredients = detailsIngredients;
        this.description = description;
        this.preparation = preparation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNbrIngredients() {
        return nbrIngredients;
    }

    public void setNbrIngredients(int nbrIngredients) {
        this.nbrIngredients = nbrIngredients;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public int getIngredientsPhoto() {
        return ingredientsPhoto;
    }

    public void setIngredientsPhoto(int ingredientsPhoto) {
        this.ingredientsPhoto = ingredientsPhoto;
    }

    public int getDureePhoto() {
        return dureePhoto;
    }

    public void setDureePhoto(int dureePhoto) {
        this.dureePhoto = dureePhoto;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public int getParcourir() {
        return parcourir;
    }

    public void setParcourir(int parcourir) {
        this.parcourir = parcourir;
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public int getSupprimer() {
        return supprimer;
    }

    public void setSupprimer(int supprimer) {
        this.supprimer = supprimer;
    }

    public String getDetailsIngredients() {
        return detailsIngredients;
    }

    public void setDetailsIngredients(String detailsIngredients) {
        this.detailsIngredients = detailsIngredients;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPreparation() {
        return preparation;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }
}
