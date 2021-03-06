package clases;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import basededatos.Album;

public class Vista_album extends vistas.VistaVista_album {
//	private Image _foto_Album;
//	private Label _titulo_Album;
//	private Label _fecha_EdicionL;
//	private Label _artistasL;
//	public Album _album;
//	public Canciones_lista _canciones_lista;
	
	public Canciones_lista cl = new Canciones_lista();
	
	public Vista_album() {
		this.getStyle().set("width", "100%");
		this.cl.getLabel1().setText("No se han añadido canciones a este Álbum");
		this.cl.getVaadinButton().setVisible(false);
		VerticalLayout vl = this.getVaadinVerticalLayout().as(VerticalLayout.class);
		vl.add(cl);
	}

	public Vista_album(Album album) {
		this.getStyle().set("width", "100%");
		this.cl = new Canciones_lista(album);
		this.cl.getLabel1().setText("No se han añadido canciones a este Álbum");
		this.cl.getVaadinButton().setVisible(false);
		this.getLabel().setText(album.getTitutloAlbum());
		if(album.autor.isEmpty()) {
			this.getLabel1().setText("Artista no asignado");
		}else {
			basededatos.Artista[] artistas = album.autor.toArray();
			String cadena = "";
			for(int i = 0; i< artistas.length; i++) {
				if(i == artistas.length-1) {
					cadena+= artistas[i].getNombre();
				}else
					cadena += artistas[i].getNombre() +", ";
			}
			
			this.getLabel1().setText(cadena);
		}
		
	
		this.getLabel2().setText(album.getFechaEdicion());
			
		this.getImg().setSrc("imagenes/"+album.getContiene_imagen().getUrl());
		this.getImg().setWidth("250px");
		this.getImg().setHeight("250px");
		VerticalLayout vl = this.getVaadinVerticalLayout().as(VerticalLayout.class);
		vl.add(cl);
	}
	
	
}