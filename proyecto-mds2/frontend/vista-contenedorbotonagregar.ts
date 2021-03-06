import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@polymer/iron-icon/iron-icon.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';

@customElement('vista-contenedorbotonagregar')
export class VistaContenedorbotonagregar extends LitElement {
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
<vaadin-horizontal-layout class="content" style="justify-content: flex-end; width: 100%;" id="vaadinHorizontalLayout">
 <vaadin-button theme="icon" aria-label="Add new" style="margin: var(--lumo-space-xl); width: 3%;" id="vaadinButton">
  <iron-icon src="https://img2.freepng.es/20180427/bfe/kisspng-plus-and-minus-signs-font-awesome-plus-minus-sign-simple-blue-graphics-box-5ae309cde75d97.3939703215248286219477.jpg" id="ironIcon"></iron-icon>
 </vaadin-button>
</vaadin-horizontal-layout>
<vaadin-vertical-layout theme="spacing" id="vaadinVerticalLayout" style="width: 100%;"></vaadin-vertical-layout>
`;
  }

  // Remove this method to render the contents of this view inside Shadow DOM
  createRenderRoot() {
    return this;
  }
}
