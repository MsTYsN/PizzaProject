package com.mestaoui.pizzaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.mestaoui.pizzaproject.beans.Produit;
import com.mestaoui.pizzaproject.service.ProduitService;

public class AffichActivity extends AppCompatActivity {

    private ProduitService ps = ProduitService.getInstance();
    private ImageView photo;
    private TextView nom, description, ingredients, etapesPreparation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affich);

        photo = findViewById(R.id.photoAffich);
        nom = findViewById(R.id.nomAffich);
        description = findViewById(R.id.descAffich);
        ingredients = findViewById(R.id.ingrAffich);
        etapesPreparation = findViewById(R.id.prepAffich);

        Produit p = ps.findById(getIntent().getIntExtra("id", -1));

        photo.setImageResource(p.getPhoto());
        nom.setText(p.getNom());
        description.setText(p.getDescription());
        ingredients.setText(p.getDetailsIngredients());
        etapesPreparation.setText(p.getPreparation());
    }
}