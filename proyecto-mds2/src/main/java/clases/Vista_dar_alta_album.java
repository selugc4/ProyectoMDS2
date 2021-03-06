package clases;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.orm.PersistentException;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.server.StreamResource;

import basededatos.ArtistaDAO;
import basededatos.CancionDAO;
import basededatos.UsuarioDAO;
import bds.BDPrincipal;
import bds.iAdministrador;

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
	public static Canciones_modificar_y_crear canciones;
	public Buscador_cancion_para_album bcpa = new Buscador_cancion_para_album(0);
	private InputStream fileData;
	private String fileName;
	private File ruta;
	String separator = System.getProperty("file.separator");
	String rutaArchivo = System.getProperty("user.dir")+ separator+ "src" + separator+ "main" +separator+ "resources" + separator + "META-INF" +separator+ "resources"+separator+"imagenes"+separator;
	String rutaArchivoFinal;
	private String fechaedicion;

	
	
	public Vista_dar_alta_album() {
		canciones = new Canciones_modificar_y_crear(3);
		iAdministrador iadmin = new BDPrincipal();
		MemoryBuffer mbuf = new MemoryBuffer();
		VerticalLayout vertical = this.getVaadinVerticalLayout3().as(VerticalLayout.class);
		VerticalLayout vl = getVerticalListado().as(VerticalLayout.class);	
		vl.add(canciones);
		
		File imagenDefault = new File(rutaArchivo+"fotoalbum.png");
		InputStream aux ;
		StreamResource imageResource;
		try {
			aux = FileUtils.openInputStream(imagenDefault);
			imageResource = new StreamResource("fotoDefaultAlbum.png",() -> aux); 
			Image image = new Image(imageResource, "");
			image.getStyle().set("height", "125px");
			image.getStyle().set("width", "125px");
			vertical.add(image);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		
		
		this.getVaadinUpload().setReceiver(mbuf);	
		this.getVaadinUpload().addSucceededListener(event ->{

		

			fileData = mbuf.getInputStream();
	
		    fileName = event.getFileName();		  
		    ruta = new File(rutaArchivo+fileName);
		    
		   
		    try {
				FileUtils.copyInputStreamToFile(fileData, ruta);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			StreamResource imageResource2;
			try {
				InputStream aux2 = FileUtils.openInputStream(ruta);
				imageResource2 = new StreamResource("fotoSubida.png",() -> aux2); 
				Image image = new Image(imageResource2, "");
				image.getStyle().set("height", "125px");
				image.getStyle().set("width", "125px");
				vertical.removeAll();
				vertical.add(image);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rutaArchivoFinal =fileName;
		
		    
		});
		this.getStyle().set("width", "100%");		
	
		
		this.getBotonAdd().addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
			
			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				if(getVaadinTextField().getValue().isEmpty() || getFechaDeEdicion().getValue() == null || canciones._canciones.size()==0) {
					Notification.show("Debe rellenar todos los campos");
					}
				else {
					String titulo = getVaadinTextField().getValue();
					String fechaEdicion = fechaedicion;
					basededatos.Cancion[] cancionesAlbum = new basededatos.Cancion[canciones._canciones.size()];
					int i = 0;
					for(Cancion cancion: canciones._canciones) {
						try {
							basededatos.Cancion cancion1= CancionDAO.loadCancionByQuery("Titulo='"+cancion.getLabel().getText()+"'", null);
							cancionesAlbum[i] = cancion1;
							} catch (PersistentException e) {
								e.printStackTrace();
								}
						i++;
						}
					basededatos.Artista[] artistas = new basededatos.Artista[0];
					if(!getVaadinTextField1().getValue().isEmpty()) {
						String[] NombreArtistas = getVaadinTextField1().getValue().split(",");
						artistas = new basededatos.Artista[NombreArtistas.length];
						int j = 0;
						for(String artista: NombreArtistas) {
							try {
								basededatos.Artista artistaAlbum = ArtistaDAO.getArtistaByORMID(UsuarioDAO.loadUsuarioByQuery("Nombre='"+artista+"'", null).getID());
								artistas[j] = artistaAlbum;
								} catch (PersistentException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
									}
							j++;
							}
						}
					if(fileName == null) {
						rutaArchivoFinal = "fotoalbum.png";
					}
					iadmin.Dar_alta_album(titulo, cancionesAlbum, artistas, rutaArchivoFinal, fechaEdicion);
					VerticalLayout vl = getVaadinVerticalLayout().as(VerticalLayout.class);
					vl.removeAll();
					vl.add(new Menu_dar_alta());
					Notification.show("Album agregado con exito");
					}
				}
			});
		
		this.getBotonFecha().addClickListener(new ComponentEventListener<ClickEvent<Button>>() {		

			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				// COGER DATO PARA GUARDAR
			 fechaedicion = getFechaDeEdicion().getValue().toString();
			 Notification.show("Fecha guardada " + fechaedicion);
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