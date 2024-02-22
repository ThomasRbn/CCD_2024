<script setup>
import {ref} from "vue";

const items = ref([{message: 'Atelier un'}, {message: 'Atelier deux'}])

</script>

<script>
import {createRouter as items} from "vue-router";
import {API_LIST_ATELIER, API_LIST_THEME} from "@/url.js";

export default {
  data() {
    return {
      nomAtelier: "",
      nbPlacesAtelier: "",
      themeAtelier: "",
      themeData: ""
    }
  },
  methods: {
    verifyAdmin() {
      return (document.cookie === "admin=true");
    },
    fetchThemeData() {
      fetch(API_LIST_THEME)
          .then(response => response.json())
          .then(data => {
            this.themeData = data;
            console.log(data);
          })
          .catch((error) => {
            console.log('erreur de chargement des données : ' + error);
          })
    },
    addAtelier() {
      fetch(API_LIST_ATELIER, {
        method: "POST",
        mode: "cors",
        cache: "no-cache",
        headers: {
          "Content-Type": "application/json",
          "Access-Control-Allow-Origin": "*",
          "Access-Control-Allow-Methods": "GET",
          "Access-Control-Allow-Headers": "Content-Type"
        },
        body: JSON.stringify({
          "theme": this.themeAtelier,
          "nom": this.nomAtelier,
          "nbPlaces": this.nbPlacesAtelier
        })
      })
          .then(response => response.json())
          .then(data => {
            console.log(data);
          })
          .catch((error) => {
            console.log('Erreur lors de la requête : ' + error);
          });
    }
  },
  mounted() {
    this.fetchThemeData();
  }
}
</script>

<template>
  <div class="w-5/6 p-8 flex content-center flex-col h-screen">
    <div v-if="verifyAdmin()">
      <p class="font-bold text-2xl mb-4">Ajout d'un atelier</p>
      <select v-model="this.themeAtelier">
        <option v-for="theme in themeData" :value="theme.code">{{ theme.nom }}</option>
      </select>
      <input v-model="nomAtelier" type="text" placeholder="Nom de l'atelier"
             class="border-2 border-green-boite-light rounded-lg p-2 m-2"/>
      <input v-model="nbPlacesAtelier" type="number" placeholder="Nombre de places"
             class="border-2 border-green-boite-light rounded-lg p-2 m-2"/>
      <button @click="addAtelier" class="bg-green-boite text-white p-2 m-2 rounded-lg active:bg-purple-boite">Ajouter
      </button>


      <p>{{ this.themeAtelier }}</p>
      <p>{{ this.nomAtelier }}</p>
      <p>{{ this.nbPlacesAtelier }}</p>


    </div>


    <div v-else>
      <p>🔴 Vous n'avez pas les rôles nécessaires pour être administrateur</p>
    </div>
  </div>

</template>

<style scoped>

</style>