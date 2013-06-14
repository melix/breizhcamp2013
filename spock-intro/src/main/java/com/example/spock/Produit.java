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

public class Produit {
    private String nom;
    private double prix;

    public Produit() {
    }

    public Produit(final String nom, final double prix) {
        this.nom = nom;
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setNom(final String nom) {
        this.nom = nom;
    }

    public void setPrix(final double prix) {
        this.prix = prix;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Produit produit = (Produit) o;

        if (Double.compare(produit.prix, prix) != 0) return false;
        if (!nom.equals(produit.nom)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = nom.hashCode();
        temp = Double.doubleToLongBits(prix);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
