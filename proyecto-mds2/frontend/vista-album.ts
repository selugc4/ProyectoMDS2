import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';

@customElement('vista-album')
export class VistaAlbum extends LitElement {
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
<vaadin-vertical-layout style="width: 100%; height: 100%; align-items: center; flex-direction: column;" id="vaadinVerticalLayout">
 <img style="width: 250px;" src="https://m.media-amazon.com/images/I/71B-wiFzFkL._SY355_.jpg" id="img">
 <label id="label">Álbum</label>
 <vaadin-button id="vaadinButton">
   Editar 
 </vaadin-button>
 <vaadin-button id="vaadinButton1">
   Eliminar 
 </vaadin-button>
</vaadin-vertical-layout>
`;
  }

  // Remove this method to render the contents of this view inside Shadow DOM
  createRenderRoot() {
    return this;
  }
}
