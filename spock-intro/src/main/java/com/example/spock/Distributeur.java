/*
 * Copyright 2003-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.spock;

import java.util.HashMap;
import java.util.Map;

public class Distributeur {

    private final Map<Produit, Integer> produits;

    public Distributeur() {
        produits = new HashMap<>();
    }

    public static String VENDOR() { return "Breizhcamp"; }

    private Produit trouveProduit(String pName) {
        for (Produit produit : produits.keySet()) {
            if (produit.getNom().equals(pName)) return produit;
        }
        return null;
    }

    public int getQuantite(String pName) {
        Produit produit = trouveProduit(pName);
        if (produit==null) return 0;
        return produits.get(produit);
    }

    public double getPrix(String pName) {
        Produit produit = trouveProduit(pName);
        if (produit==null) return 0;
        return produit.getPrix();
    }

    public void distribue(String pName) throws DistributionException {
        Produit produit = trouveProduit(pName);
        if (produit==null) throw new DistributionException("Produit introuvable");
        int qte = produits.get(produit);
        if (qte==1) {
            produits.remove(produit);
        } else {
            produits.put(produit, qte-1);
        }
    }

    public int nombreProduits() {
        int sum = 0;
        for (Integer qte : produits.values()) {
            sum += qte;
        }
        return sum;
    }

    public void remplir(Map<Produit, Integer> stock) {
        if (stock==null) return;
        for (Map.Entry<Produit, Integer> entry : stock.entrySet()) {
            Produit produit = trouveProduit(entry.getKey().getNom());
            if (produit!=null) {
                produits.put(produit, produits.get(produit)+entry.getValue());
            } else {
                produits.put(entry.getKey(), entry.getValue());
            }
        }
    }
}
