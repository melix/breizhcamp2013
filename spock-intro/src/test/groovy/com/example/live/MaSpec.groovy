package com.example.live

import com.example.toto.Adder
import spock.lang.Specification
import spock.lang.Unroll

class MaSpec extends Specification {
    def "somme de deux nombres"() {
        given:
        def adder = new Adder()
        when:
        def x = adder.sum(2, 2)
        then:
        x == 4
    }

    @Unroll("La somme de #x et #y vaut #z")
    def "somme de deux nombres en utilisant given expect where"() {
        given:
        def adder = new Adder()
        expect:
        z == adder.sum(x, y)
        where:
        x | y || z
        1 | 0 || 1
        2 | 2 || 4
        3 | 6 || 9
    }
}
