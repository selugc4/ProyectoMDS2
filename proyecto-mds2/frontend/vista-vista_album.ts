import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';

@customElement('vista-vista_album')
export class VistaVista_album extends LitElement {
  static get styles() {
    return css`
      :host {
          display: block;
          height: 100%;
    	  width: 100%;
      }
      `;
  }

  render() {
    return html`
<vaadin-vertical-layout style="width: 100%; height: 100%; align-items: flex-start;" id="vaadinVerticalLayout">
 <vaadin-horizontal-layout theme="spacing" style="margin: var(--lumo-space-xl); width: 30%; flex-direction: row; align-items: center; height: 20%;" id="vaadinHorizontalLayout">
  <img id="img" style="width: 100%; height: 100%;">
  <vaadin-vertical-layout id="vaadinVerticalLayout1" style="width: 100%;">
   <label style="font-weight:bold; font-size: 60px" id="label">Álbum</label>
   <label style="margin-bottom: var(--lumo-space-l); font-size:25px;" id="label1">Artista/s</label>
   <label style="font-size: 25px;" id="label2">Fecha de edición</label>
  </vaadin-vertical-layout>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
  }

  // Remove this method to render the contents of this view inside Shadow DOM
  createRenderRoot() {
    return this;
  }
}
