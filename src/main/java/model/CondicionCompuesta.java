package model;

/**
 * Created by rapap on 05/07/2017.
 */
public class CondicionCompuesta extends Condicion{

    @Override
    public boolean MayorQueUnValor(Empresa empresa, double valor, Periodo perido) {
        return super.MayorQueUnValor(empresa, valor, perido);
        
    }
}
