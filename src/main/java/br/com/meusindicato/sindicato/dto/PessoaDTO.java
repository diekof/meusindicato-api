package br.com.meusindicato.sindicato.dto;

import br.com.meusindicato.sindicato.model.Classe;
import br.com.meusindicato.sindicato.model.Nivel;
import br.com.meusindicato.sindicato.model.Sexo;
import br.com.meusindicato.sindicato.model.Status;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PessoaDTO(Long pessoaId,
                        @JsonAlias("nomeCompleto") String nomeCompleto,
                        @JsonAlias("rg") Integer rg,
                        @JsonAlias("orgaoExpedidor")String orgaoExpedidor,
                        @JsonAlias("dataEmissaoRg")Date dataEmissaoRg,
                        @JsonAlias("cep")Integer cep,
                        @JsonAlias("endereco")String endereco,
                        @JsonAlias("bairro")String bairro,
                        @JsonAlias("cidadeAtual")Long cidadeAtualId,
                        @JsonAlias("cidadeNatural")Long cidadeNaturalId,
                        @JsonAlias("email")String email,
                        @JsonAlias("telefone")String telefone,
                        @JsonAlias("celular")String celular,
                        @JsonAlias("watsapp") String watsapp,
                        @JsonAlias("formacaoId")Long formacaoId,
                        @JsonAlias("dataNascimento") Date dataNascimento,
                        @JsonAlias("sexo") String sexo,
                        @JsonAlias("estadoCivil") String estadoCivil,
                        @JsonAlias("nomeMae") String nomeMae,
                        @JsonAlias("nomePai") String nomePai,
                        @JsonAlias("cargo") Long CargoId,
                        @JsonAlias("lotacao") Long lotacaoId,
                        @JsonAlias("nivel") Integer nivel,
                        @JsonAlias("classe") String classe,
                        @JsonAlias("padrao") Integer padrao,
                        @JsonAlias("dataFiliacao") Date dataFiliacao,
                        @JsonAlias("status") String status) {
}
