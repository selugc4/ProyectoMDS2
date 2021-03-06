package clases;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.server.StreamResource;

import bds.BDPrincipal;
import bds.iCibernauta;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class Cibernauta extends vistas.VistaCibernauta {
//	public Cabecera_cibernauta _cabecera_cibernauta;
//	public Reproductor_canciones_simple _reproductor_canciones_simple;
//	public Ultimos_exitos _ultimos_exitos;
	
	public static Button button = new Button("Ver créditos");
	public Cabecera_cibernauta cc = new Cabecera_cibernauta();
	public Ultimos_exitos ue= new Ultimos_exitos();
	public static Reproductor_canciones_simple rcs = new Reproductor_canciones_simple();
	public InputStream fileData;
	private File ruta;
	String separator = System.getProperty("file.separator");
	public String rutaArchivo = System.getProperty("user.dir")+ separator+ "src" + separator+ "main" +separator+ "resources" + separator+ "META-INF" +separator+ "resources"+ separator+ "imagenes" + separator;
	String rutaArchivoFinal;
	
	public static String correo;
	
	public Cibernauta() {
		this.getStyle().set("width", "100%");
		HorizontalLayout h1 = this.getVaadinHorizontalLayout();
		VerticalLayout v1 = this.getVaadinVerticalLayout1().as(VerticalLayout.class);
		HorizontalLayout h2 = this.getVaadinHorizontalLayout1();
		
		h1.add(cc);
		v1.add(ue);
		h2.add(rcs);
		button.getStyle().set("width", "10%");
		button.setVisible(false);
		button.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {	
			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				v1.removeAll();
				v1.add(rcs.vcre);
				
			}
		});
		h2.add(button);
		
	
		
		cc.getVaadinHorizontalLayout1().addClickListener(new ComponentEventListener<ClickEvent<HorizontalLayout>>() {
			
			@Override
			public void onComponentEvent(ClickEvent<HorizontalLayout> event) {
				ue = new Ultimos_exitos();
				v1.removeAll();	
				v1.add(ue);
		
				
			}
		}); 
			
		
		//REGISTRO
		cc.getVaadinButton().addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
		
			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				v1.removeAll();
				cc.getReg().getImg().setSrc("imagenes/fotousuario.png");
				cc.reg.getTfemail().clear();
				cc.reg.getTfusuario().clear();
				cc.reg.getTfccontrasena().clear();
				cc.reg.getTfcontrasena1().clear();
				cc.reg.getVaadinProgressBar().getStyle().set("background-color", "none");
				cc.reg.getHorizontalUpload().removeAll();
				Upload upload = new Upload();
				cc.reg.fileName = "fotousuario.png";
				fileData = null;
				MemoryBuffer mbuf = new MemoryBuffer();
				upload.setReceiver(mbuf);	
				upload.addSucceededListener(evento ->{

					fileData = mbuf.getInputStream();
			
				    cc.reg.fileName = evento.getFileName();		  
				    ruta = new File(rutaArchivo + cc.reg.fileName);
				    
				   
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
						cc.reg.setImg(image);
						cc.reg.getHorizontalimg().removeAll();
						cc.reg.getHorizontalimg().add(image);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				    });
				cc.reg.getHorizontalUpload().add(upload);
				cc.getReg().getNivelSec().setText("");
				v1.add(cc.getReg());
				}
		});
		
		//REGISTRARSE 
		cc.getReg().getBotonRegistro().addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
			
			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				if(cc.getReg().validarDatosInternos()) {
					if(cc.getReg().validarDatos()) {
					cc.getReg().registrarse();
					v1.removeAll();
					cc.getReg().getVr().getTfCodigo().clear();
					v1.add(cc.getReg().getVr());
					
					Notification.show("Revise su correo");
					}else
						Notification.show("El nombre de usuario o el correo están siendo utilizados");
				
					
			}else {
				Notification.show("Error: Revise algun campo");
			}}
		});
		
		
		//Volver ATRAS Registro
		cc.getReg().getBotonVolver().addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
			
			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
					v1.replace(cc.getReg(), ue);
				
			}
				
		});
		
		
		
		//INICIAR SESION
		cc.getVaadinButton1().addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
			
			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				v1.removeAll();			
				cc.is.getTfUsuario().clear();
				cc.is.getTfPass().clear();
				v1.add(cc.getIs());
			}
		});
		
	
		
		//VOLVER ATRAS VerificacionRegistro
		
		cc.getReg().getVr().getBotonVolver().addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
			
			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				v1.removeAll();
				v1.add(cc.getReg());
				
			}
		});
		
		//ACEPTAR VerificacionRegistro
		cc.getReg().getVr().getBotonAceptar().addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
			
			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				if(cc.getReg().getVr().comprobarCodigo()) {
					v1.removeAll();
					v1.add(ue);
					Notification.show("Registro completado. Ya puede iniciar sesión");
					
			}else {
				Notification.show("Error: Fallo en el registro. Intente de nuevo");
			}}
		});
		
		
		//Registrate IniciarSesion
		
		cc.getIs().getBotonRegistro().addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
			
			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				v1.removeAll();
				cc.getReg().getImg().setSrc("imagenes/fotousuario.png");
				cc.reg.getTfemail().clear();
				cc.reg.getTfusuario().clear();
				cc.reg.getTfccontrasena().clear();
				cc.reg.getTfcontrasena1().clear();
				cc.reg.getVaadinProgressBar().getStyle().set("background-color", "none");
				cc.getReg().getNivelSec().setText("");
				cc.reg.getHorizontalUpload().removeAll();
				Upload upload = new Upload();
				cc.reg.fileName = "fotousuario.png";
				fileData = null;
				MemoryBuffer mbuf = new MemoryBuffer();
				upload.setReceiver(mbuf);	
				upload.addSucceededListener(evento ->{

					fileData = mbuf.getInputStream();
			
				    cc.reg.fileName = evento.getFileName();		  
				    ruta = new File(rutaArchivo + cc.reg.fileName);
				    
				   
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
						cc.reg.setImg(image);
						cc.reg.getHorizontalimg().removeAll();
						cc.reg.getHorizontalimg().add(image);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				    });
				cc.reg.getHorizontalUpload().add(upload);
				v1.add(cc.getReg());		
			}
		});

		//VolverAtras Iniciar Sesion
		cc.getIs().getBotonVolver().addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
			
			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				v1.removeAll();
				
				v1.add(ue);
		
				
			}
		});
		
		//RecuperarCuenta
		
		cc.getIs().getBotonRecuperar().addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
			
			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				v1.replace(cc.getIs(), cc.getIs().getRc());
				
			}
		});
		
		//Volver-RecuperarCuenta
		
		cc.getIs().getRc().getBotonVolver().addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
			
			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				cc.is.getTfUsuario().clear();
				cc.is.getTfPass().clear();
				v1.replace(cc.getIs().getRc(), cc.getIs());
				cc.getIs().getRc().getTfCorreo().clear();
				
			}
		});
		
		//ConfirmarCorreo
		cc.getIs().getRc().getBotonConfirmar().addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
			
			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				if(cc.getIs().getRc().validar_correo()) {
					cc.getReg().getVr().getTfCodigo().clear();
					v1.replace(cc.getIs().getRc(), cc.getIs().getRc().getVr());
					cc.getIs().getRc().getTfCorreo().clear();
				}else {
					Notification.show("Correo no existente");
				}
				
			}
		});
		
		
		//Recuperar cuenta- volver a enviar codigo
		
		cc.getIs().getRc().getVr().getBotonVolverEnviar().addClickListener(new ComponentEventListener<ClickEvent<Button>>() {			
			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
					Notification.show("Código enviado de nuevo");
			}
		
		});
		
		//Recuperar cuenta- volver atras
		
		cc.getIs().getRc().getVr().getBotonVolver().addClickListener(new ComponentEventListener<ClickEvent<Button>>() {			
			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
					v1.replace(cc.getIs().getRc().getVr(), cc.getIs().getRc());
					cc.getIs().getRc().getVr().getTfCodigo().clear();
			}
			
		});
		
		//Recuperar cuenta- Cambiar contrasena
		cc.getIs().getRc().getVr().getBotonCContrasena().addClickListener(new ComponentEventListener<ClickEvent<Button>>() {			
			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				if(cc.getIs().getRc().getVr().comprobarCodigo()) {
					v1.replace(cc.getIs().getRc().getVr(), cc.getIs().getRc().getVr().getNc());
					cc.getIs().getRc().getVr().getTfCodigo().clear();
				}else
					Notification.show("Codigo incorrecto. Compruebelo");
					
			}
			
		});
		
		//NuevaContrasena- Volver atras
		
		cc.getIs().getRc().getVr().getNc().getBotonVolver().addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
			
			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				v1.replace(cc.getIs().getRc().getVr().getNc(), cc.getIs().getRc().getVr());
				cc.getIs().getRc().getVr().getNc().getTfPass().clear();
				cc.getIs().getRc().getVr().getNc().getTfPassC().clear();
				cc.getIs().getRc().getVr().getNc().getLabelSec1().setText("Su contraseña tiene un nivel de seguridad");
				cc.getIs().getRc().getVr().getNc().getVaadinProgressBar().getStyle().set("background-color", "none");
			}
		});
		
		//NuevaContrasena - ConfirmarCC
		cc.getIs().getRc().getVr().getNc().getBotonConfirmar().addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
			
			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				if(cc.getIs().getRc().getVr().getNc().validarContrasena() && cc.getIs().getRc().getVr().getNc().passIguales()) {
					cc.getIs().getRc().getVr().getNc().confirmar_contrasena();
					v1.replace(cc.getIs().getRc().getVr().getNc(), ue);
					cc.getIs().getRc().getVr().getNc().getTfPass().clear();
					cc.getIs().getRc().getVr().getNc().getTfPassC().clear();
					cc.getIs().getRc().getVr().getNc().getLabelSec1().setText("Su contraseña tiene un nivel de seguridad");
					cc.getIs().getRc().getVr().getNc().getVaadinProgressBar().getStyle().set("background-color", "none");
					Notification.show("Contraseña cambiada");
				}else
					Notification.show("Contraseña no válida o no coinciden");
				
				
			}
		});
		
	}
	public Cabecera_cibernauta getCc() {
		return cc;
	}
	public Ultimos_exitos getUe() {
		return ue;
	}
	public static Reproductor_canciones_simple getRcs() {
		return rcs;
	}	
	
	public void iniciarSesion() {
		cc.getIs().iniciarSesion();
	}
}

	
