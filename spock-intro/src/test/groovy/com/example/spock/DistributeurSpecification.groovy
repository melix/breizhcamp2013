package com.example.spock

import spock.lang.Specification

class DistributeurSpecification extends Specification {
    def "le distributeur doit être vide"() {
        given: "Un distributeur est créé"
            def distrib = new Distributeur()
        expect: "le distributeur est vide"
            distrib.nombreProduits() == 0
    }

    def "le distributeur est rempli"() {
        given: "Un distributeur est créé"
            def distrib = new Distributeur()
            def produit = Mock(Produit)
        when: "on le remplit"
            distrib.remplir([(produit):1])
        then: "le distributeur a un produit"
            distrib.nombreProduits() == 1
    }

    def "le distributeur est rempli avec deux produits"() {
        given: "Un distributeur est créé"
            def distrib = new Distributeur()
            def produit1 = Mock(Produit)
            def produit2 = Mock(Produit)
            produit1.getNom() >> 'P1'
            produit2.getNom() >> 'P2'
        when: "on le remplit"
            distrib.remplir([(produit1):1, (produit2): 3])
        then: "le distributeur a 4 produits"
            distrib.nombreProduits() == 4
    }

    def "le distributeur est rempli avec deux produits et on en retire un"() {
        given: "Un distributeur est créé"
            def distrib = new Distributeur()
            def produit1 = Mock(Produit)
            def produit2 = Mock(Produit)
            produit1.getNom() >> 'P1'
            produit2.getNom() >> 'P2'
        when: "on le remplit"
            distrib.remplir([(produit1):1, (produit2): 3])
        and: "on retire le produit1"
            distrib.distribue('P1')
        then: "le distributeur a 3 produits"
            distrib.nombreProduits() == 3
    }

    def "le distributeur n'a pas le produit voulu"() {
        given: "Un distributeur est créé"
            def distrib = new Distributeur()
        when: "on retire le produit1"
            distrib.distribue('P1')
        then: "une erreur est lancée"
            def e = thrown(DistributionException)
            e.message == 'Produit introuvable'
    }

}
