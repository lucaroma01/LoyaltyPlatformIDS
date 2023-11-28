package it.unicam.cs.ids.loyaltyplatform.Model;
import it.unicam.cs.ids.loyaltyplatform.Controller.ControllerPagamento;

import java.sql.SQLException;
public class Banca {
    private StatoPagamento pagamento;
    private final ControllerPagamento  statoPagamento;

    public Banca() {
        statoPagamento= new ControllerPagamento();
    }
    public StatoPagamento getPagamento() {
        return pagamento;
    }
    public StatoPagamento verificaPagamento(TitolarePuntoVendita t) throws SQLException {
        if (statoPagamento.payment(t)){
            pagamento=StatoPagamento.PAGATO;
        }else pagamento=StatoPagamento.In_Attesa;

        return pagamento;
    }
}

