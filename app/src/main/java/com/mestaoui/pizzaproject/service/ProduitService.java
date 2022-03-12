package com.mestaoui.pizzaproject.service;

import com.mestaoui.pizzaproject.beans.Produit;
import com.mestaoui.pizzaproject.dao.IDao;

import java.util.ArrayList;
import java.util.List;

public class ProduitService implements IDao<Produit> {
    List<Produit> produits;
    private static ProduitService instance;

    public ProduitService() {
        this.produits = new ArrayList<>();
    }

    public static ProduitService getInstance() {
        if(instance == null)
            instance = new ProduitService();
        return instance;
    }

    @Override
    public boolean create(Produit o) {
        return produits.add(o);
    }

    @Override
    public boolean update(Produit o) {
        for(Produit p : produits) {
            if(p.getId() == o.getId()) {
                int id = p.getId();
                produits.remove(p);
                produits.add(id, o);
                return  true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(Produit o) {
        return produits.remove(o);
    }

    @Override
    public Produit findById(int id) {
        for(Produit p : produits) {
            if(p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    @Override
    public List<Produit> findAll() {
        return produits;
    }
}
