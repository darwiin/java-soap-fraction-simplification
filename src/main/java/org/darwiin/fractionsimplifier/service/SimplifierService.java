package org.darwiin.fractionsimplifier.service;

import org.darwiin.soap.Fraction;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class SimplifierService {

    public Fraction simplify(Fraction f) {
        BigInteger pgcd = this.pgcd(f.getNumerateur(), f.getDenominateur());

        Fraction result = new Fraction();
        result.setNumerateur(f.getNumerateur().divide(pgcd));
        result.setDenominateur(f.getDenominateur().divide(pgcd));
        return result;
    }

    private BigInteger pgcd(BigInteger a, BigInteger b) {
        return a.gcd(b);
    }
}
