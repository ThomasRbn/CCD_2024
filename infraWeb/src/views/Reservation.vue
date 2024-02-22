<script>
export default {
  data() {
    return {
      nom: "",
      prenom: "",
      email: "",
    }
  },
}
</script>

<template>
  <div class="w-5/6 p-8 flex content-center flex-col">
    <p class="font-bold text-2xl mb-4">Informations</p>
      <form class="flex flex-col">
        <input v-model="nom" type="text" placeholder="Nom" class="border-2 border-green-boite-light rounded-lg p-2 m-2"/>
        <input v-model="prenom" type="text" placeholder="Prénom" class="border-2 border-green-boite-light rounded-lg p-2 m-2"/>
        <input v-model="email" type="text" placeholder="Email" class="border-2 border-green-boite-light rounded-lg p-2 m-2"/>
      </form>
    <button class="bg-green-boite text-white p-2 m-2 rounded-lg active:bg-purple-boite">Valider</button>
    <p class="font-bold">Récapitulatif :</p>
    <p>Nom : {{ this.nom }}</p>
    <p>Prénom : {{ this.prenom }}</p>
    <p>Email : {{ this.email }}</p>
  </div>
</template>

<style scoped>

</style>