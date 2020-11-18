package model.bean;

public class Filme {
	private int id_filme;
	private String titulo;
	private int duracao;
	private boolean imagem3d;
	private boolean dublado;
	private String sinopse;
	private String categoria;
	
	public int getId_filme() {
		return id_filme;
	}
	
	public void setId_filme(int id_filme) {
		this.id_filme = id_filme;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public int getDuracao() {
		return duracao;
	}
	
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	
	public boolean isImagem3d() {
		return imagem3d;
	}
	
	public void setImagem3d(boolean imagem3d) {
		this.imagem3d = imagem3d;
	}
	
	public boolean isDublado() {
		return dublado;
	}
	
	public void setDublado(boolean dublado) {
		this.dublado = dublado;
	}
	
	public String getSinopse() {
		return sinopse;
	}
	
	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
}
