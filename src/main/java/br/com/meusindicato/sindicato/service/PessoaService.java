package br.com.meusindicato.sindicato.service;

import br.com.meusindicato.sindicato.dto.*;
import br.com.meusindicato.sindicato.model.*;
import br.com.meusindicato.sindicato.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private FormacaoRepository formacaoRepository;

    @Autowired
    private LotacaoRepository lotacaoRepository;

    @Autowired
    private CargoRepository cargoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<PaisDTO> listaPaises() {

        List<Pais> paisList = paisRepository.findByOrderByNomePais();

        return paisList.stream()
                .map(p -> new PaisDTO(p.getPaisId(),p.getNomePais(),p.getSiglaPais()))
                .collect(Collectors.toList());
    }

    public List<EstadoDTO> listaEstados(Long paisId) {

            Optional<Pais> paisOptional = paisRepository.findById(paisId);
            if (paisOptional.isPresent()){
                return converteEstado(estadoRepository.findByPais(paisOptional.get()));
            }
            return null;
    }

    public List<CidadeDTO> listaCidades(Long estadoId) {


        Optional<Estado> estadoOptional = estadoRepository.findById(estadoId);
//        if (estadoOptional.isPresent()){
//
//            return converteCidade(cidadeRepository.findByEstado(estadoOptional.get()));
//        }
        return null;
    }

    public static List<EstadoDTO> converteEstado(List<Estado> estados){

        return estados.stream()
                .map(e -> new EstadoDTO(e.getEstadoId(),e.getEstadoNome(),e.getUF(),e.getPais().getPaisId()))
                .collect(Collectors.toList());
    }

    public static List<CidadeDTO> converteCidade(List<Cidade> cidades){

        return cidades.stream()
                .map(c -> new CidadeDTO(c.getCidadeId(),c.getCidadeNome(),c.getEstado().getEstadoId()))
                .collect(Collectors.toList());
    }

    public List<FormacaoDTO> listaFormacoes() {
        List<Formacao> formacaoList = formacaoRepository.findByOrderByFormacaoCodigo();
        return formacaoList.stream()
                .map(f -> new FormacaoDTO(f.getFormacaoCodigo(),f.getNomeFormacao()))
                .collect(Collectors.toList());
    }

    public List<LotacaoDTO> listaLotacoes() {
        List<Lotacao> lotacaoList = lotacaoRepository.findByOrderByLotacaoDescricao();
        return lotacaoList.stream().map(
                l -> new LotacaoDTO(l.getLotacaoId(),l.getLotacaoDescricao())
        ).collect(Collectors.toList());
    }

    public ResponseEntity<Boolean> cadastraPessoa(PessoaDTO p) {

    try{
        Optional<Cidade> cidadeOptional = cidadeRepository.findById(p.cidadeAtualId());
        Optional<Cidade> cidadeNaturalOptional = cidadeRepository.findById(p.cidadeNaturalId());
        Optional<Formacao> formacaoOptional = formacaoRepository.findById(p.formacaoId());
        Optional<Lotacao> lotacaoOptional = lotacaoRepository.findById(p.lotacaoId());
        Optional<Cargo> cargoOptional = cargoRepository.findById(p.CargoId());
        Nivel nivel = Nivel.fromInteger(p.nivel());
        Classe classe = Classe.fromString(p.classe());
        Sexo sexo = Sexo.fromString(p.sexo());
        EstadoCivil estadoCivil = EstadoCivil.fromString(p.estadoCivil());
        Optional<Lotacao> lotacao = lotacaoRepository.findById(p.lotacaoId());
        Status status = Status.fromString(p.status());

        Pessoa pessoa = new Pessoa(p.nomeCompleto(),p.rg(),p.orgaoExpedidor(),p.dataEmissaoRg(),
                p.cep(),p.endereco(),p.bairro(),
                cidadeOptional.get(),cidadeNaturalOptional.get(),p.email(),
                p.telefone(),p.celular(),p.watsapp(),
                formacaoOptional.get(),p.dataNascimento(),sexo,
                estadoCivil,p.nomeMae(),p.nomePai(),
                nivel,classe,p.padrao(),
                cargoOptional.get(),lotacaoOptional.get(),p.dataFiliacao(),
                status);
        System.out.println(pessoa);
        pessoaRepository.save(pessoa);

    } catch (RuntimeException e) {
        System.out.println(e.getMessage());
        return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
    }

        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    public List<CargoDTO> listaCargos() {
        System.out.println("Entra cargo lista");
        List<Cargo> cargoList = cargoRepository.findByOrderByCargoDescricao();
        System.out.println(cargoList);
        return cargoList.stream()
                .map(c -> new CargoDTO(c.getCargoId(),c.getCargoCodigo(),c.getCargoDescricao()))
                .collect(Collectors.toList());
    }
}