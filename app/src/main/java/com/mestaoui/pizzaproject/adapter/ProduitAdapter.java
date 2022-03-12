package com.mestaoui.pizzaproject.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.mestaoui.pizzaproject.AffichActivity;
import com.mestaoui.pizzaproject.MainActivity;
import com.mestaoui.pizzaproject.R;
import com.mestaoui.pizzaproject.beans.Produit;
import com.mestaoui.pizzaproject.service.ProduitService;

import java.util.List;

public class ProduitAdapter extends BaseAdapter {
    private List<Produit> produits;
    private ProduitService ps = ProduitService.getInstance();
    private LayoutInflater inflater;

    public ProduitAdapter(Activity activity, List<Produit> produits) {
        this.produits = produits;
        this.inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return produits.size();
    }

    @Override
    public Object getItem(int position) {
        return produits.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return getCount();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
            convertView = inflater.inflate(R.layout.product_item, null);

        TextView idP = convertView.findViewById(R.id.idP);
        ImageView photo = convertView.findViewById(R.id.photo);
        TextView nom = convertView.findViewById(R.id.nom);
        ImageView ingredientsPhoto = convertView.findViewById(R.id.ingredientsPhoto);
        TextView nbIngredients = convertView.findViewById(R.id.nbIngredients);
        ImageView dureePhoto = convertView.findViewById(R.id.dureePhoto);
        TextView dureeTxt = convertView.findViewById(R.id.dureeTxt);
        ImageView parcourir = convertView.findViewById(R.id.parcourir);
        ImageView info = convertView.findViewById(R.id.info);
        ImageView supprimer = convertView.findViewById(R.id.supprimer);

        idP.setText(produits.get(position).getId()+"");
        photo.setImageResource(produits.get(position).getPhoto());
        nom.setText(produits.get(position).getNom()+"");
        ingredientsPhoto.setImageResource(produits.get(position).getIngredientsPhoto());
        nbIngredients.setText(produits.get(position).getNbrIngredients()+"");
        dureePhoto.setImageResource(produits.get(position).getDureePhoto());
        dureeTxt.setText(produits.get(position).getDuree()+"");
        parcourir.setImageResource(produits.get(position).getParcourir());
        info.setImageResource(produits.get(position).getInfo());
        supprimer.setImageResource(produits.get(position).getSupprimer());

        parcourir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(info.getVisibility() == View.GONE && supprimer.getVisibility() == View.GONE) {
                    info.setVisibility(View.VISIBLE);
                    supprimer.setVisibility(View.VISIBLE);
                    RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) parcourir.getLayoutParams();
                    params.setMarginEnd(200);
                    parcourir.setLayoutParams(params);
                }else {
                    info.setVisibility(View.GONE);
                    supprimer.setVisibility(View.GONE);
                    RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) parcourir.getLayoutParams();
                    params.setMarginEnd(20);
                    parcourir.setLayoutParams(params);
                }
            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(parent.getContext(), AffichActivity.class);
                intent.putExtra("id", Integer.parseInt(idP.getText().toString()));
                parent.getContext().startActivity(intent);
            }
        });

        supprimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(parent.getContext());
                alertDialogBuilder.setMessage("Voulez-vous vraiment supprimer " + nom.getText() + " ?");

                alertDialogBuilder.setPositiveButton("Supprimer", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ps.delete(ps.findById(Integer.parseInt(idP.getText().toString())));
                        info.setVisibility(View.GONE);
                        supprimer.setVisibility(View.GONE);
                        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) parcourir.getLayoutParams();
                        params.setMarginEnd(20);
                        parcourir.setLayoutParams(params);
                        notifyDataSetChanged();
                    }
                });
                alertDialogBuilder.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });

        return convertView;
    }
}
