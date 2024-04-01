import java.util.ArrayList;
import java.util.List;

public class AgendaTel {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();

        // Adicionando alguns contatos para teste
        agenda.adicionarContato(new Contato("João", "123456789"));
        agenda.adicionarContato(new Contato("Maria", "987654321"));

        // Buscando um contato pelo nome
        Contato contato = agenda.buscarContatoPorNome("João");
        if (contato != null) {
            System.out.println("Contato encontrado: " + contato.getNome() + " - " + contato.getTelefone());
        } else {
            System.out.println("Contato não encontrado.");
        }
    }
}

class Agenda {
    private List<Contato> contatos;

    public Agenda() {
        this.contatos = new ArrayList<>();
    }

    public void adicionarContato(Contato contato) {
        contatos.add(contato);
        System.out.println("Contato adicionado com sucesso: " + contato.getNome());
    }

    public void removerContato(Contato contato) {
        contatos.remove(contato);
        System.out.println("Contato removido com sucesso: " + contato.getNome());
    }

    public Contato buscarContatoPorNome(String nome) {
        for (Contato contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                return contato;
            }
        }
        return null;
    }
}

class Contato {
    private String nome;
    private String telefone;

    public Contato(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }
}
