<script >
export default {
  methods: {
    devenirAdmin() {
      document.cookie = "admin=true";
    },
    nePlusEtreAdmin() {
      document.cookie = "admin=false";
    }
  }
}
</script>

<template>
  <div class="w-5/6 p-8 flex content-center flex-col h-screen">
    <p class="font-bold text-2xl mb-4">Connexion</p>
    <div class="flex flex-row">
      <button @click="devenirAdmin" class="bg-green-boite w-1/4 text-white p-2 m-2 rounded-lg active:bg-purple-boite">Devenir un administrateur</button>
      <button @click="nePlusEtreAdmin" class="bg-green-boite w-1/4 text-white p-2 m-2 rounded-lg active:bg-purple-boite">Ne plus être un administrateur</button>
    </div>
  </div>
</template>

<style scoped>

</style>