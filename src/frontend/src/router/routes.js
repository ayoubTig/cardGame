import { createWebHistory, createRouter } from "vue-router";
import Login from '../components/Login.vue'
import game from '../components/GameCards.vue'


const routes = [
  {
    path: '/game',
    name: 'game',
    component: game,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/login',
    name: 'login',
    component: Login
  }, {
    path: '/:pathMatch(.*)*',
    component: Login
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes,
});

router.beforeEach((to, from, next) => {
  if (to.meta.requiresAuth) {
    if (!localStorage.getItem('user-password')) next('/login')
    else next()
  } else next()
})

export default router;
