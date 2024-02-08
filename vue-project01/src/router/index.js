import Vue from 'vue'
import VueRouter from 'vue-router'
// import HomeView from '../views/HomeView.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    redirect:'/login'
  },
  {
    path: '/login',
    name: 'login',
    component: () => import('../views/tlias/LoginView.vue')
  },
  {
    path: '/dept',
    name: 'home',
    component: () => import('../views/tlias/DeptView.vue')
  },
  {
    path: '/emp',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import('../views/tlias/EmpView.vue')
  }
]

const router = new VueRouter({
  routes
})

export default router
