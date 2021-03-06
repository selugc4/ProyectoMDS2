import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-date-picker/src/vaadin-date-picker.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';

@customElement('vista-eleccion_evento')
export class VistaEleccion_evento extends LitElement {
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
 <vaadin-horizontal-layout theme="spacing" style="margin: var(--lumo-space-xl); align-items: center;" id="vaadinHorizontalLayout1">
  <label style="margin-right: var(--lumo-space-xl);" id="label2">Nombre del festival: </label>
  <vaadin-text-field placeholder="Nombre" style="margin-left: var(--lumo-space-xl);" id="vaadinTextField"></vaadin-text-field>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout theme="spacing" style="margin-left: var(--lumo-space-xl); align-items: center;" id="vaadinHorizontalLayout2">
  <label style="margin-right: var(--lumo-space-xl);" id="label3">Fecha del festival:</label>
  <vaadin-vertical-layout theme="spacing" style="align-items: center;" id="vaadinVerticalLayout1">
   <vaadin-date-picker id="vaadinDatePicker" style="width: 100%; height: 100%;"></vaadin-date-picker>
   <vaadin-button id="vaadinButton">
     Asignar fecha 
   </vaadin-button>
  </vaadin-vertical-layout>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout theme="spacing" style="width: 100%; height: 100%; align-items: center; justify-content: center;" id="vaadinHorizontalLayout3">
  <vaadin-button id="vaadinButton1">
    Añadir 
  </vaadin-button>
  <vaadin-button id="vaadinButton2">
    Volver atrás 
  </vaadin-button>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
  }

  // Remove this method to render the contents of this view inside Shadow DOM
  createRenderRoot() {
    return this;
  }
}
