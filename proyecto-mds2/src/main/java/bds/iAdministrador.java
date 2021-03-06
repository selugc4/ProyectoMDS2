package bds;

import org.orm.PersistentException;

import basededatos.Album;
import basededatos.Artista;
import basededatos.Cancion;
import basededatos.Estilo;
import basededatos.Imagen;
import basededatos.Usuario;
import basededatos.Usuario_Registrado;

public interface iAdministrador {
	public Estilo[] cargar_Estilos(String aNombre);

	public Cancion[] cargar_Canciones_Buscadas(String aNombre);

	public void Modificar_Canciones_Mostradas(int aNumero_Canciones);

	public void Eliminar_estilo(int aIdEstilo);

	public void Anadir_a_la_vista_de_cibernauta(int aIdCancion);

	public void Eliminar_Ultimo_Exito(int aIdCancion);

	public void Dar_alta_artista(String aCorreo, String aNombre, String aContrasena, String[] aEstilos, String aFoto);

	public void Dar_alta_cancion(String aTitulo, String aTitulo_Creditos, String aTitulo_Album, String aCompositores, String aProductores, String aInterpretes, String aArchivoMultimedia);

	public void Anadir_estilo(String aNombre);

	public void Dar_alta_album(String aNombre, Cancion[] aCanciones, Artista[] aArtistas, String aImagen, String fechaEdicion);

	public void Modificar_Correo(String aCorreoAntiguo, String aCorreoNuevo);

	public Usuario_Registrado[] cargar_Usuarios(String aNombre);

	public void Eliminar_usuario(String aCorreo);

	public void eliminar_Album(int aIdAlbum);

	public void eliminar_Artista(String aCorreo);

	public void eliminar_Cancion(int aIdCancion);

	public void Modificar_Cancion(int aIdCancion, String aArchivoMultimedia, String aInterpretes, String aProductores, String aCompositores, String aTitulo, String aTituloCreditos, String aTitulo_Album);

	public void Modificar_album(int aIdAlbum, String aTituloAlbum, Cancion[] aCanciones, String aImagen, Artista[] aArtistas);

	public void Modificar_Estilo(int aIdEstilo, String aNombre);

	public Album[] cargar_Albumes_Admin(String aNombre);
	
	public Cancion[] cargar_Ultimos_Exitos();
	
	public Album cargar_Album(int id);

	public Cancion cargar_Datos_Cancion(int aIdCancion);
	
	public boolean comprobarArtista(String correo, String nombre);
}