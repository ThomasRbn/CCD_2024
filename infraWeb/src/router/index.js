import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '@/views/HomeView.vue';
import Reservation from "@/views/Reservation.vue";
import Page404 from '@/views/Page404.vue'
import Atelier from "@/views/Atelier.vue";
import Voeux from "@/views/Voeux.vue"

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/reservation',
      name: 'Reservation',
      component: Reservation
    },
    {
      path: '/atelier/:id',
      name: 'atelier',
      component: Atelier
    },
    {
      path: '/voeux',
      name: 'voeux',
      component: Voeux
    },
    {
      path: '/:pathMatch(.*)',
      name: 'page404',
      component: Page404
    }
  ]
})

export default router
