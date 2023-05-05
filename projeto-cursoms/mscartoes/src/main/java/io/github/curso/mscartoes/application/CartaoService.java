package io.github.curso.mscartoes.application;

import io.github.curso.mscartoes.domain.Cartao;
import io.github.curso.mscartoes.infra.repository.CartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartaoService {

    private final CartaoRepository cartaoRepository;

    @Transactional
    public Cartao save(Cartao cartao) {
        return cartaoRepository.save(cartao);
    }

    public List<Cartao> getCartoesRendaMenorIgual(Long renda) {
        return cartaoRepository.findByRendaLessThanEqual(BigDecimal.valueOf(renda));
    }
}