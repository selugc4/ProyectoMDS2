import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@polymer/iron-icon/iron-icon.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';

@customElement('vista-buscador_cancion_para_album')
export class VistaBuscador_cancion_para_album extends LitElement {
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
<vaadin-vertical-layout id="vaadinVerticalLayout">
 <vaadin-horizontal-layout theme="spacing" style="margin-bottom: var(--lumo-space-xl); width: 100%; height: 100%;" id="vaadinHorizontalLayout">
  <vaadin-text-field placeholder="Nombre canción" style="width: 100%;" id="vaadinTextField">
   <iron-icon icon="lumo:search" slot="prefix" id="ironIcon"></iron-icon>
  </vaadin-text-field>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
  }

  // Remove this method to render the contents of this view inside Shadow DOM
  createRenderRoot() {
    return this;
  }
}
