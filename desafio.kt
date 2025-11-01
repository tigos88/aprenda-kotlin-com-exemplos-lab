enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val nome: String)

data class ConteudoEducacional(
    val nome: String,
    val duracao: Int = 60,
    val nivel: Nivel = Nivel.BASICO
)

data class Formacao(
    val nome: String,
    val conteudos: MutableList<ConteudoEducacional>,
    val capacidade: Int = 10
) {
    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario): Boolean {
        if (inscritos.contains(usuario)) {
            println("${usuario.nome} já está matriculado em \"$nome\".")
            return false
        }
        if (inscritos.size >= capacidade) {
            println("Sem vagas para $nome.")
            return false
        }
        inscritos.add(usuario)
        println("${usuario.nome} matriculado em \"$nome\".")
        return true
    }
}

fun main() {
    val basico = ConteudoEducacional("Kotlin Básico", 90, Nivel.BASICO)
    val medio = ConteudoEducacional("POO com Kotlin", 120, Nivel.INTERMEDIARIO)

    val formacao = Formacao("Formação Kotlin", mutableListOf(basico, medio))

    val a = Usuario("Ana")
    val b = Usuario("Bruno")
    val c = Usuario("Carla")

    formacao.matricular(a)
    formacao.matricular(b)
    formacao.matricular(a)
    formacao.matricular(c)

    println("Inscritos:")
    for (i in formacao.inscritos) {
        println(i.nome)
    }
}
