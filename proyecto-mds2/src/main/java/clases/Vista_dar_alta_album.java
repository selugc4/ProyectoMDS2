package clases;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.notification.Notification;

public class Vista_dar_alta_album extends vistas.VistaVista_dar_alta_album{
//	private Label _titulo_Anadir_AlbumL;
//	private Label _titulo_AlbumL;
//	private TextField _titulo_AlbumTF;
//	private Label _nombre_ArtistasL;
//	private TextField _nombre_ArtistasTF;
//	private Label _imagenL;
//	private FileChooser _elegir_Foto;
//	private Image _foto;
//	private Label _lista_CancionesL;
//	private Button _anadir_CancionB;
//	private Dialog _anadir_CancionD;
//	private Label _fecha_EdicionL;
//	private Image _asignar_Fecha;
//	private Button _asignar_FechaB;
//	private Button _anadir_AlbumB;
//	private Button _volver_AtrasB;
//	public Menu_dar_alta _menu_dar_alta;
//	public Buscador_cancion_para_album _buscador_cancion_para_album;
//	public Canciones_modificar_y_crear _canciones_modificar_y_crear;

//	public void Elegir_foto() {
//		throw new UnsupportedOperationException();
//	}
//
//	public void Dar_alta_album() {
//		throw new UnsupportedOperationException();
//	}
//
//	public void volverAtras() {
//		throw new UnsupportedOperationException();
//	}
//
//	public void asignarFecha() {
//		throw new UnsupportedOperationException();
//	}
//
//	public void anadirCancion() {
//		throw new UnsupportedOperationException();
//	}
	
	public Canciones_modificar_y_crear canciones = new Canciones_modificar_y_crear();
	public Buscador_cancion_para_album bcpa = new Buscador_cancion_para_album();
	
	public Vista_dar_alta_album() {
		
		
		this.getBotonAdd().addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
			
			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				// AGREGAR DATOS
				
			}
		});
		
		this.getBotonFecha().addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
			
			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				// COGER DATO PARA GUARDAR
				Notification.show(getFechaDeEdición().getValue().toString());
				
			}
		});
		
		this.getBotonLista().addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
			
			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				Dialog diag = new Dialog(bcpa);
				diag.setWidth("100%");
				diag.open();
				
			}
		});
	}
}