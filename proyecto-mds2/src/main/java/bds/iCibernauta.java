package bds;

import basededatos.Cancion;

public interface iCibernauta {

	public Cancion[] cargar_Ultimos_Exitos();

	public void consultar_Datos(String aNombre, String aContrasena);

	public void guardar_Datos(String aEmail, String aNombre, String aContrasena, String aFoto);

	public boolean validar_Datos(String aNombre, String aEmail);

	public boolean consultar_Correo(String aCorreo);

	public void guardar_Contrasena(String aContrasena, String aCorreo);

}