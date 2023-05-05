package io.github.curso.mscartoes.application;

import io.github.curso.mscartoes.domain.ClienteCartao;
import io.github.curso.mscartoes.infra.repository.ClienteCartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteCartaoService {

    private final ClienteCartaoRepository cartaoRepository;

    public List<ClienteCartao> listCartoesByCpf(String cpf) {
        return cartaoRepository.findByCpf(cpf);
    }
}