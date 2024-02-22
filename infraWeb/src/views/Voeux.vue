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
    setPremierVoeu(id) {
      this.resetButtonColor();
      this.idPremierVoeu = id;
      this.updateButtonColor(id);
    },
    setDeuxiemeVoeu(id) {
      this.resetButtonColor();
      this.idDeuxiemeVoeu = id;
      this.updateButtonColor(id);
    },
    setTroisiemeVoeu(id) {
      this.resetButtonColor();
      this.idTroisiemeVoeu = id;
      this.updateButtonColor(id);
    },
    fetchAtelierData() {
      fetch(API_LIST_ATELIER)
          .then(response => response.json())
          .then(data => {
            // Ajoute la propriété 'selected' à chaque élément de données
            this.themeData = data.map(theme => ({ ...theme, selected: false }));
          })
          .catch((error) => {
            console.log('erreur de chargement des données : ' + error);
          })
    },
    resetButtonColor() {
      this.themeData.forEach(theme => {
        theme.selected = false;
      });
    },
    updateButtonColor(id) {
      const selectedTheme = this.themeData.find(theme => theme.code === id);
      if (selectedTheme) {
        selectedTheme.selected = true;
      }
    }
  }
}
</script>

<template>
  <div class="flex flex-row w-5/6 p-8">
    <div class="w-1/2 p-6 border-r-2">
      <button @click="fetchAtelierData">Charger les données</button>
      <div class="">
        <p class="font-bold text-2xl mb-4">Choix des voeux</p>
        <div>
          <p>Mon premier choix : {{ this.idPremierVoeu }}</p>
          <div class="w-full flex flex-wrap">
            <button @click="setPremierVoeu(theme.code)" v-for="theme in themeData"
                    :class="{ 'p-4 bg-green-100': !theme.selected, 'p-4 bg-blue-100': theme.selected }">{{ theme.nom }}
            </button>
          </div>
        </div>
        <div>
          <p>Mon deuxième choix : </p>
          <div class="w-full flex flex-wrap">
            <button @click="setDeuxiemeVoeu(theme.code)" v-for="theme in themeData"
                    :class="{ 'p-4 bg-green-100': !theme.selected, 'p-4 bg-blue-100': theme.selected }">{{ theme.nom }}
            </button>
          </div>
        </div>
        <div>
          <p>Mon troisième choix :</p>
          <div class="w-full flex flex-wrap">
            <button @click="setTroisiemeVoeu(theme.code)" v-for="theme in themeData"
                    :class="{ 'p-4 bg-green-100': !theme.selected, 'p-4 bg-blue-100': theme.selected }">{{ theme.nom }}
            </button>
          </div>
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
