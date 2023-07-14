package Model;

public class JavaBeans
{
	private String id_consulta;
	private String nome_cliente;
	private String nome_pet;
	private String id_anim;
	private String id_vet;
	private String data_consulta;
	
	
	public JavaBeans() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public JavaBeans(String id_consulta, String nome_cliente, String nome_pet, String id_anim, String id_vet,
			String data_consulta) {
		super();
		this.id_consulta = id_consulta;
		this.nome_cliente = nome_cliente;
		this.nome_pet = nome_pet;
		this.id_anim = id_anim;
		this.id_vet = id_vet;
		this.data_consulta = data_consulta;
	}


	/**
	 * @return the id_consulta
	 */
	public String getId_consulta() {
		return id_consulta;
	}
	/**
	 * @param id_consulta the id_consulta to set
	 */
	public void setId_consulta(String id_consulta) {
		this.id_consulta = id_consulta;
	}
	/**
	 * @return the nome_cliente
	 */
	public String getNome_cliente() {
		return nome_cliente;
	}
	/**
	 * @param nome_cliente the nome_cliente to set
	 */
	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}
	/**
	 * @return the nome_pet
	 */
	public String getNome_pet() {
		return nome_pet;
	}
	/**
	 * @param nome_pet the nome_pet to set
	 */
	public void setNome_pet(String nome_pet) {
		this.nome_pet = nome_pet;
	}
	/**
	 * @return the id_anim
	 */
	public String getId_anim() {
		return id_anim;
	}
	/**
	 * @param id_anim the id_anim to set
	 */
	public void setId_anim(String id_anim) {
		this.id_anim = id_anim;
	}
	/**
	 * @return the id_vet
	 */
	public String getId_vet() {
		return id_vet;
	}
	/**
	 * @param id_vet the id_vet to set
	 */
	public void setId_vet(String id_vet) {
		this.id_vet = id_vet;
	}
	/**
	 * @return the data_consulta
	 */
	public String getData_consulta() {
		return data_consulta;
	}
	/**
	 * @param data_consulta the data_consulta to set
	 */
	public void setData_consulta(String data_consulta) {
		this.data_consulta = data_consulta;
	}
	
	
}