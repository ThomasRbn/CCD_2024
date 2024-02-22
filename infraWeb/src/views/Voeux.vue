<script>
import { API_LIST_ATELIER } from "@/url.js";

export default {
  data() {
    return {
      themeData: [],
      idPremierVoeu: "",
      idDeuxiemeVoeu: "",
      idTroisiemeVoeu: "",
      nom: "",
      prenom: "",
      email: "",
    }
  },
  methods: {
    fetchAtelierData() {
      fetch(API_LIST_ATELIER)
          .then(response => response.json())
          .then(data => {
            this.themeData = data;
          })
          .catch((error) => {
            console.log('erreur de chargement des données : ' + error);
          })
    },
  },
  mounted() {
    this.fetchAtelierData();
  }
}
</script>

<template>
  <div class="flex flex-row w-5/6 p-8">
    <div class="w-1/2 p-6 border-r-2">
      <div class="">
        <p class="font-bold text-2xl mb-4">Choix des voeux</p>
        <div>
          <p>Mon premier choix :</p>
          <div class="w-full flex flex-wrap">
            <select v-model="this.idPremierVoeu">
              <option v-for="theme in themeData" :value="theme.code">{{ theme.nom }}</option>
            </select>
          </div>
        </div>
        <div>
          <p>Mon deuxième choix :</p>
          <select v-model="this.idDeuxiemeVoeu">
            <option v-for="theme in themeData" :value="theme.code">{{ theme.nom }}</option>
          </select>
        </div>
        <div>
          <p>Mon troisième choix :</p>
          <select v-model="this.idTroisiemeVoeu">
            <option v-for="theme in themeData" :value="theme.code">{{ theme.nom }}</option>
          </select>
        </div>
      </div>
    </div>
    <div class="w-1/2 p-6">
      <p class="font-bold text-2xl mb-4">Informations</p>
      <form class="flex flex-col">
        <input v-model="nom" type="text" placeholder="Nom"
               class="border-2 border-green-boite-light rounded-lg p-2 m-2"/>
        <input v-model="prenom" type="text" placeholder="Prénom"
               class="border-2 border-green-boite-light rounded-lg p-2 m-2"/>
        <input v-model="email" type="text" placeholder="Email"
               class="border-2 border-green-boite-light rounded-lg p-2 m-2"/>
      </form>
      <button class="bg-green-boite text-white p-2 m-2 rounded-lg active:bg-purple-boite">Valider</button>
      <p class="font-bold">Récapitulatif :</p>
      <p>Nom : {{ nom }}</p>
      <p>Prénom : {{ prenom }}</p>
      <p>Email : {{ email }}</p>
    </div>
  </div>
</template>
