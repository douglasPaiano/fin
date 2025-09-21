package com.douglas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douglas.DTO.DebitDTO;
import com.douglas.manager.user.DefaultUserManager;
import com.douglas.model.DebitModel;
import com.douglas.model.InvoiceCycleModel;
import com.douglas.repository.DebitRepository;
import com.douglas.repository.InvoiceCycleRepository;

@Service
public class DebitService {

    @Autowired
    private DebitRepository debitRepository;
    @Autowired
    private InvoiceCycleRepository invoiceCycleRepository;
    @Autowired
    private DefaultUserManager defaultUserManager;

    public List<DebitModel> debitList() {
        List<DebitModel> debitList = debitRepository.findAll();

        return debitList;
    }
    public List<InvoiceCycleModel> allCycleByUser(){

        List<InvoiceCycleModel> cycleList= invoiceCycleRepository.findAllById(defaultUserManager.getUserByUsername());

        return cycleList;
    }

    public String saveDebit(DebitDTO debit){
        DebitModel debitModel = new DebitModel();
        InvoiceCycleModel invoiceModel = new InvoiceCycleModel();
        invoiceModel.setId(debit.getCiclo());

        debitModel.setCiclo(invoiceModel);
        debitModel.setUsuario(defaultUserManager.getUserByUsername());
        debitModel.setValor(debit.getValor());
        debitModel.setTipoCompra(debit.getTipoCompra());
        debitModel.setNomeComprador(debit.getNomeComprador());
        debitModel.setTipoPagamento(debit.getTipoPagamento());
        debitModel.setNumeroParcelas(debit.getNumeroParcelas());
        debitModel.setValorParcelas(debit.getValorParcelas());
        debitModel.setJuros(debit.getJuros());
        debitModel.setValorJuros(debit.getValorJuros());
        debitModel.setLocalCompra(debit.getLocalCompra());
        debitModel.setDataCompra(debit.getDataCompra());
        debitModel.setDataPagamento(debit.getDataPagamento());
        
        debitRepository.save(debitModel);

        return "redirect:/Debito";
    }

}
