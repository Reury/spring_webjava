package users;

public class Usuario {
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", senha=" + senha + ", email=" + email + ", dd=" + dd
				+ ", numero=" + numero + ", tipo=" + tipo + "]";
	}

	private int id;
	private String nome;
	private String senha;
	private String email;
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	private int dd;
	private String numero;
	private String tipo;



	public Usuario(int id, String nome, String senha, String email, int dd, String numero, String tipo) {
		
		this(nome,senha,email,dd,numero,tipo);
		this.id = id;;
	}
	
	public Usuario(String nome, String email, String senha, int dd, String numero, String tipo) {
		this.nome = nome;
		this.senha = senha;
		this.email = email;
		this.dd = dd;
		this.numero = numero;
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getDd() {
		return dd;
	}

	public void setDd(int dd) {
		this.dd = dd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
