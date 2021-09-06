package br.inatel.cdg.algebra;

public class Reta {
    public Ponto p1 = new Ponto();
    public Ponto p2 = new Ponto();

    public double coeficienteAngular(){
        double ca = (p2.y - p1.y)/(p2.x - p1.x);
        return ca;
    }
    public double coeficienteLinear(){
        double cl = p1.y-(coeficienteAngular()* p1.x);
        return cl;
    }
}
