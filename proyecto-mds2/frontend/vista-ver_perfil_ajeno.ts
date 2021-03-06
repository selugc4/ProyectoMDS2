import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';

@customElement('vista-ver_perfil_ajeno')
export class VistaVer_perfil_ajeno extends LitElement {
  static get styles() {
    return css`
      :host {
          display: block;
          height: 100%;
      }
      `;
  }

  render() {
    return html`
<vaadin-vertical-layout style="width: 100%; height: 100%;" id="vaadinVerticalLayout">
 <vaadin-horizontal-layout theme="spacing" style="width: 100%; height: 40%; padding: var(--lumo-space-xl);" id="vaadinHorizontalLayout">
  <img id="img" style="width: 250px; height: 250px;">
  <vaadin-vertical-layout theme="spacing" style="width: 50%; align-self: center;" id="vaadinVerticalLayout1">
   <vaadin-horizontal-layout theme="spacing" style="align-self: flex-start; width: 100%; justify-content: flex-start;" id="vaadinHorizontalLayout1">
    <label style="align-self: center; font-size:35px" id="label">Nombre del usuario</label>
    <vaadin-horizontal-layout theme="spacing" style="justify-content: flex-end; align-self: center; width: 30%;" id="vaadinHorizontalLayout2">
     <vaadin-button id="vaadinButton">
       Seguir 
     </vaadin-button>
     <vaadin-button id="vaadinButton1">
       Dejar de Seguir 
     </vaadin-button>
    </vaadin-horizontal-layout>
   </vaadin-horizontal-layout>
   <label id="label1">Seguidores: XXXX</label>
   <label id="label2">Seguidos: XXXX</label>
  </vaadin-vertical-layout>
 </vaadin-horizontal-layout>
 <vaadin-vertical-layout theme="spacing" id="verticalContenedores" style="width: 100%; height: 100%; padding: var(--lumo-space-l);">
  <vaadin-horizontal-layout theme="spacing" id="horizontalListas" style="width: 100%; height: 100%;">
   <vaadin-vertical-layout theme="spacing" id="verticalSusListas" style="width: 100%; height: 100%;"></vaadin-vertical-layout>
   <vaadin-vertical-layout theme="spacing" id="verticalListasSusCanciones" style="width: 100%; height: 100%;"></vaadin-vertical-layout>
  </vaadin-horizontal-layout>
  <vaadin-horizontal-layout theme="spacing" id="horizontalAlbumes" style="width: 100%; height: 100%; align-self: center; justify-content: center; align-items: center;"></vaadin-horizontal-layout>
  <vaadin-horizontal-layout theme="spacing" id="horizontalCanciones" style="width: 100%; height: 100%;">
   <vaadin-vertical-layout theme="spacing" id="verticalExitosas" style="width: 100%; height: 100%;"></vaadin-vertical-layout>
   <vaadin-vertical-layout theme="spacing" id="verticalConciertos" style="width: 100%; height: 100%;"></vaadin-vertical-layout>
  </vaadin-horizontal-layout>
  <vaadin-horizontal-layout theme="spacing" id="horizontalArtistas" style="width: 100%; height: 100%; flex-direction: row; align-self: center; align-items: center; justify-content: center;"></vaadin-horizontal-layout>
 </vaadin-vertical-layout>
</vaadin-vertical-layout>
`;
  }

  // Remove this method to render the contents of this view inside Shadow DOM
  createRenderRoot() {
    return this;
  }
}
