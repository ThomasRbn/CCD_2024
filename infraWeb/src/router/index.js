import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '@/views/HomeView.vue'
import Page404 from '@/views/Page404.vue'
import Atelier from "@/views/Atelier.vue";
import Voeux from "@/views/Voeux.vue"
import AtelierModification from "@/views/AtelierModification.vue";
import Connexion from "@/views/Connexion.vue";
import APropos from "@/views/APropos.vue";
import DisplayAffect from "@/views/DisplayAffectations.vue";
import AcceptAffect from "@/views/AcceptAffectations.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
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
        path: '/connexion',
        name: 'connexion',
        component: Connexion
    },
    {
        path: '/modif',
        name: 'modif',
        component: AtelierModification
    },
    {
      path: '/:pathMatch(.*)',
      name: 'page404',
      component: Page404
    },
    {
      path: '/about',
      name: 'about',
      component: APropos
    },
    {
      path: '/displayAffect',
      name: 'displayAffect',
      component: DisplayAffect
    },
    {
      path: '/acceptAffect',
      name: 'acceptAffect',
      component: AcceptAffect,
    }
  ]
})

export default router
