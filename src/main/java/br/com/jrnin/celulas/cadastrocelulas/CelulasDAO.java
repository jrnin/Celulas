package br.com.jrnin.celulas.cadastrocelulas;
import java.util.List;
import br.com.jrnin.celulas.usuario.Usuario;
public interface CelulasDAO {public void salvar(Celulas celulas);
public void excluir(Celulas celulas);
public Celulas carregar(Integer celulas);
public List<Celulas> listar(Usuario usuario); 
public Celulas buscarFavorita(Usuario usuario); 
} 