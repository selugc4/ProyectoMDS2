/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Administrator(University of Almeria)
 * License Type: Academic
 */
package basededatos;

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ArtistaCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression contiene_imagenId;
	public final AssociationExpression contiene_imagen;
	public final StringExpression nombre;
	public final StringExpression contrasena;
	public final IntegerExpression tipoUsuario;
	public final StringExpression correo;
	public final StringExpression foto;
	public final CollectionExpression seguir;
	public final CollectionExpression propietario;
	public final CollectionExpression seguido;
	public final CollectionExpression recibe_notificacion;
	public final CollectionExpression favorita;
	public final CollectionExpression Ultimo_exito;
	public final CollectionExpression horass;
	public final CollectionExpression seguidor_usuario;
	public final CollectionExpression tiene;
	public final CollectionExpression propietario_album;
	public final CollectionExpression crea;
	public final CollectionExpression pertenece;
	
	public ArtistaCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		contiene_imagenId = new IntegerExpression("contiene_imagen.idImagen", this);
		contiene_imagen = new AssociationExpression("contiene_imagen", this);
		nombre = new StringExpression("nombre", this);
		contrasena = new StringExpression("contrasena", this);
		tipoUsuario = new IntegerExpression("tipoUsuario", this);
		correo = new StringExpression("correo", this);
		foto = new StringExpression("foto", this);
		seguir = new CollectionExpression("ORM_seguir", this);
		propietario = new CollectionExpression("ORM_propietario", this);
		seguido = new CollectionExpression("ORM_seguido", this);
		recibe_notificacion = new CollectionExpression("ORM_recibe_notificacion", this);
		favorita = new CollectionExpression("ORM_favorita", this);
		Ultimo_exito = new CollectionExpression("ORM_ultimo_exito", this);
		horass = new CollectionExpression("ORM_horass", this);
		seguidor_usuario = new CollectionExpression("ORM_seguidor_usuario", this);
		tiene = new CollectionExpression("ORM_tiene", this);
		propietario_album = new CollectionExpression("ORM_propietario_album", this);
		crea = new CollectionExpression("ORM_crea", this);
		pertenece = new CollectionExpression("ORM_pertenece", this);
	}
	
	public ArtistaCriteria(PersistentSession session) {
		this(session.createCriteria(Artista.class));
	}
	
	public ArtistaCriteria() throws PersistentException {
		this(basededatos.A12PersistentManager.instance().getSession());
	}
	
	public basededatos.CancionCriteria createTieneCriteria() {
		return new basededatos.CancionCriteria(createCriteria("ORM_tiene"));
	}
	
	public basededatos.AlbumCriteria createPropietario_albumCriteria() {
		return new basededatos.AlbumCriteria(createCriteria("ORM_propietario_album"));
	}
	
	public basededatos.EventoCriteria createCreaCriteria() {
		return new basededatos.EventoCriteria(createCriteria("ORM_crea"));
	}
	
	public basededatos.EstiloCriteria createPerteneceCriteria() {
		return new basededatos.EstiloCriteria(createCriteria("ORM_pertenece"));
	}
	
	public ImagenCriteria createContiene_imagenCriteria() {
		return new ImagenCriteria(createCriteria("contiene_imagen"));
	}
	
	public basededatos.Lista_ReproduccionCriteria createSeguirCriteria() {
		return new basededatos.Lista_ReproduccionCriteria(createCriteria("ORM_seguir"));
	}
	
	public basededatos.Lista_ReproduccionCriteria createPropietarioCriteria() {
		return new basededatos.Lista_ReproduccionCriteria(createCriteria("ORM_propietario"));
	}
	
	public basededatos.UsuarioCriteria createSeguidoCriteria() {
		return new basededatos.UsuarioCriteria(createCriteria("ORM_seguido"));
	}
	
	public basededatos.EventoCriteria createRecibe_notificacionCriteria() {
		return new basededatos.EventoCriteria(createCriteria("ORM_recibe_notificacion"));
	}
	
	public basededatos.CancionCriteria createFavoritaCriteria() {
		return new basededatos.CancionCriteria(createCriteria("ORM_favorita"));
	}
	
	public basededatos.CancionCriteria createUltimo_exitoCriteria() {
		return new basededatos.CancionCriteria(createCriteria("ORM_ultimo_exito"));
	}
	
	public basededatos.HorasCriteria createHorassCriteria() {
		return new basededatos.HorasCriteria(createCriteria("ORM_horass"));
	}
	
	public basededatos.UsuarioCriteria createSeguidor_usuarioCriteria() {
		return new basededatos.UsuarioCriteria(createCriteria("ORM_seguidor_usuario"));
	}
	
	public Artista uniqueArtista() {
		return (Artista) super.uniqueResult();
	}
	
	public Artista[] listArtista() {
		java.util.List list = super.list();
		return (Artista[]) list.toArray(new Artista[list.size()]);
	}
}

