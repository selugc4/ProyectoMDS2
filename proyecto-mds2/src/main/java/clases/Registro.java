package clases;

import java.util.regex.Pattern;

public class Registro extends vistas.VistaRegistro {
//	private Label _titulo_Registro;
//	private Label _emailL;
//	private TextField _emailTF;
//	private Label _nombre_UsuarioL;
//	private TextField _nombre_UsuarioTF;
//	private Label _mensaje_malsonanteL;
//	private Label _nueva_ContrasenaL;
//	private TextField _nueva_ContrasenaTF;
//	private Label _mensaje_formato_ContrasenaL;
//	private Slider _barra_Seguridad;
//	private Label _nivel_seguridadL;
//	private Label _confirmar_nueva_ContrasenaL;
//	private TextField _confirmar_nueva_ContrasenaTF;
//	private FileChooser _elegir_Foto;
//	private Image _foto;
//	private Button _volver_atrasB;
//	private Button _registrarseB;
//	public Iniciar_sesion _iniciar_sesion;
//	public Cabecera_cibernauta _cabecera_cibernauta;
//	public Verificacion_registro _verificacion_registro;

//	public void Validar_correo() {
//		throw new UnsupportedOperationException();
//	}
//
//	public void Registrarse() {
//		throw new UnsupportedOperationException();
//	}
//
//	public void Validar_contrasena() {
//		throw new UnsupportedOperationException();
//	}
//
//	public void Elegir_foto() {
//		throw new UnsupportedOperationException();
//	}
//
//	public void Validar_nombre_de_usuario() {
//		throw new UnsupportedOperationException();
//	}
//
//	public void volverAtras() {
//		throw new UnsupportedOperationException();

//	}
	
	public Verificacion_registro vr = new Verificacion_registro();
	
	
	public Verificacion_registro getVr() {
		return vr;
	}
	public boolean validarRegistro() {
		/*validarCorreo();
		validarNombre();
		validarContrasena();
		confirmarContrasena();
		*/
		return true;
	
	}
	public boolean validarContrasena(String pass) {
		String regExSpecialChars = "<([{\\^-=$!|]})?*+.>";
		if(pass.isEmpty() || pass.length() < 10) {
			return false;
		}else if (esMalsonante()){
			boolean correcta = true;
			for(int i = 0; i < pass.length(); i++) {
				if(!Character.isLowerCase(pass.charAt(i)) && !Character.isLowerCase(pass.charAt(i)) && !Character.isDigit(pass.charAt(i))) {
					correcta = false;
				}
			}
		}
		return false;
	}
	
	private boolean esMalsonante() {
		return false;
		}

}