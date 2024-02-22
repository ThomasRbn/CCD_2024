<script>
import { API_LIST_THEME } from "@/url.js";

export default {
  data() {
    return {
      themeData: [],
      idPremierVoeu: "",
      idDeuxiemeVoeu: "",
      idTroisiemeVoeu: "",
      idQuatriemeVoeu: "",
      idCinquiemeVoeu: "",
      idSixiemeVoeu: "",
      nom: "",
      prenom: "",
      email: "",
    }
  },
  methods: {
    fetchThemeData() {
      fetch(API_LIST_THEME)
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
    this.fetchThemeData();
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
            <select v-model="this.idPremierVoeu" class="bg-white border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5">
              <option v-for="theme in themeData" :value="theme.code">{{ theme.nom }}</option>
            </select>
          </div>
        </div>
        <div>
          <p>Mon deuxième choix :</p>
          <select v-model="this.idDeuxiemeVoeu" class="bg-white border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5">
            <option v-for="theme in themeData" :value="theme.code">{{ theme.nom }}</option>
          </select>
        </div>
        <div>
          <p>Mon troisième choix :</p>
          <select v-model="this.idTroisiemeVoeu" class="bg-white border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5">
            <option v-for="theme in themeData" :value="theme.code">{{ theme.nom }}</option>
          </select>
        </div>
        <div>
          <p>Mon quatrième choix :</p>
          <select v-model="this.idQuatriemeVoeu" class="bg-white border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5">
            <option v-for="theme in themeData" :value="theme.code">{{ theme.nom }}</option>
          </select>
        </div>
        <div>
          <p>Mon cinquième choix :</p>
          <select v-model="this.idCinquiemeVoeu" class="bg-white border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5">
            <option v-for="theme in themeData" :value="theme.code">{{ theme.nom }}</option>
          </select>
        </div>
        <div>
          <p>Mon sixième choix :</p>
          <select v-model="this.idSixiemeVoeu" class="bg-white border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5">
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
