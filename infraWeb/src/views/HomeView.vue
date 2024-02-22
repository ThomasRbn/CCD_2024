<script>
import AtelierList from "@/components/AtelierList.vue";

export default {
  components: {
    AtelierList
  }
}
</script>

<template>
  <div class="w-5/6 p-8">
    <p class="font-bold text-3xl">Bienvenue dans CookingBooking 👋</p>
    <div class="flex flex-row">
      <div class="w-1/2">
        <p class="font-bold text-2xl mb-4">Informations</p>
        <p>Vous êtes sur le site de réservation de la Boîte à Cuisine, un espace de coworking et de partage de savoirs.</p>
        <p>Vous pouvez réserver des ateliers, consulter les ateliers disponibles et y participer !</p>
      </div>
    </div>
      <div class="w-1/2">
        <p class="font-bold text-2xl mb-4">Réservation</p>
        <p>Vous pouvez réserver des ateliers en vous connectant avec votre compte.</p>
        <p>Si vous n'avez pas de compte, vous pouvez en créer un en cliquant sur le bouton "S'inscrire".</p>
      </div>
    <p class="font-bold text-2xl mb-4">Liste des ateliers</p>
    <AtelierList></AtelierList>
  </div>
</template>
