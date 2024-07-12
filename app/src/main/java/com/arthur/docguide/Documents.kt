package com.arthur.docguide

class Documents {
    private val documents = mapOf(
        "Divórcio" to listOf("CPF", "Certidão de casamento"),
        "Aposentadoria" to listOf("INSS", "CPF"),
        "Alvará de Construção" to listOf("Projeto aprovado", "RG", "CPF"),
        "Registro de Nascimento" to listOf(
            "Declaração de Nascido Vivo",
            "RG dos pais",
            "CPF dos pais"
        ),
        "Compra de Imóvel" to listOf("Escritura", "RG", "CPF"),
        "Transferência de Veículo" to listOf("CRV", "CNH", "Comprovante de residência"),
        "Licenciamento de Veículo" to listOf("CRLV", "CNH", "Comprovante de pagamento"),
        "Casamento" to listOf("Certidão de nascimento", "RG", "CPF"),
        "Inventário" to listOf("Certidão de óbito", "RG", "CPF"),
        "Abertura de Empresa" to listOf("Contrato social", "RG", "CPF"),
        "Licença Ambiental" to listOf("Estudo de impacto ambiental", "RG", "CPF"),
        "Regularização de Imóvel" to listOf("Planta do imóvel", "RG", "CPF"),
        "Visto de Trabalho" to listOf("Passaporte", "Contrato de trabalho", "Foto"),
        "Renovação de Passaporte" to listOf("Passaporte antigo", "RG", "CPF"),
        "Seguro Desemprego" to listOf("Carteira de trabalho", "RG", "CPF"),
        "Bolsa de Estudos" to listOf("Histórico escolar", "RG", "CPF"),
        "Financiamento de Veículo" to listOf("Proposta de financiamento", "RG", "CPF"),
        "Empréstimo Bancário" to listOf("Comprovante de renda", "RG", "CPF"),
        "Solicitação de Bolsa Família" to listOf("Comprovante de renda", "RG", "CPF"),
        "Seguro de Vida" to listOf("Proposta de seguro", "RG", "CPF"),
        "Declaração de Imposto de Renda" to listOf("Informe de rendimentos", "RG", "CPF"),
        "Cadastro de Pessoa Física (CPF)" to listOf(
            "Certidão de nascimento",
            "RG dos pais",
            "Comprovante de residência"
        ),
        "Carteira de Identidade (RG)" to listOf(
            "Certidão de nascimento",
            "Foto",
            "Comprovante de residência"
        ),
        "Carteira Nacional de Habilitação (CNH)" to listOf(
            "RG",
            "CPF",
            "Comprovante de residência"
        ),
        "Registro de Óbito" to listOf("Declaração de óbito", "RG do falecido", "CPF do falecido"),
        "Título de Eleitor" to listOf("RG", "CPF", "Comprovante de residência"),
        "Regularização de Título de Eleitor" to listOf("Título de eleitor antigo", "RG", "CPF"),
        "Certidão de Antecedentes Criminais" to listOf("RG", "CPF"),
        "Pedido de Pensão" to listOf("Certidão de óbito", "RG", "CPF"),
        "Certidão de Quitação Eleitoral" to listOf("RG", "CPF")
    )

    fun getDocuments(document: String): List<String>? {
        return documents[document]
    }

    fun getProcess(): List<String> {
        val processes: MutableList<String> = mutableListOf()
        documents.forEach { (process) ->
            processes.add(process)
        }
        return processes.sorted()
    }
}