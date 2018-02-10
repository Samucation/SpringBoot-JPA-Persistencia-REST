package br.com.jpa.com.spring.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.jpa.com.spring.model.Usuario;

public interface Usuarios extends JpaRepository<Usuario, Long>{
	
    Usuario findByNomeCompleto(String nomeCompleto);
	
    // Equivalente ao like, mas não precisamo nos preocupar com o sinal de percentual. 
    // Podemos usar também EndingWith, Containing.
    List<Usuario> findByNomeCompletoStartingWith(String nomeCompleto);
	
    // Ordenando pelo nome.
    List<Usuario> findByNomeCompletoStartingWithOrderByNomeCompleto(String nomeCompleto);
	
    // Não levar em consideração a caixa.
    List<Usuario> findByNomeCompletoStartingWithIgnoreCase(String nomeCompleto);

    // Pesquisando por duas propriedades: nome e ativo.
    List<Usuario> findByNomeCompletoStartingWithIgnoreCaseAndUsuarioAtivoEquals(String nomeCompleto, boolean usuarioAtivo);
	
    // Nesse caso, precisamos usar o sinal de percentual em nossas consultas.
    List<Usuario> findByNomeCompletoLike(String nomeCompleto);
	
    // Podemos usar também IsNotNull ou NotNull.
    List<Usuario> findByEnderecoIsNull(); 
	
    // Quando você quer negar o que passa no parâmetro
    List<Usuario> findByNomeCompletoNot(String nomeCompleto);
	
    // Todos os Usuarios com os IDs passados no varargs. Poderia usar NotIn para negar os IDs.
    List<Usuario> findByIdIn(Long... ids);
	
    // Todos onde a propriedade usuarioAtivo é true. Poderia ser falso, usando False.
    List<Usuario> findByUsuarioAtivoTrue();
	
    // Buscar onde a data de cadastro é depois do parâmetro passado. 
    // Pode ser usado Before também.
    List<Usuario> findByDataDoCadastroAfter(Date data);
	
    // Buscar onde a data cadastro está dentro de um período.
    List<Usuario> findByDataDoCadastroBetween(Date inicio, Date fim);
	
    // Todos com idade "menor que". Poderia ser usado
    // também LessThanEqual, GreaterThan, GreaterThanEqual.
    List<Usuario> findByIdadeLessThan(int idade);
    
    @Query("from Usuario where nome_completo like concat(?1, '%')")
    List<Usuario> pesquisarUsuarios(String nomeCompleto);

}
