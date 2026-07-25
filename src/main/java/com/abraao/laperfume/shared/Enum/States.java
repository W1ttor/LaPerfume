package com.abraao.laperfume.shared.Enum;

public enum States {
    ACRE("Acre", "AC", "Rio Branco"),
    ALAGOAS("Alagoas", "AL", "Maceió"),
    AMAPA("Amapá", "AP", "Macapá"),
    AMAZONAS("Amazonas", "AM", "Manaus"),
    BAHIA("Bahia", "BA", "Salvador"),
    CEARA("Ceará", "CE", "Fortaleza"),
    DISTRITO_FEDERAL("Distrito Federal", "DF", "Brasília"),
    ESPIRITO_SANTO("Espírito Santo", "ES", "Vitória"),
    GOIAS("Goiás", "GO", "Goiânia"),
    MARANHAO("Maranhão", "MA", "São Luís"),
    MATO_GROSSO("Mato Grosso", "MT", "Cuiabá"),
    MATO_GROSSO_DO_SUL("Mato Grosso do Sul", "MS", "Campo Grande"),
    MINAS_GERAIS("Minas Gerais", "MG", "Belo Horizonte"),
    PARA("Pará", "PA", "Belém"),
    PARAIBA("Paraíba", "PB", "João Pessoa"),
    PARANA("Paraná", "PR", "Curitiba"),
    PERNAMBUCO("Pernambuco", "PE", "Recife"),
    PIAUI("Piauí", "PI", "Teresina"),
    RIO_DE_JANEIRO("Rio de Janeiro", "RJ", "Rio de Janeiro"),
    RIO_GRANDE_DO_NORTE("Rio Grande do Norte", "RN", "Natal"),
    RIO_GRANDE_DO_SUL("Rio Grande do Sul", "RS", "Porto Alegre"),
    RONDONIA("Rondônia", "RO", "Porto Velho"),
    RORAIMA("Roraima", "RR", "Boa Vista"),
    SANTA_CATARINA("Santa Catarina", "SC", "Florianópolis"),
    SAO_PAULO("São Paulo", "SP", "São Paulo"),
    SERGIPE("Sergipe", "SE", "Aracaju"),
    TOCANTINS("Tocantins", "TO", "Palmas");

    private final String nome;
    private final String sigla;
    private final String capital;

    States(String nome, String sigla, String capital) {
        this.nome = nome;
        this.sigla = sigla;
        this.capital = capital;
    }

    public String getNome() {
        return nome;
    }

    public String getSigla() {
        return sigla;
    }

    public String getCapital() {
        return capital;
    }

    // Lookup method to find a state by its abbreviation (e.g., "GO", "SP")
    public static States porSigla(String sigla) {
        for (States estado : values()) {
            if (estado.getSigla().equalsIgnoreCase(sigla)) {
                return estado;
            }
        }
        throw new IllegalArgumentException("Sigla de estado inválida: " + sigla);
    }
}

