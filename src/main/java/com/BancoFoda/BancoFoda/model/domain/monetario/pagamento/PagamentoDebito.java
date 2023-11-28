package com.BancoFoda.BancoFoda.model.domain.monetario.pagamento;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value="debito")
public class PagamentoDebito extends Pagamento
{
}
