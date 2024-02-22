<script>

import {API_LIST_ATELIER} from "@/url.js";

export default {
  data() {
    return {
      atelierData: ""
    }
  },
  methods: {
    fetchAtelierData() {
      fetch(API_LIST_ATELIER)
          .then(response => response.json())
          .then(data => {
            this.atelierData = data;
          })
          .catch((error) => {
            console.log('erreur de chargement des données : ' + error);
          })
    },
  }
}
</script>
<template>
  <div class="flex flex-wrap justify-center">
    <button @click="fetchAtelierData">Charger données</button>
    <div v-for="atelier in atelierData"
         class="border-green-boite border-4 p-2 bg-green-100 my-2 mx-6 w-5/12 rounded-2xl drop-shadow-xl hover:drop-shadow-2xl transition duration-500 hover:transform hover:scale-105 hover:ease-out">
      <p class="font-bold">Atelier {{ atelier.id }} :</p>
      <p class="my-2">
        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed aliquet egestas semper. Phasellus in nibh tincidunt
        urna suscipit feugiat id ut odio. Aenean lacinia bibendum lobortis. Integer placerat feugiat nulla. Morbi luctus
        vehicula felis. Duis nisi metus, viverra et finibus nec, porta in erat. Quisque enim sem, convallis eu
        diam.
      </p>
      <RouterLink :to="/atelier/ + this.idIt">
        <button class="bg-[#36A862] text-white p-2">Voir les détails</button>
      </RouterLink>
    </div>
  </div>
</template>