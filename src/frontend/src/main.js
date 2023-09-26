import { createApp } from 'vue'
import App from './App.vue'
import router from './router/routes.js'
import 'bootstrap/dist/js/bootstrap.bundle.min.js';
import "bootstrap/dist/css/bootstrap.min.css";
import "./assets/css/main.css";
import "@mdi/font/css/materialdesignicons.min.css"
// tippy
import { plugin as VueTippy } from 'vue-tippy'
import 'tippy.js/dist/tippy.css'
import 'tippy.js/animations/scale.css'
import 'tippy.js/themes/light-border.css'

const vueTippyConfig = {
  directive: 'tippy',
  component: 'tippy', 
  componentSingleton: 'tippy-singleton', 
  defaultProps: {
    placement: 'auto',
    allowHTML: true,
    theme: 'light-border',
    animation: 'scale',
    arrow: true,
    interactive: true,
    touch: true,
    zIndex: 9999,
  },
}

createApp(App)
	.use( VueTippy, vueTippyConfig)
	.use(router)
	.mount('#app')
