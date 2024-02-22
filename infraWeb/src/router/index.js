import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '@/views/HomeView.vue'
import Prout from '@/views/Prout.vue'
import Page404 from '@/views/Page404.vue'
import Atelier from "@/views/Atelier.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/prout',
      name: 'prout',
      component: Prout
    },
    {
      path: '/atelier/:id',
      name: 'atelier',
      component: Atelier
    },
    {
      path: '/:pathMatch(.*)',
      name: 'page404',
      component: Page404
    }
  ]
})

export default router
