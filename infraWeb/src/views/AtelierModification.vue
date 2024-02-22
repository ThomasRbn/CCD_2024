<script setup>
import {ref} from "vue";

const items = ref([{message: 'Atelier un'}, {message: 'Atelier deux'}])

</script>

<script>
import {createRouter as items} from "vue-router";

export default {
  data() {
    return {
      nomAtelier: "",
      descriptionAtelier: ""
    }
  },
  methods: {
    verifyAdmin() {
      return (document.cookie === "admin=true");
    },
    supprimerAtelier(items, index) {
      items.splice(index, 1)
    },
    ajouterAtelier(items) {
      items.push({message: this.nomAtelier + ' : ' + this.descriptionAtelier})
    },
    approuverDemande(items, index) {
      items.splice(index, 1)
      // API call to approve user
    },
    rejeterDemande(items, index) {
      items.splice(index, 1)
      // API call to reject user
    }
  }
}
</script>

<template>

    <div class="w-1/2 p-6 border-r-2">
      <div class="w-5/6 p-8 flex content-center flex-col">
        <p class="font-bold text-2xl mb-4">Modification des ateliers</p>
        <div v-if="verifyAdmin()">
        <p>🟢 Connexion réussie</p>
        <li v-for="(item, index) in items">
          {{ index }} - {{ item.message }}
          <button @click="supprimerAtelier(items, index)" class="bg-purple-boite rounded-lg p-1">Supprimer</button>
        </li>
        <p class="font-bold text-2xl mb-4">Ajout d'un atelier</p>
        <input v-model="nomAtelier" type="text" placeholder="Nom de l'atelier"
               class="border-2 border-green-boite-light rounded-lg p-2 m-2"/>
        <input v-model="descriptionAtelier" type="text" placeholder="Description de l'atelier"
               class="border-2 border-green-boite-light rounded-lg p-2 m-2"/>
        <button @click="ajouterAtelier(items)"
                class="bg-green-boite text-white p-2 m-2 rounded-lg active:bg-purple-boite">Ajouter
        </button>
        </div>
        <div v-else>
          <p>🔴 Vous n'avez pas les rôles nécessaires pour modifier les ateliers. Connectez-vous.</p>
        </div>
      </div>
    </div>
    <div class="flex flex-row w-5/6 p-8">
      <div class="w-1/2 p-6">
        <p class="font-bold text-2xl mb-4">Affichage des utilisateurs affectés</p>
        <div v-if="verifyAdmin()">
        <li v-for="(item, index) in items">
          {{ index }} - {{ item.message }}
          <button @click="approuverDemande(items, index)" class="bg-purple-boite rounded-lg p-1">Approuver</button>
          <button @click="rejeterDemande(items, index)" class="bg-purple-boite rounded-lg p-1">Rejeter</button>
        </li>
        </div>
        <div v-else>
          <p>🔴 Vous n'avez pas les rôles nécessaires pour afficher les utilisateurs affectés. Connectez-vous.</p>
        </div>
      </div>
    </div>
</template>

<style scoped>

</style>